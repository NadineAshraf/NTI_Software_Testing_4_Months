import java.util.HashMap;

public class WordFrequency {

    public static HashMap<String, Integer> wordFrequency(String sentence) {
        HashMap<String, Integer> freqMap = new HashMap<>();

        // Split sentence into words
        String[] words = sentence.split(" ");

        for (String word : words) {
            // Convert word to lowercase if you want case-insensitive counting
            word = word.toLowerCase();

            if (freqMap.containsKey(word)) {
                freqMap.put(word, freqMap.get(word) + 1);
            } else {
                freqMap.put(word, 1);
            }
        }

        return freqMap;
    }

    public static void main(String[] args) {
        String sentence = "the cat and the dog and the bird";
        HashMap<String, Integer> result = wordFrequency(sentence);

        System.out.println(result);
    }
}
