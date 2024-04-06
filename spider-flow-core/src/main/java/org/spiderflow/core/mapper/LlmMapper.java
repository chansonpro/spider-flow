package org.spiderflow.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.spiderflow.core.model.LlmMessageModel;

@Mapper
public interface LlmMapper extends BaseMapper<LlmMessageModel> {

    @Insert("insert into llm_mess_tb(id,question,answer) values(#{id},#{question},#{answer})")
    int insert(@Param("id") String id, @Param("question") String question, @Param("answer") String answer);
}
