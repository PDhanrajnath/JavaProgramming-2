import edu.duke.*;
import java.util.ArrayList;
public class CharacterNames {
    private ArrayList<String> character_name;
    private ArrayList<Integer> count;
    public CharacterNames() {
        character_name = new ArrayList<String>();
        count = new ArrayList<Integer>();
    }

    public void update(String person){
        int index = character_name.indexOf(person);
        if (index == -1) {
            character_name.add(person);
            count.add(1);
        }
        else {
            int freq = count.get(index);
            count.set(index,freq+1);
        }
    }

    public void findAllCharacters() {
        character_name.clear();
        count.clear();
        FileResource Resource = new FileResource();
        for (String line: Resource.lines()){
            if (line.contains(".")) {
                int idx = line.indexOf(".");
                String possible_name = line.substring(0,idx);
                update(possible_name);
            }
        }
    }

    public void tester() {
        findAllCharacters();
        for (int k =0; k < count.size();k++) {
            if (count.get(k) > 1) {
                System.out.println("The main character is: "+ character_name.get(k) +"\t" +"The number of speaking parts is: "+ count.get(k));
            }
        }
        int num1 = 2;
        int num2 = 3;
        charactersWithNumParts(num1, num2);
    }

    public void charactersWithNumParts(int num1, int num2) {
        for (int k =0; k < count.size();k++) {
            if (count.get(k) >= num1 && count.get(k)<= num2) {
                System.out.println("The main character between : " + num1 + " and " + num2 + " is " + character_name.get(k) +"\t" +"The number of speaking parts is: "+ count.get(k));
            }
        }
    }

}