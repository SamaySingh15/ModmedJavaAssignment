package parkingsystem.parkingarea;

import java.time.LocalDateTime;

public class Ticket {
    private String ticketId;

    public String getTicketId() {
        return ticketId;
    }

    private String floorId;

    public String getFloorId() {
        return floorId;
    }

    private String vehicleRegNo;

    public String getVehicleRegNo() {
        return vehicleRegNo;
    }

    private ParkingSpotType parkingSpotType;

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    private LocalDateTime inTime;

    public LocalDateTime getInTime() {
        return inTime;
    }

    private LocalDateTime outTime;

    public LocalDateTime getOutTime() {
        return outTime;
    }

    public void setOutTime(LocalDateTime outTime) {
        this.outTime = outTime;
    }

    private String allocatedSpotId;

    public String getAllocatedSpotId() {
        return allocatedSpotId;
    }

    private EntryGate entrygate;

    public EntryGate getEntrygate() {
        return entrygate;
    }

    private ExitGate exitgate;

    public ExitGate getExitgate() {
        return exitgate;
    }

    private double cost;
    private String ticketStatus;

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Ticket(String ticketid , String regno , LocalDateTime in , String spotid , String status , String floorno, ParkingSpotType ps){
        this.ticketId=ticketid;
        this.vehicleRegNo=regno;
        this.inTime=in;
        this.allocatedSpotId=spotid;
        this.ticketStatus =status;
        this.floorId=floorno;
        this.parkingSpotType=ps;

    }
}
