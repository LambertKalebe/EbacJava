package ExtendClass;

public class Main {
    public static void main(String[] args) {
        PessoaFisica pf = new PessoaFisica("João", 123456789, "123.456.789-00");
        PessoaJuridica pj = new PessoaJuridica("Empresa X", 987654321, "12.345.678/0001-00");

        pf.exibirInformacoes();
        System.out.println(); 
        pj.exibirInformacoes();
    }
}