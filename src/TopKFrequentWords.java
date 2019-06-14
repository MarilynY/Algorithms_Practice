import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] combo = {"I", "Love", "you", "I", "Love", "you", "Love", "you", "you"};
        int k = 1;
        TopKFrequentWordsSolution test = new TopKFrequentWordsSolution();
        String[] res = test.topKFrequent(combo, k);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}

/*
corner case： k > length return all distinct words
return: array with word sorted from most frequent to less frequent

Data structure:
    Hash table: store <key = word, value = frequency>
    MaxHeap: sort frequency

Step 1: iterate all the words and for each word read, count its frequency of with hash table
        which is defined as <key = String, value = int>
        O(n) on average, O(n^2) on worst

        hashtable.put(word, count + 1)
step 2: maintain maxHeap of size n, compare by frequency, pop k times
        O(n + klogn)
        or maintain MinHeap of size k
        O(k + (n-k)logK)
*/

class TopKFrequentWordsSolution {
    public String[] topKFrequent(String[] combo, int k) {
        //assumption k >= 1
        if (combo == null || combo.length == 0) {
            return new String[0];
        }

        //Step 1: get frequency of words using helper function
        Map<String, Integer> freqMap = getFreqMap(combo);
        //step 2: maintain a MinHeap
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>(){
            //use compareTo()????
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
//                if (e1.getValue().equals(e2.getValue())) {
//                    return 0;
//                }
//                return e1.getValue() < e2.getValue() ? -1 : 1;
                //because they are integer
                return e1.getValue().compareTo(e2.getValue());
            }
        });
        //maintain a minHeap with the first k largest frequency
        //offer first k entry in heap
        //compare minHeap.peek() and the rest entries, if any entry > minheap.peek()
        //poll minHeap top and offer new entry in the minheap
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (minHeap.peek().getValue() < entry.getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        //get result in descending order
        return freqArray(minHeap);
    }
    //to get frequency of each words
    private Map<String, Integer> getFreqMap(String[] combo) {
        Map<String, Integer> freqMap = new HashMap<String, Integer>();
        for (int i = 0; i < combo.length; i++) {
            int oldCount = freqMap.getOrDefault(combo[i], 0);
            freqMap.put(combo[i], oldCount + 1);
        }
        return freqMap;
    }
    //to get result in descending order
    private String[] freqArray(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
        String[] result = new String[minHeap.size()];
        for (int i = minHeap.size() - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }
}
