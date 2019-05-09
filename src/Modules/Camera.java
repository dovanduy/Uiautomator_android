package Modules;

import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

/**
 * Created by qiumin on 2015/9/10.
 */
public class Camera extends module {
    private final Marker MARKER= MarkerManager.getMarker("CAMERA");
    
    @Override
    public void check_if_terminated() throws Exception {
    	// DONE Auto-generated method stub
    	if(button_exist("ok")){
    		logger.info(MARKER,"Find 'OK' button after click camera apk.");
    		this.clicks("ok");
    	}
    	super.check_if_terminated();    	
    }
}
