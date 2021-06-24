import java.util.logging.Level;
import java.util.logging.Logger;
public class Assignment{
    Logger logger= Logger.getLogger(Assignment.class.getName());
    public boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'i' || ch == 'u' || ch == 'e' || ch == 'o';
    }

    public void testIsVowel() {
        var ch = 'f';
        System.out.println(ch + " is a vowel = " + isVowel(ch));
        logger.log(Level.FINE,"ch + \" is a vowel = \" + isVowel(ch)");

        ch = 'A';
        System.out.println(ch + " is a vowel = " + isVowel(ch));
    }

    public String replaceVowels(String phrase, char ch) {
        StringBuilder newPhrase = new StringBuilder();

        for (var i = 0; i < phrase.length(); i++) {
            char currentCharacter = phrase.charAt(i);

            if (isVowel(currentCharacter)) {
                newPhrase.append(ch);
            } else {
                newPhrase.append(currentCharacter);
            }
        }

        return newPhrase.toString();
    }

    public void testReplaceVowels() {
        String phrase = "Hello World";
        var ch = '*';
        System.out.println(phrase + " -> " + replaceVowels(phrase, ch));
    }

    public String emphasize(String phrase, char ch) {
        StringBuilder newPhrase = new StringBuilder();
        for (var i = 0; i < phrase.length(); i++) {
            char currentCharacter = phrase.charAt(i);

            if (Character.toLowerCase(currentCharacter) == Character.toLowerCase(ch)) {
                if (i % 2 == 0) {
                    newPhrase.append('*');
                } else {
                    newPhrase.append('+');
                }
            } else {
                newPhrase.append(currentCharacter);
            }
        }

        return newPhrase.toString();
    }

    public void testEmphasize() {
        var phrase = "dna ctgaaactga";
        char ch = 'a';
        System.out.println(phrase + " with " + ch + " replaced become = " + emphasize(phrase, ch));

        phrase = "Mary Bella Abracadabra";
        ch = 'a';
        System.out.println(phrase + " with " + ch + " replaced become = " + emphasize(phrase, ch));
    }
}