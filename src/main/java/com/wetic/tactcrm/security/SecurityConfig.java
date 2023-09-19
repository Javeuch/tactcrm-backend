package com.wetic.tactcrm.security;
import com.wetic.tactcrm.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.zalando.problem.spring.web.advice.security.SecurityProblemSupport;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UtilisateurService utilisateurService;

    private final SecurityProblemSupport problemSupport;

    public SecurityConfig(SecurityProblemSupport problemSupport) {
        this.problemSupport = problemSupport;
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder.userDetailsService(utilisateurService).passwordEncoder(passEncoder());
    }
    //return response via http when login success
    @Bean
    public AjaxAuthenticationSuccessHandler ajaxAuthenticationSuccessHandler() {
        return new AjaxAuthenticationSuccessHandler();
    }
    //return response via http when login fails
    @Bean
    public AjaxAuthenticationFailureHandler ajaxAuthenticationFailureHandler() {
        return new AjaxAuthenticationFailureHandler();
    }

    @Bean
    public AjaxLogoutSuccessHandler ajaxLogoutSuccessHandler() {
        return new AjaxLogoutSuccessHandler();
    }


    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**")
                .antMatchers("/swagger-ui.html")
                .antMatchers("/test/**");
    }


    @Bean
    public PasswordEncoder passEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(problemSupport)  // comment this line, display form from spring sec
                .accessDeniedHandler(problemSupport)
        .and()
                .formLogin()
                .loginProcessingUrl("/api/authentication")
                .successHandler(ajaxAuthenticationSuccessHandler())
                .failureHandler(ajaxAuthenticationFailureHandler())
                .permitAll()
        .and()
                .logout()
                .logoutUrl("/api/logout")// will return to login page afterward
                .logoutSuccessHandler(ajaxLogoutSuccessHandler())
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .permitAll()
        .and()
                .headers()
                .frameOptions()
                .disable()
        .and()
                .authorizeRequests()
                .antMatchers("/api/account").permitAll()
                .antMatchers("/api/authenticate").permitAll()
                .antMatchers("/api/authentication").permitAll()
                .antMatchers("/api/**").authenticated();
    }
}
