package kr.co.samsami_service_desk.common.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfigurationSource

@Configuration
class SecurityConfig(private val corsConfiguration: CorsConfigurationSource) {

    companion object {
        private val AUTH_IGNORE_LIST = arrayOf(
            "/js/**", "/css/**", "/image/**", "/api/**",
            "/authentication/login",
            "/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**", "/webjars/**", "/favicon.ico"
        )
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder();
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .cors { it.configurationSource(corsConfiguration) }
            .csrf { it.disable() }
            .httpBasic { it.disable() }
            .formLogin {
                it
                    .loginPage("/login")
                    .loginProcessingUrl("/authentication/login")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/", true)
                    .permitAll()
            }
            .authorizeHttpRequests {
                for (endpoint in AUTH_IGNORE_LIST) {
                    it.requestMatchers(endpoint).permitAll()
                }
                it.anyRequest().authenticated()
            }

        return http.build()
    }
}