package factory;

import models.*;

public class MarcaAFactory implements CarFactory {
    @Override
    public Sedan criarSedan() {
        return new ModelSedan();
    }

    @Override
    public SUV criarSUV() {
        return new ModelSUV();
    }
}
