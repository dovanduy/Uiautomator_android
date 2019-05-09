package Config;

/**
 * Created by qiumin on 2015/8/18.
 */
public class Files_cfg extends module_config {
    public Files_cfg(){
        super();
    }

    @Override
    public void set_default() {
        this.name="My Files";
        this.pkg="FileManager";
        add("no_files"   ,new button("No files"      ,method_sel.text,"当前文件夹中没有任何文件的提示控件"));
        add("ok"         ,new button("OK"            ,method_sel.text,"确认键"));
        add("delete"     ,new button("Delete"        ,method_sel.text,"删除键"));
        add("operations" ,new button(".+Button_Operation.*",method_sel.id,"确认多个对象的操作按钮，比如删除、拷贝时"));
        add("phe_store"  ,new button("Phone storage" ,method_sel.text,"手机存储界面"));
        add("sd_store"   ,new button("SD CARD"       ,method_sel.text,"SD卡存储界面"));
        add("create"     ,new button("New"           ,method_sel.text,"新建键"));
        add("create_name",new button(".+EditText_PROM.*",method_sel.id,"新建文件夹名称的编辑框"));
        add("f_class"    ,new button("android.widget.LinearLayout",method_sel.text,"文件夹中文件列表，表示每个文件(夹)的控件的class"));
        add("menu"       ,new button(".+optionmenu_button.*",method_sel.id,"菜单键"));
        add("cancel"     ,new button("Cancel"        ,method_sel.text,"取消键"));
        add("copy"       ,new button("Copy"          ,method_sel.text,"拷贝键"));
        add("up"         ,new button(".+UpToParent.*",method_sel.id  ,"返回上层，类似back"));
        add("search"     ,new button(".+search_button.*",method_sel.id,"查找键"));
        add("select_all" ,new button("All"           ,method_sel.id  ,"全选键"));
        add("show_root"  ,new button("Show roots"    ,method_sel.text,"从其他APK进入文件管理器中时的界面的HOME键，类似Email中的email_home"));
    }
}
