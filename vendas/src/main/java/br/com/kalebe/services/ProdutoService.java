
package br.com.kalebe.services;

import br.com.kalebe.dao.IProdutoDAO;
import br.com.kalebe.domain.Produto;
import br.com.kalebe.services.generic.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
