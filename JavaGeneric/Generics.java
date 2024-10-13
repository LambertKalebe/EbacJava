package JavaGeneric;

import java.util.ArrayList;
import java.util.List;

class CarList<T> {
    private List<T> cars;

    public CarList() {
        cars = new ArrayList<>();
    }

    public void addCar(T car) {
        cars.add(car);
    }

    public List<T> getCars() {
        return cars;
    }

    public void displayCars() {
        for (T car : cars) {
            System.out.println(car);
        }
    }
}

public class Generics {
    public static void main(String[] args) {
        CarList<String> carList = new CarList<>();
        carList.addCar("Honda");
        carList.addCar("Hyundai");
        carList.addCar("Ford");

        carList.displayCars();
    }
}
