package ihoerodri.com.br.provapw.Config;

import ihoerodri.com.br.provapw.Repository.UsuarioRepository;
import ihoerodri.com.br.provapw.Service.UsuarioService;
import ihoerodri.com.br.provapw.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Optional;

@Configuration
@EnableWebSecurity
public class SecurityConfig implements UserDetailsService {

final UsuarioRepository userRepository;
public  SecurityConfig(UsuarioRepository userRepository){
    this.userRepository=userRepository;
}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
   Usuario usuar= userRepository.findByUsername(username)
           .orElseThrow(()-> new UsernameNotFoundException("Nçao foi achadoo"+ username));
        return usuar;
    }
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/Admin").hasRole("ADMIN");
                    auth.requestMatchers("/index/**").hasRole("USER");
                    auth.anyRequest().permitAll();
                })
                .formLogin( login -> login.loginPage("/login").permitAll())
                //.defaultSuccessUrl("/", true)
                //.and()
                .logout( logout -> logout.logoutUrl("/logout"))
                //.and()
                .build();
    }

    @Bean
    BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }


}
