package com.pet.mall.demo.config;

import com.pet.mall.demo.bo.AdminUserDetails;
import com.pet.mall.mapper.UmsAdminMapper;
import com.pet.mall.model.UmsAdmin;
import com.pet.mall.model.UmsAdminExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

/**
 * SpringSecurity related configuration
 * Created by pet on 2018/4/26.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//Configure authority
//                .antMatchers("/").access("hasRole('TEST')")//this path need TEST role
//                .antMatchers("/brand/list").hasAuthority("TEST")//need TEST authority
                .antMatchers("/**").permitAll()
                .and()//Enable HTTP-based authentication
                .httpBasic()
                .realmName("/")
                .and()//Configure login page
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .and()//Configure logout path
                .logout()
                .logoutSuccessUrl("/")
//                .and()//remember password
//                .rememberMe()
//                .tokenValiditySeconds(60*60*24)
//                .key("rememberMeKey")
                .and()//Turn off CSRF
                .csrf()
                .disable()
                .headers()//remove X-Frame-Options
                .frameOptions()
                .disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public UserDetailsService userDetailsService() {
        //Get login user detail
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                UmsAdminExample example = new UmsAdminExample();
                example.createCriteria().andUsernameEqualTo(username);
                List<UmsAdmin> umsAdminList = umsAdminMapper.selectByExample(example);
                if (umsAdminList != null && umsAdminList.size() > 0) {
                    return new AdminUserDetails(umsAdminList.get(0));
                }
                throw new UsernameNotFoundException("Incorrect username or password");
            }
        };
    }
}
