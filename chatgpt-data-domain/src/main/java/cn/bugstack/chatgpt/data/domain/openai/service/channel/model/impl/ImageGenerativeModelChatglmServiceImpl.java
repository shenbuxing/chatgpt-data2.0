package cn.bugstack.chatgpt.data.domain.openai.service.channel.model.impl;
import cn.bugstack.chatglm.model.ImageCompletionRequest;
import cn.bugstack.chatglm.model.ImageCompletionResponse;
import cn.bugstack.chatglm.model.Model;
import cn.bugstack.chatglm.session.OpenAiSession;
import cn.bugstack.chatgpt.common.Constants;
import cn.bugstack.chatgpt.data.domain.openai.model.aggregates.ChatProcessAggregate;
import cn.bugstack.chatgpt.data.domain.openai.model.entity.MessageEntity;
import cn.bugstack.chatgpt.data.domain.openai.service.channel.model.IGenerativeModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
@Slf4j
@Service
public class ImageGenerativeModelChatglmServiceImpl implements IGenerativeModelService {

    @Autowired(required = false)
    protected OpenAiSession chatGlMOpenAiSession;
    @Resource
    private ThreadPoolExecutor executor;
    @Override
    public void doMessageResponse(ChatProcessAggregate chatProcess, ResponseBodyEmitter emitter) throws Exception {
        if (null == chatGlMOpenAiSession) {
            emitter.send(chatProcess.getModel()+"通道，模型调用未开启，可以选择其他模型对话！");
            return;
        }
        // 封装请求信息
        StringBuilder prompt = new StringBuilder();
        List<MessageEntity> messages = chatProcess.getMessages();
        for (MessageEntity message : messages) {
            String role = message.getRole();
            if (Constants.Role.USER.getCode().equals(role)) {
                prompt.append(message.getContent());
                prompt.append("\r\n");
            }
        }
        // 绘图请求信息
        ImageCompletionRequest request = new ImageCompletionRequest();
        request.setModel(Model.valueOf(chatProcess.getModel()));
        request.setPrompt(prompt.toString());
        emitter.send("您的😊图片正在生成中，请耐心等待... \r\n");
        executor.execute(() -> {
            ImageCompletionResponse imageResponse ;
            try {
                imageResponse = chatGlMOpenAiSession.genImages(request);
                List<ImageCompletionResponse.Image> images = imageResponse.getData();
                for (ImageCompletionResponse.Image image : images) {
                    String url = image.getUrl();
                    emitter.send("![](" + url + ")");
                }
                emitter.complete();
            } catch (IOException e) {
                try {
                    emitter.send("您的😭图片生成失败了，请调整说明... \r\n");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

    }
}
