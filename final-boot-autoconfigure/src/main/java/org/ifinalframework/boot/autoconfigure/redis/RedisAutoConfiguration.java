/*
 * Copyright 2020-2021 the original author or authors.
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

package org.ifinalframework.boot.autoconfigure.redis;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;

import org.ifinalframework.data.redis.ObjectStringJsonRedisTemplate;
import org.ifinalframework.data.redis.RedisRegistry;

/**
 * @author ilikly
 * @version 1.0.0
 * @since 1.0.0
 * @see org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(RedisOperations.class)
public class RedisAutoConfiguration {

    @Bean
    @ConditionalOnClass(name = "org.ifinalframework.data.redis.ObjectStringJsonRedisTemplate")
    @ConditionalOnMissingBean
    public ObjectStringJsonRedisTemplate objectStringJsonRedisTemplate(final RedisConnectionFactory redisConnectionFactory) {
        ObjectStringJsonRedisTemplate template = new ObjectStringJsonRedisTemplate(redisConnectionFactory);
        RedisRegistry.getInstance().setRedisTemplate(template);
        return template;
    }

}
