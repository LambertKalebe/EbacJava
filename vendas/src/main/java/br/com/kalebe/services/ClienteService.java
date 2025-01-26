
package br.com.kalebe.services;

import br.com.kalebe.dao.IClienteDAO;
import br.com.kalebe.domain.Cliente;

import br.com.kalebe.services.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);

	}

	@Override
	public Cliente buscarPorCPF(Long cpf) {
		return this.dao.consultar(cpf);
	}

}
