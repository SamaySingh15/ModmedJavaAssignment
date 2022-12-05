import java.util.*;
public class ArcadeDrive implements SingleDrives {
    @Override
    public void drive(ArrayList<Character> moves ,int[][] grid ,int row ,int col, char direction){
        for(char move : moves){
            if(move=='F'){
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
            else if(move=='B'){
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
            else if(move=='L'){
                row=row-1;
                col=col+1;
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

            else if(move=='R'){
                row=row+1;
                col=col+1;

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
