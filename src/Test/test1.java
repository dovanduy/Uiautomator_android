package Test;

import Config.Configs; 
import Phone.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uiautomatorrpc.JsonRpcService;
import uiautomatorrpc.UiDevice;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by qiumin on 2015/9/2.
 */
public class test1 {
    Logger logger= LogManager.getLogger(this.getClass().getName());
    LoggerContext ctx=(LoggerContext) LogManager.getContext(false);
    Configs all_config =new Configs();

    HashMap<String,Integer> testcase_times  =new HashMap<String,Integer>();
    HashMap<String,Boolean> testcase_result =new HashMap<String,Boolean>();//for one loop
    HashMap<String,Boolean> testcase_results=new HashMap<String,Boolean>();
    ArrayList<String> case_list =new ArrayList<String>();

    base_phone test_phone=new Phone_Vivo();

    String phone_name=test_phone.getClass().getSimpleName();
    String file_name =phone_name.concat("_summary.xml");
    Document document= DocumentHelper.createDocument();
    Element summaryElement=document.addElement("TestCaseSummary");


    @Before
    public void setUp() throws Exception{
        String config_file_name=phone_name.concat("_cfg.xml");
        all_config.read_from_file(config_file_name);
        test_phone.get_config(all_config);
        UiDevice.setDeviceName(test_phone.get_deviceid());
        
    	DateFormat df1=new SimpleDateFormat("yyyy_MM_dd_HH_mm");
    	Date date=new Date();
        File log_dir=new File("log\\"+phone_name);
        if(log_dir.exists()){
        	logger.info("******** 新建log文件 ********"); 	
        	String new_dir="log\\"+phone_name+"_"+df1.format(date);
        	logger.info("new dir name is : {}",new_dir);
        	log_dir.renameTo(new File(new_dir));
        }
    }

    @After
    public void tearDown() throws Exception{

    }

    public String[] set_cases() throws Exception{
        String[] cases=null;

        cases=add_testcase(cases,"case08_login"                   ,1);
//        cases=add_testcase(cases,"case01_download"              ,1);
//        cases=add_testcase(cases,"case02_company_report"        ,1);
//        cases=add_testcase(cases,"case03_person_report"         ,1);
//        cases=add_testcase(cases,"case04_dishonest"             ,1);
//        cases=add_testcase(cases,"case05_enforce"               ,1);
//        cases=add_testcase(cases,"case06_creditcardbanner"      ,1);
//        cases=add_testcase(cases,"case07_creditcardtop5"          ,1);
//        cases=add_testcase(cases,"MTBF_case07_email1"           ,1);
//        cases=add_testcase(cases,"MTBF_case08_email2"           ,1);
//        cases=add_testcase(cases,"MTBF_case09_email3"           ,1);
//        cases=add_testcase(cases,"MTBF_case10_email4"           ,1);
//        cases=add_testcase(cases,"MTBF_case11_browser1"         ,1);
//        cases=add_testcase(cases,"MTBF_case12_browser2"         ,1);
//        cases=add_testcase(cases,"MTBF_case13_browser3"         ,1);
//        cases=add_testcase(cases,"MTBF_case14_browser4"         ,1);
//        cases=add_testcase(cases,"MTBF_case15_browser5"         ,1);
//        cases=add_testcase(cases,"MTBF_case16_browser6"         ,1);
//        cases=add_testcase(cases,"MTBF_case17_browser7"         ,1);
//        cases=add_testcase(cases,"MTBF_case18_calendar"         ,1);
//        cases=add_testcase(cases,"MTBF_case19_clock"            ,1);

        
        return  cases;
    }

    public String[] add_testcase(String[] run_list,String testcase_in,int times){
        String [] arr_add=new String[times];
        String [] com_array;
        case_list.add(testcase_in);
        Arrays.fill(arr_add, testcase_in);
        if(run_list != null){
            com_array=new String[run_list.length+arr_add.length];
            System.arraycopy(run_list, 0, com_array, 0, run_list.length);
            System.arraycopy(arr_add, 0, com_array, run_list.length, arr_add.length);
        }else{
            com_array=arr_add;
        }
        testcase_times.put(testcase_in, times);

        return com_array;
    }

