package ihoerodri.com.br.provapw.Repository;
import ihoerodri.com.br.provapw.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RepositoryProd extends JpaRepository<Produto, Long>{


    List<Produto> findAllByDeletedNull();

}
