package com.huifu.auth.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huifu.auth.dao.UserMapper;
import com.huifu.auth.dao.UserPwdMapper;
import com.huifu.auth.entity.User;
import com.huifu.auth.entity.UserPwd;
import com.huifu.auth.entity.UserPwdExample;
import com.huifu.auth.service.SeqCtlService;
import com.huifu.auth.service.UserService;
import com.huifu.auth.support.SequenceConstants;
import com.huifu.auth.support.SystemConstants;
import com.huifu.auth.support.UserVO;
import com.huifu.core.util.DateUtils;
import com.huifu.core.util.StringUtils;

@Service("userService")
public class UserServiceImpl implements UserService {

	private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserPwdMapper userPwdMapper;

	@Autowired
	private SeqCtlService seqCtlService;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Generate User Identity from SEQ_CTL.
	 * 
	 * @param instId
	 * @return inst_id(6 bits) + user_sequence(8 bits)
	 */
	public long getUid(long instId) {
		StringBuilder buff = new StringBuilder(20);
		buff.append(instId);

		long seqNo = seqCtlService.getSeqId(SequenceConstants.SEQID_USER, instId);
		buff.append(StringUtils.leftPad("" + seqNo, 8, "0"));

		return Long.parseLong(buff.toString());
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void save(UserVO vo) {
		String currentDate = DateUtils.getCurrentDate();
		String currentTime = DateUtils.getCurrentDatetime();

		User user = new User(vo.getName(), vo.getGender(), vo.getBirthday(), vo.getIdentityNo(), vo.getMobile(),
				vo.getTel(), SystemConstants.ENABLE, currentDate, currentTime);
		UserPwd userPwd = new UserPwd(user.getId(), vo.getLoginId(), vo.getPasswd(), vo.getModifiedUid(), currentTime);
		
		long uid = getUid(SystemConstants.DEFAULT_INST_ID);
		
		user.setId(uid);
		userPwd.setUid(uid);
		
		userMapper.insert(user);
		userPwdMapper.insert(userPwd);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void edit(UserVO vo) {
		String currentTime = DateUtils.getCurrentDatetime();

		User user = new User(vo.getName(), vo.getGender(), vo.getBirthday(), vo.getIdentityNo(), vo.getMobile(),
				vo.getTel(), vo.getStatus(), null, currentTime);

		user.setId(vo.getId());
		userMapper.updateByPrimaryKeySelective(user);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(long id) {
		User user = new User();
		user.setId(id);
		user.setStatus(SystemConstants.DISABLE);
		userMapper.updateByPrimaryKeySelective(user);
	}

	@SuppressWarnings("unchecked")
	public boolean check(String loginId, String passwd) {
		UserPwdExample example = new UserPwdExample();
		example.createCriteria().andLoginIdEqualTo(loginId);
		List<UserPwd> list = userPwdMapper.selectByExample(example);
		if (list.isEmpty()) {
			logger.error(" the user_pwd(login_id=?) is not found. ", loginId);
			return false;
		} else {
			UserPwd info = list.get(0);
			String passwdRegister = info.getPasswd();
			/*
			 * 包装成密文 String passwdSecure = Md5Utils.md5(passwd.getBytes());
			 */
			if (passwdRegister.equals(passwd)) {
				return true;
			} else {
				logger.error(" the password(login_id=?) is incorrect. ", loginId);
				return false;
			}
		}
	}

	public UserVO queryById(long id) {
		try {
			User user = userMapper.selectByPrimaryKey(id);

			UserVO vo = new UserVO();
			BeanUtils.copyProperties(user, vo);

			return vo;
		} catch (DataAccessException e) {
			logger.error(" the user(id=?) is not found. ", id);
			return null;
		} catch (BeansException e) {
			logger.error(" Converting 'User' to 'UserVO' is fail. ");
			return null;
		}
	}

}
