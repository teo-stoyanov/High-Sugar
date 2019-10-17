package logic;

import interfaces.InputReader;
import interfaces.OutputWriter;
import interfaces.Runnable;
import io.ConsoleReader;
import io.ConsoleWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Arrays.stream;

public class Engine implements Runnable {

    private InputReader reader;
    private OutputWriter writer;

    public Engine() {
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
    }

    @Override
    public void run(){
        // here we read from the console array of strings, than we split it (by regex), filter the empty entries,
        // map each element, parse it to integer and collect it in a List
        List<Integer> candyArr = stream(reader.readLine().split("[\\[\\],\\s]+"))
                .filter((str -> !str.isEmpty()))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //here we read from the console the threshold and parse it to integer
        int threshold = Integer.parseInt(reader.readLine());

        //we create a new arr of int so we can copy the list
        int[] sortedCandyArr = new int[candyArr.size()];
        for (int i = 0; i < candyArr.size(); i++) {
            sortedCandyArr[i] = candyArr.get(i);
        }

        //sort the arr so we can start from lowest sugar candy
        Arrays.sort(sortedCandyArr);
        //create a new list so we can add the indices in it
        List<Integer> indices = new ArrayList();

        //main logic where we iterate true the sortedCandyArr and add value in sugarSum until we reach our limit
        //after every added candy we add its indices as well
        int sugarSum = 0;
        for (int i1 : sortedCandyArr) {
            if (sugarSum + i1 > threshold) {
                break;
            }

            sugarSum += i1;
            indices.add(candyArr.indexOf(i1));
        }
        //sort the indices and print
        indices.sort(Comparator.comparingInt(a -> a));
        writer.writeLine(String.join(", ",indices.toString()));
    }
}
