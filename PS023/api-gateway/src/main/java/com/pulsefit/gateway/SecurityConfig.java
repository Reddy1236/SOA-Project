package com.pulsefit.gateway;
import javax.crypto.spec.SecretKeySpec; import org.springframework.context.annotation.Bean; import org.springframework.context.annotation.Configuration; import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity; import org.springframework.security.config.web.server.ServerHttpSecurity; import org.springframework.security.oauth2.jwt.JwtDecoder; import org.springframework.security.oauth2.jwt.NimbusJwtDecoder; import org.springframework.security.web.server.SecurityWebFilterChain;
@Configuration @EnableWebFluxSecurity public class SecurityConfig {
 @Bean SecurityWebFilterChain security(ServerHttpSecurity http){ return http.csrf(ServerHttpSecurity.CsrfSpec::disable).authorizeExchange(e->e.pathMatchers("/api/auth/**","/actuator/health").permitAll().anyExchange().authenticated()).oauth2ResourceServer(o->o.jwt(j->{})).build(); }
 @Bean JwtDecoder jwtDecoder(){ return NimbusJwtDecoder.withSecretKey(new SecretKeySpec("PulseFit-PS023-JWT-Secret-Key-2026-ChangeMe-32Bytes".getBytes(),"HmacSHA256")).build(); }
}
