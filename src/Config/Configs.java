package Config;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by qiumin on 2015/8/17.
 */
public class Configs {
    public static String device_id;
    public static boolean two_cards;
    String file_name="config_file.xml";
    Browser_cfg      browser_cfg    = new Browser_cfg();
    Calculator_cfg   calculator_cfg = new Calculator_cfg();
    Calendar_cfg     calendar_cfg   = new Calendar_cfg();
    Call_cfg         call_cfg       = new Call_cfg();
    Camera_cfg       camera_cfg     = new Camera_cfg();
    Clock_cfg        clock_cfg      = new Clock_cfg();
    Contacts_cfg     contacts_cfg   = new Contacts_cfg();
    Downloads_cfg    downloads_cfg  = new Downloads_cfg();
    Email_cfg        email_cfg      = new Email_cfg();
    Files_cfg        files_cfg      = new Files_cfg();
    Gallery_cfg      gallery_cfg    = new Gallery_cfg();
    Messaging_cfg    messaging_cfg  = new Messaging_cfg();
    Music_cfg        music_cfg      = new Music_cfg();
    Recorder_cfg     recorder_cfg   = new Recorder_cfg();
    Phone_cfg        phone_cfg      = new Phone_cfg();
    Settings_cfg     settings_cfg   = new Settings_cfg();
    Memo_cfg         memo_cfg       = new Memo_cfg();
    Video_cfg        video_cfg      = new Video_cfg();


    public module_config[] configs =new module_config[18];

    public Configs(){
        configs[0]=phone_cfg;
        configs[1]=browser_cfg;
        configs[2]=calculator_cfg;
        configs[3]=calendar_cfg;
        configs[4]=call_cfg;
        configs[5]=camera_cfg;
        configs[6]=clock_cfg;
        configs[7]=contacts_cfg;
        configs[8]=downloads_cfg;
        configs[9]=email_cfg;
        configs[10]=files_cfg;
        configs[11]=gallery_cfg;
        configs[12]=messaging_cfg;
        configs[13]=music_cfg;
        configs[14]=recorder_cfg;
        configs[15]=settings_cfg;
        configs[16]=memo_cfg;
        configs[17]=video_cfg;
    }


    /**
     * <Title>从xml文件中读取config，并替换内部原有的config数据</Title>
      * @param file_name
     */
    public void read_from_file(String file_name) throws  Exception{
        System.out.println("Read file : "+file_name);

        SAXReader reader = new SAXReader();
        Document document= reader.read(new File(file_name));
        Element root=document.getRootElement();
        for(module_config cfg:configs){
            cfg.clear_config();
            System.out.println("module element of "+cfg.getClass().getSimpleName());
            Element module_elm =root.element(cfg.getClass().getSimpleName());
            cfg.name=module_elm.attributeValue("name");
            cfg.pkg =module_elm.attributeValue("package");
            cfg.pkg_2=module_elm.attributeValue("pkg_2");
            Iterator<?> iterator=module_elm.elementIterator();
            while(iterator.hasNext()){
                Element cfg_elm= (Element) iterator.next();
                String cfg_name= cfg_elm.attributeValue("name");
                String path=cfg_elm.getPath()+"/comment()";
                Node bbb=cfg_elm.node(1);
                String comm;
                if(bbb.getNodeTypeName().equals("Comment")){

                    comm = bbb.getStringValue();
                }else {
                    comm="";
                }

                String attri=cfg_elm.element("Attribute").getText();
                String msel =cfg_elm.element("Method_sel").getText();
                //System.out.println("name : "+cfg_name+" attr : "+attri+" sel :"+msel);
                cfg.add(cfg_name ,new button(attri, module_config.method_sel.valueOf(msel),comm));
            }

        }


    }

    /**
     * <p>将config配置写到xml文件中</p>
     * @param file_name
     */
    public void write_to_file(String file_name) throws  Exception{
        Document document= DocumentHelper.createDocument();
        Element root_elem =document.addElement("root");//root
        for (module_config cfg:configs) {
            //Element module_elem = root_elem.addElement(cfg.name);
            Element module_elem = root_elem.addElement(cfg.getClass().getSimpleName());
            module_elem.addAttribute("name",cfg.name);
            module_elem.addAttribute("package",cfg.pkg);
            module_elem.addComment("This is buttons config in "+cfg.name);
            Iterator<Map.Entry<String, button>> iterator = cfg.get_cfg_iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, button> entry = iterator.next();
                String key_t = String.valueOf(entry.getKey());
                button val_t = entry.getValue();
                //Element button_elm=module_elem.addElement(key_t);
                Element button_elm=module_elem.addElement("Widget");
                button_elm.addAttribute("name",key_t);
                button_elm.addComment(val_t.comment);
                button_elm.addElement("Attribute").addText(val_t.attribute);
                button_elm.addElement("Method_sel").addText(String.valueOf(val_t.mSel));
            }
        }

        OutputFormat outputFormat=OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");
        outputFormat.setIndent(true);
        outputFormat.setNewlines(true);
        XMLWriter writer=new XMLWriter(new FileWriter(new File(file_name)),outputFormat);

        writer.write(document);
        writer.close();

    }

    public void set_default(){
        for(module_config cfg:configs){
            cfg.set_default();
        }
    }
    public void print_config(){
        for(module_config cfg:configs){
            cfg.print_cfg();
        }
    }
}
