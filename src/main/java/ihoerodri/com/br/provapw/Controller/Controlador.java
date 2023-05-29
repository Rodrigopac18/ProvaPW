package ihoerodri.com.br.provapw.Controller;

import ihoerodri.com.br.provapw.Repository.RepositoryProd;
import ihoerodri.com.br.provapw.Service.ProdutoService;
import ihoerodri.com.br.provapw.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Controlador {
    private ProdutoService re;
    @GetMapping("/")
public String login(){

    return "Login";
}
}
