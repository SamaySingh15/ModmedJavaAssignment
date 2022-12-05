package parkingsystem.parkingarea;

import java.time.LocalDateTime;

public class Ticket {
    private String ticketId;
    private String vehicleRegNo;
    private LocalDateTime inTime;
    private LocalDateTime outTime;
    private String allocatedSpotId;
    private double cost;
    private String ticketStatus;
}
