import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    private static ArrayList<String> places = new ArrayList<String>(
            Arrays.asList("Buenos Aires", "Córdoba", "La Plata"));

    private static ArrayList<Integer> numbers = new ArrayList<Integer>(
            Arrays.asList(1,2,3,4,5));


    public static void main(String[] args) {
//        new for in java 8
        Long one=logTime();
        ArrayList<String> resultOne= IntStream.range(1, 80).mapToObj((i) -> myFunction(i))
                .map((s) -> s + " String").collect(Collectors.toCollection(ArrayList::new));
//        System.out.println(resultOne);
        calculateTime(one,logTime());


//        use full for 800,000
        one=logTime();
        ArrayList<String> resultParallel= IntStream.range(1, 80).parallel().mapToObj((i) -> myFunction(i))
                .map((s) -> s + " String").collect(Collectors.toCollection(ArrayList::new));
//        System.out.println(resultParallel);
        calculateTime(one,logTime());

// reduce sample
        String result = places.stream()
                .reduce("", (a,b) -> a + b);
        System.out.println(result);

        Integer resultNumber= numbers.stream()
                .reduce(0, (a,b) -> a + b);
        System.out.println(resultNumber);

    }

    private static String myFunction(int i) {
//        impl biz

        return String.valueOf(i);
    }

    private static Long logTime() {
        long startTime = System.nanoTime();
        return startTime;
    }

    private static void calculateTime(long one,long two ) {

        System.out.println((two-one)/1000);
    }

}
