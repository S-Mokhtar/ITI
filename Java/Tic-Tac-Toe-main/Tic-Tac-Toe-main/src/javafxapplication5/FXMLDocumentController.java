/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package javafxapplication5;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


/**
 *
 * @author Adham 
 */
public class FXMLDocumentController implements Initializable {
    
    String val;// Either X or O 
    boolean gameDone;//one player wins
    boolean singlePlayer;
    @FXML public Text l1;//the Text inside the gameboard ( either X or O )
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
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gameDone=false;
        val="X";
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
//action to pressing on location 1 ( setting loc to either X or O ,
//switching the val for next iteration,checking if game is over
//checks for winning condition
//colorizes the winning condition ( 3 of the same letter in a row)
public void s1(){process(0);}
public void s2(){process(1);}
public void s3(){process(2);}
public void s4(){process(3);}
public void s5(){process(4);}
public void s6(){process(5);}
public void s7(){process(6);}
public void s8(){process(7);}
public void s9(){process(8);}
public void b(){restart();};//button restart
public void single(){singlePlayer=true;};
public void multi(){singlePlayer=false;};


private void switchVal() {
        if(val=="X" && !gameDone)//if last player wrote X and game is not done change what next player writes to "O"
            {
            val="O";
            }
        else if(val=="O" && !gameDone)
            {
            val="X";
            }
        else if ( gameDone)
            {
            val=" ";
            }
    }

public String checkRes()//checks if any player wins if so (gameDone flag is turned to true) and x or O is returned
{
   String retval="Draw";
   
   
    if (isAllEqual(midRow)){ retval= midRow[0].getText();colorize(midRow);}//add colorize function to end of each of those lines take array as a parameter 
    else if(isAllEqual(topRow)){retval= topRow[0].getText();colorize(topRow);}
    else if(isAllEqual(botRow)){retval= botRow[0].getText();colorize(botRow);}
    else if(isAllEqual(leftCol)){retval= leftCol[0].getText();colorize(leftCol);}
    else if(isAllEqual(rightCol)){retval= rightCol[0].getText();colorize(rightCol);}
    else if(isAllEqual(midCol)){ retval= midCol[0].getText();colorize(midCol);}
    else if(isAllEqual(cross1)){ retval= midRow[1].getText();colorize(cross1);}
    else if(isAllEqual(cross2)){ retval= midRow[1].getText();colorize(cross2);}
     if(isBoardFull()){stringfy(textArr); gameDone=true;}
     if(gameDone)
     {
         System.out.println("Game Result: "+retval);
     }

return retval;//either Draw , X or O
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
}//checks if all content of passed array are similiar

public void process(int l)//head method , calls most other methods
{

    
if(!gameDone && (textArr[l].getText().equals(" ")))
    {
       textArr[l].setText(val); switchVal();checkRes(); 
       
       if(singlePlayer && !gameDone)
       {compPlay();switchVal();checkRes();} 
    }

}

public void colorize(Text a[])//colorizes the winning condition when game is done
{
        
        if (a.equals(topRow))
        {
         
          for (int i=0;i<3;i++){topRow[i].setStroke(Color.GREEN) ;}
        }
        else if (a.equals(midRow))
        {
          for (int i=0;i<3;i++){midRow[i].setStroke(Color.GREEN) ;}
        }
        
        else if (a.equals(botRow))
        {
         for (int i=0;i<3;i++){botRow[i].setStroke(Color.GREEN) ;}
        }
         
        
        
        
        else if (a.equals(leftCol))
        {
        for (int i=0;i<3;i++){leftCol[i].setStroke(Color.GREEN) ;}
        }
        
        else if (a.equals(midCol))
        {
        for (int i=0;i<3;i++){midCol[i].setStroke(Color.GREEN) ;}  
        }
        
        else if (a.equals(rightCol))
        {
            
         for (int i=0;i<3;i++){rightCol[i].setStroke(Color.GREEN) ;}
        }
         
        else if (a.equals(cross1))
        {
        for (int i=0;i<3;i++){cross1[i].setStroke(Color.GREEN) ;}
        }
           
        else  if (a.equals(cross2))
        {
        for (int i=0;i<3;i++){cross2[i].setStroke(Color.GREEN) ;}
        }
   
    
        
        
    
}

public void compPlay()
{

 if(textArr[4].getText().equals(" "))
 {
     textArr[4].setText(val);
 }
 else 
 {
     
    ArrayList<Integer> vacantIndexes;//carries indexes of free spaces of text arr
        vacantIndexes = new ArrayList<>();
    for ( int i=0; i<9;i++)
    {
        if(textArr[i].getText().equals(" "))
        {
            vacantIndexes.add(i);
        }
    }
    
    int RandomIndex=(int)Math.floor(Math.random()*(vacantIndexes.size()) );//random number from 0 to vacant arraylist size 

        if (vacantIndexes.size()>0)
        {
            textArr[vacantIndexes.get(RandomIndex)].setText(val);
        }
 }
    
}

public void restart()//resets everything
{
    if(gameDone || checkRes()=="Draw")
    {
        gameDone=false;
        val="X";
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
    String gameResult="";
    
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
}//class done


