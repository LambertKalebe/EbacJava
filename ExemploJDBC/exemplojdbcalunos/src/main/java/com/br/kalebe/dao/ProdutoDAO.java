package com.br.kalebe.dao;

import com.br.kalebe.dao.jdbc.ConnectionFactory;
import com.br.kalebe.domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO {

    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        String sql = "INSERT INTO TB_PRODUTO (ID, CODIGO, NOME) VALUES (nextval('SQ_PRODUTO'),?,?)";
        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, produto.getCodigo());
            stm.setString(2, produto.getNome());
            return stm.executeUpdate();
        }
    }

    @Override
    public Produto consultar(String codigo) throws Exception {
        String sql = "SELECT * FROM TB_PRODUTO WHERE CODIGO = ?";
        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, codigo);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    Produto produto = new Produto();
                    produto.setId(rs.getLong("id"));
                    produto.setCodigo(rs.getString("codigo"));
                    produto.setNome(rs.getString("nome"));
                    return produto;
                }
            }
        }
        return null;
    }

    @Override
    public Integer excluir(Produto produto) throws Exception {
        String sql = "DELETE FROM TB_PRODUTO WHERE CODIGO = ?";
        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, produto.getCodigo());
            return stm.executeUpdate();
        }
    }

    @Override
    public Integer atualizar(Produto produto) throws Exception {
        String sql = getSqlUpdate();
        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement stm = connection.prepareStatement(sql)) {
            adicionarParametrosUpdate(stm, produto);
            return stm.executeUpdate();
        }
    }

    @Override
    public Produto buscar(String codigo) throws Exception {
        String sql = getSqlSelect();
        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement stm = connection.prepareStatement(sql)) {
            adicionarParametrosSelect(stm, codigo);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    Produto produto = new Produto();
                    produto.setId(rs.getLong("ID"));
                    produto.setNome(rs.getString("NOME"));
                    produto.setCodigo(rs.getString("CODIGO"));
                    return produto;
                }
            }
        }
        return null;
    }

    @Override
    public List<Produto> buscarTodos() throws Exception {
        String sql = getSqlSelectAll();
        List<Produto> list = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
                PreparedStatement stm = connection.prepareStatement(sql);
                ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getLong("ID"));
                produto.setNome(rs.getString("NOME"));
                produto.setCodigo(rs.getString("CODIGO"));
                list.add(produto);
            }
        }
        return list;
    }

    private String getSqlUpdate() {
        return "UPDATE TB_PRODUTO SET NOME = ?, CODIGO = ? WHERE ID = ?";
    }

    private void adicionarParametrosUpdate(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setString(1, produto.getNome());
        stm.setString(2, produto.getCodigo());
        stm.setLong(3, produto.getId());
    }

    private String getSqlSelect() {
        return "SELECT * FROM TB_PRODUTO WHERE CODIGO = ?";
    }

    private void adicionarParametrosSelect(PreparedStatement stm, String codigo) throws SQLException {
        stm.setString(1, codigo);
    }

    private String getSqlSelectAll() {
        return "SELECT * FROM TB_PRODUTO";
    }
}
