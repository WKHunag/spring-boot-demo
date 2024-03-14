package dev.demo.demo.config;

import dev.demo.demo.filter.AuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class WebConfig {
    @Bean
    public FilterRegistrationBean<AuthenticationFilter>  logingFilter() {
        FilterRegistrationBean<AuthenticationFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new AuthenticationFilter());
        registrationBean.addUrlPatterns("/movie/api/*");
        registrationBean.setOrder(2);

        return registrationBean;
    }
}
