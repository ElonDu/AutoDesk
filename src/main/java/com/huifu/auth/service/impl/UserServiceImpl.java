package com.huifu.auth.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huifu.auth.entity.User;
import com.huifu.auth.entity.UserPwd;
import com.huifu.auth.service.UserService;
import com.huifu.auth.support.AuthConstants;
import com.huifu.auth.support.UserVO;
import com.huifu.core.util.DateUtils;

@Service("userService")
public class UserServiceImpl implements UserService {

	private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(propagation = Propagation.REQUIRED)
	public void save(UserVO vo) {
		String currentDate = DateUtils.getCurrentDate();
		String currentTime = DateUtils.getCurrentDatetime();

		User user = new User(vo.getName(), vo.getGender(), vo.getBirthday(), vo.getIdentityNo(), vo.getMobile(),
				vo.getTel(), vo.getStatus(), currentDate, currentTime);
		/*
		 * Update the given persistent instance, associating it with the current
		 * Hibernate Session.
		 */
		hibernateTemplate.save(user);

		UserPwd userPwd = new UserPwd(user.getId(), vo.getLoginId(), vo.getPasswd(), vo.getModifiedUid(), currentTime);
		hibernateTemplate.save(userPwd);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void edit(UserVO vo) {
		String currentTime = DateUtils.getCurrentDatetime();

		User user = new User(vo.getName(), vo.getGender(), vo.getBirthday(), vo.getIdentityNo(), vo.getMobile(),
				vo.getTel(), vo.getStatus(), null, currentTime);

		/*
		 * Update the given persistent instance, associating it with the current
		 * Hibernate Session.
		 */
		user.setId(vo.getId());
		hibernateTemplate.update(user);
	}

	public void remove(long id) {
		User user = new User();
		user.setStatus(AuthConstants.USER_STATUS_CLOSE);
		/*
		 * Update the given persistent instance, associating it with the current
		 * Hibernate Session.
		 */
		user.setId(id);
		hibernateTemplate.update(user);
	}

	@SuppressWarnings("unchecked")
	public boolean check(String loginId, String passwd) {
		String hql = " from UserPwd where loginId = :loginId ";
		List<UserPwd> list = (List<UserPwd>) hibernateTemplate.findByNamedParam(hql, "loginId", loginId);
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
			User user = hibernateTemplate.load(User.class, id);

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
