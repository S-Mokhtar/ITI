import java.util.stream.IntStream;

public class stream{
public static void main(String[] args) {
int[] values= {3,2,5,6,1,9,7};
IntStream.of(values).filter(value->value%2!=0).sorted().limit(3).forEach(value -> System.out.printf("%d ",value)); 
}
}