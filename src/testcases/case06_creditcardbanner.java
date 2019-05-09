package testcases;

import Phone.base_phone;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

/**
 * Created by qiumin on 2015/9/2.
 */
public class case06_creditcardbanner extends base_testcase{
    public static int case_count=0;
    private final Marker MARKER= MarkerManager.getMarker("vivo");

    public case06_creditcardbanner(base_phone phone_in) {
        super(phone_in);
    }

    @Override
    public void during_run() throws Exception {
        function_name="信用卡banner_test";
        logger.info(MARKER, "Now is running function '{}'", function_name);
        my_phone.creditcardbanner_test();
    }

    @Override
    public void pre_report() throws Exception {
        this.case_count +=1;
    }
  
}
