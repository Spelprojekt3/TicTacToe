package tictactoe.model;

import java.util.ArrayList;

import tictactoe.view.View;

public class Model{
	
	View view; 
	private String player1,player2;
	private int size;  
	private char player;
	private char[][] board = new char [10][10];
	private static int score1,score2,dscore1,dscore2,lscore1,lscore2; 
	private ArrayList<Integer>score=new ArrayList<Integer>(); 
	private ArrayList<Integer>dscore=new ArrayList<Integer>(); 
	
	
public ArrayList<Integer> getScore() {
		return score;
	}


public Model(){
	
	newBoard(); 
	currentBoard(); 
		
}



public void newBoard(){
	
	int x= 3;
  
	for(int s=0; s<x; s++){
		
	 for(int f=0; f<x; f++){
	   board[s][f]=' ';
	}
	player='X';
	}
};

public String currentBoard(){
	
	 int x=3; 
	 
	 System.out.print("\n");
	 printCol(); 	
	 
    for(int i=0; i<x; i++){
   	  
   	 for(int j=0; j<x; j++){
			if(j!=x-1){
			  System.out.print(" "+board[i][j]+" |");
			} else{
			  System.out.print(" "+board[i][j]);
			}
			}
   	      System.out.println("   "+i);
   	 
   	    if(i<(x-1)){
   	      System.out.print("---");
   	    } if(i<(x-1)){	
	      for(int z=1; z<x; z++)
	          System.out.print("+---"); 
	          System.out.println("");
           }
   	 }
     System.out.print("\n");
     return "currentBoard"; 
};

public void printCol(){
	
	for(int r=0;r<3;r++){
		System.out.print(" "+r+"  ");
		}System.out.println("\n");
};


public char checkwin(){
	int n=3,counter=0;  
	char winner; 
	
	//check if all coordinates are filled
	for(int i=0;i<n;i++){
		
		for(int j=0;j<n;j++){ 
			
			if(board[i][j]=='X'||board[i][j]=='O'){
			  counter=counter+1; 
			}
			if(board[i][j]==' '){
			  counter=counter+0; 
			}
			if(counter==(n*n)){
		      return winner='D'; 
			}
			}
		}
    
	
	//check horizontal coordinates  
      counter=1; 
      for(int i = 0; i<n; i++){
          for(int j=0;j<n-1;j++){
              if(board[i][j]=='X'&& board[i][j+1]=='X'){
                  counter = counter+1;
              } if(counter == n){
            	return winner='X';
            	} if(board[i][j]=='O'&& board[i][j+1]=='O'){
                  counter = counter+1;
                  } if(counter == n){
                  return winner='O';
                  }
              }
          counter = 1;
          }
      
      
      counter = 1;
    // check vertical coordinates 
      for(int i = 0; i<n; i++){
          for(int j=0;j<n-1;j++){
              if(board[j][i]=='X'&& board[j+1][i]=='X'){
                  counter = counter+1;
                 } if(counter == n){
            	 return winner='X';
            	 } if(board[j][i]=='O'&& board[j+1][i]=='O'){
                  counter = counter+1;
                 } if(counter == n){
            	 return winner='O';
            	 }
              }
          counter = 1;
      }
      
      
      counter = 1;
      // check diagonal coordinates
      for(int i=0;i<n-1;i++){
             if(board[i][i]=='X'&& board[i+1][i+1]=='X'){
             counter = counter+1;
             } if (counter==n){
             return winner='X';
             } if(board[i][i]=='O'&& board[i+1][i+1]=='O'){
             counter = counter+1;
             } if (counter==n){
             return winner='O'; 
             }
      }
      
      
      counter = 1;
      // check anti-diagonal coordinates 
      for(int i=0;i<n-1;i++){
          if(board[i][n-1-i]=='X' && board[i+1][n-1-(i+1)]=='X'){
              counter = counter+1;
              } if (counter==n){
              return winner='X';
              } if(board[i][n-1-i]=='O' && board[i+1][n-1-(i+1)]=='O'){
              counter = counter+1;
              } if (counter==n){
        	  return winner='O';
        	  }
          }
      return winner=' '; 
};

public void addCoordinatate(int x,int y )
{
if(board[x][y]!=' ')
{
	System.out.println("Error, position is already taken");
	nextPlayer(); 
}
else if(board[x][y]==' ')
board[x][y]=player;

}



public void scoreBoard(String name){
	 
	ArrayList<String>userName=new ArrayList<String>(); 
	score=new ArrayList<Integer>(); 
	setDscore(new ArrayList<Integer>()); 
	ArrayList<Integer>lscore=new ArrayList<Integer>(); 
	
    //Check winner and give points if win
	if(name.equals("X")){
		score1=score1+1; 
	    lscore2=lscore2+1;
	    } else if(name.equals("O")) {
	    score2=score2+1;
	    lscore1=lscore1+1;
	    } else {
	    dscore2=dscore2+1;
	    dscore1=dscore1+1; 
	    }
	
	//Add players and scores to separate array-lists 
	userName.add("X");
	score.add(score1);
	getDscore().add(dscore1);
	lscore.add(lscore1);
	userName.add("O");
	score.add(score2); 
	getDscore().add(dscore2);
	lscore.add(lscore2);
	
	//Put the "Scoreboard" to the console
	System.out.println("Player     W          D          L");
	System.out.println("+--------------------------------+");
	
	for (int index = 0; index<2; index++){
	   System.out.printf("%-11s",userName.get(index));
       System.out.printf("%-11s",score.get(index));
       System.out.printf("%-11s",getDscore().get(index));
       System.out.printf("%-11s",lscore.get(index));
       System.out.println(""); 
       }
       System.out.println("");
		
		
};

public void emptyModel(){
	
	newBoard(); 
	currentBoard(); 
}

public char getPlayer() {

	return player;
}

public char nextPlayer(){
	if (player=='X'){
       return player='O';
       } else{
	   return player='X';
	   }
};

public void setPlayer(char player) {
	this.player = player;
}

public char[][] getBoard() {
	return board;
}

public void setBoard(char[][] board) {
	this.board = board;
}


public ArrayList<Integer> getDscore() {
	return dscore;
}


public void setDscore(ArrayList<Integer> dscore) {
	this.dscore = dscore;
}

};