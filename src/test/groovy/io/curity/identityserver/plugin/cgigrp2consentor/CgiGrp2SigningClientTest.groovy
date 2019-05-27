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

package io.curity.identityserver.plugin.cgigrp2consentor

import se.curity.identityserver.sdk.service.ExceptionFactory
import se.curity.identityserver.sdk.service.trust.TrustManagerFactory
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations

import static org.mockito.Mockito.*

class CgiGrp2SigningClientTest extends Specification {

    @Mock
    ExceptionFactory _exceptionFactory
    @Mock
    TrustManagerFactory _trustManagerFactory
    @InjectMocks
    CgiGrp2SigningClient cgiGrp2SigningClient

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test get Domain Name"() {
        given:
        when(_exceptionFactory.configurationException(anyString()))
                .thenReturn(new RuntimeException("Domain name for CGI-GRP endpoint could not be parsed"))

        when:
        def domain = cgiGrp2SigningClient.getDomainName(url)

        then:
        domain == expectedDomain

        where:
        url                                              | expectedDomain
        "https://eidt.funktionstjanster.se:18898/grp/v2" | "eidt.funktionstjanster.se"
        "https://grpt.funktionstjanster.se:18898/grp/v2" | "grpt.funktionstjanster.se"
        "https://eid.funktionstjanster.se:8890/grp/v2"   | "eid.funktionstjanster.se"
        "https://grp.funktionstjanster.se:8890/grp/v2"   | "grp.funktionstjanster.se"
    }

    def "test get Domain Name throwing when not being able to parse domain"() {
        given:
        when(_exceptionFactory.configurationException(anyString()))
                .thenReturn(new RuntimeException("Domain name for CGI-GRP endpoint could not be parsed"))

        when:
        cgiGrp2SigningClient.getDomainName(url)

        then:
        def error = thrown(expectedException)
        error.message == expectedMessage

        where:
        url    || expectedException | expectedMessage
        "foo"  || RuntimeException  | "Domain name for CGI-GRP endpoint could not be parsed"
        "test" || RuntimeException  | "Domain name for CGI-GRP endpoint could not be parsed"
    }
}