import java.io.*;  
public class fileOut{
public static void main (String[] args)
{ 
System.out.println(args[0]);
FileWriter fileWriter = null;
PrintWriter printWriter = null;
try{
//Opening a file in append mode using FileWriter
fileWriter = new FileWriter("Test.txt",true);
//Wrapping BufferedWriter object in PrintWriter
printWriter = new PrintWriter(fileWriter);
//Bringing cursor to next line
printWriter.println();
//Writing text to file
for(String data : args){
printWriter.println(data);
}
}
catch (IOException e){
e.printStackTrace();
}
finally{ //Closing the resources
try{
printWriter.close();
fileWriter.close();
}catch (IOException e)
{
e.printStackTrace();
}
}
} 
}