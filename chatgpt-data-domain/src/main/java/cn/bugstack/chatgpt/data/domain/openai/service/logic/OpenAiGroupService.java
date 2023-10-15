package cn.bugstack.chatgpt.data.domain.openai.service.logic;

import cn.bugstack.chatgpt.data.domain.openai.model.aggregates.ChatProcessAggregate;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 服务组
 * @create 2023-10-15 14:11
 */
public interface OpenAiGroupService {

    void doMessageResponse(ChatProcessAggregate chatProcess, ResponseBodyEmitter emitter) throws JsonProcessingException;

}
