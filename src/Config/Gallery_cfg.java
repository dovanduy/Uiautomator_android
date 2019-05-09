package Config;

/**
 * Created by qiumin on 2015/8/18.
 */
public class Gallery_cfg extends module_config {
    public Gallery_cfg(){
        super();
    }

    @Override
    public void set_default() {
        this.name="Gallery";
        this.pkg="gallery3d";
        add("albums"    ,new button(".+text1"        ,method_sel.id  ,"照片专辑键"));
        add("multi"     ,new button("Multi-operation",method_sel.text,"多种操作复用的确认键，通常是删除、拷贝之类的，比如选择了两个图片删除，会让你再确认一下"));
        add("menu"      ,new button("More options"   ,method_sel.desc,"菜单键"));
        add("select_all",new button("Select all"     ,method_sel.text,"全选键"));
        add("delete"    ,new button("Delete"         ,method_sel.text,"删除键"));
        add("ok"        ,new button("OK"             ,method_sel.text,"确认键"));
        add("cancel"    ,new button("Cancel"         ,method_sel.text,"取消键"));
    }
}
