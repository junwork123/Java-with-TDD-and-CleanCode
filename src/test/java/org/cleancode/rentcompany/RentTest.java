package org.cleancode.rentcompany;

import org.cleancode.rentcompany.rentcompany.RentalProducts;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RentTest {
    @Test
    public void create(){
        RentalProducts products = new RentalProducts();
        assertThat(products.getTotalCounts()).isEqualTo(RentalProducts.GARAGE_CAPACITY);
    }
}
