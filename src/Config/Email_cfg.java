package Config;

/**
 * Created by qiumin on 2015/8/18.
 */
public class Email_cfg extends module_config{
    public Email_cfg(){
        super();
    }

    @Override
    public void   set_default() {
        this.name="Email";
        this.pkg="email";
        add("compose"    ,new button(".+compose"       ,method_sel.id  ,"写新邮件按钮"));
        add("more"       ,new button("More"            ,method_sel.text,""));
        add("refresh"    ,new button(".+refresh"       ,method_sel.id  ,"刷新按钮"));
        add("inbox"      ,new button("Inbox"           ,method_sel.text,"邮箱列表中的收件箱"));
        add("outbox"     ,new button("Outbox"          ,method_sel.text,"邮箱列表中的发件箱"));
        add("drafts"     ,new button("Drafts"          ,method_sel.text,"邮箱列表中的草稿箱"));
        add("sent"       ,new button("Sent"            ,method_sel.text,"邮箱列表中的已发邮件邮箱"));
        add("trash"      ,new button("Trash"           ,method_sel.text,"邮箱列表中的垃圾箱"));
        add("email_home" ,new button(".+home"          ,method_sel.id  ,"Email的主菜单键，点击会拉出邮箱列表"));
        add("send"       ,new button(".+send"          ,method_sel.id  ,"发送按钮"));
        add("address"    ,new button(".+to"            ,method_sel.id  ,"写新邮件视图中的收件人输入框"));
        add("subject"    ,new button(".+subject"       ,method_sel.id  ,"Emei的主题输入框"));
        add("body"       ,new button(".+body_text"     ,method_sel.id  ,"Email的内容输入框"));
        add("picker"     ,new button(".+to_recipients_picker",method_sel.id,""));
        add("attach"     ,new button("Attach file"     ,method_sel.text,"写新邮件视图中添加附件按钮，通常以曲别针形式显示"));
        add("to_draft"   ,new button("Save draft"      ,method_sel.text,""));
        add("picture"    ,new button("Pictures"        ,method_sel.text,"选择已有图片作为附件"));
        add("take_pic"   ,new button("Take Pictures"   ,method_sel.text,"选择现拍照片作为附件"));
        add("video"      ,new button("Videos"          ,method_sel.text,"选择已有视频作为附件"));
        add("take_vdo"   ,new button("Take Video"      ,method_sel.text,"选择现拍视频作为附件"));
        add("audio"      ,new button("Audios"          ,method_sel.text,"选择已有音频作为附件"));
        add("take_aud"   ,new button("Take Audio"      ,method_sel.text,"选择现在录音作为附件"));
        add("selected"   ,new button("Operate selected",method_sel.text,""));
        add("select_all" ,new button(".+select_all"    ,method_sel.id  ,"全选键"));
        add("up"         ,new button(".+up"            ,method_sel.id  ,"返回上层，类似back，通常以小于号的样子出现"));
        add("spinner"    ,new button(".+spinner_count" ,method_sel.id  ,"邮箱视图中显示新邮件数目的控件"));
        add("ok"         ,new button("OK"              ,method_sel.text,"确认键"));
        add("cancel"     ,new button("Cancel"          ,method_sel.text,"取消键"));
        add("delete"     ,new button("Delete"          ,method_sel.text,"删除键"));
        add("no_message" ,new button(".+empty_text"    ,method_sel.id  ,"邮箱中没有任何邮件的提示控件"));
        add("loading"    ,new button("Loading…"        ,method_sel.text,"邮箱界面正在加载邮件的提示控件"));
        add("empty_trash",new button(".+empty_trash"   ,method_sel.id  ,"垃圾箱为空的提示控件"));
        add("discard"    ,new button(".+discard.*"     ,method_sel.id  ,"抛弃当前所写邮件或草稿邮件的按钮"));
        add("edit"       ,new button(".+edit_draft"    ,method_sel.id  ,"编辑草稿邮件按钮"));
        add("clear"      ,new button("Clear"           ,method_sel.text,"清除所有键"));
    }
}