    @Test
    public void run() throws Exception{

        logger.info("Phone is {}", phone_name);
        Boolean result=false;
        String[] testcases=set_cases();
        testcases=out_of_order(false,testcases);

        for(int j=0;j<1;j++){
            Method method=null;
            for(String b:testcases){
                String log_file = "log/"+phone_name+"/"+j+"/"+b;
                Class<?> cls    = Class.forName("testcases."+b);
                Field run_cnt=cls.getField("run_count");
                Field cse_cnt=cls.getField("case_count");
                log_file=log_file.concat("_"+run_cnt.get(null).toString());
                System.setProperty("filename", log_file);
                ctx.reconfigure();

                Constructor<?>[] cons=cls.getConstructors();
                Constructor<?> defCon=cons[0];

                Object obj=defCon.newInstance(test_phone);

                method=obj.getClass().getMethod("process");
                result=(Boolean)method.invoke(obj);
                Boolean value=testcase_result.get(b);
                logger.debug("Result is {},original result is {} ",result,value);
                if(value != null){
                    value &= result;
                }else {
                    value =  result;
                }
                testcase_result.put(b,value);
                int set_times=testcase_times.get(b);
                int cse_times=Integer.parseInt(cse_cnt.get(null).toString());
                logger.info("TestCase : '{}' is {}!",b,result?"SUCCESS":"FAILED");
                logger.info("TEST_TOP : {} set_times is {} case_times is {}",b,set_times,cse_times);
                if((cse_times%set_times)==0){
                	logger.info("TEST_TOP : case '{}' all finished. now gen html file.",b);
                    Method HTML_m=obj.getClass().getMethod("xmlToHtml");
                    HTML_m.invoke(obj);
                }
                method=obj.getClass().getMethod("cycle_add");
            }//for each testcase(b)
            xmlfile_write(j);
            method.invoke(null);
            testcase_result.clear();
        }//j


    }//test_name_run

    public void write_summary_xml(int j) {
        summaryElement.addComment("This is a summary report of all testcases.");
        //Iterator<Map.Entry<String, Integer>> iterator = testcase_times.entrySet().iterator();
//        while(iterator.hasNext()){
//            Map.Entry<String, Integer> entry=iterator.next();
//            String  key_t=String.valueOf(entry.getKey());
//            String  val_t=String.valueOf(entry.getValue());
//            Boolean rst_t=testcase_result.get(key_t);
//            logger.debug("result of testcase {} is {}",key_t,rst_t);
//            String rst_tString=null;
//            if(rst_t){
//                rst_tString="Passed";
//            }else{
//                rst_tString="Failed";
//            }
//            Element testcaseElement =summaryElement.addElement("TestCase");
//            testcaseElement.addElement("Name").addText(key_t);
//            testcaseElement.addElement("Cycle").addText(val_t);
//            testcaseElement.addElement("Result").addText(rst_tString);
//            testcaseElement.addElement("Detail").addText("./html/"+key_t+"_cycle_"+j+".html");
//
//        }
        for(String key :case_list){
        	String  val= String.valueOf(testcase_times.get(key));
        	Boolean rst= testcase_result.get(key);
        	logger.debug("result of testcase {} is {}",key,rst);
        	String rst_tString=null;
        	if(rst){
        		rst_tString="Passed";
        	}else{
        	    rst_tString="Failed";
        	}
        	Element testcaseElement =summaryElement.addElement("TestCase");
        	testcaseElement.addElement("Name").addText(key);
        	testcaseElement.addElement("Cycle").addText(val);
        	testcaseElement.addElement("Result").addText(rst_tString);
        	testcaseElement.addElement("Detail").addText("./html/"+key+"_cycle_"+j+".html");
        }

        try{
            File xml_dir=new File("log/"+phone_name+"/xml/");
            if(!xml_dir.exists()){
                xml_dir.mkdir();
            }
            XMLWriter writer = new XMLWriter(new FileWriter(new File("log/"+phone_name+"/xml/"+j+"_summary.xml")));
            writer.write(document);
            writer.close();
            summaryElement.clearContent();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void xmlToHtml(String xmlFile,String xslFile,String html) {

        try {
            File htmlFile = new File(html);
            htmlFile.createNewFile();
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer(new StreamSource(xslFile));
            transformer.transform(new StreamSource(xmlFile), new StreamResult(new FileOutputStream(htmlFile)));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public void xmlfile_write(int j) throws Exception{
        write_summary_xml(j);
        xmlToHtml("./log/" + phone_name + "/xml/" + j + "_summary.xml", "./src/utils/summary.xsl", "./log/" +
                phone_name + "/" + j + "_summary.html");
    }

    public String[] out_of_order(boolean rand,String[] arr){
        String[] arr2=new String[arr.length];
        if(rand) {
            int count = arr.length;
        	logger.info("%%%% Use random length is {}",count);
            int cbRandCount = 0;
            int cbPosition = 0;
            int k = 0;
            do {
                Random random = new Random();
                int r = count - cbRandCount;
                cbPosition = random.nextInt(r);
                arr2[k++] = arr[cbPosition];
                cbRandCount++;
                arr[cbPosition] = arr[r - 1];
            } while (cbRandCount < count);
        }else{
            arr2=arr;
        }
        return arr2;        
    }
    
    public String[] randomize(String[] arr){
    
    	String [] arr2 = new String[arr.length];
    	int count= arr.length;
    	int cbRandCount=0;
    	int cbPosition=0;
    	int k=0;
    	do{
    		Random rand=new Random();
    		int r=count-cbRandCount;
    		cbPosition=rand.nextInt(r);
    		arr2[k++]=arr[cbPosition];
    		cbRandCount++;
    		arr[cbPosition]=arr[r-1];
    	}while(cbRandCount<count);
    	return arr2;
    }

}
