//-------TUDO QUE TENHA HAVER COM O USUÁRIO(Admin/User) COMENTAMOS.

//package ihoerodri.com.br.provapw.Service;
//
//import ihoerodri.com.br.provapw.Repository.UsuarioRepository;
//import ihoerodri.com.br.provapw.model.Produto;
//import ihoerodri.com.br.provapw.model.Usuario;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UsuarioService implements UserDetailsService {
//
//    UsuarioRepository repository;
//    BCryptPasswordEncoder encoder;
//    @Autowired
//    public UsuarioService(UsuarioRepository repository, BCryptPasswordEncoder encoder) {
//        this.repository = repository;
//        this.encoder = encoder;
//    }
//
//    public void create(Usuario u){
//        u.setSenha(encoder.encode(u.getPassword()));
//        this.repository.save(u);
//    }
//
//    public List<Usuario>findAll(){
//
//        return repository.findAll();
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        Optional<Usuario> user = repository.findByUsername(username);
//        if (user.isPresent()){
//            return user.get();
//        }else{
//            throw new UsernameNotFoundException("Username not found");
//        }
//    }
//
//    public List<Usuario> listAll(){
//        return  repository.findAll();
//    }
//}