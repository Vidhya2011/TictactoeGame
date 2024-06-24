package TicTacToeGame;
import java.util.*;
public class TicTacToe {
	
	private static final int Playercount = 0;
	public static String TicTacBoard[][]= {{"00","01","02"},{"10","11","12"},{"20","21","22"}};
	public static int PlayerCount=0;
	
	public static void print() {
		for(int i =0;i<TicTacBoard.length;i++) {
			for(int j=0;j<TicTacBoard[i].length;j++) {
				System.out.print(TicTacBoard[i][j]+" | " );
			}
			System.out.println();
		}
	}
	
	public static void GreetingMsg(Scanner sc) {
		int x=0;
		int y=0;
		
		System.out.println(PlayerCount%2==0?"Player X" :"Player O");
		System.out.print("Enter X value:");
		x=sc.nextInt();
		System.out.print("Enter Y Value:");
		y=sc.nextInt();
		System.out.println(insert(x,y,PlayerCount%2==0?"X":"O"));
	}
	
	public static String insert(int x,int y, String playerName) {
		if((x<3&&x>=0)&&(y<3&&y>=0)) {
			if(!TicTacBoard[x][y].equals("X")&&!TicTacBoard[x][y].equals("O")){
				TicTacBoard[x][y]=playerName;
				print();
				PlayerCount++;
				if(check()) {
					System.out.println(playerName+"Wins!!!");
					System.exit(0);
				}
				else if(PlayerCount==9) {
					System.out.println("Its Draw!!!");
					System.exit(0);
				}
				return "Inserted";
			}else {
				return "Already Occupied";
			}
		}
		return "unexpected Place";
	}
	
	public static boolean check(){
		
		//row
		for(int i =0;i<3;i++) {
			if(TicTacBoard[i][0].equals(TicTacBoard[i][1])
				&&TicTacBoard[i][1].equals(TicTacBoard[i][2])
				&&!TicTacBoard[i][0].equals("")) {
				return true;
			}
		}
		
		//column
		for(int i =0;i<3;i++) {
			if(TicTacBoard[0][i].equals(TicTacBoard[1][i])
				&&TicTacBoard[1][i].equals(TicTacBoard[2][i])
				&&!TicTacBoard[0][i].equals("")) {
				return true;
			}
		}
		
		//diagonal
		if(TicTacBoard[0][2].equals(TicTacBoard[1][1])
				&&TicTacBoard[1][1].equals(TicTacBoard[2][0])
				&&!TicTacBoard[0][2].equals("")) {
				return true;
		}
		if(TicTacBoard[0][0].equals(TicTacBoard[1][1])
				&&TicTacBoard[1][1].equals(TicTacBoard[2][2])
				&&!TicTacBoard[0][0].equals("")) {
				return true;
		}
		
		
		return false;
	}
	
	public static void main(String args[]) {
		 Scanner sc =new Scanner(System.in);
		 
		 while(true) {
			 print();
		 GreetingMsg(sc);
	     }
		 
}}
