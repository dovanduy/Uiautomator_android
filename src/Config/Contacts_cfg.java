package Config;

/**
 * Created by qiumin on 2015/8/18.
 */
public class Contacts_cfg extends module_config {
    public Contacts_cfg(){
        super();
    }

    @Override
    public void set_default() {
        this.name="Contacts";
        this.pkg="contacts";
        add("create"     ,new button("Add"               ,method_sel.text,"创建新联系人键"));
        add("search"     ,new button(".+search_text"     ,method_sel.id,"查找输入框"));
        add("delete"     ,new button("Delete"            ,method_sel.text,""));
        add("menu"       ,new button(".+menu_button_more",method_sel.id,"菜单键"));
        //add("select_all" ,new button(".+select_all.*"    ,method_sel.id,"全选键"));
        add("select_all" ,new button("Select all"        ,method_sel.text,""));
        add("btn_done"   ,new button(".+btn_done.*"      ,method_sel.id,""));
        add("call"       ,new button(".+call_icon"       ,method_sel.id,""));
        add("message"    ,new button(".+secondary_action_button",method_sel.id,""));
        add("new_name"   ,new button("Name"              ,method_sel.text,"新建联系人视图中的联系人名称输入框"));
        add("new_phone"  ,new button("Phone"             ,method_sel.text,"新建联系人视图中的手机号输入框"));
        add("new_save"   ,new button("Save"              ,method_sel.text,"新建联系人视图中的保存键"));
        add("ok"         ,new button("OK"                ,method_sel.text,""));
        add("cancel"     ,new button("Cancel"            ,method_sel.text,"取消键"));
        add("no_contacts",new button("No contacts."      ,method_sel.text,"没有任何联系人的提示信息控件"));
        add("create_new_contact",new button(".+create_contact_button",method_sel.id,"没有任何联系人时候的新建联系人按钮"));
        add("up"         ,new button(".+up"              ,method_sel.id,"返回上层，类似back，经常以小于号显示"));
        add("more"       ,new button("More"      ,method_sel.text,""));
    }
}
