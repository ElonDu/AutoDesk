package com.huifu.auth.service;

public interface SeqCtlService {

	public Long getSeqId(Long id, Long subId);

	public Long getSeqId(Long id, Long subId, Boolean forceMode);

}
