package Modules;

import Config.button;
import Config.module_config;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.util.Arrays;

/**
 * Created by qiumin on 2015/8/14.
 */
public class Call extends module{
    private module_config config ;
    private String[] nums;
    private module_config.method_sel numb_sel;
    private final Marker MARKER= MarkerManager.getMarker("CALL");


//    @Override
//    public void set_cfg(module_config cfg) throws Exception{
//        super.set_cfg(cfg);
//        nums=get_button("number").attribute.split("\\|");
//        numb_sel=get_button("number").mSel;
//    }
    

    @Override
    public void clicks(String btns_in) throws Exception {
        String [] btns=btns_in.split("\\|");
        logger.debug(Arrays.toString(btns));
        for(String btn : btns) {
            if (btn.contains("D")) {  
                String a = btn.replace("D", "");
                int n = Integer.parseInt(a);
                Thread.sleep(1000 * n);
                logger.info("Wait for " + n + " seconds.");
            } else if (btn.equals("HOME")) {
                press_home();
            } else if (btn.equals("BACK")) {
                press_back();
            }else if(btn.equals("NUMS")){
                click_phone_num(get_button("phone_num").attribute);
            }
            else if(btn.equals("NUMS1")){
            	click_phone_num(get_button("phone_num1").attribute);
            }
            else if (btn.equals("CALL")) {
                press_call();
            } else if (btn.equals("CAMERA")) {
                press_camera();
            } else if (btn.equals("NOTIFY")) {
                open_notification();
            } else if(btn.equals("WAKE")){
                wakup();
            }
            else {
                click_button(btn);
            }
            Thread.sleep(2000);
        }
    }

    public void click_phone_num(String phone_num) throws Exception{
        logger.info(MARKER,"Start to press dial number : {}. ",phone_num);
        for(int i=0;i<phone_num.length();i++){
            char c=phone_num.charAt(i);

            int j=Integer.parseInt(String.valueOf(c));
            String attribute;
            if(numb_sel== module_config.method_sel.id){
                attribute=".+"+nums[j];
            }else {
                attribute = nums[j];
            }
            //logger.debug(MARKER,"{} : attr - {} , sel - {}",String.valueOf(c),attribute,numb_sel);
            click_button(new button(attribute, numb_sel, String.valueOf(c)));
            logger.info(MARKER, "Click number - {}", c);
        }
    }

    public void dial_and_check() throws Exception{
        clicks("NUMS|dial|D5|HOME|D2|NOTIFY|D2");
        if(button_exist("hangout")){
            clicks("hangout|BACK");
        }else{
            logger.info(MARKER,"");
            throw new Exception();
        }
    }
}
