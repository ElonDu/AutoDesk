package com.huifu.auth.entity;

public class SeqCtlKey {
	private Long id;

	private Long subId;

	public SeqCtlKey() {
		super();
	}

	public SeqCtlKey(Long id, Long subId) {
		super();
		this.id = id;
		this.subId = subId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSubId() {
		return subId;
	}

	public void setSubId(Long subId) {
		this.subId = subId;
	}
}