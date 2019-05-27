/*
 *  Copyright 2019 Curity AB
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

package io.curity.identityserver.plugin.descriptor;

import io.curity.identityserver.plugin.cgigrp2consentor.CgiGrp2ConsentorConfiguration;
import io.curity.identityserver.plugin.cgigrp2consentor.CgiGrp2SigningConsentor;
import se.curity.identityserver.sdk.oauth.consent.signing.SigningConsentor;
import se.curity.identityserver.sdk.plugin.descriptor.SigningConsentorPluginDescriptor;

public class CgiGrp2ConsentorPluginDescriptor implements SigningConsentorPluginDescriptor<CgiGrp2ConsentorConfiguration>
{
    @Override
    public Class<? extends SigningConsentor> getConsentorType()
    {
        return CgiGrp2SigningConsentor.class;
    }

    @Override
    public String getPluginImplementationType()
    {
        return "cgi-grpv2-signing-consentor";
    }

    @Override
    public Class<? extends CgiGrp2ConsentorConfiguration> getConfigurationType()
    {
        return CgiGrp2ConsentorConfiguration.class;
    }
}
