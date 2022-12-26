package parkingsystem.accounts;

import Exceptions.InvalidParkingFloorException;
import parkingsystem.parkingarea.*;

import java.util.Optional;

public class Admin extends UserAccount{

    private String id;
    private String userName;
    private String email;
    private String password;
    private Contactdetails contact;

    private static String admusername = "ParkingAdmin";
    private static String adpassword = "Admin@123";
    public String getAdmusername(){
        return admusername;
    }
    public String getAdpassword(){
        return adpassword;
    }

   // UserAccount(String id , String userName , String email , String password , String personalInfo ,String address ,String phone){
    public Admin(String id , String username , String email ,String password ,String personalInfo , String address , String phone){
        super(id, username , email , password ,personalInfo, address,phone);
    }

    public Boolean adminValidation(){
        if( getAdmusername().equals(super.getUserName()) && getAdpassword().equals(super.getPassword()) ){
            return true;
        }
        else return false;
    }

    public void addFloor(String floorId,ParkingFloor floor){
        Optional<ParkingFloor> pfloor = ParkingLot.getInstance().getParkingFloors().stream().filter(parkingFloor -> parkingFloor.getFloorId().equalsIgnoreCase(floorId)).findFirst();
        if(pfloor.isPresent()) return;
        ParkingLot.getInstance().getParkingFloors().add(floor);

    }
    public void addSpot(String parkingFloorId , ParkingSpot spot){
        Optional<ParkingFloor> pfloor = ParkingLot.getInstance().getParkingFloors().stream().filter(parkingFloor -> parkingFloor.getFloorId().equalsIgnoreCase(parkingFloorId)).findFirst();

        if(!pfloor.isPresent())
            try{
                throw new InvalidParkingFloorException("this floor does not exists");
            }
            catch(InvalidParkingFloorException e){
                e.printStackTrace();
            }
    }
    public void addEntrance(EntryGate entrance){

    }
    public void addExit(ExitGate exit){

    }

}
