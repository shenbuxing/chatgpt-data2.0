package cn.bugstack.chatgpt.data.types.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 模型对象
 * @create 2023-10-15 13:59
 */
@Getter
@AllArgsConstructor
public enum ChatGLMModel {
    CHATGLM_6B_SSE("chatGLM_6b_SSE"),
    CHATGLM_LITE("chatglm_lite"),
    CHATGLM_LITE_32K("chatglm_lite_32k"),
    CHATGLM_STD("chatglm_std"),
    CHATGLM_PRO("chatglm_pro"),
    COGVIEW_3("COGVIEW_3"),
    CHATGLM_Turbo("CHATGLM_Turbo"),
    GLM_3_5_TURBO("GLM_3_5_TURBO"),
    GLM_4("GLM_4"),
    GLM_4V("GLM_4")
    ;
    private final String code;
    public static ChatGLMModel get(String code){
        switch (code){
            case "chatGLM_6b_SSE":
                return ChatGLMModel.CHATGLM_6B_SSE;
            case "chatglm_lite":
                return ChatGLMModel.CHATGLM_LITE;
            case "chatglm_lite_32k":
                return ChatGLMModel.CHATGLM_LITE_32K;
            case "chatglm_std":
                return ChatGLMModel.CHATGLM_STD;
            case "chatglm_pro":
                return ChatGLMModel.CHATGLM_PRO;
            case "COGVIEW_3":
                return ChatGLMModel.COGVIEW_3;
            case "CHATGLM_Turbo":
                return ChatGLMModel.CHATGLM_Turbo;
            case "GLM_3_5_TURBO":
                return ChatGLMModel.GLM_3_5_TURBO;
            case "GLM_4":
                return ChatGLMModel.GLM_4;
            case "GLM_4V":
                return ChatGLMModel.GLM_4V;
            default:
                return ChatGLMModel.GLM_3_5_TURBO;
        }
    }

}
