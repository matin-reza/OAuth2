package com.auth.config;


import org.springframework.beans.factory.annotation.Value;

/**
 * Created by daz on 01/07/2017.
 */
//@Configuration
public class AppConfig {
    
    /*@Value("${spring.datasource.url}")
    private String datasourceUrl;
    
    @Value("${spring.datasource.driver-class-name}")
    private String dbDriverClassName;
    
    @Value("${spring.datasource.username}")
    private String dbUsername;
    
    @Value("${spring.datasource.password}")
    private String dbPassword;*/
    
    //@Bean
   /* public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        dataSource.setDriverClassName(dbDriverClassName);
        dataSource.setUrl(datasourceUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        
        return dataSource;
    }
    
    //@Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource());
    }
*/}
