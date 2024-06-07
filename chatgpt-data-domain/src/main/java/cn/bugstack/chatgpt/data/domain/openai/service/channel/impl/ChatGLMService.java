package cn.bugstack.chatgpt.data.domain.openai.service.channel.impl;

import cn.bugstack.chatgpt.data.domain.openai.model.aggregates.ChatProcessAggregate;
import cn.bugstack.chatgpt.data.domain.openai.model.valobj.GenerativeModelVO;
import cn.bugstack.chatgpt.data.domain.openai.service.channel.OpenAiGroupService;
import cn.bugstack.chatgpt.data.domain.openai.service.channel.model.IGenerativeModelService;
import cn.bugstack.chatgpt.data.domain.openai.service.channel.model.impl.ImageGenerativeModelChatglmServiceImpl;
import cn.bugstack.chatgpt.data.domain.openai.service.channel.model.impl.TextGenerativeModelChatglmServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description ChatGLM 服务
 * @create 2023-10-15 14:12
 */
@Slf4j
@Service
public class ChatGLMService implements OpenAiGroupService {
    private final Map<GenerativeModelVO, IGenerativeModelService> generativeModelServiceMap = new HashMap<>();
    //这个是构造函数注入还是动态注入？
    public ChatGLMService(ImageGenerativeModelChatglmServiceImpl imageGenerativeModelService, TextGenerativeModelChatglmServiceImpl textGenerativeModelService) {
        generativeModelServiceMap.put(GenerativeModelVO.TEXT, textGenerativeModelService);
        generativeModelServiceMap.put(GenerativeModelVO.IMAGES, imageGenerativeModelService);
    }
    @Override
    public void doMessageResponse(ChatProcessAggregate chatProcess, ResponseBodyEmitter emitter) throws Exception {
        //获得模型值
        generativeModelServiceMap.get(chatProcess.getGenerativeModelVO()).doMessageResponse(chatProcess, emitter);

    }
}
