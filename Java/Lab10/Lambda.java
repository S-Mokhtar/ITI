class Lambda
{
@FunctionalInterface
interface value
{
double getValue();
}
public static void main(String args[]) {
value val=() -> 9;
System.out.println("A constant value: " +val.getValue());
}
} 