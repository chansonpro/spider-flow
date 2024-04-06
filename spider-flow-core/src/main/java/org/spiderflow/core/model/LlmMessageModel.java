package org.spiderflow.core.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * 大语言模型-持久化实体类
 */
@TableName("llm_mess_tb")
public class LlmMessageModel {

    @TableId(type = IdType.UUID)
    private String id;


    /**
     * 问题描述
     */
    private String question;


    /**
     * 答案
     */
    private String answer;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }




}
