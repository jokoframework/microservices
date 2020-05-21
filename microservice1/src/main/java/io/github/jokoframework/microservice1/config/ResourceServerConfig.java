package io.github.jokoframework.microservice1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("microservice1");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http    /*.anonymous()
                .and()*/
                .authorizeRequests()
                .antMatchers("/v1/cities/{id}").permitAll()
                .antMatchers("/v1/cities/country/{countryId}").authenticated();
    }
}
