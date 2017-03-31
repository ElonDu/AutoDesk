package com.huifu.auth.entity;

public class UserPwd {
	private Long uid;

	private String loginId;

	private String passwd;

	private Long modifiedUid;

	private String modifiedTime;

	public UserPwd() {
		super();
	}

	public UserPwd(Long uid, String loginId, String passwd, Long modifiedUid, String modifiedTime) {
		super();
		this.uid = uid;
		this.loginId = loginId;
		this.passwd = passwd;
		this.modifiedUid = modifiedUid;
		this.modifiedTime = modifiedTime;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId == null ? null : loginId.trim();
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd == null ? null : passwd.trim();
	}

	public Long getModifiedUid() {
		return modifiedUid;
	}

	public void setModifiedUid(Long modifiedUid) {
		this.modifiedUid = modifiedUid;
	}

	public String getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime == null ? null : modifiedTime.trim();
	}
}