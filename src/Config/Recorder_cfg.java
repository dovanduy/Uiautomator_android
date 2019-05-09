package Config;

/**
 * Created by qiumin on 2015/8/18.
 */
public class Recorder_cfg extends module_config{
    public Recorder_cfg(){
        super();
    }

    @Override
    public void set_default() {
        this.name="Recorder";
        this.pkg="soundrecorder";
        add("menu"        ,new button("More options"   ,method_sel.desc,"更多操作，类似menu，三个点"));
        add("amr"         ,new button("AMR"            ,method_sel.text,"选择AMR作为保存录音的格式"));
        add("gp3"         ,new button("3GP"            ,method_sel.text,"选择3GP作为保存录音的格式"));
        add("phone_store" ,new button("Phone storage"  ,method_sel.text,"录音保存在手机内存中"));
        add("sd_card"     ,new button("SD card"        ,method_sel.text,"录音保存在SD卡中"));
        add("mem_location",new button("Memory location",method_sel.text,"选择存储位置按钮"));
        add("file_type"   ,new button("File type"      ,method_sel.text,"选择储存文件类型按钮"));
        add("start_pause" ,new button(".+recordButton" ,method_sel.id  ,"开始/停止录音键"));
        add("save"        ,new button(".+stopButton"   ,method_sel.id  ,"保存按钮"));
        add("list"        ,new button(".+listButton"   ,method_sel.id  ,"录音文件列表按钮"));
        add("delete"      ,new button("Delete"         ,method_sel.text,"删除按钮"));
        add("multi"       ,new button(".+deleteButton" ,method_sel.id  ,"确认操作多个按钮"));
        add("more"        ,new button(".+recordButton" ,method_sel.id  ,"List界面中的more，也是三个点"));
        add("select_all"  ,new button(".+toggler"      ,method_sel.id  ,"全选键"));
        add("cancel"      ,new button("Cancel"         ,method_sel.text,"取消键"));
        add("ok"          ,new button("OK"             ,method_sel.text,"确认键"));
        add("up"          ,new button(".+up"           ,method_sel.id  ,"返回上层，类似back"));
        add("record_data" ,new button(".+duration"     ,method_sel.id  ,"录音文件的控件"));
        add("no_records"  ,new button("No records"     ,method_sel.text,"List界面中没有任何录音文件的提示控件"));
        add("record_item" ,new button(".+title"        ,method_sel.id  ,"返回上层，类似back"));
             
    }
}
