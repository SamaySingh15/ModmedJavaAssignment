package parkingsystem.parkingarea;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class ExitGate {
    private String gateId;

    public String getGateId() {
        return gateId;
    }

    public ExitGate(String gateid){
        this.gateId = gateid;
    }
    public void vacateParkingLot(Ticket parkingTicket){
        ParkingLot plot = ParkingLot.getInstance();
        List<ParkingFloor> pfloors= plot.getParkingFloors();
        String floorid = parkingTicket.getFloorId();
        for(ParkingFloor pf : pfloors){
            if(pf.getFloorId()==floorid){
                Map<String , ParkingSpot> hm = pf.getUsedParkingSpots();
                hm.remove(parkingTicket.getVehicleRegNo());
                Map<ParkingSpotType , Deque<ParkingSpot>> deq = pf.getParkingSpots();
                Deque<ParkingSpot> dq= deq.get(parkingTicket.getParkingSpotType());
                dq.add(new ParkingSpot(parkingTicket.getAllocatedSpotId() , parkingTicket.getParkingSpotType()));
                parkingTicket.setOutTime(LocalDateTime.now());
            }
        }
    }

    public void calculateCost(Ticket parkingTicket , ParkingSpotType parkingSpotType){
        LocalDateTime entryTime = parkingTicket.getInTime();
        LocalDateTime exitTime = parkingTicket.getOutTime();
        Duration dur = Duration.between(entryTime, exitTime);
        long millis = dur.toMillis();
        int hours_diff = (int) TimeUnit.MILLISECONDS.toHours(millis);
        hours_diff = (int) (hours_diff+Math.random()*11);
        int amount=0;
        if(parkingSpotType==ParkingSpotType.CAR){
            amount= hours_diff*10;
        }
        else if(parkingSpotType == ParkingSpotType.ELECTRIC){
            amount= hours_diff*13;
        }
        else if(parkingSpotType==ParkingSpotType.HEAVYVEHICLE){
            amount=hours_diff*25;
        }
        else if(parkingSpotType==ParkingSpotType.BIKE){
            amount=hours_diff*5;
        }
        else if(parkingSpotType==ParkingSpotType.PHYSICALLYCHALLENGE){
            amount=hours_diff*1;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("your payable amount is : "+amount);
        System.out.println("enter you Card Number to Pay");
        String cardno = sc.next();
        System.out.println("please enter the card pin");
        String pin = sc.next();
        String paymentId=parkingTicket.getTicketId()+String.valueOf(parkingSpotType);
        Payment ptm = new Payment(paymentId , parkingTicket.getTicketId(), amount);
        ptm.makePayment();
        System.out.println("waiting for response .........");
        if(ptm.getPaymentStatus()){
            parkingTicket.setTicketStatus("Paid");
        }
        if(ptm.getPaymentStatus()){
            System.out.println("Thanks for paying! Have a nice day");
        }
        else{
            System.out.println("Error could not complete payment");
        }

    }
}
