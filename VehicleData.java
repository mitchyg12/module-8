public class VehicleData {
    private String make;
    private String model;
    private double milesPerGallon;

    public VehicleData(String make, String model, double milesPerGallon) {
        this.make = make;
        this.model = model;
        this.milesPerGallon = milesPerGallon;
    }

    public double getMilesPerGallon() {
        return milesPerGallon;
    }

    @Override
    public String toString() {
        return "Make: " + make + ", Model: " + model + ", MPG: " + milesPerGallon;
    }
}
