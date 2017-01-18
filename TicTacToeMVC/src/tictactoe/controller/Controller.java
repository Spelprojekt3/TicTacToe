package tictactoe.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import tictactoe.model.*;
import tictactoe.view.*;
class Controller{
	
	GameButtonListener gamebuttonlistner; 
	static View view; 
    static Model model; 
    static int currentRoll = 0; 

public Controller(){
	
	View view = View.getInstance();   
	Model model = new Model(); 
	this.view=view; 
	this.model=model; 
	
	GameButtonListener gamebuttonlistener = new GameButtonListener(view,model);
	this.gamebuttonlistner = gamebuttonlistener; 
	
	for (int j = 0; j< view.getGameButtons().length; j++) {
		
	
	 for (int i = 0; i < view.getGameButtons().length; i++) {
         view.getGameButtons()[j][i].addActionListener(gamebuttonlistner);
     }
	}
    
}
	
public static void winnerIs(){
	
	if (model.checkwin()=='X')
	{
		System.out.println("X"+" wins!"+"\n");
		model.scoreBoard("X"); 
		
	} 
	else if (model.checkwin()=='O')
	{	
		System.out.println("O"+" wins!"+"\n"); 
		model.scoreBoard("O");
		
	} 
	else if (model.checkwin()=='D')
	{
	    System.out.println("It's a tie!"+"\n");
	    model.scoreBoard("T"); 
	}
}

public static void updateScoreboard(){
	
	if (model.checkwin()=='X')
	{
		view.X.setText(Integer.toString(model.getScore().get(0)));
	} 
	else if (model.checkwin()=='O')
	{	
		
		view.O.setText(Integer.toString(model.getScore().get(1)));
	} 
	else if (model.checkwin()=='D')
	{
	    
	    view.D.setText(Integer.toString(model.getDscore().get(0)));
	}
	
}


       
    
public static void main(String[] args){
	
	try {
        // select Look and Feel
        UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        // start application
    } catch (Exception ex) {
        ex.printStackTrace();
    }
	        Controller controller = new Controller();
	    }

public static class GameButtonListener implements ActionListener {

    View view;
    Model model; 

public GameButtonListener(View view , Model model) {
        
	this.view = view;
	this.model= model; 
      
    }

    public void actionPerformed(ActionEvent e) {
    
    	
    	
        for (int j = 0; j< view.getGameButtons().length; j++) {
        	
        	for(int i=0; i< view.getGameButtons().length;i++){
        		
        	
                if (e.getSource() == view.getGameButtons()[j][i]) {
                	
                	
                  if(model.checkwin()!='X'||model.checkwin()!='O'||model.checkwin()!='D')
                  {
                	view.setText(view.getGameButtons()[j][i]);
                	model.addCoordinatate(j,i);
                	model.currentBoard(); 
                    model.nextPlayer();
                  }
                    
                  if(model.checkwin()=='X'||model.checkwin()=='O'||model.checkwin()=='D')
                  {
                	    winnerIs(); 
                    	updateScoreboard(); 
                    	model.nextPlayer();
                        currentRoll++; 
                        model.emptyModel();
                  }
                  else if(currentRoll==1)
                  { 	
                    	view.emptyView();
                    	view.setText(view.getGameButtons()[j][i]);
                    	currentRoll=0; 
                  }
                	
                	
 	
                	
                }
        	}
            }
        }
    }
	
};


	
	

		

