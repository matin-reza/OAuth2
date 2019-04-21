package com.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;


@Configuration
@EnableAuthorizationServer
public class OAuthConfiguration extends AuthorizationServerConfigurerAdapter {

    //private final AuthenticationManager authenticationManager;
    //private final AppConfig appConfig;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private UserDetailsServiceImpl userDetailsService;

   /* @Autowired
    private TokenStore tokenStore;

    @Autowired
    private ApprovalStore approvalStore;*/

    @Autowired
    private ClientDetailsService clientDetailsService;

  /*  @Autowired
    private UserApprovalHandler userApprovalHandler;
*/


    /*@Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("acme")
                .authorizedGrantTypes("authorization_code", "refresh_token")
                .scopes("openid")
                .secret("acmesecret").autoApprove(true);
    }

*/
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.userDetailsService(userDetailsService);
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //clients.jdbc(appConfig.dataSource());
        clients.inMemory()
                .withClient("web")
                .secret(new HashingClass().encode("secret"))
                .authorizedGrantTypes("authorization_code")
                .scopes("read,write")
                .accessTokenValiditySeconds(9)
                .refreshTokenValiditySeconds(9);

    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        /*
         * Allow our tokens to be delivered from our token access point as well as for tokens
         * to be validated from this point
         */
        security.passwordEncoder(passwordEncoder).tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
        ;
    }

   /* @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.approvalStore(approvalStore).tokenStore(tokenStore).userApprovalHandler(userApprovalHandler);
                //.authenticationManager(authenticationManager);

    }

    @Bean
    @Autowired
    public TokenStoreUserApprovalHandler userApprovalHandler(TokenStore tokenStore) {
        TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
        handler.setTokenStore(tokenStore);
        handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
        handler.setClientDetailsService(clientDetailsService);
        return handler;
    }

    @Bean
    @Autowired
    public ApprovalStore approvalStore(TokenStore tokenStore) throws Exception {
        TokenApprovalStore store = new TokenApprovalStore();
        store.setTokenStore(tokenStore);
        return store;
    }
*/

}

