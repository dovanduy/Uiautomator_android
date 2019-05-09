package testcases;

import Phone.base_phone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

/**
 * Created by qiumin on 2015/8/31.
 */
public class base_testcase {
    public static int run_count = 0;
    public static int err_count = 0;
    public static int ext_loop_cycle = 0;
    public String function_name;
    boolean screen_shot;
    boolean result;
    private final Marker MARKER= MarkerManager.getMarker("BASE_CASE");

    public Logger logger = LogManager.getLogger(this.getClass());


    base_phone my_phone;
    String case_name;
    String phone_name;

    public static void cycle_add() {
        ext_loop_cycle++;
    }

    public boolean process() {
        result=false;
        build();
        run();
        logger.debug(MARKER,"After run result is {}",result);
        report();
        logger.debug(MARKER,"After report result is {}",result);
        ending();
        logger.debug(MARKER,"After ending result is {}",result);
        return result;
    }

    public base_testcase(base_phone phone_in) {
        case_name = this.getClass().getSimpleName();
        my_phone  = phone_in; 
        phone_name= my_phone.getClass().getSimpleName();
        screen_shot = false;
    }

    public void run() {
        try {
            pre_run();
            during_run();
            post_run();
            result=true;
            logger.debug(MARKER,"in run_try : result is {}",result);
        }catch (Exception e){
            logger.info(MARKER,"This is run error.");
            catch_body();
            logger.info(MARKER,e.getMessage(),e);
        }
        
    }

    public void build() {
        try {
            pre_build();
            during_build();
            post_build();
        }catch (Exception e){
            logger.info(MARKER, "This is build error.");
        }

    }

    public void report() {
        try {
            pre_report();
            during_report();
            post_report();
        }catch (Exception e){
            logger.info(MARKER, "This is report error.");
        }
    }

    public void ending() {
        try{
            pre_ending();
            during_ending();
            post_ending();
        }
        catch (Exception e){
            logger.info(MARKER,"This is ending error.");
        }
    }


    public void pre_build() throws Exception {
    }
    public void during_build() throws Exception {
    }
    public void post_build() throws Exception {
    }

    public void pre_run() throws Exception{
        logger.info(MARKER,"Enter Testcase : "+case_name);
        my_phone.clicks("WAKE|D1");
        logger.info(MARKER, "The Phone is {}", my_phone.getClass().getSimpleName());
    }
    public void during_run() throws Exception {
    }
    public void post_run() throws Exception {
    }

    public void pre_report() throws Exception {
    }
    public void during_report() throws Exception {
        write_xml_after_testcase_finish(result);
    }
    public void post_report() throws Exception {
    }

    public void pre_ending() throws Exception{
    }
    public void during_ending() throws Exception{
    }
    public void post_ending() throws Exception{
        logger.info(MARKER, "Let phone back to home view.");
        my_phone.clicks("D2|BACK|D1|BACK|D1|BACK|D1|BACK|D1|BACK|D1|BACK|D1");
        String pkg_name=my_phone.get_current_pkg();
        if(pkg_name.contains("launcher")){
        	my_phone.clicks("HOME");
        }else {
			logger.info(MARKER,"ERROR: press BACK cannot exit.");
			throw new Exception();
		}
    }





    public void xml_process(String filename,int run_count,String case_name,String phone_name,boolean result) throws Exception {
        SAXReader saxReader=new SAXReader();
        Document document;
        Element root;
        XMLWriter writer;
        try {
            document=saxReader.read(new File(filename));
            root=document.getRootElement();
        } catch (DocumentException e) {
            logger.info(MARKER,"{} : file '{}' is not exist, create it.",case_name,filename);
            document= DocumentHelper.createDocument();
            root=document.addElement("TestCaseDetail");
        }
        Element ts=root.addElement("TestCase");
        ts.addElement("NO").setText(String.valueOf(run_count));
        ts.addElement("Result").setText(String.valueOf(result));
        String snapshot_text=screen_shot?"../"+ext_loop_cycle+"/"+case_name+"_"+run_count+".png":"NONE";

        ts.addElement("SnapShot").setText(snapshot_text);
        ts.addElement("Log").setText("../"+ext_loop_cycle+"/"+case_name+"_"+run_count+".log");
        screen_shot=false;
        try {
            writer=new XMLWriter(new FileWriter(new File(filename)));
            writer.write(document);
            writer.close();
        } catch (Exception ex) {
            logger.error(MARKER,"Can't write to xml file.");
            throw new Exception(ex);
        }
    }

    public void xmlToHtml(){
        String xmldir ="./log/"+phone_name+"/xml/";
        String htmldir="./log/"+phone_name+"/html/";
        String xmlFile=xmldir+case_name+"_cycle_"+ext_loop_cycle+".xml";
        String xslFile="./src/utils/Detail.xsl";
        String html   =htmldir+case_name+"_cycle_"+ext_loop_cycle+".html";

        File html_dir=new File(htmldir);
        if(!html_dir.exists()){
            html_dir.mkdir();
        }
        try {
            File htmlFile = new File(html);
            htmlFile.createNewFile();
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer(new StreamSource(xslFile));
            // 将xml文件转换成html文件
            transformer.transform(new StreamSource(xmlFile), new StreamResult(new FileOutputStream(htmlFile)));
        } catch (Exception e) {
            logger.error(MARKER,e.getMessage(), e);
        }
    }

    public void write_xml_after_testcase_finish(boolean result) {
        String xmldir="./log/"+phone_name+"/xml/";
        File xml_dir=new File(xmldir);
        if(!xml_dir.exists()){
            xml_dir.mkdir();
        }
        try {
            xml_process(xmldir+case_name+"_cycle_"+ext_loop_cycle+".xml", run_count, case_name, phone_name, result);
        } catch (Exception e) {
            // DONE Auto-generated catch block
            logger.error(MARKER, "testcase : process detail xml file error.");
        }
        logger.debug(MARKER,"run_count ={}",run_count);

        run_count += 1;
    }

    public void catch_body(){
        err_count++;       
        logger.info(MARKER,"Screenshot-->./{}/{}/{}_{}.png",phone_name,ext_loop_cycle,case_name,String.valueOf(run_count));
        screen_shot=true;
        result=false;
        String screenshot=case_name+"_"+String.valueOf(run_count)+".png";
        String snapshot_path="./log/"+phone_name+"/"+ext_loop_cycle+"/";
        my_phone.take_screen_shot(snapshot_path,screenshot);
        logger.info(MARKER,"Screenshot saved.");
        try {
			my_phone.clicks("BACK|D1|BACK|D1|BACK|D1|BACK|D1|HOME");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    //added for baiduyun
    public void upload_music() throws Exception{
     
    }
    public void download_music() throws Exception{
    	
    }
}

