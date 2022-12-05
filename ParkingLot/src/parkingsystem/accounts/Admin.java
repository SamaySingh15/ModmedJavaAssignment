package parkingsystem.accounts;

import parkingsystem.parkingarea.*;

import java.util.Optional;

public class Admin extends UserAccount {

    public void addFloor(String floorId,ParkingFloor floor){
        Optional<ParkingFloor> pfloor = ParkingLot.getInstance().getParkingFloors().stream().filter(parkingFloor -> parkingFloor.getFloorId().equalsIgnoreCase(floorId)).findFirst();
        if(pfloor.isPresent()) return;
        ParkingLot.getInstance().getParkingFloors().add(floor);

    }
    public void addSpot(String parkingFloorId , ParkingSpot spot){
        Optional<ParkingFloor> pfloor = ParkingLot.getInstance().getParkingFloors().stream().filter(parkingFloor -> parkingFloor.getFloorId().equalsIgnoreCase(parkingFloorId)).findFirst();

        if(!pfloor.isPresent())
            throw new InvalidParkingFloorException("this floor does not exists");
    }
    public void addEntrance(EntryGate entrance){

    }
    public void addExit(ExitGate exit){

    }

}
