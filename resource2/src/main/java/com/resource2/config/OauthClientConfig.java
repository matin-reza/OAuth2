package com.resource2.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@EnableOAuth2Client
@Configuration
public class OauthClientConfig extends ResourceServerConfigurerAdapter {

    private static final String SERVER_RESOURCE_ID = "resource";

    private final AppConfig appConfig;


    @Autowired
    private TokenStore tokenStore;

    @Autowired
    public OauthClientConfig(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore).resourceId(SERVER_RESOURCE_ID);
    }

}

