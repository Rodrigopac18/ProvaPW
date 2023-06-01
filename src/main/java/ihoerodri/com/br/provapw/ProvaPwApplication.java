package ihoerodri.com.br.provapw;

//import ihoerodri.com.br.provapw.Repository.UsuarioRepository;
import ihoerodri.com.br.provapw.Service.FileStorageService;
//import ihoerodri.com.br.provapw.model.Usuario;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class ProvaPwApplication implements WebMvcConfigurer {

//As rotas de acesso as paginas estava complicado de fazer :(
//    @Bean
//    CommandLineRunner commandLineRunner(UsuarioRepository usuarioRepository, PasswordEncoder encoder) {
//        return args -> {
//
//            List<Usuario> users = Stream.of(
//                    new Usuario(" ", "João", encoder.encode("admin"), true),
//                    new Usuario(" ", "Maria", encoder.encode("user1"), false),
//                    new Usuario(" ", "Pedro", encoder.encode("user2"), false)
//            ).collect(Collectors.toList());
//
//            for (var e : users) {
//                System.out.println(e);
//            }
//            usuarioRepository.saveAll(users);
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(ProvaPwApplication.class, args);
    }

//Tentamos por a imagem, mas para a gravação do video não mostramos, pois estava com erro.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Register resource handler for images
        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/");
    }



}
