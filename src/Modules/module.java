package Modules;

import Config.button;
import Config.module_config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import uiautomatorrpc.UiDevice;
import uiautomatorrpc.UiObject;
import uiautomatorrpc.UiSelector;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by qiumin on 2015/8/14.
 */
public class module {
    private HashMap<String, button> buttons;
    private module_config config;
    public Logger logger= LogManager.getLogger(this.getClass());
    private final Marker MARKER = MarkerManager.getMarker("MODULE");
    public UiDevice device=UiDevice.getInstance();

    public Marker get_mark(){return MARKER;}
    public void set_map(){
        this.buttons=config.set_map();
    }
    public void set_cfg(module_config cfg) throws Exception{
        this.config=cfg;
        set_map();
    }
    public String get_pkg2_cfg(){return config.get_pkg2();}
    public String get_pkg_cfg(){return config.get_pkg();}
    public String get_apk_name(){return config.get_apk_name();}
    public String get_attr(String name){
        return this.config.get_attr(name);
    }
    public module_config.method_sel get_sel(String name){return  this.config.get_sel(name);}
    public button get_button(String name) throws Exception{
        if(buttons.containsKey(name)) {
            //logger.debug(MARKER,"'{}' is exist in config map.",name);
            return buttons.get(name);
        }else{
            logger.error(MARKER,"The '{}' is not in config map.",name);
            throw new Exception();
        }
    }
    public void print_cfg(){
        config.print_cfg();
    }
    public void open_apk() throws Exception{
        boolean find=false;
        logger.info(MARKER,"apk name is '{}'",config.name);
        try {
            find = scroll_find(config.name, false);
        	find = new UiObject(new UiSelector().text(config.name)).exist();
            logger.info("find is {}",find);
        	if(!find){
        		for(int i=0;i<15;i++){
        			device.swipe(585, 360, 180, 360, 20);
        			find = new UiObject(new UiSelector().text(config.name)).exist();
        			if(find){
        				logger.info("finally find apk,click it");
        				click_button(new UiObject(new UiSelector().text(config.name)));
        				this.clicks("D1");
        				return;
        			}
        			logger.info("open-apk : {}",i);        			
        		}
        	}else {
        		logger.info("Click open apk");
        		click_button(new UiObject(new UiSelector().text(config.name)));
			}
        }catch (Exception e){
            logger.error(MARKER," can't find '{}' .",config.name);
            throw e;
        } catch (Throwable e) {
			e.printStackTrace();
			logger.error(MARKER," ~ can't find '{}' .",config.name);
		}
       
    }
    public void check_if_terminated() throws Exception{
        clicks("D5");
        String real_pkg=get_current_pkg();
        if(real_pkg.contains(config.pkg)){
            logger.info(MARKER, "The package name is correct. this apk is running correctly.");
        }else {
            logger.error(MARKER,"The package name is not correct (real({}) vs expect({})), this apk is not running correctly.",real_pkg,config.pkg);
            throw new Exception();
        }
    }
    public void clicks(String btns_in) throws Exception{
        String [] btns=btns_in.split("\\|");
        logger.debug(Arrays.toString(btns));
        for(String btn : btns){
            if(btn.contains("D")){
                String a=btn.replace("D","");
                int n=Integer.parseInt(a);
                Thread.sleep(1000*n);
                logger.info(MARKER,"Wait for "+n+" seconds.");
            }
            else if(btn.equals("HOME")){
                press_home();
            }
            else if(btn.equals("BACK")){
                press_back();
            }
            else if(btn.equals("CALL")){
                press_call();
            }
            else if(btn.equals("CAMERA")){
                press_camera();
            }
            else if(btn.equals("NOTIFY")){
                open_notification();
            }
            else if(btn.equals("WAKE")){
                wakup();
            }
            else{
                click_button(btn);
            }
        }
    }
    public void click_button(String name) throws  Exception{
        button btn=get_button(name);
        UiObject click_obj=button_to_uiobject(btn);
        boolean b=button_exist(click_obj);
        if(b) {
            try {
                click_obj.click();
                logger.info(MARKER, "Try to click the button '{}' ", name);
//                if (!a) {
//                    throw new Exception();
//                }
            } catch (Throwable throwable) {
                logger.error(MARKER, "Click button '{}'failed.", name);
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER,"'{}' is configed,but not exist..",name);
            throw new Exception();
        }
    }
    public void click_button(button btn) throws Exception{
        UiObject click_obj=button_to_uiobject(btn);
        boolean b=button_exist(click_obj);
        if(b) {
            try {
                click_obj.click();
                logger.info(MARKER, "Try to click the button '{}' ", btn.attribute);
//                if (!a) {
//                    throw new Exception();
//                }
            } catch (Throwable throwable) {
                logger.error(MARKER, "Click button '{}'failed.", btn.attribute);
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER,"'{}' is configed,but not exist..",btn.attribute);
            throw new Exception();
        }
    }
    public void click_button(UiObject obj) throws Exception{
        boolean b=button_exist(obj);
        if(b) {
            try {
                obj.click();
                logger.info(MARKER, "Try to click a UiObject.");
//                if (!a) {
//                    throw new Exception();
//                }
            } catch (Throwable throwable) {
                logger.error(MARKER, "Click a UiObject Failed.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER,"This uiobject is not exist.");
            throw new Exception();
        }
    }
    public void write_button(String name,String text) throws Exception{
        button btn=get_button(name);
        UiObject write_obj=button_to_uiobject(btn);
        boolean b=button_exist(write_obj);
        if(b) {
            try {
                boolean a = write_obj.setText(text);
                logger.info(MARKER, "Try to write '" + text + "' in button :" + name);
                if (!a) {
                    throw new Exception();
                }
            } catch (Throwable throwable) {
                logger.error(MARKER, "Write in button '" + name + "'failed.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER,"'{}' is configed,but not exist..",name);
            throw new Exception();
        }
    }
    public void write_button(button btn,String text) throws Exception{
        UiObject write_obj=button_to_uiobject(btn);
        boolean b=button_exist(write_obj);
        if(b) {
            try {
                boolean a = write_obj.setText(text);
                logger.info(MARKER, "Try to write '{}' in button : '{}'", text, btn.attribute);
                if (!a) {
                    throw new Exception();
                }
            } catch (Throwable throwable) {
                logger.error(MARKER, "Write in button '{}'failed.", btn.attribute);
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER,"'{}' is configed,but not exist..",btn.attribute);
            throw new Exception();
        }
    }
    public void write_button(UiObject obj,String text) throws  Exception{
        boolean b=button_exist(obj);
        if(b) {
            try {
                boolean a = obj.setText(text);
                logger.info(MARKER, "Try to write a UiObject.");
                if (!a) {
                    throw new Exception();
                }
            } catch (Throwable throwable) {
                logger.error(MARKER, "Write a UiObject failed.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "This UiObject is not exist.");
            throw new Exception();
        }
    }
    public String read_button(String name) throws Exception{
        button btn=get_button(name);
        UiObject read_obj=button_to_uiobject(btn);
        boolean b=button_exist(read_obj);
        String out;
        if(b) {
            try {
                out = read_obj.getText();
                logger.info(MARKER, "Try to read button '" + name + "',and the Text is :" + out);
            } catch (Throwable throwable) {
                logger.error(MARKER, "Read the button '" + name + "' failed.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",name);
            throw new Exception();
        }
        return  out;
    }
    public String read_button(button btn) throws Exception{
        UiObject read_obj=button_to_uiobject(btn);
        String out;
        boolean b=button_exist(read_obj);
        if(b) {
            try {
                out = read_obj.getText();
                logger.info(MARKER, "Try to read button '{}',and the Text is : '{}'", btn.attribute, out);
            } catch (Throwable throwable) {
                logger.error(MARKER, "Read the button '{}' failed.", btn.attribute);
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",btn.attribute);
            throw new Exception();
        }
        return  out;
    }
    public String read_button(UiObject obj) throws Exception{
        String out=null;
        boolean b=button_exist(obj);
        if(b) {
            try {
                out = obj.getText();
                logger.info(MARKER, "Try to read a UiObject, and the Text is :" + out);
            } catch (Throwable throwable) {
                logger.error(MARKER, "Read a UiObject failed.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "This UiObject is not exist.");
            throw new Exception();
        }
        return out;
    }
    public void clear_button(String name) throws Exception{
        button btn=get_button(name);
        UiObject read_obj=button_to_uiobject(btn);
        boolean b=button_exist(read_obj);
        String out;
        if(b) {
            try {
                read_obj.clearTextField();
                logger.info(MARKER, "Try to clear text field of button '{}'.",name);
            } catch (Throwable throwable) {
                logger.info(MARKER, "Clear text field of button '{}' field.", name);
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",name);
            throw new Exception();
        }
    }
    public void clear_button(button btn) throws Exception{
        UiObject read_obj=button_to_uiobject(btn);
        boolean b=button_exist(read_obj);
        String out;
        if(b) {
            try {
                read_obj.clearTextField();
                logger.info(MARKER, "Try to clear text field of button '{}'.",btn.attribute);
            } catch (Throwable throwable) {
                logger.info(MARKER, "Clear text field of button '{}' field.",btn.attribute);
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",btn.attribute);
            throw new Exception();
        }
    }
    public void clear_button(UiObject obj) throws Exception{
        boolean b=button_exist(obj);
        String out;
        if(b) {
            try {
                obj.clearTextField();
                logger.info(MARKER, "Try to clear text field of a UiObject.");
            } catch (Throwable throwable) {
                logger.info(MARKER, "Clear text field of a UiObject field.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "This UiObject is not exist.");
            throw new Exception();
        }
    }
    public void long_click_button(String name) throws  Exception{
        button btn=get_button(name);
        UiObject click_obj=button_to_uiobject(btn);
        boolean b=button_exist(click_obj);
        if(b) {
            try {
                boolean a = click_obj.longClick();
                logger.info(MARKER, "Try to longclick the button : " + name);
                if (!a) {
                    logger.error(MARKER, "Longclick returns false result.");
                    throw new Exception();
                }
            } catch (Throwable throwable) {
                logger.error(MARKER, "Longclick button '" + name + "'failed.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",name);
            throw new Exception();
        }
    }
    public void long_click_button(button btn) throws Exception{
        UiObject click_obj=button_to_uiobject(btn);
        boolean b=button_exist(click_obj);
        if(b) {
            try {
                boolean a = click_obj.longClick();
                logger.info(MARKER, "Try to longclick the button : " +
                        "'{}'", btn.attribute);
                if (!a) {
                    logger.error(MARKER, "Longclick returns false result.");
                    throw new Exception();
                }
            } catch (Throwable throwable) {
                logger.error(MARKER, "Longclick button '{}'failed.", btn.attribute);
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",btn.attribute);
            throw new Exception();
        }
    }
    public void long_click_button(UiObject obj) throws  Exception{
        boolean b=button_exist(obj);
        if(b) {
            try {

                boolean a = obj.longClick();
                logger.info(MARKER, "Try to longclick a UiObject.");
                if (!a) {
                    logger.error(MARKER, "Longclick returns false result.");
                    throw new Exception();
                }
            } catch (Throwable throwable) {
                logger.error(MARKER, "Longclick a UiObject failed.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "This UiObject is not exist.");
            throw new Exception();
        }
    }
    public int count_button(String name) throws Exception{
        button btn=get_button(name);
        UiObject count_obj=button_to_uiobject(btn);
        boolean b=button_exist(count_obj);
        int a;
        if(b) {
            try {
                a = count_obj.count();
                logger.info(MARKER, "Try count buttons ({}) and count is '{}'", name, a);
            } catch (Throwable throwable) {
                a = 0;
                logger.error(MARKER, "Count some kind of button failed.");
                throw new Exception();
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",name);
            throw new Exception();
        }
        return a;
    }
    public int count_button(button btn) throws Exception{
        UiObject count_obj=button_to_uiobject(btn);
        boolean b=button_exist(count_obj);
        int a;
        if(b) {
            try {
                a = count_obj.count();
                logger.info(MARKER, "Try count buttons ({}) and count is '{}'", btn.attribute, a);
            } catch (Throwable throwable) {
                a = 0;
                logger.error(MARKER, "Count some kind of button failed.");
                throw new Exception();
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",btn.attribute);
            throw new Exception();
        }
        return a;
    }
    public int count_button(UiObject obj) throws Exception{
        boolean b=button_exist(obj);
        int a;
        if(b) {
            try {
                a = obj.count();
                logger.info(MARKER, "Try count The UiObject,and the count is '{}'",a);
            } catch (Throwable throwable) {
                a = 0;
                logger.error(MARKER, "Count the UiObject failed.");
                throw new Exception();
            }
        }else{
            logger.error(MARKER, "This UiObject is not exist.");
            throw new Exception();
        }
        return a;
    }
    public void swipe_button(String name,String direction,int steps) throws  Exception{
        button btn=get_button(name);
        UiObject swipe_obj=button_to_uiobject(btn);
        boolean b=button_exist(swipe_obj);
        if(b) {
            try {
                boolean a = swipe_obj.swipe(direction, steps);
                logger.info(MARKER, "Try to swipe the button '{}' with direction '{}' and step of '{}'", name, direction, steps);
                if (!a) {
                    throw new Exception();
                }
            } catch (Throwable throwable) {
                logger.error(MARKER, "Swipe the button '{}' failed.", name);
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",name);
            throw new Exception();
        }
    }
    public void swipte_button(button btn,String direction,int steps) throws Exception{
        UiObject swipe_obj=button_to_uiobject(btn);
        boolean b=button_exist(swipe_obj);
        if(b) {
            try {
                boolean a = swipe_obj.swipe(direction, steps);
                logger.info(MARKER, "Try to swipe the button '{}' with direction '{}' and step of '{}'", btn.attribute, direction, steps);
                if (!a) {
                    throw new Exception();
                }
            } catch (Throwable throwable) {
                logger.error(MARKER, "Swipe the button '{}' failed.", btn.attribute);
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",btn.attribute);
            throw new Exception();
        }
    }
    public void swipe_button(UiObject obj,String direction,int steps) throws Exception{
        boolean b=button_exist(obj);
        if(b) {
            try {
                boolean a = obj.swipe(direction, steps);
                logger.info(MARKER, "Try to swipe a UiObject.");
                if (!a) {
                    throw new Exception();
                }
            } catch (Throwable throwable) {
                logger.error(MARKER, "Swipe a UiObject failed.");
                throw new Exception(throwable);
            }
        }else {
            logger.error(MARKER, "This UiObject is not exist.");
            throw new Exception();
        }
    }
    public void drag_button(String name,int dest_x,int dest_y,int steps) throws  Exception{
        button btn=get_button(name);
        UiObject drag_obj=button_to_uiobject(btn);
        boolean b=button_exist(drag_obj);
        if(b) {
            try {
                boolean a = drag_obj.dragTo(dest_x, dest_y, steps);
                logger.info(MARKER, "Try to drag button to ({},{}) with step '{}'", dest_x, dest_y, steps);
                if (!a) {
                    throw new Exception();
                }
            } catch (Throwable throwable) {
                logger.error(MARKER, "Drag the button '{}' failed.", name);
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",name);
            throw new Exception();
        }
    }
    public void drag_button(button btn,int dest_x,int dest_y,int steps) throws Exception{
        UiObject drag_obj=button_to_uiobject(btn);
        boolean b=button_exist(drag_obj);
        if(b) {
            try {
                boolean a = drag_obj.dragTo(dest_x, dest_y, steps);
                logger.info(MARKER, "Try to drag button to ({},{}) with step '{}'", dest_x, dest_y, steps);
                if (!a) {
                    throw new Exception();
                }
            } catch (Throwable throwable) {
                logger.error(MARKER, "Drag the button '{}' failed.", btn.attribute);
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",btn.attribute);
            throw new Exception();
        }
    }
    public void drag_button(UiObject obj,int dest_x,int dest_y,int steps)throws Exception{
        boolean b=button_exist(obj);
        if(b) {
            try {
                boolean a = obj.dragTo(dest_x, dest_y, steps);
                logger.info(MARKER, "Try to drag a UiObject to ({},{}) with step '{}'", dest_x, dest_y, steps);
                if (!a) {
                    throw new Exception();
                }
            } catch (Throwable throwable) {
                logger.error(MARKER, "Drag a UiObject failed.");
                throw new Exception(throwable);
            }
        }else {
            logger.error(MARKER, "This UiObjet is not exist.");
            throw new Exception();
        }
    }
    public boolean button_checkable(String name) throws Exception{
        boolean checkable=false;
        button btn=get_button(name);
        UiObject btn_obj=button_to_uiobject(btn);
        boolean b=button_exist(btn_obj);
        if(b) {
            try {
                checkable = btn_obj.isCheckable();
                logger.info(MARKER, "Try get the checkable attribute of button {}'", name);
            } catch (Throwable throwable) {
                logger.error(MARKER, "Try get the checkable attribute of button failed.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",name);
            throw new Exception();
        }
        return checkable;
    }
    public boolean button_checkable(button btn) throws Exception{
        boolean checkable;
        UiObject btn_obj=button_to_uiobject(btn);
        boolean b=button_exist(btn_obj);
        if(b) {
            try {
                checkable = btn_obj.isCheckable();
                logger.info(MARKER, "Try get the checkable attribute of button {}'", btn.attribute);
            } catch (Throwable throwable) {
                logger.error(MARKER, "Try get the checkable attribute of button failed.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",btn.attribute);
            throw new Exception();
        }
        return checkable;
    }
    public boolean button_checkable(UiObject obj) throws Exception {
        boolean checkable;
        boolean b=button_exist(obj);
        if(b) {
            try {
                checkable= obj.isCheckable();
                logger.info(MARKER, "Try get the checkable attribute of a UiObject.");
            } catch (Throwable throwable) {
                logger.info(MARKER, "Try get the checkable attribute of a UiObject.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "This UiObject is not exist.");
            throw new Exception();
        }
        return checkable;
    }
    public boolean button_clickable(String name) throws Exception{
        boolean clickable;
        button btn=get_button(name);
        UiObject btn_obj=button_to_uiobject(btn);
        boolean b=button_exist(btn_obj);
        if(b) {
            try {
                clickable=btn_obj.isClickable();
                logger.info(MARKER,"Try get the clickable attribute of button {}'",name);
            } catch (Throwable throwable) {
                logger.error(MARKER, "Get the clickable attribute of button failed.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",name);
            throw new Exception();
        }
        return clickable;
    }
    public boolean button_clickable(button btn) throws Exception{
        boolean clickable;
        UiObject btn_obj=button_to_uiobject(btn);
        boolean b=button_exist(btn_obj);
        if(b) {
            try {
                clickable = btn_obj.isClickable();
                logger.info(MARKER, "Try get the clickable attribute of button {}'", btn.attribute);
            } catch (Throwable throwable) {
                logger.error(MARKER, "Get the clickable attribute of button failed.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",btn.attribute);
            throw new Exception();
        }
        return clickable;
    }
    public boolean button_clickable(UiObject obj) throws Exception {
        boolean clickable;
        boolean b=button_exist(obj);
        if(b) {
            try {
                clickable= obj.isClickable();
                logger.info(MARKER, "Try get the clickable attribute of a UiObject.");
            } catch (Throwable throwable) {
                logger.info(MARKER, "Try get the clickable attribute of a UiObject.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "This UiObject is not exist.");
            throw new Exception();
        }
        return clickable;
    }
    public boolean button_enabled(String name) throws Exception{
        boolean enabled;
        button btn=get_button(name);
        UiObject btn_obj=button_to_uiobject(btn);
        boolean b=button_exist(btn_obj);
        if(b) {
            try {
                enabled = btn_obj.isEnabled();
                logger.info(MARKER, "Try get the enabled attribute of button {}'", name);
            } catch (Throwable throwable) {
                logger.error(MARKER, "Get the enabled attribute of button failed.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",name);
            throw new Exception();
        }
        return enabled;
    }
    public boolean button_enabled(button btn) throws Exception{
        boolean enabled;
        UiObject btn_obj=button_to_uiobject(btn);
        boolean b=button_exist(btn_obj);
        if(b) {
            try {
                enabled = btn_obj.isEnabled();
                logger.info(MARKER, "Try get the enabled attribute of button {}'", btn.attribute);
            } catch (Throwable throwable) {
                logger.error(MARKER, "Get the enabled attribute of button failed.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",btn.attribute);
            throw new Exception();
        }
        return enabled;
    }
    public boolean button_enabled(UiObject obj) throws Exception {
        boolean enabled;
        boolean b=button_exist(obj);
        if(b) {
            try {
                enabled= obj.isEnabled();
                logger.info(MARKER, "Try get the enabled attribute of a UiObject.");
            } catch (Throwable throwable) {
                logger.info(MARKER, "Try get the enabled attribute of a UiObject.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "This UiObject is not exist.");
            throw new Exception();
        }
        return enabled;
    }
    public boolean button_focusable(String name) throws Exception{
        boolean focusable;
        button btn=get_button(name);
        UiObject btn_obj=button_to_uiobject(btn);
        boolean b=button_exist(btn_obj);
        if(b) {
            try {
                focusable = btn_obj.isFocusable();
                logger.info(MARKER, "Try get the focusable attribute of button {}'", name);
            } catch (Throwable throwable) {
                logger.error(MARKER, "Try get the focusable attribute of button failed.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",name);
            throw new Exception();
        }
        return focusable;
    }
    public boolean button_focusable(button btn) throws Exception{
        boolean focusable;
        UiObject btn_obj=button_to_uiobject(btn);
        boolean b=button_exist(btn_obj);
        if(b) {
            try {
                focusable=btn_obj.isFocusable();
                logger.info(MARKER,"Try get the focusable attribute of button {}'",btn.attribute);
            } catch (Throwable throwable) {
                logger.error(MARKER, "Try get the focusable attribute of button failed.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",btn.attribute);
            throw new Exception();
        }
        return focusable;
    }
    public boolean button_focusable(UiObject obj) throws Exception {
        boolean focusable;
        boolean b=button_exist(obj);
        if(b) {
            try {
                focusable= obj.isFocusable();
                logger.info(MARKER, "Try get the focusable attribute of a UiObject.");
            } catch (Throwable throwable) {
                logger.info(MARKER, "Try get the focusable attribute of a UiObject.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "This UiObject is not exist.");
            throw new Exception();
        }
        return focusable;
    }
    public boolean button_focused(String name) throws Exception{
        boolean focused;
        button btn=get_button(name);
        UiObject btn_obj=button_to_uiobject(btn);
        boolean b=button_exist(btn_obj);
        if(b) {
            try {
                focused = btn_obj.isFocused();
                logger.info(MARKER, "Try get the focused attribute of button {}'", name);
            } catch (Throwable throwable) {
                logger.error(MARKER, "Try get the focused attribute of button failed.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",name);
            throw new Exception();
        }
        return focused;
    }
    public boolean button_focused(button btn) throws Exception{
        boolean focused;
        UiObject btn_obj=button_to_uiobject(btn);
        boolean b=button_exist(btn_obj);
        if(b) {
            try {
                focused = btn_obj.isFocused();
                logger.info(MARKER, "Try get the focused attribute of button {}'", btn.attribute);
            } catch (Throwable throwable) {
                logger.error(MARKER, "Try get the focused attribute of button failed.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",btn.attribute);
            throw new Exception();
        }
        return focused;
    }
    public boolean button_focused(UiObject obj) throws Exception {
        boolean focused;
        boolean b=button_exist(obj);
        if(b) {
            try {
                focused= obj.isFocused();
                logger.info(MARKER, "Try get the focused attribute of a UiObject.");
            } catch (Throwable throwable) {
                logger.info(MARKER, "Try get the focused attribute of a UiObject.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "This UiObject is not exist.");
            throw new Exception();
        }
        return focused;
    }
    public boolean button_loongclickable(String name) throws Exception{
        boolean longclickable;
        button btn=get_button(name);
        UiObject btn_obj=button_to_uiobject(btn);
        boolean b=button_exist(btn_obj);
        if(b) {
            try {
                longclickable = btn_obj.isLongClickable();
                logger.info(MARKER, "Try get the longclickable attribute of button {}'", name);
            } catch (Throwable throwable) {
                logger.error(MARKER, "Try get the longclickable attribute of button failed.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",name);
            throw new Exception();
        }
        return longclickable;
    }
    public boolean button_loongclickable(button btn) throws Exception{
        boolean longclickable;
        UiObject btn_obj=button_to_uiobject(btn);
        boolean b=button_exist(btn_obj);
        if(b) {
            try {
                longclickable = btn_obj.isLongClickable();
                logger.info(MARKER, "Try get the longclickable attribute of button {}'", btn.attribute);
            } catch (Throwable throwable) {
                logger.error(MARKER, "Try get the longclickable attribute of button failed.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",btn.attribute);
            throw new Exception();
        }
        return longclickable;
    }
    public boolean button_longclickable(UiObject obj) throws Exception {
        boolean longclickable;
        boolean b=button_exist(obj);
        if(b) {
            try {
                longclickable= obj.isLongClickable();
                logger.info(MARKER, "Try get the longclickable attribute of a UiObject.");
            } catch (Throwable throwable) {
                logger.info(MARKER, "Try get the longclickable attribute of a UiObject.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "This UiObject is not exist.");
            throw new Exception();
        }
        return longclickable;
    }
    public boolean button_checked(String name) throws Exception{
        boolean checked;
        button btn=get_button(name);
        UiObject btn_obj=button_to_uiobject(btn);
        boolean b=button_exist(btn_obj);
        if(b) {
            try {
                checked = btn_obj.isChecked();
                logger.info(MARKER, "Try get the checked attribute of button {}'", name);
            } catch (Throwable throwable) {
                logger.error(MARKER, "Try get the checked attribute of button failed.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",name);
            throw new Exception();
        }
        return checked;
    }
    public boolean button_checked(button btn) throws Exception{
        boolean checked;
        UiObject btn_obj=button_to_uiobject(btn);
        boolean b=button_exist(btn_obj);
        if(b) {
            try {
                checked = btn_obj.isChecked();
                logger.info(MARKER, "Try get the checked attribute of button {}'", btn.attribute);
            } catch (Throwable throwable) {
                logger.error(MARKER, "Try get the checked attribute of button failed.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",btn.attribute);
            throw new Exception();
        }
        return checked;
    }
    public boolean button_checked(UiObject obj) throws Exception {
        boolean checked;
        boolean b=button_exist(obj);
        if(b) {
            try {
                checked= obj.isChecked();
                logger.info(MARKER, "Try get the checked attribute of a UiObject.");
            } catch (Throwable throwable) {
                logger.info(MARKER, "Try get the checked attribute of a UiObject.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "This UiObject is not exist.");
            throw new Exception();
        }
        return checked;
    }
    public boolean button_scrollable(String name) throws Exception{
        boolean scrollable;
        button btn=get_button(name);
        UiObject btn_obj=button_to_uiobject(btn);
        boolean b=button_exist(btn_obj);
        if(b) {
            try {
                scrollable = btn_obj.isScrollable();
                logger.info(MARKER, "Try get the scrollable attribute of button {}'", name);
            } catch (Throwable throwable) {
                logger.error(MARKER, "Try get the scrollable attribute of button failed.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",btn.attribute);
            throw new Exception();
        }
        return scrollable;
    }
    public boolean button_scrollable(button btn) throws Exception{
        boolean scrollable;
        UiObject btn_obj=button_to_uiobject(btn);
        boolean b=button_exist(btn_obj);
        if(b) {
            try {
                scrollable = btn_obj.isScrollable();
                logger.info(MARKER, "Try get the scrollable attribute of button {}'", btn.attribute);
            } catch (Throwable throwable) {
                logger.error(MARKER, "Try get the scrollable attribute of button failed.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",btn.attribute);
            throw new Exception();
        }
        return scrollable;
    }
    public boolean button_scrollable(UiObject obj) throws Exception {
        boolean scrollable= false;
        boolean b=button_exist(obj);
        if(b) {
            try {
                scrollable= obj.isScrollable();
                logger.info(MARKER, "Try get the scrollable attribute of a UiObject.");
            } catch (Throwable throwable) {
                logger.info(MARKER, "Try get the scrollable attribute of a UiObject.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "This UiObject is not exist.");
            throw new Exception();
        }
        return scrollable;
    }
    public boolean button_selected(String name) throws Exception{
        boolean selected;
        button btn=get_button(name);
        UiObject btn_obj=button_to_uiobject(btn);
        boolean b=button_exist(btn_obj);
        if(b) {
            try {
                selected=btn_obj.isSelected();
                logger.info(MARKER,"Try get the selected attribute of button {}'",name);
            } catch (Throwable throwable) {
                logger.error(MARKER, "Try get the selected attribute of button failed.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",name);
            throw new Exception();
        }
        return selected;
    }
    public boolean button_selected(button btn) throws Exception {
        boolean selected = false;
        UiObject btn_obj = button_to_uiobject(btn);
        boolean b=button_exist(btn_obj);
        if(b) {
            try {
                selected = btn_obj.isSelected();
                logger.info(MARKER, "Try get the selected attribute of button {}'", btn.attribute);
            } catch (Throwable throwable) {
                logger.error(MARKER, "Try get the selected attribute of button failed.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "'{}' is configed,but not exist..",btn.attribute);
            throw new Exception();
        }
        return selected;
    }
    public boolean button_selected(UiObject obj) throws Exception {
        boolean selected = false;
        boolean b=button_exist(obj);
        if(b) {
            try {
                selected = obj.isSelected();
                logger.info(MARKER, "Try get the selected attribute of a UiObject.");
            } catch (Throwable throwable) {
                logger.info(MARKER, "Try get the selected attribute of a UiObject.");
                throw new Exception(throwable);
            }
        }else{
            logger.error(MARKER, "This UiObject is not exist.");
            throw new Exception();
        }
        return selected;
    }
    public boolean button_conatin(String name,String check_contain_text) throws Exception{
        boolean contain=false;
        String text=read_button(name);
        if(text.contains(check_contain_text)){
            contain=true;
            logger.info(MARKER,"The button '{}' contains the text '{}'",name,check_contain_text);
        }else{
            logger.info(MARKER, "The button '{}' not contains the text '{}'", name, check_contain_text);
        }
        return contain;
    }
    public boolean button_contain(button btn,String check_contain_text) throws Exception{
        boolean contain=false;
        String text=read_button(btn);
        if(text.contains(check_contain_text)){
            contain=true;
            logger.info(MARKER,"The button contains the text '{}'",check_contain_text);
        }else{
            logger.info(MARKER, "The button not contains the text '{}'", check_contain_text);
        }
        return contain;
    }
    public boolean button_contain(UiObject obj,String check_contain_text) throws Exception{
        boolean contain=false;
        String text=read_button(obj);
        if(text.contains(check_contain_text)){
            contain=true;
            logger.info(MARKER,"The UiObject contains the text '{}'",check_contain_text);
        }else{
            logger.info(MARKER, "The UiObject not contains the text '{}'", check_contain_text);
        }
        return contain;
    }

    /**
     * <p>Title : 婊氬姩浠ュ彂鐜版煇涓壒瀹氱殑鎺т欢銆傝鎺т欢灞炴�у彲浠ユ槸宸茬粡閫氳繃config鏂囦欢閰嶇疆濂界殑锛屼篃鍙幇鍐檅uton鐜颁骇鐢熺殑</p>
     * @param name
     * @param virtual
     * @return
     * @throws Exception
     */
    public boolean scroll_find_button(String name,boolean virtual)throws Exception{
        boolean find=false;
        button btn=get_button(name);
        UiSelector scroll_sel=new UiSelector().scrollable(true);
        try {
            switch (btn.mSel) {
                case text:
                	logger.trace("text: {}",btn.attribute);
                    find=new UiObject(scroll_sel).scrollTo(new UiSelector().text(btn.attribute), virtual);
                    break;
                case id:
                	logger.trace("id: {}",btn.attribute);
                    find=new UiObject(scroll_sel).scrollTo(new UiSelector().resourceIdMatches(btn.attribute), virtual);
                    break;
                case desc:
                	logger.trace("desc: {}",btn.attribute);
                    find=new UiObject(scroll_sel).scrollTo(new UiSelector().description(btn.attribute), virtual);
                    break;
            }
            logger.info(MARKER,"Try to scroll to the button '{}' and result is {}",name,find);
        }catch (Throwable throwable){
            logger.error(MARKER,"Try to scroll to the button '{}' failed.",name);
            throw new Exception(throwable);
        }
        return find;
    }
    public boolean scroll_find_button(button btn,boolean virtual)throws Exception{
        boolean find=false;
        UiSelector scroll_sel=new UiSelector().scrollable(true);
        try {
            switch (btn.mSel) {
                case text:
                    find=new UiObject(scroll_sel).scrollTo(new UiSelector().text(btn.attribute), virtual);
                    break;
                case id:
                    find=new UiObject(scroll_sel).scrollTo(new UiSelector().resourceIdMatches(btn.attribute), virtual);
                    break;
                case desc:
                    find=new UiObject(scroll_sel).scrollTo(new UiSelector().description(btn.attribute), virtual);
                    break;
            }
            logger.info(MARKER,"Try to scroll to the button '{}'",btn.attribute);
        }catch (Throwable throwable){
            logger.error(MARKER,"Try to scroll to the button '{}' failed.",btn.attribute);
            throw new Exception(throwable);
    
        }
        return find;
    }

    public boolean button_exist(String name) throws Exception{
        boolean exist;
        button btn=get_button(name);
        UiObject exist_obj=button_to_uiobject(btn);
        try {
            exist=exist_obj.exist();
            logger.info(MARKER,"Try to check if the button '{}' is exist, and result is {}.",name,exist);
        } catch (Throwable throwable) {
            logger.error(MARKER,"Check if the button '{}' is exist failed.",name);
            throw new Exception(throwable);
        }
        return exist;
    }
    public boolean button_exist(button btn) throws Exception{
        boolean exist=false;
        UiObject exist_obj=button_to_uiobject(btn);
        try {
            exist=exist_obj.exist();
            logger.debug(MARKER,"Try to check if the button '{}' is exist.",btn.attribute);
        } catch (Throwable throwable) {
            logger.error(MARKER,"Check if the button '{}' is exist failed.",btn.attribute);
            //throw new Exception(throwable);
        }
        return exist;
    }
    public boolean button_exist(UiObject obj) throws Exception{
        boolean exist=false;
        try {
            exist=obj.exist();
            logger.debug(MARKER,"Try to check if the UiObject is exist.");
        } catch (Throwable throwable) {
            logger.error(MARKER,"Check if the UiObject is exist failed.");
            //throw new Exception(throwable);
        }
        return exist;
    }

    /**
     * <p>Title : 婊氬姩浠ユ壘鍒版煇涓壒瀹氱殑瀛楃锛岀壒鎰忎负鎵撳紑apk鍑嗗鐨勬柟娉�</p>
     * @param text
     * @param virtual true涓哄瀭鐩存柟鍚戯紝false涓烘按骞虫柟鍚�
     * @return
     * @throws Exception
     */
    public boolean scroll_find(String text,boolean virtual) throws Exception{
        boolean find;
        UiSelector scroll_sel=new UiSelector().scrollable(true);
        try {
            find=new UiObject(scroll_sel).scrollTo(new UiSelector().text(text), virtual);
            logger.info(MARKER,"Try to scroll to the text of '"+text+"'");
        }catch (Throwable throwable){
            logger.error(MARKER,"Try to scroll to the text of '"+text+"' failed.");
            throw new Exception(throwable);
        }
        return find;
    }

    public String get_current_pkg()throws Exception{
        String pkg_name=null;
        UiObject view_obj=new UiObject(new UiSelector());
        try {
            pkg_name=view_obj.getPackageName();
            logger.info(MARKER,"Try get packagename of this view :"+pkg_name);
        } catch (Throwable throwable) {
            logger.error(MARKER,"Get package name failed.");
            throw new Exception(throwable);
        }
        return pkg_name;
    }

    public void press_home() throws Exception{
        try {
            boolean a=device.pressHome();
            logger.info(MARKER,"Try to press home(use keycode).");
            if(!a){
                throw new Exception();
            }
        } catch (Throwable throwable) {
            logger.error(MARKER,"Try to press home(use keycode) failed.");
            throw new Exception(throwable);
        }
    }

    public void press_back() throws Exception{
        try {
            boolean a=device.pressBack();
            logger.info(MARKER,"Try to press back(use keycode).");
            if(!a){
                throw new Exception();
            }
        } catch (Throwable throwable) {
            logger.error(MARKER,"Try to press back(use keycode) failed.");
            throw new Exception(throwable);
        }

    }

    public void press_call() throws Exception{
        try {
            boolean a=device.pressCall();
            logger.info(MARKER,"Try to press call(use keycode).");
            if(!a){
                throw new Exception();
            }
        } catch (Throwable throwable) {
            logger.error(MARKER, "Try to press call(use keycode) failed.");
            throw new Exception(throwable);
        }
    }

    public void press_camera() throws  Exception{
        try {
            boolean a=device.pressCamera();
            logger.info(MARKER,"Try to press camera(use keycode).");
            if(!a){
                throw new Exception();
            }
        } catch (Throwable throwable) {
            logger.error(MARKER, "Try to press camera(use keycode) failed.");
            throw new Exception(throwable);
        }
    }

    public void open_notification() throws Exception{
        try {
            boolean a=device.openNotification();
            logger.info(MARKER,"Try to open notification .");
            if(!a){
                throw new Exception();
            }
        } catch (Throwable throwable) {
            logger.info(MARKER, "Try to open notification .");
            throw new Exception(throwable);
        }
    }
    public void wakup() throws Exception{
        try {
            device.wakeUp();
            logger.info(MARKER,"Try to Wake up the phone.");
        } catch (Throwable throwable) {
            logger.error(MARKER, "Wake up the phone failed.");
            throw new Exception(throwable);
        }
    }

    public void click(int x,int y) throws Exception{
        try {
            device.click(x, y);
            logger.info(MARKER,"Try to click @({},{})",x,y);
        } catch (Throwable throwable) {
            logger.error(MARKER, "Click failed.");
        }
    }


    public void swipe(int start_x,int start_y,int end_x,int end_y,int steps) throws Exception{
        try {
            device.swipe(start_x, start_y, end_x, end_y, steps);
            logger.info(MARKER,"Try to swipe.");
        } catch (Throwable throwable) {
            logger.error(MARKER, "Swipe failed.");
            throw new Exception();
        }
    }

    public void drag(int start_x,int start_y,int end_x,int end_y,int steps) throws Exception{
        try {
            device.drag(start_x, start_y, end_x, end_y, steps);
            logger.info(MARKER, "Try to drag.");
        } catch (Throwable throwable) {
            logger.info(MARKER, "Drag failed.");
            throw new Exception();
        }
    }


    public UiObject button_to_uiobject(button btn) {
        UiObject btn_obj = null;
        switch (btn.mSel) {
            case text:
                btn_obj = new UiObject(new UiSelector().text(btn.attribute));
                break;
            case id:
                btn_obj = new UiObject(new UiSelector().resourceIdMatches(btn.attribute));
                break;
            case desc:
                btn_obj = new UiObject(new UiSelector().description(btn.attribute));
                break;
        }
        return btn_obj;
    }
    /**
     * <p>Title : 鐢眀utton浜х敓UiObject</p>
     * <p>Description : 涓巄utton_to_uiobject鐨勪笉鍚屼箣澶勬槸涓嶈姹倀ext鍜宒escription瀹屽叏鍖归厤锛屽彧瑕佸寘鍚煇涓瓧绗︿覆灏卞彲绠楀尮閰嶄笂浜�</p>
     * @param btn
     * @return
     * @throws Exception 
     */
    public UiObject button_contain_to_uiobject(String name) throws Exception{
    	button btn=get_button(name);
        UiObject ctn_obj=null;
        switch (btn.mSel){
            case text:
                ctn_obj=new UiObject(new UiSelector().textContains(btn.attribute));
                break;
            case id:
                ctn_obj=new UiObject(new UiSelector().resourceIdMatches(btn.attribute));
                break;
            case desc:
                ctn_obj=new UiObject(new UiSelector().descriptionContains(btn.attribute));
                break;
        }
        return ctn_obj;
    }
    /**
     * <p>Title : 鐢眀utton浜х敓UiObject</p>
     * <p>Description : 涓巄utton_to_uiobject鐨勪笉鍚屼箣澶勬槸涓嶈姹倀ext鍜宒escription瀹屽叏鍖归厤锛屽彧瑕佸寘鍚煇涓瓧绗︿覆灏卞彲绠楀尮閰嶄笂浜�</p>
     * @param btn
     * @return
     */
    public UiObject button_contain_to_uiobject(button btn){
        UiObject ctn_obj=null;
        switch (btn.mSel){
            case text:
                ctn_obj=new UiObject(new UiSelector().textContains(btn.attribute));
                break;
            case id:
                ctn_obj=new UiObject(new UiSelector().resourceIdMatches(btn.attribute));
                break;
            case desc:
                ctn_obj=new UiObject(new UiSelector().descriptionContains(btn.attribute));
                break;
        }
        return ctn_obj;
    }
    public UiObject classname_to_uiobject(String classname) {
        UiObject cls_obj=new UiObject(new UiSelector().className(classname));
        return cls_obj;
    }

    public void take_screen_shot(String path,String name,float scale,int quality) {
        try {
            //device.takeScreenshotByCompress(path,name,scale,quality);
            device.takeScreenshot(path, name, scale, quality);
        } catch (Throwable throwable) {
            logger.error(MARKER,"!!! Can't take screen shot !!!");
        }
    }
    public void take_screen_shot(String path,String name){

        take_screen_shot(path,name,0.2f,100);
        try {
			clicks("D1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
    
    public String attr2key(String attrbute_in) throws Exception{
    	logger.debug("attribute in is {}",attrbute_in);
        String name_out = null;
        Iterator<Map.Entry<String, button>> iterator = config.get_cfg_iterator();
        while (iterator.hasNext()){
            Map.Entry<String, button> entry = iterator.next();
            String nme=entry.getKey();
            //logger.debug("attr2key : key is - {}",nme);
            String atr=entry.getValue().attribute;
            if(attrbute_in.equals(atr)) {
                logger.info("Find button '{}' has attribute '{}'", nme, atr);
                name_out=nme;
            }
        }
        if(name_out==null){
            logger.error("Search button which has attribute '{}' failed.",attrbute_in);
            throw new Exception();
        }
        return name_out;
    }
    
}
