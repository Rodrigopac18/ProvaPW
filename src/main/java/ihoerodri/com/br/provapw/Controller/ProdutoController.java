package ihoerodri.com.br.provapw.Controller;

import ihoerodri.com.br.provapw.Service.FileStorageService;
import ihoerodri.com.br.provapw.Service.ProdutoService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import ihoerodri.com.br.provapw.model.Produto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class ProdutoController {

    FileStorageService fileStorageService;
    ProdutoService service;
    private List<Produto> carrinho = new ArrayList<>();

    @Autowired
    public ProdutoController(FileStorageService fileStorageService, ProdutoService service) {
        this.fileStorageService = fileStorageService;
        this.service = service;
    }

    @GetMapping({"/", "/index"})
    public String PagHome(Model model, HttpServletResponse response) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss:SSS");
        Date date = new Date();
        Cookie cookie = new Cookie("visita", dateFormat.format(date));
        cookie.setMaxAge(60 * 60 * 24); // 24horas
        response.addCookie(cookie);
        List<Produto> produtoList = service.findAll();
        int tamanho= service.SizeCarrinho(carrinho);
        model.addAttribute("produtoLista", produtoList);
        model.addAttribute("tam", tamanho);

        return "UserHome";
    }


    @GetMapping("/admin")
    public String HomeAdmin(Model model) {
        List<Produto> produtoList = service.findAll();
        model.addAttribute("produtoLista", produtoList);
        return "PagHome";
    }

    @GetMapping("/cadastrarProdutos")
    public String CadastrarProdutos(Model model) {
        Produto p = new Produto();
        model.addAttribute("prod", p);
        return "PagCadastrarProdutos";
    }

    @PostMapping("/salvarProduto")
    // @RequestParam(name = "file") MultipartFile file
    public String Salvar(@ModelAttribute @Valid Produto p, RedirectAttributes redirectAttributes, Errors erro) {
        if(erro.hasErrors()){
            return "PagCadastrarProdutos";

        }else{


            this.service.salvar(p);
            redirectAttributes.addAttribute("msg", "Cadastro realizado com sucesso");
            return "redirect:/admin";
        }


    }

    @RequestMapping(value = "/deletar/{id}", method = RequestMethod.GET)
    public String Excluir(@PathVariable(name = "id") Long id) {
        service.deletar(id);

        return "redirect:/admin";
    }

    @GetMapping("/editar/{id}")
    public String Editar(@PathVariable(name = "id") Long id, Model model) {
        Optional<Produto> atualiza = service.buscar(id);
        if (atualiza.isPresent()) {
            model.addAttribute("atual", atualiza.get());
            return "PagEditar";
        }

        return "redirect:/admin";
    }

    @GetMapping("/adicionarCarrinho/{id}")
    public String AddCarrinho(Model model, @PathVariable(name = "id") Long id, HttpServletRequest request) {
        service.buscar(id);
        HttpSession session = request.getSession();

        if (session.getAttribute("carrinho") == null) {
            session.setAttribute("carrinho", new ArrayList<Produto>());
        }
         carrinho = (ArrayList<Produto>) session.getAttribute("carrinho");

        carrinho.add(service.BuscarID(id));

        model.addAttribute("array", carrinho.size());
        return "redirect:/index";
    }
//@GetMapping("/visualizarCarrinho")
//       public String VerCarrinho(Model model){
//
//       return "PagVisualizarCarrinho";
//       }
    @RequestMapping("/verCarrinho")
    public String getCarrinho(Model model, HttpServletRequest request){
        System.out.println(service.findAll());
        HttpSession session = request.getSession();
        if(session.getAttribute("carrinho")!=null){
            carrinho = (ArrayList<Produto>) session.getAttribute("carrinho");
            model.addAttribute("listCar",carrinho);
            System.out.println(carrinho);
            return "PagVisualizarCarrinho";

        }

        return "redirect:/?message=Não existe produtos no carrinho";

    }
//    public String Excluir(@PathVariable(name = "id") String id){
//        Optional<Produto> produt = service.buscar(id);
//        if (produt.isPresent()) {
//            service.delete(id);
//        }
//        return "redirect:/index";
//    }


}
