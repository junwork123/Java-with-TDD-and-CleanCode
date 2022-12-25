package org.cleancode.rentcompany.rentcompany;

public class Order {
    private final double distance;

    private final int productId;
    private final String carName;
    private final double fuelEfficiency;

    public Order(double distance, RentProduct product) {
        this.distance = distance;
        this.productId = product.getId();
        this.carName = product.getCarName();
        this.fuelEfficiency = product.getFuelEfficiency(distance);
    }
    public double getDistance() {
        return distance;
    }
    public int getProductId() {
        return productId;
    }
    public double getFuelEfficiency() {
        return fuelEfficiency;
    }
    public String toString() {
        return generateReport();
    }

    public String generateReport() {
        return "차종: " + this.carName
                + ", 주행거리: " + distance + "km, 연비: " + fuelEfficiency + "km/l";
    }
}
