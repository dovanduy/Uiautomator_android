package Config;

/**
 * Created by qiumin on 2015/8/17.
 */
public class Calendar_cfg extends module_config{

    public Calendar_cfg(){
        super();
    }

    @Override
    public void set_default() {
        this.name="Calendar";
        this.pkg="calendar";
        add("new_event" ,new button("New event"   ,method_sel.text,"新建事件按钮"));
        add("today"     ,new button(".+action_today",method_sel.id,"查看今天的日历、日程按钮"));
        add("menu"      ,new button("More"        ,method_sel.text,"菜单键"));
        add("corpus"    ,new button(".+corpus_indicator",method_sel.id,"日程视图选择按钮，点击可选择切换成月历/年历/查看所有日程"));
        add("empty"     ,new button(".+empty"     ,method_sel.id  ,"日程为空的提示控件"));
        add("cancel"    ,new button("Cancel"      ,method_sel.text,"取消键"));
        add("done"      ,new button("Done"        ,method_sel.text,"写完新建完事件后，点击done确认新建，类似save"));
        add("addevent"  ,new button("Add event"   ,method_sel.text,"添加中选择新事件按钮"));
        add("addtask"   ,new button("Add task"    ,method_sel.text,"添加中选择新任务按钮"));
        add("theme"     ,new button("theme"       ,method_sel.text,"事件主题编辑框"));//theme
        add("content"   ,new button("content"     ,method_sel.text,"事件的内容"));
        add("start_date",new button(".+start_date",method_sel.id  ,"事件开始日期"));
        add("start_time",new button(".+start_time",method_sel.id  ,"事件开始时间"));
        add("end_date"  ,new button(".+end_date"  ,method_sel.id  ,"事件终止日期"));
        add("end_time"  ,new button(".+end_time"  ,method_sel.id  ,"事件终止时间"));
        add("reminder"  ,new button(".+reminder.+",method_sel.id  ,"提醒按钮"));
        add("delete"    ,new button("Delete"      ,method_sel.text,"删除键"));
        add("agenda"    ,new button("Agenda"      ,method_sel.text,"日程视图按钮"));
        add("year"      ,new button("Year"        ,method_sel.text,"年历视图"));
        add("month"     ,new button("Month"       ,method_sel.text,"查看月历视图"));
        add("week"      ,new button("Week"        ,method_sel.text,"周历视图"));
        add("day"       ,new button("Day"         ,method_sel.text,"日历视图"));
        add("all_agenda",new button(".+select_checkbox",method_sel.id,"查看所有日程"));
        add("confirm"   ,new button(".+confirm_ok",method_sel.id,"操作确认键，通常是确认删除、拷贝"));
        add("ok"        ,new button("OK"          ,method_sel.text,"OK按钮，确认按钮"));
    }
}
