package com.huifu.auth.service;

import com.huifu.auth.support.UserVO;

public interface UserService {
	
	public void save(UserVO vo);
	
	public void edit(UserVO vo);
	
	public void remove(long id);

	public boolean check(String loginId, String passwd);
	
	public UserVO queryById(long id);
	
}
