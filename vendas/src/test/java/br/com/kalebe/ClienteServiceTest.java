
package br.com.kalebe;

import br.com.kalebe.dao.ClienteDaoMock;
import br.com.kalebe.dao.IClienteDAO;
import br.com.kalebe.domain.Cliente;
import br.com.kalebe.exceptions.TipoChaveNaoEncontradaException;
import br.com.kalebe.services.ClienteService;
import br.com.kalebe.services.IClienteService;

public class ClienteServiceTest {

	private IClienteService clienteService;

	private Cliente cliente;

	public ClienteServiceTest() {
		IClienteDAO dao = new ClienteDaoMock();
		clienteService = new ClienteService(dao);
	}

	@Before
	public void init() {
		cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Kalebe");
		cliente.setCidade("Jundiai");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(30);
		cliente.setTel(1198765432L);

	}

	@Test
	public void pesquisarCliente() {
		Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}

	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException {
		Boolean retorno = clienteService.cadastrar(cliente);

		Assert.assertTrue(retorno);
	}

	@Test
	public void excluirCliente() {
		clienteService.excluir(cliente.getCpf());
	}

	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setNome("Kalebe");
		clienteService.alterar(cliente);

		Assert.assertEquals("Kalebe", cliente.getNome());
	}
}
