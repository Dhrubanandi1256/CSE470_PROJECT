//package com.example.demo4;
//
//import com.example.demo4.Model.Role;
//import com.example.demo4.Model.User;
//import com.example.demo4.Repository.RoleRepository;
//import com.example.demo4.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
//import org.springframework.security.web.DefaultRedirectStrategy;
//import org.springframework.security.web.RedirectStrategy;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//
//public class GoogleOAuth2successHandler implements AuthenticationSuccessHandler{
//    @Autowired
//    RoleRepository roleRepository;
//    @Autowired
//    com.example.springtutorial.repository.UserRepository userRepository;
//    private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();
//    private HttpServletResponse httpServletResponse;
//    private HttpServletRequest httpServletRequest;
//
//    @Override
//    public  void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//
//
//        OAuth2AuthenticationToken token=(OAuth2AuthenticationToken) authentication ;
//        String email=token.getPrincipal().getAttributes().get("email").toString();
//        if(userRepository.findUserByEmail(email).isPresent()){
//
//        }
//        else {
//            User user=new User();
//            user.setFirstName(token.getPrincipal().getAttributes().get("given_name").toString());
//            user.setLastName(token.getPrincipal().getAttributes().get("family_name").toString());
//            user.setEmail(email);
//            List<Role>roles =new ArrayList<>();
//            roles.add(roleRepository.findById(2).get());
//            user.setRoles(roles);
//            userRepository.save(user);
//        }
//        redirectStrategy.sendRedirect(httpServletRequest,httpServletResponse,"/");
//    }
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
//
//    }
//}
