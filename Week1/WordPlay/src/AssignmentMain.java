import java.util.logging.Level;
import java.util.logging.Logger;
public class AssignmentMain {
    public static void main(String[] args){
        var logger= Logger.getLogger(AssignmentMain.class.getName());
        var obj=new Assignment();
        obj.testEmphasize();
        logger.log(Level.FINE,"\n");
        obj.testIsVowel();
        logger.log(Level.FINE,"\n");
        logger.log(Level.INFO,"Hello World"); //testing logger.log()
        obj.testReplaceVowels();
    }
}
