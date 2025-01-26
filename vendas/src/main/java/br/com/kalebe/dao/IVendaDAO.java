
package br.com.kalebe.dao;

import br.com.kalebe.dao.generic.IGenericDAO;
import br.com.kalebe.domain.Venda;
import br.com.kalebe.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException;
}
