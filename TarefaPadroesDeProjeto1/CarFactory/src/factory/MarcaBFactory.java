package factory;

import models.*;

public class MarcaBFactory implements CarFactory {
    @Override
    public Sedan criarSedan() {
        return new ModelSedanB();
    }

    @Override
    public SUV criarSUV() {
        return new ModelSUVB();
    }
}
