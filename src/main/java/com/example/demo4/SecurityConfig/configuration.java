//package com.example.demo4.SecurityConfig;
//
//import com.example.demo4.GoogleOAuth2successHandler;
//import com.example.demo4.Service.CustomUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class configuration extends WebSecurityConfigurerAdapter  {
//    GoogleOAuth2successHandler googleOAuth2successHandler;
//   // @Autowired
//   // CustomUserDetailsService customUserDetailsService;
//    protected void configure(HttpSecurity http) throws Exception {
////        http
////                .authorizeRequests()
////               .antMatchers("/", "/shop/**", "forgotpassword", "/register", "/h2-console/**").permitAll()
////                .antMatchers("/admin/**").hasRole("ADMIN")
////                .anyRequest()
////                .authenticated()
////                .and()
////                .formLogin()
////                .loginPage("/login")
////                .permitAll()
////                .failureUrl("/login?error=true")
////                .defaultSuccessUrl("/")
////                .usernameParameter("email")
////                .passwordParameter("password")
////                .and()
////                .oauth2Login()
////                .loginPage("/login")
////                .successHandler(googleOAuth2successHandler)
////                .and()
////                .logout()
////                .logoutRequestMatcher(new AntPathRequestMatcher("/lohout"))
////                .logoutSuccessUrl("/login")
////                .invalidateHttpSession(true)
////                .deleteCookies("JSESSSIONID")
////                .and()
////                .exceptionHandling()
////                .and()
////                .csrf()
////                .disable();
////        http.headers().frameOptions().disable();//for h3
////
////
////
////
//    }
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
////
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(customUserDetailsService);
////    }
//
////    @Override
////    public void configure(WebSecurity web) throws Exception {
////        web.ignoring().antMatchers("/resources/**","/static/**","/images/**","/productimages/**","/css/**","/js/**");
////    }
//}
