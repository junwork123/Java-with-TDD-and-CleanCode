package org.cleancode.rentcompany;

import org.cleancode.rentcompany.cars.K5;
import org.cleancode.rentcompany.rentcompany.Order;
import org.cleancode.rentcompany.rentcompany.RentCompany;
import org.cleancode.rentcompany.rentcompany.RentProduct;
import org.cleancode.rentcompany.rentcompany.RentalProducts;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RentTest {
    @Test
    public void createProduct(){
        RentalProducts products = new RentalProducts();
        assertThat(products.getTotalCounts()).isEqualTo(RentalProducts.GARAGE_CAPACITY);
    }
    @Test
    public void order(){
        RentCompany company = RentCompany.create();
        RentProduct product = company.getAvailableProduct(K5.class);
        Order order = new Order(130, product);
        assertThat(order.getDistance()).isEqualTo(130);
        assertThat(order.getFuelEfficiency()).isEqualTo(10);
    }
}
