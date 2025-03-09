package com.br.kalebe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.br.kalebe.dao.jdbc.ConnectionFactory;
import com.br.kalebe.domain.Cliente;

public class ClienteDAO implements IClienteDAO {

    @Override
    public Integer cadastrar(Cliente cliente) throws Exception {
        String sql = "INSERT INTO TB_CLIENTE_2 (ID, CODIGO, NOME) VALUES (nextval('SQ_CLIENTE_2'),?,?)";
        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, cliente.getCodigo());
            stm.setString(2, cliente.getNome());
            return stm.executeUpdate();
        }
    }

    @Override
    public Cliente consultar(String codigo) throws Exception {
        String sql = "SELECT * FROM TB_CLIENTE_2 WHERE CODIGO = ?";
        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, codigo);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getLong("id"));
                    cliente.setCodigo(rs.getString("codigo"));
                    cliente.setNome(rs.getString("nome"));
                    return cliente;
                }
            }
        }
        return null;
    }

    @Override
    public Integer excluir(Cliente cliente) throws Exception {
        String sql = "DELETE FROM TB_CLIENTE_2 WHERE CODIGO = ?";
        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, cliente.getCodigo());
            return stm.executeUpdate();
        }
    }

    @Override
    public Integer atualizar(Cliente cliente) throws Exception {
        String sql = getSqlUpdate();
        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement stm = connection.prepareStatement(sql)) {
            adicionarParametrosUpdate(stm, cliente);
            return stm.executeUpdate();
        }
    }

    @Override
    public Cliente buscar(String codigo) throws Exception {
        String sql = getSqlSelect();
        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement stm = connection.prepareStatement(sql)) {
            adicionarParametrosSelect(stm, codigo);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getLong("ID"));
                    cliente.setNome(rs.getString("NOME"));
                    cliente.setCodigo(rs.getString("CODIGO"));
                    return cliente;
                }
            }
        }
        return null;
    }

    @Override
    public List<Cliente> buscarTodos() throws Exception {
        String sql = getSqlSelectAll();
        List<Cliente> list = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement stm = connection.prepareStatement(sql);
                ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getLong("ID"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setCodigo(rs.getString("CODIGO"));
                list.add(cliente);
            }
        }
        return list;
    }

    private String getSqlUpdate() {
        return "UPDATE TB_CLIENTE_2 SET NOME = ?, CODIGO = ? WHERE ID = ?";
    }

    private void adicionarParametrosUpdate(PreparedStatement stm, Cliente cliente) throws SQLException {
        stm.setString(1, cliente.getNome());
        stm.setString(2, cliente.getCodigo());
        stm.setLong(3, cliente.getId());
    }

    private String getSqlSelect() {
        return "SELECT * FROM TB_CLIENTE_2 WHERE CODIGO = ?";
    }

    private void adicionarParametrosSelect(PreparedStatement stm, String codigo) throws SQLException {
        stm.setString(1, codigo);
    }

    private String getSqlSelectAll() {
        return "SELECT * FROM TB_CLIENTE_2";
    }
}
