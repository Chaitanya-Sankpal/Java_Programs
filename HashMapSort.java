import java.util.*;

public class HashMapSort {
    public static void main(String[] args) {
        // Step 1: Create and fill a HashMap
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Banana", 3);
        map.put("Apple", 5);
        map.put("Mango", 2);
        map.put("Grapes", 4);

        // Step 2: Print original HashMap (unordered)
        System.out.println("Original HashMap (unordered):");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        // Step 3: Sort by key and store in LinkedHashMap
        TreeMap<String, Integer> sorted = new TreeMap<>(map); // sorts by key
        LinkedHashMap<String, Integer> orderedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            orderedMap.put(entry.getKey(), entry.getValue());
        }

        // Step 4: Print LinkedHashMap (ordered by key, maintains insertion order)
        System.out.println("\nLinkedHashMap (sorted by key and insertion order maintained):");
        for (Map.Entry<String, Integer> entry : orderedMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
