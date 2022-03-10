/*
 * Copyright 2020-2022 the original author or authors.
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

package org.ifinalframework.boot.autoconfigure.sharding;

import org.ifinalframework.boot.autoconfigure.sharding.config.ShardingDataSourceSupport;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author likly
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
@ConditionalOnProperty(prefix = ShardingDataSourceProperties.DEFAULT_DATASOURCE_PREFIX, name = "enable", havingValue = "true")
public class ShardingDataSourceAutoConfiguration extends ShardingDataSourceSupport {

}
