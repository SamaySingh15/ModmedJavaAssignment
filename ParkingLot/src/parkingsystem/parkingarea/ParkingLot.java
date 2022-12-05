package parkingsystem.parkingarea;
import java.util.*;

public class ParkingLot {
    private String parkingLotId;
    public String getParkingLotId(){
        return parkingLotId;
    }
    private String Address;
    public String getAddress(){
        return this.Address;
    }
    private List<ParkingFloor> parkingFloors;
    public List<ParkingFloor>  getParkingFloors(){
        return this.parkingFloors;
    }
    private List<EntryGate> entryGates;
    public List<EntryGate> getEntryGates(){
        return this.entryGates;
    }

    private List<ExitGate> exitGates;
    public List<ExitGate> getExitGates(){
        return this.exitGates;
    }


    private ParkingLot(){
        parkingFloors= new ArrayList<ParkingFloor>();
        entryGates = new ArrayList<EntryGate>();
        exitGates = new ArrayList<ExitGate>();
    }

    private static ParkingLot parkingLotinstance = null;

    public static ParkingLot getInstance(){
        if(parkingLotinstance==null){
            parkingLotinstance=new ParkingLot();
        }
         return parkingLotinstance;
    }


}
