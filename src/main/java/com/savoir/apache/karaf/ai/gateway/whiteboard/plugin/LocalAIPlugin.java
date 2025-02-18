/*
 * Copyright (c) 2012-2025 Savoir Technologies, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.savoir.apache.karaf.ai.gateway.whiteboard.plugin;

import com.savoir.apache.karaf.ai.gateway.spi.ExecutorPlugin;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.localai.LocalAiChatModel;
import java.time.Duration;

public class LocalAIPlugin implements ExecutorPlugin {
//----------------------------------------------------------------------------------------------------------------------
// Fields
//----------------------------------------------------------------------------------------------------------------------

    ChatLanguageModel model;
    String modelName;
    String baseUrl;

//----------------------------------------------------------------------------------------------------------------------
// Constructors
//----------------------------------------------------------------------------------------------------------------------

    public LocalAIPlugin(String modelName, String baseUrl) {
        this.modelName = modelName;
        this.baseUrl = baseUrl;
        model =  LocalAiChatModel.builder()
                .baseUrl(this.baseUrl)
                .modelName(this.modelName)
                .temperature(0.8)
                .timeout(Duration.ofSeconds(60))
                .build();
    }

//----------------------------------------------------------------------------------------------------------------------
// Implementation
//----------------------------------------------------------------------------------------------------------------------


    @Override
    public String describe() {
        return "This is the LocalAI plugin.";
    }

    @Override
    public String generate(String prompt) {
        return model.chat(prompt);
    }

}
