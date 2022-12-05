import java.util.ArrayList;

public class SwerveDrive implements SingleDrives {
    @Override
    public void drive(ArrayList<Character> moves, int[][] grid, int row, int col, char direction) {
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
                if(direction=='E'){
                    row=row-1;
                }
                else if(direction=='W'){
                    row=row+1;
                }
                else if(direction=='S'){
                    col=col+1;
                }
                else{
                    col=col-1;
                }
            }

            else if(move=='R'){
                if(direction=='E'){
                    row=row+1;
                }
                else if(direction=='W'){
                    row=row-1;
                }
                else if(direction=='S'){
                    col=col-1;
                }
                else{
                    col=col+1;
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
