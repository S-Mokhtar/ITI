

import java.util.*;
import java.lang.*;

public class StarsTask{

public static void main(String[] args) {


  String x = "*******************************************";
  String y = "                                           ";

    for(int i = 0 ; i < 12 ; i++){


      System.out.println(x.substring(0 , i+1)+ y.substring(i+1 , x.length() - (i+1) + 1) + x.substring(x.length() - i )+ x.substring(0 , i+1));

    }





}


}
