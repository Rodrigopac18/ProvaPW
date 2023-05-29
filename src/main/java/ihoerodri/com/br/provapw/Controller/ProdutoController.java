package ihoerodri.com.br.provapw.Controller;

import ihoerodri.com.br.provapw.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import ihoerodri.com.br.provapw.model.Produto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ProdutoController {
    @Autowired
  private ProdutoService service;
public ProdutoController(ProdutoService service){

    this.service=service;
}


    @GetMapping("/index")
    public String Home(Model model){
    List<Produto>produtoList= service.findAll();
    model.addAttribute("produtoLista", produtoList);
        return "PagHome";
    }
    @GetMapping("/Cadastrar")
    public String CadastrarProdutos(Model model){
        Produto p = new Produto();
        model.addAttribute("prod", p);
     return "PagCadastrarProdutos";
    }

@PostMapping("/salvarProduto")
    public String Salvar(@ModelAttribute @Valid Produto p, Errors errors){

        service.salvar(p);
        return "redirect:/index";

}

    @RequestMapping(value = "/deletar/{id}", method = RequestMethod.GET)
    public String Excluir(@PathVariable(name = "id") Long id){
        service.deletar(id);

        return "redirect:/index";
    }


    @GetMapping("/editarPag/{id}")
    public String Editar(@PathVariable(name = "id") Long id, Model model){
       Optional<Produto> atualiza= service.buscar(id);
        if(atualiza.isPresent()){
            model.addAttribute("atual", atualiza.get());
            return"PagEditar";
        }

        return "redirect:/index";
    }


//    public String Excluir(@PathVariable(name = "id") String id){
//        Optional<Produto> produt = service.buscar(id);
//        if (produt.isPresent()) {
//            service.delete(id);
//        }
//        return "redirect:/index";
//    }


}
