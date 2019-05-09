package Config;

/**
 * Created by qiumin on 2015/8/14.
 */
public class Browser_cfg extends  module_config{
    public Browser_cfg(){
        super();
    }
    public void set_default(){
        this.name="Browser";
        this.pkg="browser";
        this.pkg_2="hplayer";
        add("bookmark"  ,new button(".+bookmark.*",method_sel.id,"工具栏中的书签按钮"));
        add("homepage"  ,new button(".+homepage",method_sel.id,"工具栏中的主页按钮"));
        add("forword"   ,new button(".+forword",method_sel.id,"往后面一页的按钮"));
        add("menu"      ,new button(".+more",method_sel.id,"菜单键"));
        add("stop"      ,new button(".+stop",method_sel.id,"加载网页时出现的停止按钮，通常在url输入框附近"));
        add("go"        ,new button(".+go" ,method_sel.id,"在url输入框中输入完地址后，点击该键开始加载输入的网址"));
        add("url"       ,new button(".+url",method_sel.id,"浏览器的网址输入框，当加载完网页后，网址名称也会显示在此框中"));
        add("bookmarks" ,new button("Bookmarks",method_sel.id,"菜单中的书签选项"));
        add("history"   ,new button("History",method_sel.text,"菜单中的历史记录选项"));
        add("exit"      ,new button("Exit",method_sel.text,"菜单列表中的退出选项"));
    }

}
