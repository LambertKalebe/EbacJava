/**
 * 
 */
package br.com.kalebe;

import java.math.BigDecimal;

import br.com.kalebe.dao.IProdutoDAO;
import br.com.kalebe.dao.ProdutoDaoMock;
import br.com.kalebe.domain.Produto;
import br.com.kalebe.exceptions.TipoChaveNaoEncontradaException;
import br.com.kalebe.services.IProdutoService;
import br.com.kalebe.services.ProdutoService;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoServiceTest {

	private IProdutoService produtoService;

	private Produto produto;

	public ProdutoServiceTest() {
		IProdutoDAO dao = new ProdutoDaoMock();
		produtoService = new ProdutoService(dao);
	}

	@Before
	public void init() {
		produto = new Produto();
		produto.setCodigo("A1");
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setValor(BigDecimal.TEN);
	}

	@Test
	public void pesquisar() {
		Produto produtor = this.produtoService.consultar(produto.getCodigo());
		Assert.assertNotNull(produtor);
	}

	@Test
	public void salvar() throws TipoChaveNaoEncontradaException {
		Boolean retorno = produtoService.cadastrar(produto);
		Assert.assertTrue(retorno);
	}

	@Test
	public void excluir() {
		produtoService.excluir(produto.getCodigo());
	}

	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		produto.setNome("Kalebe");
		produtoService.alterar(produto);

		Assert.assertEquals("Kalebe", produto.getNome());
	}
}
