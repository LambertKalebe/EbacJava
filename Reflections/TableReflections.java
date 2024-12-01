package Reflections;


import Annotations.tabela;

public class TableReflections {
    public static void main(String[] args) {
        Class<?> classe = MinhaClasse.class;
        
        tabela tabelaAnnotation = classe.getAnnotation(tabela.class);
            String nomeTabela = tabelaAnnotation.nome();
            System.out.println("Nome da tabela: " + nomeTabela);
    }
}

@tabela(nome = "TabelaTeste")
class MinhaClasse {
}
