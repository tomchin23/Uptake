package commons;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import static commons.LogPrac.myMethod;

/**
 * Created by hbhardwa on 7/22/2016.
 */
public class LogPrac {

    static Logger lgr = Logger.getLogger(LogPrac.class);

    public static void main(String[] args) {

        BasicConfigurator.configure();
        lgr.debug("Debug here");

        myMethod();

        lgr.info("Error info here");
    }
    public static void myMethod() {

    }

}
