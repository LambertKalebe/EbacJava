
package br.com.kalebe;

import java.util.Collection;

import br.com.kalebe.dao.ClienteDAO;
import br.com.kalebe.dao.IClienteDAO;
import br.com.kalebe.domain.Cliente;
import br.com.kalebe.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDAOTest {

	private IClienteDAO clienteDao;

	private Cliente cliente;

	public ClienteDAOTest() {
		clienteDao = new ClienteDAO();
	}

	@Before
	public void init() throws TipoChaveNaoEncontradaException {
		cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Kalebe");
		cliente.setCidade("Jundiai");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(30);
		cliente.setTel(1198765432L);
		clienteDao.cadastrar(cliente);
	}

	@Test
	public void pesquisarCliente() {
		Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}

	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setCpf(12312312312L);
		Boolean retorno = clienteDao.cadastrar(cliente);
		Assert.assertTrue(retorno);
	}

	@Test
	public void excluirCliente() {
		clienteDao.excluir(cliente.getCpf());
	}

	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setNome("Kalebe");
		clienteDao.alterar(cliente);
		Assert.assertEquals("Kalebe", cliente.getNome());
	}

	@Test
	public void buscarTodos() {
		Collection<Cliente> list = clienteDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
	}
}
