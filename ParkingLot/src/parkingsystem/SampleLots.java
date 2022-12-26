package parkingsystem;
import parkingsystem.parkingarea.*;
import java.util.*;

public class SampleLots {
    public void initializer(){
        ParkingLot plot = ParkingLot.getInstance();
        plot.setParkingLotId("PLOT1");
        plot.setAddress("DOWNTOWN AREA JOY24");

        //creating of parking floor
        ParkingFloor floor1 = new ParkingFloor("PFLOOR#1");
        ParkingFloor floor2 = new ParkingFloor("PFLOOR#2");
        ParkingFloor floor3 = new ParkingFloor("PFLOOR#3");



        //adding lots to parking floors
        ParkingSpot ps1 = new ParkingSpot("PSPOT#1" , ParkingSpotType.BIKE);
        ParkingSpot ps2 = new ParkingSpot("PSPOT#2" , ParkingSpotType.BIKE);
        ParkingSpot ps3 = new ParkingSpot("PSPOT#3" , ParkingSpotType.CAR);
        ParkingSpot ps4 = new ParkingSpot("PSPOT#4" , ParkingSpotType.CAR);
        ParkingSpot ps22 = new ParkingSpot("PSPOT#22" ,ParkingSpotType.CAR);
        ParkingSpot ps5 = new ParkingSpot("PSPOT#5" , ParkingSpotType.ELECTRIC);
        ParkingSpot ps6 = new ParkingSpot("PSPOT#6" , ParkingSpotType.HEAVYVEHICLE);
        ParkingSpot ps7 = new ParkingSpot("PSPOT#7" , ParkingSpotType.PHYSICALLYCHALLENGE);
        ParkingSpot ps8 = new ParkingSpot("PSPOT#8" , ParkingSpotType.PHYSICALLYCHALLENGE);
        ParkingSpot ps9 = new ParkingSpot("PSPOT#9" , ParkingSpotType.BIKE);
        ParkingSpot ps10 = new ParkingSpot("PSPOT#10" , ParkingSpotType.BIKE);
        ParkingSpot ps11 = new ParkingSpot("PSPOT#11" , ParkingSpotType.CAR);
        ParkingSpot ps12 = new ParkingSpot("PSPOT#12" , ParkingSpotType.CAR);
        ParkingSpot ps13 = new ParkingSpot("PSPOT#13" , ParkingSpotType.ELECTRIC);
        ParkingSpot ps14 = new ParkingSpot("PSPOT#14" , ParkingSpotType.HEAVYVEHICLE);
        ParkingSpot ps15 = new ParkingSpot("PSPOT#15" , ParkingSpotType.ELECTRIC);
        ParkingSpot ps16 = new ParkingSpot("PSPOT#16" , ParkingSpotType.PHYSICALLYCHALLENGE);
        ParkingSpot ps17 = new ParkingSpot("PSPOT#13" , ParkingSpotType.ELECTRIC);
        ParkingSpot ps18 = new ParkingSpot("PSPOT#14" , ParkingSpotType.HEAVYVEHICLE);
        ParkingSpot ps19 = new ParkingSpot("PSPOT#15" , ParkingSpotType.ELECTRIC);
        ParkingSpot ps20 = new ParkingSpot("PSPOT#16" , ParkingSpotType.PHYSICALLYCHALLENGE);
        ParkingSpot ps21 = new ParkingSpot("PSPOT#16" , ParkingSpotType.CAR);


        // adding spots to floor1

        Map<ParkingSpotType, Deque<ParkingSpot>> pspots = floor1.getParkingSpots();
        pspots.get(ParkingSpotType.CAR).add(ps22);
        pspots.get(ParkingSpotType.BIKE).add(ps1);
        pspots.get(ParkingSpotType.BIKE).add(ps2);
        pspots.get(ParkingSpotType.CAR).add(ps3);
        pspots.get(ParkingSpotType.CAR).add(ps4);
        pspots.get(ParkingSpotType.ELECTRIC).add(ps5);
        pspots.get(ParkingSpotType.HEAVYVEHICLE).add(ps6);
        pspots.get(ParkingSpotType.PHYSICALLYCHALLENGE).add(ps7);

        // adding spots to floor2
        Map<ParkingSpotType, Deque<ParkingSpot>> pspotsf2 = floor2.getParkingSpots();
        pspotsf2.get(ParkingSpotType.PHYSICALLYCHALLENGE).add(ps8);
        pspotsf2.get(ParkingSpotType.BIKE).add(ps9);
        pspotsf2.get(ParkingSpotType.BIKE).add(ps10);
        pspotsf2.get(ParkingSpotType.CAR).add(ps11);
        pspotsf2.get(ParkingSpotType.CAR).add(ps12);
        pspotsf2.get(ParkingSpotType.ELECTRIC).add(ps13);
        pspotsf2.get(ParkingSpotType.HEAVYVEHICLE).add(ps14);

        //adding spots to floor3
        Map<ParkingSpotType, Deque<ParkingSpot>> pspotsf3 = floor3.getParkingSpots();
        pspotsf3.get(ParkingSpotType.PHYSICALLYCHALLENGE).add(ps15);
        pspotsf3.get(ParkingSpotType.BIKE).add(ps16);
        pspotsf3.get(ParkingSpotType.BIKE).add(ps17);
        pspotsf3.get(ParkingSpotType.CAR).add(ps18);
        pspotsf3.get(ParkingSpotType.CAR).add(ps19);
        pspotsf3.get(ParkingSpotType.ELECTRIC).add(ps20);
        pspotsf3.get(ParkingSpotType.HEAVYVEHICLE).add(ps21);

        //adding floors to the parking lot
        List<ParkingFloor> floors  = plot.getParkingFloors();
        floors.add(floor1);
        floors.add(floor2);
        floors.add(floor3);


        // adding exits and entry gates
        EntryGate egate1 = new EntryGate("EGATE#1");
        EntryGate egate2 = new EntryGate("EGATE#2");
        EntryGate egate3 = new EntryGate("EGATE#3");

        ExitGate exgate1 = new ExitGate("EXGATE#1");
        ExitGate exgate2 = new ExitGate("EXGATE#2");
        ExitGate exgate3 = new ExitGate("EXGATE#3");

        plot.getEntryGates().add(egate1);
        plot.getEntryGates().add(egate2);
        plot.getEntryGates().add(egate3);

        plot.getExitGates().add(exgate1);
        plot.getExitGates().add(exgate2);
        plot.getExitGates().add(exgate3);


    }
}
