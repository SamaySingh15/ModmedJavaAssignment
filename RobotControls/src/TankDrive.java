import java.util.*;
public class TankDrive implements DoubleDrives {
    @Override
    public void drive(ArrayList<char[]> moves ,int[][] grid, int row, int col, char direction ){
        for(char[] move : moves){
            char leftJs = move[0];
            char rightJs=move[1];

            if(leftJs=='F' && rightJs=='F'){
                if(direction=='E'){
                    col=col+1;
                }
                else if(direction=='W'){
                    col=col-1;
                }
                else if(direction=='S'){
                    row=row+1;
                }
                else{
                    row=row-1;
                }
            }
            else if(leftJs=='B' && rightJs=='B'){
                if(direction=='E'){
                    col=col-1;
                }
                else if(direction=='W'){
                    col=col+1;
                }
                else if(direction=='S'){
                    row=row-1;
                }
                else{
                    row=row+1;
                }
            }
            else if(leftJs=='F' && rightJs=='B'){
                if(direction=='E'){
                    direction='S';
                }
                else if(direction=='N'){
                    direction='E';
                }
                else if(direction=='W'){
                    direction='N';
                }
                else if(direction=='S'){
                    direction='W';
                }
            }
            else if(leftJs=='B' && rightJs=='F'){
                if(direction=='E'){
                    direction='N';
                }
                else if(direction=='N'){
                    direction='W';
                }
                else if(direction=='W'){
                    direction='S';
                }
                else if(direction=='S'){
                    direction='E';
                }
            }
            if(row<0 || col<0){
                try {
                    throw new OutofGridException("Out of Grid move");
                }
                catch(OutofGridException e){
                    System.out.println(e.getMessage());
                    System.out.println("please enter right move to keep in grid");
                    return;
                }
            }
            System.out.println("("+row+","+col+") "+direction);
        }

    }

}
