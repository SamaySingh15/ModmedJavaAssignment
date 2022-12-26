package parkingsystem.accounts;

import Exceptions.InvalidParkingFloorException;
import parkingsystem.parkingarea.*;

import java.util.List;
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
            try {
                throw new InvalidParkingFloorException("this floor does not exists");
            } catch (InvalidParkingFloorException e) {
                System.out.println("Wrong floor entered or Spot already exits");
                e.printStackTrace();
            }


        else{
            System.out.println("adding spot to floor");
            List<ParkingFloor> floors=ParkingLot.getInstance().getParkingFloors();
            for(ParkingFloor pf: floors){
                if(pf.getFloorId().equalsIgnoreCase(parkingFloorId)){
                    pf.getParkingSpots().get(spot.getParkingSpotType()).add(spot);
                }
            }


        }
    }
    public void addEntrance(EntryGate entrance){
        List<EntryGate> egates = ParkingLot.getInstance().getEntryGates();
        for(EntryGate e : egates){
            if(e.getGateId()==entrance.getGateId()){
                System.out.println("Gate already present");
                return;
            }
        }
        ParkingLot.getInstance().getEntryGates().add(entrance);
        System.out.println("entry gate added successfully");
    }
    public void addExit(ExitGate exit){
        List<ExitGate> egates = ParkingLot.getInstance().getExitGates();
        for(ExitGate e : egates){
            if(e.getGateId()==exit.getGateId()){
                System.out.println("Gate already present");
                return;
            }
        }
        ParkingLot.getInstance().getExitGates().add(exit);
        System.out.println("exit gate added successfully");
    }

}
