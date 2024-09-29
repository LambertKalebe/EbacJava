import factory.CarFactory;
import factory.MarcaAFactory;
import factory.MarcaBFactory;
import models.Sedan;
import models.SUV;

public class Cliente {
    public static void main(String[] args) {
        // Fábrica da Marca A
        CarFactory fabricaA = new MarcaAFactory();
        Sedan sedanA = fabricaA.criarSedan();
        SUV suvA = fabricaA.criarSUV();
        
        sedanA.exibirInfoSedan();
        suvA.exibirInfoSUV();
        
        // Fábrica da Marca B
        CarFactory fabricaB = new MarcaBFactory();
        Sedan sedanB = fabricaB.criarSedan();
        SUV suvB = fabricaB.criarSUV();
        
        sedanB.exibirInfoSedan();
        suvB.exibirInfoSUV();
    }
}
