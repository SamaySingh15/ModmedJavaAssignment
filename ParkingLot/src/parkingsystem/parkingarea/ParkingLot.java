package parkingsystem.parkingarea;
import parkingsystem.vehicle.VehicleCategory;

import java.time.LocalDateTime;
import java.util.*;

public class ParkingLot {
    private String parkingLotId;
    public void setParkingLotId(String id){
        this.parkingLotId=id;
    }
    public String getParkingLotId(){
        return this.parkingLotId;
    }
    private String address;

    public void setAddress(String Address){
        this.address=address;
    }
    public String getAddress(){
        return this.address;
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
    public boolean checkAvailablity(String category){
        VehicleCategory vc = VehicleCategory.valueOf(category);
        if(vc == VehicleCategory.TWOWHEELER || vc==VehicleCategory.BICYCLE ){
            for(ParkingFloor pf : parkingFloors){
                Map<ParkingSpotType  ,Deque<ParkingSpot>> mp = pf.getParkingSpots();
                Deque<ParkingSpot> emptydeques= mp.get(ParkingSpotType.BIKE);
                if(emptydeques.size()!=0){
                    return true;
                }
                else return false;
            }
        }
        else if(vc == VehicleCategory.CAR){
            for(ParkingFloor pf : parkingFloors){
                Map<ParkingSpotType  ,Deque<ParkingSpot>> mp = pf.getParkingSpots();
                Deque<ParkingSpot> emptydeques= mp.get(ParkingSpotType.CAR);
                if(emptydeques.size()!=0){
                    return true;
                }
                else return false;
             }
        }
        else if(vc == VehicleCategory.ELECTRICBIKE || vc==VehicleCategory.ELECTRICCAR){
            for(ParkingFloor pf : parkingFloors){
                Map<ParkingSpotType  ,Deque<ParkingSpot>> mp = pf.getParkingSpots();
                Deque<ParkingSpot> emptydeques= mp.get(ParkingSpotType.ELECTRIC);
                if(emptydeques.size()!=0){
                    return true;
                }
                else return false;
            }
        }
        else if(vc==VehicleCategory.TRUCK  || vc==VehicleCategory.TRUCK){
            for(ParkingFloor pf : parkingFloors){
                Map<ParkingSpotType  ,Deque<ParkingSpot>> mp = pf.getParkingSpots();
                Deque<ParkingSpot> emptydeques= mp.get(ParkingSpotType.HEAVYVEHICLE);
                if(emptydeques.size()!=0){
                    return true;
                }
                else return false;
            }
        }

        else{
            for(ParkingFloor pf : parkingFloors){
                Map<ParkingSpotType  ,Deque<ParkingSpot>> mp = pf.getParkingSpots();
                Deque<ParkingSpot> emptydeques= mp.get(ParkingSpotType.PHYSICALLYCHALLENGE);
                if(emptydeques.size()!=0){
                    return true;
                }
                else return false;
            }
        }
            return false;
        }




        // Allocating spot And returning ticket after spot Allocation


        public Ticket allotSpot(String category ,String rcno){
            VehicleCategory vc = VehicleCategory.valueOf(category);

            if(vc == VehicleCategory.TWOWHEELER || vc==VehicleCategory.BICYCLE ){
                for(ParkingFloor pf : parkingFloors){
                    Map<ParkingSpotType  ,Deque<ParkingSpot>> mp = pf.getParkingSpots();
                    Deque<ParkingSpot> emptydeques= mp.get(ParkingSpotType.BIKE);
                    ParkingSpot sp = emptydeques.remove();
                    sp.assignvehicle(rcno);
                    Map<String ,ParkingSpot > usedpspots  = pf.getUsedParkingSpots();
                    usedpspots.put(rcno , sp);
                    pf.setUsedParkingSpots(usedpspots);
                    String ticketID = rcno+ LocalDateTime.now();

                    Ticket ticket = new Ticket(ticketID , rcno , LocalDateTime.now() , sp.getParkingSpotId(),"Created",
                    pf.getFloorId(),ParkingSpotType.BIKE);
                    return ticket;

                }
            }
            else if(vc == VehicleCategory.CAR){
                for(ParkingFloor pf : parkingFloors){
                    Map<ParkingSpotType  ,Deque<ParkingSpot>> mp = pf.getParkingSpots();

                    Deque<ParkingSpot> emptydeques= mp.get(ParkingSpotType.CAR);
                    System.out.println("the size of lot is "+ emptydeques.size());
                    ParkingSpot sp = emptydeques.remove();
                    sp.assignvehicle(rcno);
                    if(sp==null){
                        System.out.println("empty slot detected");
                    }
                    else System.out.println(sp.getVehicleRegNo() + sp.getParkingSpotId());
                    Map<String ,ParkingSpot > usedpspots  = pf.getUsedParkingSpots();
                    usedpspots.put(rcno , sp);
                    pf.setUsedParkingSpots(usedpspots);
                    String ticketID = rcno+ LocalDateTime.now();
                    Ticket ticket = new Ticket(ticketID , rcno , LocalDateTime.now() , sp.getParkingSpotId(),"Created",
                    pf.getFloorId(),ParkingSpotType.CAR);
                    return ticket;

                }
            }
            else if(vc == VehicleCategory.ELECTRICBIKE || vc==VehicleCategory.ELECTRICCAR){
                for(ParkingFloor pf : parkingFloors){
                    Map<ParkingSpotType  ,Deque<ParkingSpot>> mp = pf.getParkingSpots();
                    Deque<ParkingSpot> emptydeques= mp.get(ParkingSpotType.ELECTRIC);
                    ParkingSpot sp = emptydeques.remove();
                    sp.assignvehicle(rcno);
                    Map<String ,ParkingSpot > usedpspots  = pf.getUsedParkingSpots();
                    usedpspots.put(rcno , sp);
                    pf.setUsedParkingSpots(usedpspots);
                    String ticketID = rcno+ LocalDateTime.now();
                    Ticket ticket = new Ticket(ticketID , rcno , LocalDateTime.now() , sp.getParkingSpotId(),"Created",
                    pf.getFloorId(),ParkingSpotType.ELECTRIC);
                    return ticket;

                }
            }
            else if(vc==VehicleCategory.TRUCK  || vc==VehicleCategory.TRUCK){
                for(ParkingFloor pf : parkingFloors){
                    Map<ParkingSpotType  ,Deque<ParkingSpot>> mp = pf.getParkingSpots();
                    Deque<ParkingSpot> emptydeques= mp.get(ParkingSpotType.HEAVYVEHICLE);
                    ParkingSpot sp = emptydeques.remove();
                    sp.assignvehicle(rcno);
                    Map<String ,ParkingSpot > usedpspots  = pf.getUsedParkingSpots();
                    usedpspots.put(rcno , sp);
                    pf.setUsedParkingSpots(usedpspots);
                    String ticketID = rcno+ LocalDateTime.now();
                    Ticket ticket = new Ticket(ticketID , rcno , LocalDateTime.now() , sp.getParkingSpotId(),"Created",
                    pf.getFloorId(),ParkingSpotType.HEAVYVEHICLE);
                    return ticket;

                }
            }

            else{
                for(ParkingFloor pf : parkingFloors){
                    Map<ParkingSpotType  ,Deque<ParkingSpot>> mp = pf.getParkingSpots();
                    Deque<ParkingSpot> emptydeques= mp.get(ParkingSpotType.PHYSICALLYCHALLENGE);
                    ParkingSpot sp = emptydeques.remove();
                    sp.assignvehicle(rcno);
                    Map<String ,ParkingSpot > usedpspots  = pf.getUsedParkingSpots();
                    usedpspots.put(rcno , sp);
                    pf.setUsedParkingSpots(usedpspots);
                    String ticketID = rcno+ LocalDateTime.now();
                    Ticket ticket = new Ticket(ticketID , rcno , LocalDateTime.now() , sp.getParkingSpotId(),"Created",
                    pf.getFloorId(),ParkingSpotType.PHYSICALLYCHALLENGE);
                    return ticket;

                }
            }

            return null;
        }




}
