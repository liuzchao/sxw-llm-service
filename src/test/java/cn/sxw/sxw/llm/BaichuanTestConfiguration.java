/*
 * Copyright 2023-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.sxw.sxw.llm;

import org.springframework.ai.baichuan.BaichuanChatModel;
import org.springframework.ai.baichuan.api.BaichuanApi;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;

/**
 * @author Geng Rong
 */
@SpringBootConfiguration
public class BaichuanTestConfiguration {

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

	public void tst() {
	}

}
