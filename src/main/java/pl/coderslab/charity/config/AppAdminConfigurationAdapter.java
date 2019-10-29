package pl.coderslab.charity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.coderslab.charity.service.SpringDataUserDetailsService;


@Configuration
@Order(1)
public class AppAdminConfigurationAdapter extends WebSecurityConfigurerAdapter {

    public AppAdminConfigurationAdapter() {
        super();
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/admin*")
                .authorizeRequests()
                .anyRequest()
                .hasRole("ADMIN")

                .and()
                .formLogin()
                .loginPage("/admin/loginAdmin")
                .defaultSuccessUrl("/")

                .and()
                .logout()
                .logoutSuccessUrl("/")

                .and()
                .exceptionHandling()
                .accessDeniedPage("/403");

    }

/*    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }*/


}
