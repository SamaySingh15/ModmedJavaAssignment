import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int[][] board = new int[5][5];
        char direction = 'E';
        int row= 0;
        int col= 0;

        Scanner sc = new Scanner(System.in);


        System.out.println("please Choose from the Types of Drive");
        System.out.println("press 1 for Swerve Drive \n press 2 for ArcadeDrive \n press 3 for TankDrive \n press 4 for Omni Drive");
        int selectedDrive= sc.nextInt();

        if(selectedDrive==1 || selectedDrive==2){
            ArrayList<Character> al = new ArrayList<>();
            System.out.println("please enter no. of moves");
            int n = sc.nextInt();
            for(int i=0; i<n ;i++){
                System.out.println("please enter move no :"+i);
                char ch = sc.next().charAt(0);
                al.add(ch);
            }
            if(selectedDrive==1){
                SwerveDrive sd=  new SwerveDrive();
                sd.drive(al, board,row, col ,direction);
            }
            if(selectedDrive==2){
                ArcadeDrive ad = new ArcadeDrive();
                ad.drive(al, board ,row ,col , direction);
            }

        }
        else if(selectedDrive==3 || selectedDrive==4){
            ArrayList<char[]> twoJoystick = new ArrayList<>();
            System.out.println("please enter no. of moves---");
            int n =sc.nextInt();
            for(int i=0; i<n ;i++){
                System.out.println("please enter the move"+ i+" for joystick 1");
                char move = sc.next().charAt(0);
                System.out.println("please enter the move"+ i+" for joystick 2");
                char move2 = sc.next().charAt(0);
                char[] joystickmoves= new char[2];
                joystickmoves[0]=move;
                joystickmoves[1]=move2;
                twoJoystick.add(joystickmoves);
            }
            if(selectedDrive==3){
                TankDrive td = new TankDrive();
                td.drive(twoJoystick , board , row , col , direction);
            }
            else if(selectedDrive==4){
                OmniDrive od = new OmniDrive();
                od.drive(twoJoystick , board , row , col , direction);
            }
            
        }

    }
}
