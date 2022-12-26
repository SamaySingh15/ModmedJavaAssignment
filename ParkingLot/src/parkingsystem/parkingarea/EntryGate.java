package parkingsystem.parkingarea;

import parkingsystem.vehicle.Vehicle;

public class EntryGate {
    private String GateId;

    public String getGateId() {
        return GateId;
    }

    public EntryGate(String id){
        this.GateId=id;
    }

    public void generateParkingTicket(Vehicle vehicle){

    }

}
