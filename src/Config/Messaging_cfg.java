package Config;

/**
 * Created by qiumin on 2015/8/18.
 */
public class Messaging_cfg extends module_config {
    public Messaging_cfg(){
        super();
    }

    @Override
    public void set_default() {
        this.name="Messaging";
        this.pkg="mms";
        add("search"     ,new button(".+search.*",method_sel.id  ,""));
        add("create"     ,new button(".+new"     ,method_sel.id  ,"写新短信按钮"));
        add("more"       ,new button("More"      ,method_sel.text,"more键，类似menu"));
        add("delete"     ,new button("Delete"    ,method_sel.text,"删除键"));
        add("card1"      ,new button("Card1"     ,method_sel.text,"选择卡1发送"));
        add("card2"      ,new button("Card2"     ,method_sel.text,"选择卡2发送"));
        add("select_all" ,new button("All"       ,method_sel.text,"全选键"));
        add("ok"         ,new button("OK"        ,method_sel.text,"确认键"));
        add("cancel"     ,new button("Cancel"    ,method_sel.text,"取消键"));
        add("del_x"      ,new button(".+delete_button.*"  ,method_sel.id,"确认删除多个的按钮"));
        add("up"         ,new button(".+up"      ,method_sel.id  ,"返回键，类似back"));
        add("menu"       ,new button("More options"       ,method_sel.desc,"菜单键"));
        add("receiver"   ,new button(".+recipients_editor",method_sel.id,"写短信界面的收件人编辑框"));
        add("reci_picker",new button(".+recipients_picker",method_sel.id,""));
        add("message"    ,new button(".+frame_text_bottom",method_sel.id,"写短信界面中的短信内容输入框"));
        add("attach"     ,new button(".+attach_button"    ,method_sel.id,"写短信界面添加附件按钮，通常是曲别针的样子"));
        add("picture"    ,new button("Pictures"  ,method_sel.text,"选择已有图片作为附件"));
        add("subject"    ,new button("Subject"   ,method_sel.text,"给mms添加主题附件"));
        add("video"      ,new button("Videos"    ,method_sel.text,"选择已有视频作为附件"));
        add("audio"      ,new button("Audio"     ,method_sel.text,"选择已有音频作为附件"));
        add("take_pic"   ,new button("Capture picture"    ,method_sel.text,"选择现拍图片作为附件"));
        add("take_vdo"   ,new button("Capture video"      ,method_sel.text,"选择现拍视频作为附件"));
        add("take_aud"   ,new button("Record audio"       ,method_sel.text,"选择现录音频作为附件"));
        add("contact"    ,new button("Contact"            ,method_sel.text,""));
        add("send"       ,new button(".+send_button.*"    ,method_sel.id  ,"发送键"));
        add("sch_editor" ,new button(".+search_src_text"  ,method_sel.id  ,""));
        add("fail"       ,new button(".+failed.+",method_sel.id  ,"短信发送失败的提示控件"));
        add("sending"    ,new button("SENDING…"  ,method_sel.text,"表明短信正在发送中的提示控件"));
        add("has_draft"  ,new button("[Draft]"   ,method_sel.text,"短信列表中的表明是草稿的控件"));
        add("msg_subj"   ,new button(".+subject" ,method_sel.id  ,""));
        add("no_convst"  ,new button("No conversations."  ,method_sel.text,"当前界面没有任何短信的提示控件"));
        add("multi"      ,new button(".+ok_button"        ,method_sel.id  ,"多种操作的确认键，比如删除、拷贝、分享"));
        add("save"       ,new button(".+okayButton"       ,method_sel.id  ,"保存键"));
        add("sys_audio"  ,new button("System audio"       ,method_sel.text,"选择系统音频文件作为附件"));
        add("ext_audio"  ,new button("External audio"     ,method_sel.text,"选择外部音频文件作为附件"));
        add("clear"      ,new button("Delete all threads" ,method_sel.text,"清除键，删除所有，毋需再全选删除"));
        add("from"       ,new button(".+from"    ,method_sel.id,""));
        add("edit"       ,new button(".+edit_slideshow_button",method_sel.id,"编辑幻灯片键"));
        add("done"       ,new button(".+done_button"      ,method_sel.id,""));
        add("slide"      ,new button(".+slide_number_text",method_sel.id,""));

    }
}
