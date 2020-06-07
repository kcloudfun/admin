package com.likai.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

/**
 * Spring Security配置类
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 定义一个密码转换器，用来加密
     *
     * @return
     */
    @Bean
    public PasswordEncoder encoder() {
        //支持的加密方式有：
        // BCryptPasswordEncoder（使用bcrypt强哈希加密）、Pbkdf2PasswordEncoder（使用PBKDF2加密）
        // SCryptPasswordEncoder（使用scrypt哈希加密）、StandardPasswordEncoder（使用SHA-256哈希加密）
        return new StandardPasswordEncoder("likai");
    }

    @Qualifier("userServiceImpl")
    @Autowired(required = false)
    private UserDetailsService userService;

    /**
     * 重写此方法来覆盖默认的查找用户规则
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(encoder());
    }

    /**
     * 重写此方法来配置在Web级别该如何处理安全性
     * 功能包括：在为某个请求提供服务之前，需要预先满足特定的条件；配置自定义的登录页面；支持用户退出应用；预防跨站请求伪造。
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        //这里定义了ADMIN权限的用户才能访问swagger页面，除此之外，其他所有用户都能访问
        //这里的规则定义有先后顺序区别，定义在前面的优先级比后面的优先级高
        http.authorizeRequests().antMatchers("/swagger-ui.html#/").hasRole("ADMIN")
                .antMatchers("/", "/**").permitAll();
    }
}
