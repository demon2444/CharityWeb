package pl.coderslab.charity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;
import pl.coderslab.charity.service.SpringDataUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private AppAdminConfigurationAdapter admin;
    private AppUserConfigurationAdapter user;

    @Autowired
    public SecurityConfig(AppAdminConfigurationAdapter admin, AppUserConfigurationAdapter user) {
        this.admin = admin;
        this.user = user;
    }



    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/form").authenticated()
                .and().formLogin().loginPage("/login")
                .and().logout().logoutSuccessUrl("/")
                .permitAll()

                .and().exceptionHandling().accessDeniedPage("/403");

    }

     */

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }


}
