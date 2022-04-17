package team4.tictactoe.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import team4.tictactoe.controllers.players.PlayersController;
import team4.tictactoe.models.Client;
import team4.tictactoe.TicTacToeApplication;

class Move{
    int pid;
    String value;
    int loc;
    Move(int id, String val, int l){
        pid=id;
        value=val;
        loc=l;
    }
}


public class GameController implements Initializable {
    Move moves[]= new Move[9]; 
    int counter=0;
    String val1;
    String val2;
    String retval="Draw";
    boolean symbol = true;
    Client client;
    boolean currentTurn=false;
    boolean gameDone;
    boolean singlePlayer;
    String gameResult="";
    Text[] coloredRow;
    @FXML public Text l1;
    @FXML public Text l2;
    @FXML public Text l3;
    @FXML public Text l4;
    @FXML public Text l5;
    @FXML public Text l6;
    @FXML public Text l7;
    @FXML public Text l8; 
    @FXML public Text l9;
    Text[] textArr = new Text[9];
    
    Text topRow[]=new Text[3];
    Text midRow[]=new Text[3];
    Text botRow[]=new Text[3];
    Text leftCol[]=new Text[3];
    Text midCol[]=new Text[3];
    Text rightCol[]=new Text[3];
    Text cross1[]=new Text[3];
    Text cross2[]=new Text[3];
   Alert a = new Alert(AlertType.NONE);
    
