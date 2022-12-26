package parkingsystem.parkingarea;

public class ParkingSpot{
    private String parkingSpotId;

    public String getParkingSpotId() {
        return parkingSpotId;
    }

    private boolean isAvailable;

    public void setAvailable(boolean available){
        isAvailable = available;
    }
    public boolean getAvailable(){
        return isAvailable;
    }

    private ParkingSpotType parkingSpotType;
    private String vehicleRegNo;

    public String getVehicleRegNo() {
        return vehicleRegNo;
    }

    public ParkingSpot(String parkingspot , ParkingSpotType parkingSpotType){
        this.parkingSpotId = parkingspot;
        this.parkingSpotType= parkingSpotType;
    }
    public void assignvehicle(String registrationNo){this.vehicleRegNo=registrationNo;}
    public void removevehicle(){
        this.isAvailable=true;
        this.vehicleRegNo=null;
    }
}
