package org.cleancode.rentcompany.rentcompany;

import java.util.ArrayList;
import java.util.List;

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

    public int getTotalCounts(){
        return rentMap.size();
    }
}
