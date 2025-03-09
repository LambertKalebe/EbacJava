package com.br.kalebe.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.br.kalebe.dao.IClienteDAO;
import com.br.kalebe.domain.Cliente;

public class ConnectionFactory implements IClienteDAO {
    public static Connection getConnection() throws Exception {
        throw new UnsupportedOperationException("Database connection not implemented.");
    }

    @Override
    public Integer cadastrar(Cliente cliente) throws Exception {
        String sql = "INSERT INTO TB_CLIENTE_2 (ID, CODIGO, NOME) VALUES (nextval('SQ_CLIENTE_2'),?,?)";
        try (Connection connection = getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getCodigo());
            stmt.setString(2, cliente.getNome());
            return stmt.executeUpdate();
        }
    }

    @Override
    public Cliente consultar(String codigo) throws Exception {
        String sql = "SELECT * FROM TB_CLIENTE_2 WHERE CODIGO = ?";
        try (Connection connection = getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setId(rs.getLong("id"));
                    cliente.setCodigo(rs.getString("codigo"));
                    cliente.setNome(rs.getString("nome"));
                    return cliente;
                }
                return null;
            }
        }
    }

    @Override
    public Integer excluir(Cliente cliente) throws Exception {
        String sql = "DELETE FROM TB_CLIENTE_2 WHERE CODIGO = ?";
        try (Connection connection = getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getCodigo());
            return stmt.executeUpdate();
        }
    }

    @Override
    public Integer atualizar(Cliente cliente) throws Exception {
        throw new UnsupportedOperationException("Method 'atualizar' is not implemented yet.");
    }

    @Override
    public Cliente buscar(String codigo) throws Exception {
        throw new UnsupportedOperationException("Method 'buscar' is not implemented yet.");
    }

    @Override
    public List<Cliente> buscarTodos() throws Exception {
        throw new UnsupportedOperationException("Method 'buscarTodos' is not implemented yet.");
    }
}
