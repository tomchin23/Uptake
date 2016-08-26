package commons;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Created by hbhardwa on 7/26/2016.
 */
public class Logging {

    static Logger lgr = Logger.getLogger(Logging.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
         lgr.debug("Debug message here!");

        myMethod();

        lgr.info("info message here!");
    }

    public static void myMethod() {
        try {
            throw new Exception("My Exception");
        }
        catch (Exception e) {
            lgr.error("This is an Exception and cause is: " + e.getCause());
        }

    }
}
