package com.huifu.auth.dao;

import com.huifu.auth.entity.SeqCtl;
import com.huifu.auth.entity.SeqCtlExample;
import com.huifu.auth.entity.SeqCtlKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SeqCtlMapper {
    long countByExample(SeqCtlExample example);

    int deleteByExample(SeqCtlExample example);

    int deleteByPrimaryKey(SeqCtlKey key);

    int insert(SeqCtl record);

    int insertSelective(SeqCtl record);

    List<SeqCtl> selectByExample(SeqCtlExample example);

    SeqCtl selectByPrimaryKey(SeqCtlKey key);
    
    SeqCtl lockByPrimaryKey(SeqCtlKey key); /** Custom Method */

    int updateByExampleSelective(@Param("record") SeqCtl record, @Param("example") SeqCtlExample example);

    int updateByExample(@Param("record") SeqCtl record, @Param("example") SeqCtlExample example);

    int updateByPrimaryKeySelective(SeqCtl record);

    int updateByPrimaryKey(SeqCtl record);
    
}