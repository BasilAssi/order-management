package com.example.webservciesfinalproject.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.example.webservciesfinalproject.user.Permission.ADMIN_READ;
import static com.example.webservciesfinalproject.user.Permission.CUSTOMER_READ;
import static com.example.webservciesfinalproject.user.Role.ADMIN;
import static com.example.webservciesfinalproject.user.Role.CUSTOMER;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {

  private final JwtAuthenticationFilter jwtAuthFilter;
  private final AuthenticationProvider authenticationProvider;


  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      return http
              .csrf(AbstractHttpConfigurer::disable)
              .cors(AbstractHttpConfigurer::disable)
              .authorizeHttpRequests(auth -> auth
                      .requestMatchers("/api/v1/auth/**","/swagger-ui/**", "/v3/api-docs/**").permitAll()
                      .requestMatchers(HttpMethod.GET,"/api/v1/products").permitAll()
                      .requestMatchers(HttpMethod.GET,"/api/v1/products/{id}").permitAll()
                      .requestMatchers("/api/v1/products").hasAnyAuthority(ADMIN.name())

                      .requestMatchers("/api/v1/customers").hasAnyAuthority(ADMIN.name())
                      .requestMatchers("/api/v1/customers/{id}").hasAnyAuthority(ADMIN.name() ,CUSTOMER.name())




                      .requestMatchers("/api/v1/products/{productId}/stocks").hasAnyAuthority(ADMIN.name())
                      .requestMatchers("/api/v1/products/{productId}/stocks/{id}").hasAnyAuthority(ADMIN.name())



                      .requestMatchers("/api/v1/customers/{customerId}/orders").hasAnyAuthority(CUSTOMER.name() ,ADMIN.name())
                      .requestMatchers("/api/v1/customers/{customerId}/orders/{id}").hasAnyAuthority(CUSTOMER.name() ,ADMIN.name())




                      .requestMatchers("/api/v1/customers/{customerId}/orders/{orderId}/products").hasAnyAuthority(CUSTOMER.name(),ADMIN.name() )
                      .requestMatchers("/api/v1/customers/{customerId}/orders/{orderId}/products/{productId}").hasAnyAuthority(CUSTOMER.name() , ADMIN.name())

                     // .requestMatchers("/api/v1/customers").hasAuthority(ADMIN.name())
                      .anyRequest().authenticated())
//              .authorizeHttpRequests(auth ->
//                              auth.requestMatchers("/api/v1/customers/**").hasRole(CUSTOMER.name())
//                                      ,auth.requestMatchers("/api/v1/auth/**").permitAll().anyRequest().authenticated())
              .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
              .authenticationProvider(authenticationProvider)
              .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
              .build();
  }

//        .requestMatchers("/api/v1/management/**").hasAnyRole(ADMIN.name(), CUSTOMER.name())
//
//
//        .requestMatchers(GET, "/api/v1/management/**").hasAnyAuthority(ADMIN_READ.name(), MANAGER_READ.name())
//        .requestMatchers(POST, "/api/v1/management/**").hasAnyAuthority(ADMIN_CREATE.name(), MANAGER_CREATE.name())
//        .requestMatchers(PUT, "/api/v1/management/**").hasAnyAuthority(ADMIN_UPDATE.name(), MANAGER_UPDATE.name())
//        .requestMatchers(DELETE, "/api/v1/management/**").hasAnyAuthority(ADMIN_DELETE.name(), MANAGER_DELETE.name())
//
//
//       /* .requestMatchers("/api/v1/admin/**").hasRole(ADMIN.name())
//
//        .requestMatchers(GET, "/api/v1/admin/**").hasAuthority(ADMIN_READ.name())
//        .requestMatchers(POST, "/api/v1/admin/**").hasAuthority(ADMIN_CREATE.name())
//        .requestMatchers(PUT, "/api/v1/admin/**").hasAuthority(ADMIN_UPDATE.name())
//        .requestMatchers(DELETE, "/api/v1/admin/**").hasAuthority(ADMIN_DELETE.name())*/
//
//
//        .anyRequest()
//          .authenticated()
//        .and()
//          .sessionManagement()
//          .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//        .and()
//        .authenticationProvider(authenticationProvider)
//        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
//        .logout()
//        .logoutUrl("/api/v1/auth/logout")
//        .addLogoutHandler(logoutHandler)
//        .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())


}
