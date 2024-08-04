public class Smartphone {
    // Propriedades
    private String marca;
    private String modelo;
    private int capacidadeBateria;
    private double tamanhoTela;

    public Smartphone(String marca, String modelo, int capacidadeBateria, double tamanhoTela) {
        this.marca = marca;
        this.modelo = modelo;
        this.capacidadeBateria = capacidadeBateria;
        this.tamanhoTela = tamanhoTela;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidadeBateria() {
        return capacidadeBateria;
    }

    public void setCapacidadeBateria(int capacidadeBateria) {
        this.capacidadeBateria = capacidadeBateria;
    }

    public double getTamanhoTela() {
        return tamanhoTela;
    }

    public void setTamanhoTela(double tamanhoTela) {
        this.tamanhoTela = tamanhoTela;
    }

    // Exibir informações do smartphone
    public void exibirInformacoes() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Capacidade da Bateria: " + capacidadeBateria);
        System.out.println("Tamanho da Tela: " + tamanhoTela);
    }
}
