package ExtendClass;

public class PessoaJuridica extends Pessoa {
    private String cnpj;

    // Constructor
    public PessoaJuridica(String name, int tel, String cnpj) {
        super(name, tel);
        this.cnpj = cnpj;
    }

    // Getter
    public String getCnpj() {
        return cnpj;
    }

    // Setter
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public void exibirInformacoes() {
        System.out.println("Nome: " + getName());
        System.out.println("Endereço: " + getTel());
        System.out.println("CNPJ: " + cnpj);
    }
}
