import edu.duke.*;
import java.util.*;
public class CodonCount {
    private HashMap<String , Integer> codonMap;
    private int count;
    private int maxCount;

    public CodonCount(){
        codonMap=new HashMap<String ,Integer>();
        count=0;
        maxCount=0;
    }
    public void buildCodonMap(int start, String dna){
        codonMap.clear();
        dna=dna.toUpperCase();
        for(int i=start; i+3 <dna.length();i=i+3){
            String codon=dna.substring(i,i+3);
            if(codonMap.keySet().contains(codon))
                codonMap.put(codon,codonMap.get(codon)+1);
            else
            {
                codonMap.put(codon,1);
                count+=1;
            }
        }
    }
    public String getMostCommonCodon(){
        String maxCountCodon="";
        for (String codon: codonMap.keySet()){
            int occur=codonMap.get(codon);
            if(occur>maxCount){
                maxCount=occur;
                maxCountCodon=codon;
            }
        }
        return maxCountCodon;
    }
    public void printCodonCounts(int start,int end){
        System.out.println("Count of codons between "+start+" and "+end+" inclusive are follows ->");
        for(String codon : codonMap.keySet()){
            int occur=codonMap.get(codon);
            if(occur >= start && occur <= end){
                System.out.println(codon+"\t\t"+occur);
            }
        }
    }
    public void tester(){
        FileResource fr=new FileResource();
        String dna=fr.asString();
        int startString=0;
        buildCodonMap(startString,dna);
        System.out.println("Reading frame starting with "+ startString+" results in "+count+" unique codons");
        String maxCodonCount=getMostCommonCodon();
        System.out.println("And most common codon is --> "+maxCodonCount+" with Count ="+maxCount);
        int startCount=1;
        int endCount=5;
        printCodonCounts(startCount,endCount);
    }


}
