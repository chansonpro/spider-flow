package org.spiderflow.core.service;

import org.spiderflow.core.mapper.LlmMapper;
import org.spiderflow.core.model.LlmMessageModel;
import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationParam;
import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.common.Message;
import com.alibaba.dashscope.common.Role;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.UUID;

/**
 * @author chans
 */
@Service
public class CallWithMessageService extends ServiceImpl<LlmMapper, LlmMessageModel> {


    @Autowired
    private  LlmMapper llmMapper;


    public  void CallWithMess(String request) throws NoApiKeyException, InputRequiredException {
        Generation gen = new Generation();
        Message systemMsg = Message.builder().role(Role.SYSTEM.getValue())
                .content("You are a helpful assistant.").build();
        Message userMsg =
                Message.builder().role(Role.USER.getValue()).content("你好，周末去哪里玩？").build();
        GenerationParam param = GenerationParam.builder().model("qwen-turbo")
                .messages(Arrays.asList(systemMsg, userMsg))
                .resultFormat(GenerationParam.ResultFormat.MESSAGE).topP(0.8).apiKey("sk-fa7045726e3240b698dfdf3eda8eb5ca").build();
        GenerationResult result = gen.call(param);
        String content = result.getOutput().getChoices().get(0).getMessage().getContent();


        String id = UUID.randomUUID().toString().replace("-", "");
        llmMapper.insert(id,request,content);
    }


}
