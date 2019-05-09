package Config;

/**
 * Created by qiumin on 2015/8/18.
 */
public class Downloads_cfg extends module_config {

    String videoplayer_pkg;

    public Downloads_cfg(){
        super();
    }

    @Override
    public void set_default() {
        this.name="Downloads";
        this.pkg="documentsui";
        this.videoplayer_pkg="hplayer";
        add("sort_by"    ,new button(".+menu_sort"  ,method_sel.id  ,"排列规则"));
        add("more_opt"   ,new button("More options" ,method_sel.desc,"更多操作，类似more"));
        add("view_sel"   ,new button(".+title"      ,method_sel.id  ,""));
        add("retry"      ,new button("Retry"        ,method_sel.text,"重试按钮"));
        add("delete"     ,new button("Delete"       ,method_sel.text,"删除键"));
        add("no_items"   ,new button("No items"     ,method_sel.text,"没有任何下载内容的提示信息控件"));
        add("downloading",new button("In progress"  ,method_sel.text,"正在下载中的提示信息控件"));
        add("fail"       ,new button("Unsuccessful" ,method_sel.text,"下载不成功提示信息控件"));
        add("item"       ,new button(".+title"      ,method_sel.id  ,"下载列表中每个下载项就是一个item"));
    }
}
