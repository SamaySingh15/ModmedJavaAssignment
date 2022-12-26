package parkingsystem.parkingarea;

import java.time.LocalDateTime;

public class Payment {
    private String id;
    private String ticketId;
    private double amount;

    private LocalDateTime initiatedDate;
    private LocalDateTime completeDate;
    private Boolean paymentStatus;

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public Payment(String id , String ticketId , double amount){
        this.id=id;
        this.ticketId = ticketId;
        this.amount = amount;
    }
    public void makePayment(){
        this.initiatedDate = LocalDateTime.now();
        this.paymentStatus = true;
        this.completeDate = LocalDateTime.now();
    }
}

