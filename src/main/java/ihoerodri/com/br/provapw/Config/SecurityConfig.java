//package ihoerodri.com.br.provapw.Config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig{
//
//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(auth -> {
//                    auth.requestMatchers("/admin").hasRole("ADMIN");
//                    auth.requestMatchers("/PagHome/**").hasRole("USER");
//                    auth.anyRequest().permitAll();
//                })
//                .formLogin(login -> login.loginPage("/PagLogin").permitAll())
//                //.defaultSuccessUrl("/PagHome", true)
//                //.and()
//                .logout(logout -> logout.logoutUrl("/logout"))
//                //.and()
//                .build();
//    }
//
//    @Bean
//    BCryptPasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
//}
