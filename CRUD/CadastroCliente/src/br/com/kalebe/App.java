package br.com.kalebe;

import javax.swing.JOptionPane;
import br.com.kalebe.dao.ClienteMapDAO;
import br.com.kalebe.dao.IClienteDAO;
import br.com.kalebe.domain.Cliente;

public class App {
    private static IClienteDAO clienteDAO;

    public static void main(String[] args) {
        clienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastrar, 2 para consultar, 3 para exclusão, 4 para alteração, 5 para sair",
                "Green dinner", JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoSair(opcao)) {
            if (!isOpcaoValida(opcao)) {
                opcao = JOptionPane.showInputDialog(null,
                        "Opção inválida. Digite 1 para cadastrar, 2 para consultar, 3 para exclusão, 4 para alteração, 5 para sair",
                        "Green dinner", JOptionPane.INFORMATION_MESSAGE);
                continue;
            }

            switch (opcao) {
                case "1":
                    String dadosCadastro = JOptionPane.showInputDialog(null,
                            "Digite os dados do cliente separados por vírgula, conforme o exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade, Estado",
                            "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                    cadastrar(dadosCadastro);
                    break;

                case "2":
                    String cpfConsulta = JOptionPane.showInputDialog(null,
                            "Digite o CPF do Cliente", "Consulta de Cliente",
                            JOptionPane.INFORMATION_MESSAGE);
                    consultar(Long.valueOf(cpfConsulta));
                    break;

                case "3":
                    String cpfExclusao = JOptionPane.showInputDialog(null,
                            "Digite o CPF do Cliente", "Exclusão de Cliente",
                            JOptionPane.INFORMATION_MESSAGE);
                    excluir(Long.valueOf(cpfExclusao));
                    break;

                case "4":
                    String dadosAlteracao = JOptionPane.showInputDialog(null,
                            "Digite os dados do Cliente separados por vírgula, conforme o exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade, Estado",
                            "Alteração de Cliente", JOptionPane.INFORMATION_MESSAGE);
                    alterar(dadosAlteracao);
                    break;

                default:
                    break;
            }

            opcao = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastrar, 2 para consultar, 3 para exclusão, 4 para alteração, 5 para sair",
                    "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }

        sair();
    }

    private static boolean isOpcaoValida(String opcao) {
        return "1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao);
    }

    private static boolean isOpcaoSair(String opcao) {
        return "5".equals(opcao);
    }

    private static void cadastrar(String dados) {
        String[] dadosCliente = dados.split(",");
        Cliente cliente = new Cliente(dadosCliente[0].trim(), dadosCliente[1].trim(), dadosCliente[2].trim(), dadosCliente[3].trim(), Integer.parseInt(dadosCliente[4].trim()), dadosCliente[5].trim(), dadosCliente[6].trim());
        clienteDAO.cadastrar(cliente);
        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void consultar(Long cpf) {
        Cliente cliente = clienteDAO.consultar(cpf);
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Cliente encontrado: " + cliente, "Consulta", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Consulta", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void excluir(Long cpf) {
        clienteDAO.excluir(cpf);
        JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!", "Exclusão", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void alterar(String dados) {
        String[] dadosCliente = dados.split(",");
        Cliente cliente = new Cliente(dadosCliente[0].trim(), dadosCliente[1].trim(), dadosCliente[2].trim(), dadosCliente[3].trim(), Integer.parseInt(dadosCliente[4].trim()), dadosCliente[5].trim(), dadosCliente[6].trim());
        clienteDAO.alterar(cliente);
        JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!", "Alteração", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Aplicação encerrada!", "Sair", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
