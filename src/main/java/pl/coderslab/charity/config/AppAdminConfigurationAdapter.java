package pl.coderslab.charity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


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
                .defaultSuccessUrl("/admin/panel")

                .and()
                .logout()
                .logoutSuccessUrl("/admin_logout")

                .and()
                .exceptionHandling()
                .accessDeniedPage("/403");

    }


}
