package ExtendClass;

public class PessoaFisica extends Pessoa {

    private String cpf;

    //constructor
    public PessoaFisica(String name, int tel, String cpf) {
        super(name, tel);
        this.cpf = cpf;
    }

    //getter
    public String getCpf() {
        return cpf;
    }

    //Setter
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void exibirInformacoes() {
        System.out.println("Nome: " + getName());
        System.out.println("Endereço: " + getTel());
        System.out.println("CNPJ: " + cpf);
    }

}
