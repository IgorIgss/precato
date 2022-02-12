package precato.precato.repository;

import org.springframework.data.repository.CrudRepository;
import precato.precato.model.PagamentoModel;

public interface PagamentoRepository extends CrudRepository<PagamentoModel, String>{
}
