package com.huifu.auth.entity;

public class User {
	private Long id;

	private String name;

	private Integer gender;

	private String birthday;

	private String identityNo;

	private String mobile;

	private String tel;

	private Integer status;

	private String createTime;

	private String modifiedTime;

	public User() {
		super();
	}

	public User(String name, Integer gender, String birthday, String identityNo, String mobile, String tel,
			Integer status, String createTime, String modifiedTime) {
		super();
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.identityNo = identityNo;
		this.mobile = mobile;
		this.tel = tel;
		this.status = status;
		this.createTime = createTime;
		this.modifiedTime = modifiedTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday == null ? null : birthday.trim();
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo == null ? null : identityNo.trim();
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel == null ? null : tel.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime == null ? null : createTime.trim();
	}

	public String getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime == null ? null : modifiedTime.trim();
	}
}