package com.huifu.auth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_pwd", catalog = "autodesk")
public class UserPwd {

	private long uid; /* 用户代号 */

	private String loginId; /* 登录账号 */

	private String passwd; /* 密码 */

	private String modifiedUid; /* 更新者的用户代号 */

	private String modifiedTime; /* 更新时间 */

	public UserPwd() {
		// Default.
	}

	public UserPwd(long uid, String loginId, String passwd, String modifiedUid, String modifiedTime) {
		super();
		this.uid = uid;
		this.loginId = loginId;
		this.passwd = passwd;
		this.modifiedUid = modifiedUid;
		this.modifiedTime = modifiedTime;
	}

	@Id
	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	@Column
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	@Column
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Column
	public String getModifiedUid() {
		return modifiedUid;
	}

	public void setModifiedUid(String modifiedUid) {
		this.modifiedUid = modifiedUid;
	}

	@Column
	public String getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	@Override
	public String toString() {
		return "UserPwd [uid=" + uid + ", loginId=" + loginId + ", passwd=" + passwd + ", modifiedUid=" + modifiedUid
				+ ", modifiedTime=" + modifiedTime + "]";
	}

}
