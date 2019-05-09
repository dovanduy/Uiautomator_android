package Test;

/**
 * Created by qiumin on 2015/8/14.
 */

import Config.Configs;
import Modules.Call;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uiautomatorrpc.UiDevice;
//import uiautomatorrpc.UiObject;
//import uiautomatorrpc.UiSelector;
import uiautomatorrpc.UiObject;
import uiautomatorrpc.UiSelector;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import java.io.File;
import java.io.FileOutputStream;

public class Example {
    private UiDevice device=UiDevice.getInstance();
    
    Logger logger= LogManager.getLogger(Example.class);

    Call base_call=new Call();
    Configs my_cfg=new Configs();
    



    @Before
    public void setUp() throws Throwable {
//        device.pressKeyCode(4);
//        device.pressKeyCode(4);
//        device.pressKeyCode(4);
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void test_run() throws  Throwable{
        //my_cfg.set_default()
        // ;
    	UiObject ls = new UiObject(new UiSelector().text("企业报告"));
    	ls.click();
    	UiObject a = new UiObject(new UiSelector().text("请输入企业名称"));
    	a.setText("zhongchengxin");
//    	device.dumpWindowHierarchy(false,"a.xml");
    	
        //my_cfg.set_default();
        //my_cfg.write_to_file("cfg2.xml");
        //my_cfg.read_from_file("base_phone_cfg.xml");
        //my_cfg.write_to_file("cfg1.xml");
        //base_call.set_cfg(my_cfg.configs[3]);
        //base_call.get_map();
        //base_call.print_cfg();
        //base_call.scroll_find("Phone",false);
        //base_call.click_button("Phone");
        //base_call.clicks("star|D5|pound");
    }
    
    
 

    public void change_cfg() {

    }

    public void xmlToHtml(String xmlFile,String xslFile,String html) {

        try {
            File htmlFile = new File(html);
            htmlFile.createNewFile();
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer(new StreamSource(
                    xslFile));
            // 将xml文件转换成html文件
            transformer.transform(new StreamSource(xmlFile), new StreamResult(new FileOutputStream(htmlFile)));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
