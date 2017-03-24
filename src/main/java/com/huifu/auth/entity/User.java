package com.huifu.auth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", catalog = "autodesk")
public class User {

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

	public User() {
		// Default.
	}

	public User(String name, int gender, String birthday, String identityNo, String mobile, String tel, int status,
			String createTime, String modifiedTime) {
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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	@Column
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Column
	public String getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	@Column
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", birthday=" + birthday + ", identityNo="
				+ identityNo + ", mobile=" + mobile + ", tel=" + tel + ", status=" + status + ", createTime="
				+ createTime + ", modifiedTime=" + modifiedTime + "]";
	}

}
