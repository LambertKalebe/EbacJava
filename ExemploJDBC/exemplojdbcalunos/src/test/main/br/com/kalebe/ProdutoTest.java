import com.br.kalebe.domain.Produto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class ProdutoTest {

    private IProdutoDAO produtoDAO;

    @BeforeEach
    public void setUp() {
        produtoDAO = new ProdutoDAO();
    }

    @Test
    public void testAddAndFindById() {
        Produto produto = new Produto(1, "Produto1", 10.0);
        produtoDAO.add(produto);
        Produto found = produtoDAO.findById(1);
        Assertions.assertNotNull(found);
        Assertions.assertEquals("Produto1", found.getNome());
    }

    @Test
    public void testFindAll() {
        Produto produto1 = new Produto(1, "Produto1", 10.0);
        Produto produto2 = new Produto(2, "Produto2", 20.0);
        produtoDAO.add(produto1);
        produtoDAO.add(produto2);
        List<Produto> produtos = produtoDAO.findAll();
        Assertions.assertEquals(2, produtos.size());
    }

    @Test
    public void testUpdate() {
        Produto produto = new Produto(1, "Produto1", 10.0);
        produtoDAO.add(produto);
        Produto updatedProduto = new Produto(1, "Produto1Updated", 15.0);
        produtoDAO.update(updatedProduto);
        Produto found = produtoDAO.findById(1);
        Assertions.assertEquals("Produto1Updated", found.getNome());
        Assertions.assertEquals(15.0, found.getPreco());
    }

    @Test
    public void testDelete() {
        Produto produto = new Produto(1, "Produto1", 10.0);
        produtoDAO.add(produto);
        produtoDAO.delete(1);
        Produto found = produtoDAO.findById(1);
        Assertions.assertNull(found);
    }
}