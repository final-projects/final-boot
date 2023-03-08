/*
 * Copyright 2020-2023 the original author or authors.
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

package org.ifinalframework.boot.flyway;

import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.api.callback.Callback;
import org.flywaydb.core.api.callback.Context;
import org.flywaydb.core.api.callback.Event;

/**
 * CleanFlywaySchemaHistoryCallback.
 *
 * @author ilikly
 * @version 1.5.0
 * @since 1.5.0
 */
@Slf4j
public class CleanFlywaySchemaHistoryCallback implements Callback {

    @Setter
    private String cleanSql = "TRUNCATE TABLE flyway_schema_history;";

    @Override
    public boolean supports(Event event, Context context) {
        return Event.AFTER_MIGRATE_OPERATION_FINISH == event;
    }

    @Override
    public boolean canHandleInTransaction(Event event, Context context) {
        return false;
    }

    @Override
    @SneakyThrows
    public void handle(Event event, Context context) {
        boolean execute = context.getConnection().createStatement().execute(cleanSql);
        logger.info(cleanSql);
    }

    @Override
    public String getCallbackName() {
        return "Clean Flyway Schema History.";
    }
}