    public void initGame(boolean b){
        symbol = b;
         System.out.println("symbol is: " + symbol);
        if(symbol){
            val1= "X";
            val2 = "O";
            currentTurn = true;
        }else{
            val1= "O";
            val2 = "X";
            currentTurn = false;
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TicTacToeApplication.controller=this;
        client = Client.client;
        gameDone=false;
        singlePlayer=true;
       textArr[0]=l1;
       textArr[1]=l2;
       textArr[2]=l3;
       textArr[3]=l4;
       textArr[4]=l5;
       textArr[5]=l6;
       textArr[6]=l7;
       textArr[7]=l8;
       textArr[8]=l9;
       
       topRow[0]=l1;
       topRow[1]=l2;
       topRow[2]=l3;

        
        midRow[0]=l4;
        midRow[1]=l5;
        midRow[2]=l6;
        
        botRow[0]=l7;
        botRow[1]=l8;
        botRow[2]=l9;
       
         leftCol[0]=l1;
         leftCol[1]=l4;
         leftCol[2]=l7;
         
         midCol[0]=l2;
         midCol[1]=l5;
         midCol[2]=l8;
               
        rightCol[0]=l3;
        rightCol[1]=l6;
        rightCol[2]=l9;
        
        cross1[0]=l3;
        cross1[1]=l5;
        cross1[2]=l7;
                
        cross2[0]=l1;
        cross2[1]=l5;
        cross2[2]=l9;
    }    
    
public void s1(){process(0);}
public void s2(){process(1);}
public void s3(){process(2);}
public void s4(){process(3);}
public void s5(){process(4);}
public void s6(){process(5);}
public void s7(){process(6);}
public void s8(){process(7);}
public void s9(){process(8);}
public void b(){restart();};
public void a(){replay();};
public void single(){singlePlayer=true;};
public void multi(){
 // singlePlayer=false;
   // client.printStream.println("START");
    //System.out.println("start from GUI "+ client.myID);
};

private void switchVal() {
        if(val1=="X" && !gameDone)
            {
            val1="O";
            }
        else if(val1=="O" && !gameDone)
            {
            val1="X";
            }
        else if ( gameDone)
            {
            val1=" ";
            }
    }

public String checkRes()
{
    if (isAllEqual(midRow)){ retval= midRow[0].getText(); coloredRow = midRow;}
    else if(isAllEqual(topRow)){retval= topRow[0].getText();coloredRow = topRow;}
    else if(isAllEqual(botRow)){retval= botRow[0].getText();coloredRow = botRow;}
    else if(isAllEqual(leftCol)){retval= leftCol[0].getText();coloredRow = leftCol;}
    else if(isAllEqual(rightCol)){retval= rightCol[0].getText();coloredRow = rightCol;}
    else if(isAllEqual(midCol)){ retval= midCol[0].getText();coloredRow = midCol;}
    else if(isAllEqual(cross1)){ retval= midRow[1].getText();coloredRow = cross1;}
    else if(isAllEqual(cross2)){ retval= midRow[1].getText();coloredRow = cross1;}
     
    if(isBoardFull()){stringfy(textArr); gameDone=true;}
     if(gameDone)
     {
     handleAlert();
     
     }
return retval;
}

public void handleAlert(){
         System.out.println("Game Result: "+retval);
          if(retval.equals(val1)){
         a.setAlertType(AlertType.CONFIRMATION);
          a.setContentText("Congratulations! You are the winner");
          colorize(coloredRow,Color.GREEN);
          Client.client.endGame();
     }else{
         a.setAlertType(AlertType.ERROR);
         a.setContentText("Hard luck! You lose");
         colorize(coloredRow,Color.RED);
     }
     a.show();
}

public boolean isAllEqual(Text a[]){
    boolean identical;
    if(a[0].getText().equals(a[1].getText())&& a[1].getText().equals(a[2].getText()) && (  a[0].getText().equals("X")  || a[0].getText().equals("O") )    )//if the three elements are equal ( x or o) return true
    {
        identical=true;
        gameDone=true;
        stringfy(textArr);
    }
    else 
    {
        identical=false;
    }
return identical;
}

public void process(int l)
{
    if(currentTurn){
        if(!gameDone && (textArr[l].getText().equals(" ")))
        {
            Client.client.sendMove(l+"",val1);
           checkRes(); 
        }
    }
}

public void sendPlay(int loc,String value)
{   
    if(value.equals(val1)){
        currentTurn=false;
    //    moves[counter]=new Move(client.myID,value,loc);
    }else{
        currentTurn=true;
   //     moves[counter]=new Move(client.p2ID,value,loc);
    }
    counter++;
    textArr[loc].setText(value);
     checkRes(); 
}

public void sendPlay2(int loc,String value)
{  
    textArr[loc].setText(value);
    System.out.println("locatin is"+loc+"value is "+value);
}
int iter;
String str;
public void replay(){
        restart();
        
         Platform.runLater( new Runnable() {
                    
                        public void run(){
                            Thread th = new Thread(){
            public void run(){
                
                for ( iter = 0;iter< counter; iter++){
            try {
                Thread.sleep(555);
            } catch (InterruptedException ex) {
                Logger.getLogger(PlayersController.class.getName()).log(Level.SEVERE, null, ex);
            }
                    

                 str= moves[iter].value;
                                       System.out.println("Character at location "+str +" is "+moves[iter].loc);
                               sendPlay2(moves[iter].loc,str);
                
        
        }
            }
        };
        th.start();
        }
                    });
}

public void colorize(Text a[], Color myColor)
{
        if (a.equals(topRow))
        {
          for (int i=0;i<3;i++){topRow[i].setStroke(myColor) ;}
        }
        else if (a.equals(midRow))
        {
          for (int i=0;i<3;i++){midRow[i].setStroke(myColor) ;}
        }
        
        else if (a.equals(botRow))
        {
         for (int i=0;i<3;i++){botRow[i].setStroke(myColor) ;}
        }

        else if (a.equals(leftCol))
        {
        for (int i=0;i<3;i++){leftCol[i].setStroke(myColor) ;}
        }
        
        else if (a.equals(midCol))
        {
        for (int i=0;i<3;i++){midCol[i].setStroke(myColor) ;}  
        }
        
        else if (a.equals(rightCol))
        {
            
         for (int i=0;i<3;i++){rightCol[i].setStroke(myColor) ;}
        }
         
        else if (a.equals(cross1))
        {
        for (int i=0;i<3;i++){cross1[i].setStroke(myColor) ;}
        }
           
        else  if (a.equals(cross2))
        {
        for (int i=0;i<3;i++){cross2[i].setStroke(myColor) ;}
        }
}

public void compPlay()
{
 if(textArr[4].getText().equals(" "))
 {
     textArr[4].setText(val1);
 }
 else 
 {
    ArrayList<Integer> vacantIndexes;
        vacantIndexes = new ArrayList<>();
    for ( int i=0; i<9;i++)
    {
        if(textArr[i].getText().equals(" "))
        {
            vacantIndexes.add(i);
        }
    }
    
    int RandomIndex=(int)Math.floor(Math.random()*(vacantIndexes.size()) );

        if (vacantIndexes.size()>0)
        {
            textArr[vacantIndexes.get(RandomIndex)].setText(val1);
        }
 }
}

public void restart()
{
    if(gameDone || checkRes()=="Draw")
    {
        gameDone=false;
        val1="X";
        for( int i=0;i<9;i++)
        {
            textArr[i].setText(" ");
        }

        for ( int i=0;i<9;i++)
        {
            textArr[i].setStroke(Color.BLACK);
        }
    }
}

public String stringfy(Text s[])
{
    
    
    if(gameDone || isBoardFull())
    {
        for(int i=0;i<9;i++)
    {
        if(s[i].getText().equals(" "))
        {
            gameResult+="S";
        }
        else 
        {
            gameResult+=s[i].getText();
        }
    }
    System.out.println("game Board:"+gameResult);
    }
    return gameResult; 
}

public boolean isBoardFull()
{
    boolean Full=false;
   int count = 0;
      for ( int i=0; i<9;i++)
   {
       if(textArr[i].getText().equals("X") || textArr[i].getText().equals("O"))//any of board locations is empty
       {
           count++;
       }
   }
   if(count==9){Full=true; gameDone=true;}
   return Full;
}
}