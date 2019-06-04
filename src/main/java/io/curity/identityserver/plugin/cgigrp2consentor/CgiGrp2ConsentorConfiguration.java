/*
 *  @Copyright 2019 Curity AB
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.curity.identityserver.plugin.cgigrp2consentor;

import se.curity.identityserver.sdk.config.Configuration;
import se.curity.identityserver.sdk.config.annotation.DefaultEnum;
import se.curity.identityserver.sdk.config.annotation.Description;
import se.curity.identityserver.sdk.config.annotation.Name;
import se.curity.identityserver.sdk.service.ExceptionFactory;
import se.curity.identityserver.sdk.service.SessionManager;
import se.curity.identityserver.sdk.service.trust.TrustManagerFactory;

/**
 * Configuration interface for the CGI-GRP2 consentor.
 */
public interface CgiGrp2ConsentorConfiguration extends Configuration
{
    ExceptionFactory getExceptionFactory();

    SessionManager getSessionManager();

    @Name("operational-mode")
    @DefaultEnum("PRODUCTION")
    @Description("The mode that the CGI-GRP2 connection operates.")
    GRPOperationalMode operationalMode();

    @Name("authentication-mode")
    @Description("The endpoint prefix that CGI-GRP2 will use.")
    @DefaultEnum("GRP")
    GRPAuthenticationMode authenticationMode();

    @Name("service-id")
    @Description("The service id provided by CGI-GRP2 as user identifier")
    String serviceId();

    TrustManagerFactory getTrustManagerFactory();
}
