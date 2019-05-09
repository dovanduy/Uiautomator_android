package Modules;

import Config.module_config;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by qiumin on 2015/8/28.
 */
public class Calculator extends module{
    private module_config config ;
    private String[] nums;
    private module_config.method_sel numb_sel;
    private final Marker MARKER = MarkerManager.getMarker("CALCULATE");

    private HashMap<Character,String> cal_opr;

    private void initial_opr_map(){
        cal_opr=new HashMap<Character,String>();
        cal_opr.put('+',"plus");
        cal_opr.put('-',"minus");
        cal_opr.put('*',"multiply");
        cal_opr.put('/',"division");
        cal_opr.put('C',"clear");
        cal_opr.put('.',"dot");
        cal_opr.put('=',"equal");
        cal_opr.put('s',"sin");
        cal_opr.put('c',"cos");
        cal_opr.put('t',"tan");
        cal_opr.put('n',"ln");
        cal_opr.put('o',"log");
        cal_opr.put('π',"pi");
        cal_opr.put('e',"e");
        cal_opr.put('^',"power");
        cal_opr.put('%',"percent");
        cal_opr.put('d',"divd");
        cal_opr.put('!',"factorial");
        cal_opr.put('(',"left_paren");
        cal_opr.put(')',"right_paren");
        cal_opr.put('√',"sqrt");//ALT+41420
        cal_opr.put('²',"square");//ALT+178
        cal_opr.put('0',"zero");
        cal_opr.put('1',"one");
        cal_opr.put('2',"two");
        cal_opr.put('3',"three");
        cal_opr.put('4',"four");
        cal_opr.put('5',"five");
        cal_opr.put('6',"six");
        cal_opr.put('7',"seven");
        cal_opr.put('8',"eight");
        cal_opr.put('9',"nine");
    }
    public Calculator(){
        super();
        initial_opr_map();
    }

    @Override
    public void clicks(String btns_in) throws Exception {
        String [] btns=btns_in.split("\\|");
        logger.debug(Arrays.toString(btns));
        for(String btn : btns){
            if(btn.contains("D")){
                String a=btn.replace("D","");
                int n=Integer.parseInt(a);
                Thread.sleep(1000*n);
                logger.info(MARKER,"Wait for "+n+" seconds.");
            }else if(btn.equals("HOME")){
                press_home();
            }else if(btn.equals("BACK")){
                press_back();
            }else if(btn.equals("EXPR")){
                clicks_expression();
            }else if(btn.equals("CALL")){
                press_call();
            }else if(btn.equals("CAMERA")){
                press_camera();
            }else if(btn.equals("NOTIFY")){
                open_notification();
            }else if(btn.equals("WAKE")){
                wakup();
            }
            else{
                click_button(btn);
            }
        }
    }

    public void clicks_expression() throws Exception{
        String expression=get_attr("expression");
        String button_name;
        int left_x=Integer.valueOf(get_attr("left_x"));
        int right_x=Integer.valueOf(get_attr("right_x"));
        int left_y=Integer.valueOf(get_attr("left_y"));
        int right_y=Integer.valueOf(get_attr("right_y"));
        int steps=Integer.valueOf(get_attr("steps"));
        
        for(int i=0;i<expression.length();i++){
            Character ch=expression.charAt(i);
            button_name=cal_opr.get(ch);
            boolean exist=button_exist(button_name);
            
            if(!exist)
                //swipe(650,1000,150,1000,5);
            	//swipe(275,297,26,293,2);
            	swipe(right_x, right_y, left_x, left_y, steps);
                exist=button_exist(button_name);
                if(!exist){
                    //swipe(150,1000,650,1000,5);
                	//swipe(26,293,275,297,2);
                	swipe(left_x, left_y, right_x, right_y, steps);
            }
            click_button(button_name);
        }
    }

    public String get_result() throws Exception{
        String real_result=get_attr("real_result");
        return read_button("cal_result");
    }

    public String cal_result2real_result(String result_in) throws Exception{
    	logger.info(MARKER, "******** 鎶婅绠楀櫒鐨勭粨鏋滆浆鎹㈡垚甯歌鐨�(閰嶇疆)鐨勭粨鏋� ********");
        String tmp="";
        logger.debug(MARKER,"result is {} ",result_in);
        for(int i=0;i<result_in.length();i++){
        	logger.debug(MARKER,"i={};",i);
        	char ch=result_in.charAt(i);
            logger.debug(MARKER,"ch ={}",ch);
            String nam=attr2key(String.valueOf(ch));
            logger.debug(MARKER,"ch ={},nam={}",ch,nam);
            Character opr=cal_opr_value2key(nam);
            tmp=tmp+opr;
            logger.debug(MARKER,"tmp is '{}'",tmp);
        }
        logger.info(MARKER,"converse to real_reasult of '{}'",tmp);
        return tmp;
    }
    public String real_result2cal_result(String result_in) throws Exception{
    	logger.info(MARKER, "******** 鎶婄湡瀹炵殑缁撴灉(閰嶇疆)杞崲鎴愯绠楀櫒鐨勭粨鏋� ********");
        String tmp="";
        for(int i=0;i<result_in.length();i++){
            char ch=result_in.charAt(i);
            String nam=cal_opr.get(ch);
            String attr=config.get_attr(nam);
            tmp=tmp+attr;
        }
        return tmp;
    }

    public Character cal_opr_value2key(String value_in) throws Exception{
        Character opr_out = null;
        Iterator<Map.Entry<Character, String>> iterator = cal_opr.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Character, String> entry = iterator.next();
            Character opr=entry.getKey();
            String nme=entry.getValue();
            if(nme.equals(value_in)) {
                logger.info("Value '{}''s key is '{}'.",nme,opr);
                opr_out= opr ;
            }
        }
        if(opr_out==null){
            logger.info("Value '{}''s key is not find.",value_in);
            throw new Exception();
        }
        return opr_out;
    }
}
