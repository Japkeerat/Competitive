import java.io.*;
import java.util.*;

/*Question Link: https://practice.geeksforgeeks.org/problems/convert-an-array-to-reduced-form/0*/
public class ArrayReduce {

    private int[] createMap(int[] elements, int size) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<size; i++) {
            map.put(elements[i], i);
        }
        int i = 0;
        int reducedArray[] =  new int[size];
        for(int element: map.keySet()) {
            int index = map.get(element);
            reducedArray[index] = i;
            i++;
        }
        return reducedArray;
    }

    private void printArray(int[] array, int size) {
        for(int i=0; i<size; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayReduce reduce = new ArrayReduce();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());
        while(testCases-->0) {
            int size = Integer.parseInt(br.readLine().trim());
            String s[] = br.readLine().trim().split("\\s+");
            int elements[] = new int[size];
            for(int i=0; i<size; i++) {
                elements[i] = Integer.parseInt(s[i]);
            }
            int reducedArray[] = reduce.createMap(elements, size);
            reduce.printArray(reducedArray, size);
            System.out.println();
        }
    }
}
