package parkingsystem.parkingarea;

import java.util.*;

public class ParkingFloor {

    private String floorId;
    public String getFloorId(){
        return this.floorId;
    }
    private Map<ParkingSpotType, Deque<ParkingSpot>> parkingSpots = new HashMap<>();

    public Map<ParkingSpotType, Deque<ParkingSpot>> getParkingSpots() {
        return parkingSpots;
    }

    private Map<String, ParkingSpot> usedParkingSpots = new HashMap<>();
    public void setUsedParkingSpots(Map<String , ParkingSpot> spots){
        this.usedParkingSpots = spots;
    }
    public Map<String, ParkingSpot> getUsedParkingSpots() {
        return usedParkingSpots;
    }

    public ParkingFloor(String floorId){
        this.floorId=floorId;
        parkingSpots.put(ParkingSpotType.CAR,new ArrayDeque<ParkingSpot>());
        parkingSpots.put(ParkingSpotType.BIKE , new ArrayDeque<ParkingSpot>());
        parkingSpots.put(ParkingSpotType.HEAVYVEHICLE , new ArrayDeque<ParkingSpot>());
        parkingSpots.put(ParkingSpotType.ELECTRIC , new ArrayDeque<ParkingSpot>());
        parkingSpots.put(ParkingSpotType.PHYSICALLYCHALLENGE , new ArrayDeque<ParkingSpot>());
    }
    public Boolean isFloorFull(){
            return true;
    }

}
