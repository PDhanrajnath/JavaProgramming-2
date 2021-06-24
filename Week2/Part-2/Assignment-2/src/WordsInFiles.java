import java.util.*;
import java.io.*;
import edu.duke.*;
public class WordsInFiles {
    private HashMap<String, ArrayList <String >> wordMap;
    public WordsInFiles(){
        wordMap=new HashMap<String ,ArrayList<String>>();
    }
    private void addWordsFromFile(File file){
        FileResource fr =new FileResource(file);
        String filename=file.getName();
        for(String word: fr.words()){
            if(wordMap.keySet().contains(word)){
                ArrayList <String> values=wordMap.get(word);
                if(!values.contains(filename)){
                    values.add(filename);
                }
            }
            else{
                ArrayList <String> values=new ArrayList<String>();
                values.add(filename);
                wordMap.put(word,values);
            }
        }
    }
    private void buildWordFileMap(){
        wordMap.clear();
        DirectoryResource dr=new DirectoryResource();
        for (File file: dr.selectedFiles()){
            addWordsFromFile(file);
        }
    }

    private int maxNumber(){
        int maxNum=0;
        for(String key : wordMap.keySet()){
            int count=0;
            for(String value : wordMap.get(key)){
                count+=1;
            }
            if(count > maxNum)
                maxNum=count;
        }
        return maxNum;
    }
    private ArrayList wordsInNumFiles(int number){
        ArrayList <String> wordsList =new ArrayList<String>();
        for (String key: wordMap.keySet()){
            int count=0;
            for (String value :wordMap.get(key)){
                count+=1;
            }
            if(count==number)
                wordsList.add(key);
        }
        return wordsList;
    }
    private void PrintFilesIn(String word){
        ArrayList <String> filenames=new ArrayList<String>();
        for(String key : wordMap.keySet()){
            if(key.equals(word)){
                for(String val : wordMap.get(key)){
                    filenames.add(val);
                }
            }
        }
        System.out.println("The word \""+word+"\"+appears in the following file(s): ");
        for (int k=0;k<filenames.size();k++){
            System.out.println(filenames.get(k));
        }
    }

    void tester(){


    }

}
