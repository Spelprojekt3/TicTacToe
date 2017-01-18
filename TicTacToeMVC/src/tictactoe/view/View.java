package tictactoe.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.MatteBorder;

import tictactoe.model.Model;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class View extends JFrame{
	
private JFrame mainFrame; 
private JPanel topPanel;
private JPanel bottonPanel; 
private JPanel centerPanel; 
private JPanel eastPanel;
private JPanel westPanel; 
private JButton[][] gameButtons; 
private JLabel p1,pT,p2; 
private JLabel boxes[]; 
private String letter="X"; 
public JLabel X,D,O;

private static View firstInstance= null; 



private View(){
	
	createWindow(); 
	createGameButtons(); 
	createScoreboard(); 
	setVisible(true);
	
}

public static View getInstance(){
	
	if(firstInstance ==null){
	firstInstance = new View(); 
		
	}
	return firstInstance; 
}



public void createWindow(){
	      	
	
    setPreferredSize(new Dimension(600,800));
    getContentPane().setLayout(new BorderLayout());

    
    topPanel= new JPanel(); 
    JLabel label = new JLabel(); 
    label.setFont(new Font("TeXGyreAdventor", Font.PLAIN, 50));
    label.setForeground(new Color(255,255,255));
    topPanel.add(label);
    
    
	topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    topPanel.setPreferredSize(new Dimension(200, 120));
    topPanel.setBackground(new Color(46,46,46));
    add(topPanel,BorderLayout.NORTH); 
    //topPanel.setBackground(new Color(0,0,0));
	
	setCenterPanel(new JPanel()); 
    getCenterPanel().setLayout(new GridLayout(3,3));
	getCenterPanel().setBackground(new Color(46,46,46));
	add(getCenterPanel(),BorderLayout.CENTER);
	
	westPanel= new JPanel(); 
	westPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    westPanel.setPreferredSize(new Dimension(40, 0));
    westPanel.setBackground(new Color(46,46,46));
    add(westPanel,BorderLayout.WEST); 
   
    eastPanel= new JPanel(); 
	eastPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    eastPanel.setPreferredSize(new Dimension(40,0));
    eastPanel.setBackground(new Color(46,46,46));
    add(eastPanel,BorderLayout.EAST); 
	
	
	bottonPanel= new JPanel(); 
	bottonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,100,30));
    bottonPanel.setPreferredSize(new Dimension(0,150));
    bottonPanel.setBackground(new Color(46,46,46));
    add(bottonPanel,BorderLayout.SOUTH); 
	
	
	pack();  
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
			    
}

public void emptyView(){
	
	for(int j=0;j<gameButtons.length;j++){
		
		for(int i=0;i<gameButtons.length;i++){
		gameButtons[j][i].setText("");
		}
		
	}
	letter="X"; 
	
    
}
	
public void createGameButtons(){
	
	gameButtons = new JButton[3][3];
	
	int k=0; 
	
	for(int j=0;j<gameButtons.length;j++){
	
	for(int i=0;i<gameButtons.length;i++){
		
		 gameButtons[j][i] = new JButton();
		 gameButtons[j][i].setBackground(new Color(0,0,0));
         gameButtons[j][i].putClientProperty("id", k);
         gameButtons[j][i].setContentAreaFilled(false);
         gameButtons[j][i].setFocusable(false);
         if(j==0 && i<2){
         gameButtons[j][i].setBorder(new MatteBorder(0,0,0,5, new Color(60,60,60)));
         if(j==0 && i>2){
         }
         }
         if(j==1){
         gameButtons[j][i].setBorder(new MatteBorder(5,0,5,5, new Color(60,60,60)));
         if(j==1 && i==2){
         gameButtons[j][i].setBorder(new MatteBorder(5,0,5,0, new Color(60,60,60))); 
         }
         
         }
         if(j==2 && i<2){
         gameButtons[j][i].setBorder(new MatteBorder(0,0,0,5, new Color(60,60,60)));
         
         }
        
         getCenterPanel().add(gameButtons[j][i]);
         k++; 
	}
	
	
	}	
	gameButtons[0][2].setBorder(new MatteBorder(0,0,0,0, new Color(255,255,255)));
	gameButtons[2][2].setBorder(new MatteBorder(0,0,0,0, new Color(255,255,255)));
}

public void setText(JButton gameButton) 
{
	    
	    gameButton.setFont(new Font("Tahoma", Font.BOLD, 100));
		
	    if(gameButton.getText().equals("")){
	       gameButton.setText(letter);
	       changeLetter(); 
	       changeColor(gameButton); 
	    }
	   
		
		
}

public void changeColor(JButton gameButton){
	
	
	
	if(letter=="O")
	{
		gameButton.setForeground(new Color(255,150,23));
		
	}
	else if (letter=="X")
	{
		gameButton.setForeground(new Color(0,200,255));
	} 
	
}
	
public void changeLetter()
{
	if(letter.equals("X"))
	{
		
		letter="0";
	}
	if(letter.equals("O"))
	{
		letter="X"; 
	}
	else
	letter="O";
}

public void createScoreboard()
{
  p1= new JLabel("PLAYER(X)"); 
  p1.setFont(new Font("TeXGyreAdventor", Font.PLAIN, 20));
  
  pT= new JLabel("TIES"); 
  pT.setFont(new Font("TeXGyreAdventor", Font.PLAIN, 20));
  
  p2= new JLabel("PLAYER(O)"); 
  p2.setFont(new Font("TeXGyreAdventor", Font.PLAIN, 20));
  
  boxes= new JLabel[3]; 
  X = new JLabel("0");
  D = new JLabel("0"); 
  O = new JLabel("0"); 
  
  
  X.setFont(new Font("TeXGyreAdventor", Font.PLAIN, 50));
  D.setFont(new Font("TeXGyreAdventor", Font.PLAIN, 50));
  O.setFont(new Font("TeXGyreAdventor", Font.PLAIN, 50));

  
  boxes[0]=X;
  boxes[1]=D; 
  boxes[2]=O; 
    
  bottonPanel.add(p1); 
  bottonPanel.add(pT); 
  bottonPanel.add(p2); 
  bottonPanel.add(X); 
  bottonPanel.add(D); 
  bottonPanel.add(O);  
}

public JPanel getCenterPanel() {
	return centerPanel;
}

public void setCenterPanel(JPanel centerPanel) {
	this.centerPanel = centerPanel;
}
public JButton[][] getGameButtons() {
	return gameButtons;
}

public void setGameButtons(JButton[][] gameButtons) {
	this.gameButtons = gameButtons;
}

}
	
