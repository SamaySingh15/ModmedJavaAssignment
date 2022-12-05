package parkingsystem.parkingarea;

public class ParkingSpot {
    private String parkingSpotId;
    private boolean isAvailable;
    private ParkingSpotType parkingSpotType;
    private String vehicleRegNo;
    public ParkingSpot(String parkingspotId , ParkingSpotType parkingSpotType){
        this.parkingSpotId = parkingSpotId;
        this.parkingSpotType= parkingSpotType;
    }
    public void assignvehicle(String registrationNo){this.vehicleRegNo=registrationNo;}
    public void removevehicle(){
        this.isAvailable=true;
        this.vehicleRegNo=null;
    }
}
