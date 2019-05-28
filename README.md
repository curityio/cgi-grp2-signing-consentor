# CGI-GRPv2 Signing Consentor

A consentor that uses the **CGI-GRPv2** for signing the consent data.

This project provides an open source CGI-GRPv2 Signing Consentor plugin for the Curity Identity Server.
This plugin provides the ability to an administrator to add functionality to Curity, which enables the users to sign the consent data using the CGI-GRPv2 API. 
The aforementioned API will be used to sign the consent data along with providing information about the person that signs the data, such as the Swedish personal number. 
For more information on the CGI-GRPv2 and the signing flow please visit <https://doc.funktionstjanster.se/#API/GRP2/>.

## System Requirements

Curity Identity Server 4.1.0 and its system requirements <https://developer.curity.io/docs/latest/system-admin-guide/system-requirements.html> .


### Requirements for Building from Source
The source code is written entirely in Java. Tests are written in Groovy and use *Spock* - http://spockframework.org/ and *Mockito* https://site.mockito.org/.
It can be compiled using Maven 3. The project can be compiled by executing a command like : `mvn clean package`. The build process requires JDK 8.

#### Installation
To install this plugin, either download a binary version available from [the releases section of this project's GitHub repository](https://github.com/curityio/cgi-grp2-signing-consentor/releases) , or compile it from source (as described above). 
If you compiled the plugin from source, the package will be placed in the `target` subdirectory. The resulting JAR file or the one downloaded from GitHub needs to placed in the directory ${IDSVR_HOME}/usr/share/plugins/consent.cgigrp2consentor. 
(The name of the last directory, consent.cgigrp2consentor, which is the plugin group, is arbitrary and can be anything.)

## Creating a CGI-GRPv2 Signing Consentor in Curity
The easiest way to configure a new CGI-GRPv2 Signing Consentor is using the Curity admin UI. The configuration for this can be downloaded as XML or CLI commands later, so only the steps to do this in the GUI will be described.

- Go to the `Profiles` page and click the `Token Service Profile` wherein the consentor instance should be created.
- Navigate lower in the `General` section and at the `Consentors` sub-section click the `New consentor` button.
- Once the pop up shows up, type a name/identifier for the consentor and select the type `Signing`. Click `Next`.

![Create consentor](docs/images/create-consentor.png?raw=true "Create Consentor")

- On the next page, the consentor's specific configuration can be set.

![Update consentor](docs/images/update-consentor.png?raw=true "Update Consentor")

- The first part is a description of the consentor. A free text description can be written.

- The next setting is the `Text to Display Procedure`. The procedure is generating the visible text that the user will sign and will be shown on the forms and the native signing application. 

- The `Token Issuer` responsible for converting the data to be signed to a JWT. The latter will be sent to the signing API (CGI-GRPv2). 

- `WebService`, Enable and configure this if the procedure needs access to a web service in it's context.

- `Attribute Data Source`, Enable and configure this if the procedure needs access an attribute data source in its context.

- The dropdown list of `Signing Consentor Type` to select from.  

- The `Authentication Mode` can be *GRP* or *EID* and points to the two different hosts tha CGI-GRP provides in production, acting as primary and secondary servers. 

- `Operational Mode` can be *test* or *production* and the corresponding environment's endpoints will be called during signing the consent data.

- The `ServiceId` or `Policy` is a customer identifier and can be obtained from CGI. It can be considered as a password for the service endpoints called and is unique per customer. 


### Server truststore configuration
In order for the signing consentor to connect to the CGI-GRPv2 endpoints, the server has to get its trustore updated with the certificates of those endpoints.
For that reason, a new entry in the server trustore can be added as depicted below, by pasting the endpoint's url in the corresponding form.

![Update truststore](docs/images/new-server-truststore.png?raw=true "Update Consentor")

This configuration setting exists under Facilities > Server Trust Stores > + New.  

#### License


This plugin and its associated documentation is listed under the `Apache 2 license` <http://www.apache.org/licenses/LICENSE-2.0>.

#### More Information


Please visit **curity.io** <https://curity.io/> for more information about the **Curity Identity Server**.

*Copyright (C) 2019 Curity AB*.