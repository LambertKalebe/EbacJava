package com.br.kalebe.dao;

import com.br.kalebe.domain.Produto;
import java.util.List;

public interface IProdutoDAO {
    public Integer cadastrar(Produto produto) throws Exception;

    public Produto consultar(String codigo) throws Exception;

    public Integer excluir(Produto produto) throws Exception;

    public Integer atualizar(Produto produto) throws Exception;

    public Produto buscar(String codigo) throws Exception;

    public List<Produto> buscarTodos() throws Exception;
}
