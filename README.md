# Spring Microservices

## Limits Service
Currently, this is a small service with a single endpoint at: `GET /limits`
which returns a minimum (int) and maximum (int) for limits. These limits
are dynamically defined through Spring's `application.properties` file which
is mapped to a Java class at `io.michaelarnold.limitsservice.configuration.Config`.

The configuration works as follows:
* Annotation `@ConfigurationProperties("<<SERVICE NAME>>")` defines which
properties from `application.properties` to pick up.
* If `<<SERVICE NAME>>` is `limits-service` then all properties from
`application.properties` matching `limits-service.*` will be mapped to their
equivalent inside the class
* As an example, in `application.properties` a variable named
`limits-service.minimum=5` will be mapped to a field inside an instance of the
`Config` class marked with `int minimum`

Further, in `application.properties`, the variable `spring.config.import=...` 
specifies another `server:port` from which we will pull the configuration data
from. In our example, `spring.config.import=optional:configserver:http://localhost:8888`
which means that we are expecting configuration data to be served at `localhost:8888`

We must also specify an application name with the `spring.application.name` variable
in `application.properties`. This name is used and mapped to the name of the
resource being served from our configuration server. For example, if we set the
variable as `spring.application.name=limits-service` then we are expecting that
configuration data specific to our app are being served from
`localhost:8888/limits-service/<<PROFILE NAME>>`

## Spring Cloud Config Server
