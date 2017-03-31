package com.huifu.auth.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huifu.auth.dao.SeqCtlMapper;
import com.huifu.auth.entity.SeqCtl;
import com.huifu.auth.entity.SeqCtlKey;
import com.huifu.auth.service.SeqCtlService;
import com.huifu.auth.support.SequenceConstants;

@Service("seqCtlService")
public class SeqCtlServiceImpl implements SeqCtlService {

	private final static Logger logger = LoggerFactory.getLogger(SeqCtlServiceImpl.class);

	@Autowired
	private SeqCtlMapper seqCtlMapper;

	public Long getSeqId(Long id, Long subId) {
		return safeMode(id, subId);
	}

	public Long getSeqId(Long id, Long subId, Boolean forceMode) {
		if (forceMode.booleanValue()) {
			return forceMode(id, subId);
		} else {
			return safeMode(id, subId);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private Long safeMode(Long id, Long subId) {
		long retVal = -1L;

		if (id == null || subId == null) {
			logger.error(" input parameters can not be empty. ");
			return -1L;
		}

		/** select for update */
		SeqCtlKey key = new SeqCtlKey(id, subId);
		SeqCtl seqCtl = seqCtlMapper.lockByPrimaryKey(key);

		if (seqCtl == null) {
			/** for insert */
			SeqCtl record = new SeqCtl();
			record.setId(id);
			record.setSubId(subId);

			/** select TEMPLET Record */
			SeqCtlKey templetKey = new SeqCtlKey(id, SequenceConstants.SUBID_TEMPLET_BY_INST);
			SeqCtl templetRecord = seqCtlMapper.selectByPrimaryKey(templetKey);
			if (templetRecord == null) {
				/** error */
				logger.error(" seq_ctl({}, {}) is not found. ", id, SequenceConstants.SUBID_TEMPLET_BY_INST);
				return -1L;
			}
			Long nextValue = templetRecord.getMinValue();
			retVal = nextValue;
			nextValue++;

			record.setName(templetRecord.getName());
			record.setNextValue(nextValue);
			record.setMinValue(templetRecord.getMinValue());
			record.setMaxValue(templetRecord.getMaxValue());
			seqCtlMapper.insert(record);
		} else {
			/** for update */
			Long nextValue = seqCtl.getNextValue();
			retVal = nextValue;
			nextValue++;

			if (nextValue.compareTo(seqCtl.getMaxValue()) < 0) {
				seqCtl.setNextValue(nextValue);
				seqCtlMapper.updateByPrimaryKeySelective(seqCtl);
			} else {
				logger.warn(" seq_ctl({}, {}) is overflow. ", id, subId);
			}
		}
		return retVal;
	}

	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRES_NEW, timeout = 1)
	private Long forceMode(Long id, Long subId) {
		long retVal = -1L;

		if (id == null || subId == null) {
			logger.error(" input parameters can not be empty. ");
			return -1L;
		}

		/** select for update */
		SeqCtlKey key = new SeqCtlKey(id, subId);
		SeqCtl seqCtl = seqCtlMapper.lockByPrimaryKey(key);

		if (seqCtl == null) {
			/** for insert */
			SeqCtl record = new SeqCtl();
			record.setId(id);
			record.setSubId(subId);

			/** select TEMPLET Record */
			SeqCtlKey templetKey = new SeqCtlKey(id, SequenceConstants.SUBID_TEMPLET_BY_INST);
			SeqCtl templetRecord = seqCtlMapper.selectByPrimaryKey(templetKey);
			if (templetRecord == null) {
				/** error */
				logger.error(" seq_ctl({}, {}) is not found. ", id, SequenceConstants.SUBID_TEMPLET_BY_INST);
				return -1L;
			}
			Long nextValue = templetRecord.getMinValue();
			retVal = nextValue;
			nextValue++;

			record.setName(templetRecord.getName());
			record.setNextValue(nextValue);
			record.setMinValue(templetRecord.getMinValue());
			record.setMaxValue(templetRecord.getMaxValue());
			seqCtlMapper.insert(record);
		} else {
			/** for update */
			Long nextValue = seqCtl.getNextValue();
			retVal = nextValue;
			nextValue++;

			if (nextValue.compareTo(seqCtl.getMaxValue()) < 0) {
				seqCtl.setNextValue(nextValue);
				seqCtlMapper.updateByPrimaryKeySelective(seqCtl);
			} else {
				logger.warn(" seq_ctl({}, {}) is overflow. ", id, subId);
			}
		}
		return retVal;
	}

}
