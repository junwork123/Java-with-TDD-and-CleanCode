package org.cleancode.rentcompany.rentcompany;

import org.cleancode.rentcompany.cars.*;

public class RentCompany {
    private final RentalProducts products;
    protected RentCompany(RentalProducts products) {
        this.products = products;
    }
    public RentProduct getAvailableProduct(Class<? extends Car> car){
        return products.getAvailableProduct(car);
    }
    public static RentCompany create(){
        RentalProducts products = new RentalProducts();
        products.add(new RentProduct.Builder()
                .car(CarFactory.create(K5.class))
                .isAvailable(true)
                .build());
        products.add(new RentProduct.Builder()
                .car(CarFactory.create(K5.class))
                .isAvailable(true)
                .build());
        products.add(new RentProduct.Builder()
                .car(CarFactory.create(Avante.class))
                .isAvailable(true)
                .build());
        products.add(new RentProduct.Builder()
                .car(CarFactory.create(Avante.class))
                .isAvailable(true)
                .build());
        products.add(new RentProduct.Builder()
                .car(CarFactory.create(Sonata.class))
                .isAvailable(true)
                .build());
        return new RentCompany(products);
    }
}
