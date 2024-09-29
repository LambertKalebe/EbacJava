package factory;

import models.Sedan;
import models.SUV;

public interface CarFactory {
    Sedan criarSedan();
    SUV criarSUV();
}
