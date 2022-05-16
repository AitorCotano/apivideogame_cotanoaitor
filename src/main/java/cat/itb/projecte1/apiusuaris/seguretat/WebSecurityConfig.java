package cat.itb.projecte1.apiusuaris.seguretat;

import cat.itb.projecte1.apiusuaris.model.serveis.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final MyAuthenticationEntryPoint myEntryPoint;
    private final MyUserDetailsService myUserDetailsService;
    private final PasswordEncoder xifrat;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { auth.userDetailsService(myUserDetailsService).passwordEncoder(xifrat); }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .httpBasic()
                .authenticationEntryPoint(myEntryPoint)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/me/**").hasRole("ADMIN") //per fer proves del forbidden
                .antMatchers(HttpMethod.GET, "/users/**", "/videojocs/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/users/**", "/videojocs/**").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/videojocs/**").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/videojocs/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/videojocs/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated();
    }
}
