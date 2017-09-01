package io.tusted.article.configuration;

import io.tusted.article.endpoint.ArticleEndpoint;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/spring-app")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(ArticleEndpoint.class);
    }


}
