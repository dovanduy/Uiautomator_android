package Config;

/**
 * Created by qiumin on 2015/8/14.
 */
public class Call_cfg extends module_config{
    public Call_cfg(){
        super();
    }
    public void set_default(){
        this.name="Phone";
        this.pkg="contact";
        add("Phone"   ,new button("Phone"            ,method_sel.text,"拨号盘的APK名称"));
        add("star"    ,new button(".+star"           ,method_sel.id  ,"星号键"));
        add("number"  ,new button("zero|one|two|three|four|five|six|seven|eight|nine|",method_sel.desc,"数字键盘的配置，所有10个数字都在这里，以|来分割"));
        add("phone_num",new button("10086"           ,method_sel.text,"需要拨打出去的电话号码，通常只需要attribute属性，不需要method_sel"));
        add("pound"   ,new button(".+pound"          ,method_sel.id  ,"井号键"));
        add("dial"    ,new button(".+dialButton.*"   ,method_sel.id  ,"拨号键"));
        add("dailpad" ,new button(".+dialPad"        ,method_sel.id  ,"拨号盘键"));
        add("enddial" ,new button(".+end_call.*"     ,method_sel.id  ,"挂电话键"));
        add("delete"  ,new button(".+deleteButton"   ,method_sel.id  ,"删除键"));
        add("menu"    ,new button(".+menuButton"     ,method_sel.id  ,"菜单键"));
        add("record"  ,new button(".+recordButton.*" ,method_sel.id  ,"通话录音键"));
        add("elaptime",new button(".+elapsedTime"    ,method_sel.id  ,"通话时间控件"));
        add("hangup"  ,new button("Hang up"          ,method_sel.text,"通知栏中的挂电话键"));
        add("dialing" ,new button("Dialing"          ,method_sel.text,"通知栏中显示正在拨号中的控件"));
        add("ongoing" ,new button("Ongoing call"     ,method_sel.text,"通知栏中显示正在通话中的控件"));
    }
}