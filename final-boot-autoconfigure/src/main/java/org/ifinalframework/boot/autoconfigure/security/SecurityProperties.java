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

package org.ifinalframework.boot.autoconfigure.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import org.ifinalframework.core.IUser;

import lombok.Getter;
import lombok.Setter;

/**
 * SecurityProperties.
 *
 * @author ilikly
 * @version 1.4.3
 * @since 1.4.3
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "spring.security")
public class SecurityProperties {
    Class<? extends IUser<?>> userClass;

    private LogoutProperties logout = new LogoutProperties();

    private BasicProperties basic = new BasicProperties();

    private RememberMeProperties rememberMe = new RememberMeProperties();

    private AnonymousProperties anonymous = new AnonymousProperties();

    @Setter
    @Getter
    public static class BasicProperties {
        private Boolean enable = false;
    }

    @Setter
    @Getter
    public static class RememberMeProperties {
        private Boolean enable = true;
        private Boolean alwaysRemember = false;

    }


    @Setter
    @Getter
    public static class LogoutProperties {
        private Boolean enable = true;

        private String url = "/api/logout";

        private Class<? extends LogoutSuccessHandler> successHandler;
    }

    @Setter
    @Getter
    public static class AnonymousProperties {
        private Boolean enable;
    }
}
