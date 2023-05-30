package ihoerodri.com.br.provapw.Controller;

import ihoerodri.com.br.provapw.Service.ProdutoService;
import ihoerodri.com.br.provapw.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UsuarioController {
    @Autowired
    private ProdutoService service;
    public UsuarioController(ProdutoService service){

        this.service=service;
    }
    @GetMapping("/index")
    public String PagHomeUser(Model model){
        List<Produto> produtoList= service.findAll();
        model.addAttribute("produtoLista", produtoList);
    return "UserHome";
    }


}
