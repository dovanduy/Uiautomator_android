package Config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by qiumin on 2015/8/14.
 */
public abstract class module_config{
    public enum method_sel{
        text,
        id,
        desc
    }
    Logger logger= LogManager.getLogger(this.getClass());
    private HashMap<String,button> buttonsMap;
    public String name;
    public String pkg;
    public String pkg_2;
    public module_config(){
        buttonsMap=new HashMap<String,button>();
    }

    public void add(String name,button new_button){
        buttonsMap.put(name,new_button);
    }
    public HashMap<String, button> set_map(){return buttonsMap;}
    public void set_default(){}
    public Iterator<Map.Entry<String, button>> get_cfg_iterator(){
        return buttonsMap.entrySet().iterator();
    }
    public void clear_config(){
        buttonsMap.clear();
    }
    public String get_attr(String name){
        String attr=buttonsMap.get(name).attribute;
        return attr;
    }
    public method_sel get_sel(String name){
        return buttonsMap.get(name).mSel;
    }
    public String get_pkg2(){return pkg_2;}
    public String get_pkg(){return pkg;}
    public String get_apk_name() {return name;}
    public void print_cfg(){
        Iterator<Map.Entry<String, button>> iterator = get_cfg_iterator();
        while (iterator.hasNext()){
            Map.Entry<String, button> entry = iterator.next();
            String nme=entry.getKey();
            button btn=entry.getValue();
            logger.info("Button : {} --> {}",nme,btn.pr_out());
        }
    }
//    public String attr2key(String attrbute_in) throws Exception{
//    	logger.debug("attribute in is {}",attrbute_in);
//        String name_out = null;
//        Iterator<Map.Entry<String, button>> iterator = get_cfg_iterator();
//        while (iterator.hasNext()){
//            Map.Entry<String, button> entry = iterator.next();
//            String nme=entry.getKey();
//            logger.debug("attr2key : key is - {}",nme);
//            String atr=entry.getValue().attribute;
//            if(attrbute_in.equals(atr)) {
//                logger.info("Find button '{}' has attribute '{}'", nme, atr);
//                name_out=nme;
//            }
//        }
//        if(name_out==null){
//            logger.error("Search button which has attribute '{}' failed.",attrbute_in);
//            throw new Exception();
//        }
//        return name_out;
//    }

}
