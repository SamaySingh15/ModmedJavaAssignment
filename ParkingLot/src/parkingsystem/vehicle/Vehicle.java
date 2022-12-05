package parkingsystem.vehicle;

public abstract class Vehicle {
    private String registrationNumber;
    private final VehicleCategory category;
    private Ticket ticket;

    public Vehicle(String rc , VehicleCategory category){
        this.registrationNumber=rc;
        this.category=category;
    }

}
