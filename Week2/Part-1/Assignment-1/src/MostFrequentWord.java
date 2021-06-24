import edu.duke.*;
import java.util.ArrayList;
import java.util.Locale;

public class MostFrequentWord {
    private ArrayList<String> words;
    private ArrayList<Integer> frequency;
    private int maxCount;
    private String maxCountWord;

    public MostFrequentWord() {
        words = new ArrayList<String>();
        frequency = new ArrayList<Integer>();
    }

    private void findUnique() {
        words.clear();
        frequency.clear();
        maxCount = 0;
        maxCountWord = null;
        FileResource fr = new FileResource();
        for (String s : fr.words()) {
            s = s.toLowerCase();
            int index = words.indexOf(s);
            if (index == -1) {
                words.add(s);
                frequency.add(1);
            } else {
                int count = frequency.get(index);
                frequency.set(index, count + 1);
            }
        }
    }

    private void findIndexOfMax() {
        int indexOfMax = 0;
        for (int i = 0; i < frequency.size(); i++) {
            int currVal = frequency.get(i);
            if (currVal > maxCount) {
                maxCount = currVal;
                indexOfMax = frequency.indexOf(maxCount);
            }
        }
        maxCountWord = words.get(indexOfMax);
    }

    public void tester(){
        findUnique();
        Integer unqWords=words.size();
        System.out.println("Number of unique words-> "+unqWords);
        for(int i=0;i<words.size();i++){
            System.out.println(frequency.get(i)+"\t"+ words.get(i));
        }
        findIndexOfMax();
        System.out.println("The word that occurs most often and its count are-> "+maxCountWord+"-->"+maxCount);
    }
}