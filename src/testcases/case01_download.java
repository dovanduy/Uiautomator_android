package testcases;

import Phone.base_phone;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

/**
 * Created by qiumin on 2015/9/2.
 */
public class case01_download extends base_testcase{
    public static int case_count=0;
    private final Marker MARKER= MarkerManager.getMarker("vivo");

    public case01_download(base_phone phone_in) {
        super(phone_in);
    }

    @Override
    public void during_run() throws Exception {
        function_name="版本升级_test";
        logger.info(MARKER, "Now is running function '{}'", function_name);
        my_phone.version_download_test();
    }

    @Override
    public void pre_report() throws Exception {
        this.case_count +=1;
    }
  
}
