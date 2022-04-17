import java.io.*;  
public class fileIn{
public static void main (String[] args)
{
try{
FileInputStream fis = new FileInputStream("Test.txt");
int size = fis.available();
byte[] b = new byte[size];
fis.read(b);
System.out.println( new String(b));
fis.close();
}
catch (IOException e) {
      e.printStackTrace();
}
}
}