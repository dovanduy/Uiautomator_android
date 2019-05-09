package Config;

/**
 * Created by qiumin on 2015/8/18.
 */
public class Clock_cfg extends module_config{
    public Clock_cfg(){
        super();
    }

    @Override
    public void set_default() {
        this.name="Clock";
        this.pkg="clock";
        add("alarm"       ,new button("ALARMS"         ,method_sel.text,"闹钟视图"));
        add("more"        ,new button("more"           ,method_sel.text,"more按钮，类似menu的三个点"));
        add("add_alarm"   ,new button("Add alarm"      ,method_sel.text,"增加一个新闹钟按钮"));
        add("delete"      ,new button("Delete"         ,method_sel.text,"删除键"));
        add("no_alarm"    ,new button("No alarms"      ,method_sel.text,"没任何闹钟时的提示信息"));
        add("save"        ,new button("Save"           ,method_sel.text,"保存键"));
        add("select_all"  ,new button(".+select_all.*" ,method_sel.id  ,"全选键"));
        add("multi_del"   ,new button(".+Button_del.*" ,method_sel.id  ,"操作多个的确认键"));
        add("new_alarm_id",new button(".+digital_clock",method_sel.id  ,"显示在闹钟界面的每个闹钟控件"));
        add("ok"          ,new button("OK"             ,method_sel.text,"确认键"));
        add("cancel"      ,new button("Cancel"         ,method_sel.text,"取消键"));
        add("repeat"      ,new button("Repeat"         ,method_sel.text,"闹钟属性中的重复选项"));
    }
}
