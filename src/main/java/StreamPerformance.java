import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Allan Tejano
 * 3/2/2018
 */
public class StreamPerformance {

    public static void main(String[] args) {
        StreamPerformance instance = new StreamPerformance();
        List<Integer> amounts = new ArrayList<>();
        for (int ii = 0; ii < 5; ii++) {
            int amount = (int)Math.pow(10, ii);
            amounts.add(amount);
            instance.action(amount);
            line(ITERABLE_FOR_EACH, amounts);
            line(FOR_COLON_EACH, amounts);
            line(ITERABLE_STREAM_FOR_EACH, amounts);
            line(FOR_WITH_INDEX, amounts);
        }

        String header = leftPad("", 26);
        for(Integer next : amounts) {
            header += leftPad("" + next, ("" + next).length() +GAP);
        }
        System.out.println(header);
        line(ITERABLE_FOR_EACH, amounts);
        line(FOR_COLON_EACH, amounts);
        line(ITERABLE_STREAM_FOR_EACH, amounts);
        line(FOR_WITH_INDEX, amounts);

        //                   10   100    1000   10000  100000
        // iterator.forEach
    }

    private final static int GAP = 4;

    private static void line(String which, List<Integer> amounts) {
        System.out.print(leftPad(which, 26));
        for(Integer next : amounts) {
            for(Result nextR : RESULTS) {
                if(nextR.integerCount == next && nextR.method.equals(which)) {
                    System.out.print(leftPad(nextR.millis + "", ("" + next).length() +GAP));
                }
            }
        }
        System.out.println("");
    }

    private static String leftPad(String input, int size) {
        StringBuilder foo = new StringBuilder();
        for(int ii = input.length(); ii < size; ii++) {
            foo.append(" ");
        }
        foo.append(input);
        return foo.toString();
    }

    public static final String ITERABLE_FOR_EACH =        "iterator.forEach";
    public static final String FOR_COLON_EACH =           "for:each";
    public static final String ITERABLE_STREAM_FOR_EACH = "iterable.stream.forEach";
    public static final String FOR_WITH_INDEX =           "for with index";

    private static class Result {

        int integerCount;
        String method;
        long millis;

        public Result(int integerCount, String method, long millis) {
            this.integerCount = integerCount;
            this.method = method;
            this.millis = millis;
        }
    }

    private final static List<Result> RESULTS = new ArrayList<>();

    public void action(int integerCount) {
        System.out.println("action: " + integerCount);
        List<Integer> integers = new ArrayList<>(integerCount);
        for(int ii = 0; ii < integerCount; ii++) {
            integers.add(ii);
            // calculate once to avoid penality for the first section.
            outside = ii*ii;
        }

        int iterations = 10_000_000;

        Instant beforeFor = Instant.now();
        for(int ii = 0; ii < iterations; ii++) {
            forCounter(integers);
        }
        Instant afterFor = Instant.now();
        RESULTS.add(new Result(integerCount, FOR_WITH_INDEX, (afterFor.toEpochMilli() - beforeFor.toEpochMilli())));

        Instant beforeStream = Instant.now();
        for(int ii = 0; ii < iterations; ii++) {
            iteratorStream(integers);
        }
        Instant afterStream = Instant.now();
        RESULTS.add(new Result(integerCount, ITERABLE_STREAM_FOR_EACH, (afterStream.toEpochMilli() - beforeStream.toEpochMilli())));

        Instant beforeForEach = Instant.now();
        for(int ii = 0; ii < iterations; ii++) {
            forEach(integers);
        }
        Instant afterForEach = Instant.now();
        RESULTS.add(new Result(integerCount, FOR_COLON_EACH, (afterForEach.toEpochMilli() - beforeForEach.toEpochMilli())));

        Instant beforeIterator = Instant.now();
        for(int ii = 0; ii < iterations; ii++) {
            iteratorForEach(integers);
        }
        Instant afterIterator = Instant.now();
        RESULTS.add(new Result(integerCount, ITERABLE_FOR_EACH, (afterIterator.toEpochMilli() - beforeIterator.toEpochMilli())));
    }

    public int outside = 0;

    private void forCounter(List<Integer> integers) {
        for(int ii = 0; ii < integers.size(); ii++) {
            Integer next = integers.get(ii);
            outside = next*next;
        }
    }

    private void forEach(List<Integer> integers) {
        for(Integer next : integers) {
            outside = next * next;
        }
    }

    private void iteratorForEach(List<Integer> integers) {
        integers.forEach((ii) -> {
            outside = ii*ii;
        });
    }
    private void iteratorStream(List<Integer> integers) {
        integers.stream().forEach((ii) -> {
            outside = ii*ii;
        });
    }
}
