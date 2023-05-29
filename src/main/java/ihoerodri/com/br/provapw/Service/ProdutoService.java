package ihoerodri.com.br.provapw.Service;

import ihoerodri.com.br.provapw.Repository.RepositoryProd;
import ihoerodri.com.br.provapw.model.Produto;
import jakarta.annotation.Resource;
import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private RepositoryProd repositoryProd;

    public ProdutoService(RepositoryProd repositoryProd){
        this.repositoryProd=repositoryProd;
    }
    public void salvar(Produto p){
        repositoryProd.save(p);

    }

    public Optional<Produto> buscar(Long id){
        return repositoryProd.findById(id);

    }

    public void deletar(Long id){
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Produto produto = repositoryProd.getById(id);
       Date data = new Date();
        produto.setDeleted(data);
        repositoryProd.save(produto);

    }

    public List<Produto>findAll(){

        return repositoryProd.findAllByDeletedNull();
    }
}
