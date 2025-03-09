package test.main.br.com.kalebe;

import org.junit.Assert.assertEquals;
import org.junit.Assert.assertNotNull;
import org.junit.Assert.assertNull;

import java.util.List;
import org.junit.Test;

import main.br.com.kalebe.dao.ClienteDAO;
import main.br.com.kalebe.dao.IClienteDAO;
import main.br.com.kalebe.domain.Cliente;

public class ClienteTest {

    private IClienteDAO getClienteDAO() {
        return new ClienteDAO();
    }

    private Cliente createCliente(String codigo, String nome) {
        Cliente cliente = new Cliente();
        cliente.setCodigo(codigo);
        cliente.setNome(nome);
        return cliente;
    }

    @Test
    public void testCadastrar() throws Exception {
        IClienteDAO dao = getClienteDAO();
        Cliente cliente = createCliente("01", "Kalebe");
        int countCad = dao.cadastrar(cliente);
        assertEquals("Cadastro deve retornar 1 registro", 1, countCad);

        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        assertNotNull("Cliente não encontrado após cadastro", clienteBD);
        assertNotNull("ID do cliente não foi setado", clienteBD.getId());
        assertEquals("Código divergente", cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals("Nome divergente", cliente.getNome(), clienteBD.getNome());

        int countDel = dao.excluir(clienteBD);
        assertEquals("Exclusão deve retornar 1 registro", 1, countDel);
    }

    @Test
    public void testBuscar() throws Exception {
        IClienteDAO dao = getClienteDAO();
        Cliente cliente = createCliente("10", "Kalebe");
        int countCad = dao.cadastrar(cliente);
        assertEquals("Cadastro deve retornar 1 registro", 1, countCad);

        Cliente clienteBD = dao.buscar(cliente.getCodigo());
        assertNotNull("Cliente não encontrado com o código fornecido", clienteBD);
        assertEquals("Código divergente", cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals("Nome divergente", cliente.getNome(), clienteBD.getNome());

        int countDel = dao.excluir(clienteBD);
        assertEquals("Exclusão deve retornar 1 registro", 1, countDel);
    }

    @Test
    public void testExcluir() throws Exception {
        IClienteDAO dao = getClienteDAO();
        Cliente cliente = createCliente("10", "Kalebe");
        int countCad = dao.cadastrar(cliente);
        assertEquals("Cadastro deve retornar 1 registro", 1, countCad);

        Cliente clienteBD = dao.buscar(cliente.getCodigo());
        assertNotNull("Cliente não encontrado para exclusão", clienteBD);
        assertEquals("Código divergente", cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals("Nome divergente", cliente.getNome(), clienteBD.getNome());

        int countDel = dao.excluir(clienteBD);
        assertEquals("Exclusão deve retornar 1 registro", 1, countDel);
    }

    @Test
    public void testBuscarTodos() throws Exception {
        IClienteDAO dao = getClienteDAO();
        Cliente cliente1 = createCliente("10", "Kalebe");
        Cliente cliente2 = createCliente("20", "Teste");
        int countCad1 = dao.cadastrar(cliente1);
        int countCad2 = dao.cadastrar(cliente2);
        assertEquals("Cadastro do primeiro cliente deve retornar 1 registro", 1, countCad1);
        assertEquals("Cadastro do segundo cliente deve retornar 1 registro", 1, countCad2);

        List<Cliente> listaClientes = dao.buscarTodos();
        assertNotNull("Lista de clientes não pode ser nula", listaClientes);
        assertEquals("A lista deve conter 2 clientes", 2, listaClientes.size());

        // Cleanup: remove all clientes
        for (Cliente cli : listaClientes) {
            int countDel = dao.excluir(cli);
            assertEquals("Exclusão do cliente " + cli.getCodigo() + " deve retornar 1 registro", 1, countDel);
        }

        List<Cliente> listaAposExclusao = dao.buscarTodos();
        assertEquals("A lista deve estar vazia após todas as exclusões", 0, listaAposExclusao.size());
    }

    @Test
    public void testAtualizar() throws Exception {
        IClienteDAO dao = getClienteDAO();
        Cliente cliente = createCliente("10", "Kalebe");
        int countCad = dao.cadastrar(cliente);
        assertEquals("Cadastro deve retornar 1 registro", 1, countCad);

        Cliente clienteBD = dao.buscar(cliente.getCodigo());
        assertNotNull("Cliente não encontrado para atualização", clienteBD);
        assertEquals("Código divergente", cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals("Nome divergente", cliente.getNome(), clienteBD.getNome());

        // Atualiza os dados do cliente
        clienteBD.setCodigo("20");
        clienteBD.setNome("Outro nome");
        int countAtualiza = dao.atualizar(clienteBD);
        assertEquals("Atualização deve retornar 1 registro", 1, countAtualiza);

        Cliente clienteAntigo = dao.buscar("10");
        assertNull("Cliente com código antigo não deve existir", clienteAntigo);

        Cliente clienteAtualizado = dao.buscar("20");
        assertNotNull("Cliente atualizado não encontrado", clienteAtualizado);
        assertEquals("ID divergente após atualização", clienteBD.getId(), clienteAtualizado.getId());
        assertEquals("Código divergente após atualização", clienteBD.getCodigo(), clienteAtualizado.getCodigo());
        assertEquals("Nome divergente após atualização", clienteBD.getNome(), clienteAtualizado.getNome());

        // Cleanup: remove o cliente atualizado
        int countDel = dao.excluir(clienteAtualizado);
        assertEquals("Exclusão do cliente atualizado deve retornar 1 registro", 1, countDel);
    }
}
