package org.cleancode.rentcompany.rentcompany;

import org.cleancode.rentcompany.cars.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RentalProducts {
    public static final int GARAGE_CAPACITY = 5;
    private final List<RentProduct> rentMap;

    public RentalProducts() {
        this.rentMap = new ArrayList<>(GARAGE_CAPACITY);
    }

    public void add(RentProduct rentProduct){
        rentMap.add(rentProduct);
    }

    public int getAvailableCounts(){
        return (int) rentMap.stream().filter(RentProduct::isAvailable).count();
    }
    public RentProduct getAvailableProduct(Class<? extends Car> car){
        return rentMap.stream()
                .filter(RentProduct::isAvailable)
                .filter(rentProduct -> rentProduct.isSameCar(car))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }
    public int getTotalCounts(){
        return rentMap.size();
    }
}
