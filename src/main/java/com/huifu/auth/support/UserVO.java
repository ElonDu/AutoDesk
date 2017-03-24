package com.huifu.auth.support;

public class UserVO {

	/** ------------------------- */
	private long id;

	private String name; /* 姓名 */

	private int gender; /* 性别 */

	private String birthday; /* 出生日期 */

	private String identityNo; /* 身份证号码 */

	private String mobile; /* 手机号码 */

	private String tel; /* 固定电话 */

	private int status; /* 状态 */

	private String createTime; /* 创建时间 */

	private String modifiedTime; /* 更新时间 */

	/** ------------------------- */
	private String loginId; /* 登录账号 */

	private String passwd; /* 密码 */

	private String modifiedUid; /* 更新者的用户代号 */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getModifiedUid() {
		return modifiedUid;
	}

	public void setModifiedUid(String modifiedUid) {
		this.modifiedUid = modifiedUid;
	}

}
