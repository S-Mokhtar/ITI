package Task1;

public class Calculator {

  public void add(int numOne, int numTwo) {
    int result = numOne + numTwo;
    System.out.println(numOne + " + " + numTwo + " = " + result);
  }

  public void subtract(int numOne, int numTwo) {
    int result = numOne - numTwo;
    System.out.println(numOne + " - " + numTwo + " = " + result);
  }

  public void multiply(int numOne, int numTwo) {
    int result = numOne * numTwo;
    System.out.println(numOne + " * " + numTwo + " = " + result);
  }

  public void divide(int numOne, int numTwo) {
    int result = numOne / numTwo;
    System.out.println(numOne + " / " + numTwo + " = " + result);
  }

  public static void main(String[] args) {
	Calculator cal = new Calculator();
    int numOne = Integer.parseInt(args[0]);
	String operator= args[1];
    int numTwo = Integer.parseInt(args[2]);
	switch(operator){
	case"+":
    cal.add(numOne, numTwo);
	break;
	case"-":
    cal.subtract(numOne, numTwo);
	break;
	case".":
    cal.multiply(numOne, numTwo);
	break;
	case"/":
    cal.divide(numOne, numTwo);
	break;
	}
  }
}