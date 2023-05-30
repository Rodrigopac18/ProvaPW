package ihoerodri.com.br.provapw.Service;

import ihoerodri.com.br.provapw.Repository.UsuarioRepository;
import ihoerodri.com.br.provapw.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UsuarioService {

    UsuarioRepository user;
    public UsuarioService(UsuarioRepository user){
    this.user=user;
    }
    public Optional<Usuario> buscar(String name){
        return user.findByUsername(name);
    }


}
