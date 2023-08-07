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

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.util.CollectionUtils;

import org.ifinalframework.data.sharding.config.ShardingConfigurer;
import org.ifinalframework.data.sharding.config.ShardingTableRegistry;

import java.util.Map;
import java.util.Objects;

/**
 * SharingRuleConfigurer.
 *
 * @author ilikly
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(ShardingConfigurer.class)
@EnableConfigurationProperties(ShardingRuleProperties.class)
public class SharingRuleConfigurer implements ShardingConfigurer {

    private final ShardingRuleProperties rule;

    public SharingRuleConfigurer(final ShardingRuleProperties rule) {
        this.rule = rule;
    }

    @Override
    public void addShardingTable(@NonNull final ShardingTableRegistry registry) {

        if (Objects.isNull(rule) || CollectionUtils.isEmpty(rule.getTables())) {
            return;
        }

        for (final Map.Entry<String, TableRuleProperties> entry : rule.getTables().entrySet()) {
            String table = entry.getKey();
            TableRuleProperties tableRuleProperties = entry.getValue();
            if (Objects.isNull(tableRuleProperties.getLogicTable())) {
                tableRuleProperties.setLogicTable(table);
            }

        }

    }

}
