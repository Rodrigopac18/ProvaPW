package ihoerodri.com.br.provapw.Controller;

import ihoerodri.com.br.provapw.Service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {
    private ProdutoService re;
    @GetMapping("/")
public String LoginMet(){

    return "PagLogin";
}
}
