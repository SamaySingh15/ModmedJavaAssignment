package parkingsystem;
import parkingsystem.accounts.Admin;
import parkingsystem.accounts.UserAccount;
import parkingsystem.parkingarea.*;
import parkingsystem.vehicle.VehicleCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ParkingLot plot = ParkingLot.getInstance();
        SampleLots initLot = new SampleLots();
        initLot.initializer();

        HashMap<String ,UserAccount > users = new HashMap<>();
        UserAccount sampleuser = new UserAccount("1978","AgentKellerman" ,"Hikellerman@gmail.com","welcomeKellerman@123", "B+", "texas","5444433");
        UserAccount sampleuser2 = new UserAccount("1978","samay" ,"ssamaysinght@gmail.com" ,"123" ,"B+" ,"Mathura", "8923129376");
        users.put("AgentKellerman$welcomeKellerman@123" , sampleuser);
        users.put("samay$123",sampleuser2);

        HashMap<String ,Ticket> ticketStore = new HashMap<String ,Ticket>();

        System.out.println("Hello Welcome to Our Digital Parking System");
        Scanner sc = new Scanner(System.in);
        System.out.println("please Select type of user: \n press 1 for user \n press 2 for Admin");
        int x =sc.nextInt();

        //Login of users
        if(x==1){

            System.out.println("please select one option :-");
            System.out.println("\n 1 for login \n 2 for signup");
            int userlogin = sc.nextInt();

            //if user already exists

            if(userlogin==1){
                System.out.println("enter user name");
                String username = sc.next();
                System.out.println("enter password: ");
                String password = sc.next();
                String userpass = username+"$"+password;
                UserAccount user;
                if(users.containsKey(userpass)){
                    user = users.get(userpass);
                    System.out.print("hi welcome to parkingLot booking " +user.getUserName()+ " ");

                    //to get userdetails we can use this function and access to the details of users
                  //  user.getContactdetails();
                }
                else System.out.println("No such user exists");
            }

            //userSignUp
            else if(userlogin==2){
                System.out.println("enter a id: ");
                String id = sc.next();
                System.out.println("enter a username: ");
                String username = sc.next();
                System.out.println("enter a password :");
                String password = sc.next();
                System.out.println("enter you email: ");
                String email = sc.next();
                System.out.println("enter your phone no. : ");
                String phone = sc.next();
                System.out.println("enter you address : ");
                String address = sc.next();
                System.out.println("enter you blood group : ");
                String bloodGroup = sc.next();
                UserAccount user = new UserAccount(id ,username ,email, password, bloodGroup, address,phone);
                String userpass = username+"$"+password;
                users.put(userpass ,user);
                System.out.println("hello "+user.getUserName()+ " welcome to parking system");
            }

            System.out.println("Please select from the options available here : \n 1) Book a parking Lot \n 2) Exit parkingLot");
            int parkchoice = sc.nextInt();
            if(parkchoice==1){
                System.out.println("enter the vehicle type :");
                String vehicleType=sc.next();
                System.out.println("enter your vehicle registration number");
                String vehicleId=sc.next();


                boolean slotAvailablity = plot.checkAvailablity(vehicleType);

                Ticket ticket =null;
                 if(slotAvailablity){
                     ticket=plot.allotSpot(vehicleType , vehicleId);
                     ticketStore.put(vehicleId, ticket);
                 }

                if(ticket!=null){
                    System.out.println("ticket generated successfully : "+ ticket.getTicketId());
                    System.out.println("Allocated Spot ID is : "+ ticket.getAllocatedSpotId());
                }
                else System.out.println("Sorry All slots are full ");


            }
            System.out.println("Please select from the options available here : \n 1) Exit ParkingLot Booking \n 2) Vacate ParkingLot");
            int choice2 = sc.nextInt();
            if(choice2==1){
                System.out.println("Thanks For using Our System good bye and Have a nice day");
            }
            if(choice2==2){
                System.out.println("Please enter the vehicle registration no");
                String vehicleregno = sc.next();
                Ticket ticket2 = ticketStore.get(vehicleregno);
                String floorId = ticket2.getFloorId();
                String exitGateId="";
                ExitGate exgate=null;
                if(floorId=="PFLOOR#1"){
                    exitGateId="EXGATE#1";
                    List<ExitGate> egates = plot.getExitGates();
                    for(ExitGate e : egates){
                        if(e.getGateId()==exitGateId){
                            exgate=e;
                        }
                    }
                    exgate.vacateParkingLot(ticket2);
                    exgate.calculateCost(ticket2 ,ticket2.getParkingSpotType() );
                }
            }

        }
        else if(x==2){
            System.out.println("Hello Admin ");
            System.out.println("Please enter you username");
            String username = sc.next();
            System.out.println("Please enter your password");
            String password = sc.next();
            System.out.println("please wait validating........");

            Admin adm = new Admin("123", username,"Admin@parkinglot.com", password ,"b+" ,"mathura", "7017163301" );
            if(adm.adminValidation()){
                System.out.println("Admin verified");
            }
            else{
                System.out.println("Error! could not verify");
                System.exit(0);
            }
            System.out.println("Choose from the following options : \n 1) add floor to the ParkingLot \n 2 add ParkingSpot to the ParkingLot \n 3) add EntryGate to the ParkingLot \n 4) add ExitGate to the ParkingLot");
            int choice = sc.nextInt();
            if(choice==1){
                int length = plot.getParkingFloors().size();
                String floorId = "PFLOOR#"+(length+1);
                adm.addFloor(floorId , new ParkingFloor(floorId));
                System.out.println("Floor added succesfully");
            }
            else if(choice==2){
                List<ParkingFloor> floors=ParkingLot.getInstance().getParkingFloors();
                System.out.println("enter the type of spot");
                String spot = sc.next();
                System.out.println("enter the FloorId");
                String parkingFloorId = sc.next();

                for(ParkingFloor floor :floors){
                    if(floor.getFloorId().equalsIgnoreCase(parkingFloorId)){
                        int length = floor.getParkingSpots().get(ParkingSpotType.valueOf(spot)).size();
                        String parkingSpotId = "PSPOT#"+(length+1);
                        adm.addSpot(parkingFloorId , new ParkingSpot(parkingSpotId , ParkingSpotType.valueOf(spot)));
                        System.out.println("floor addded successfully");
                    }
                }



            }
            else if(choice==3){
                System.out.println("enter the floor Id : ");
                String floorid = sc.next();
                int length = plot.getEntryGates().size();
                String gateId = "EGATE#"+(length+1);
                EntryGate egate = new EntryGate(gateId);
                adm.addEntrance(egate);

            }

        }

    }
}
