package cn.sxw.sxw.llm.config;

import org.springframework.ai.baichuan.BaichuanChatModel;
import org.springframework.ai.baichuan.api.BaichuanApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * 描述:
 *
 * @author 张强
 * @since 2024-11-18 13:32
 */
@Configuration
public class ChatModeConfiguration {

    @Bean
    public BaichuanApi baichuanApi() {
        var apiKey = System.getenv("BAICHUAN_API_KEY");
        apiKey = "sk-131857011ab0b02f0a7439652c209f8e";
        if (!StringUtils.hasText(apiKey)) {
            throw new IllegalArgumentException(
                    "Missing BAICHUAN_API_KEY environment variable. Please set it to your Baichuan API key.");
        }
        return new BaichuanApi(apiKey);
    }

    @Bean
    public BaichuanChatModel baichuanChatModel(BaichuanApi baichuanApi) {
        return new BaichuanChatModel(baichuanApi);
    }

}
