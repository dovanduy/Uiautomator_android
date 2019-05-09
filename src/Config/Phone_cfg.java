package Config;

/**
 * Created by qiumin on 2015/8/25.
 */
public class Phone_cfg extends module_config{
    public Phone_cfg(){ super();}

    @Override
    public void set_default() {
        add("call_number"    ,new button("10086"        ,method_sel.text,"测试中拨打的号码，要添加到通讯录里面的号码，要发送短信的号码"));
        add("content_name"   ,new button("Test"         ,method_sel.text,"联系人apk中新添加的联系人名称"));
        add("calendar_theme" ,new button("just_test"    ,method_sel.text,"日历中需要新建的event/task的主题"));
        add("calendar_content",new button("Have fun."   ,method_sel.text,"日历中需要新建的event/task的内容"));
        add("sms_message"    ,new button("nihao"        ,method_sel.text,"测试短信apk时，发送的短信内容，也可作为彩信的主题"));
        add("mms_picture"    ,new button("48.86"        ,method_sel.text,"测试彩信时，添加图片附件时候，识别图片的文本，通常是图片大小"));
        add("mms_video"      ,new button("63.43KB"      ,method_sel.text,"测试彩信时，添加视频附件时候，识别视频的文本，通常是视频大小"));
        add("mms_audio"      ,new button("Sound 100K"   ,method_sel.text,"测试彩信时，添加音频附件时候，识别音频的文本，通常是歌曲名"));
        add("calcu_express"  ,new button("s5)*2="       ,method_sel.text,"测试计算器时，输入的表达式，具体符号意思详见Calculator模块")) ;
        add("calcu_result"   ,new button("-1.9178485"   ,method_sel.text,"测试计算器时，用来比对的结果")) ;
        add("eml_receiver"   ,new button("testmtbf5@139.com"   ,method_sel.text,"测试Email时，邮件的收信人"));
        add("eml_subject"    ,new button("For MTBF test"       ,method_sel.text,"测试Email时，邮件的主题"));
        add("eml_body"       ,new button("Can you see this?"   ,method_sel.text,"测试Email时，邮件的内容"));
        add("eml_picture"    ,new button("96.87KB"             ,method_sel.text,"测试Email时，添加图片附件用来识别附件的文本，通常是图片大小"));
        add("website_mark"   ,new button("BAIDU"        ,method_sel.text,"测试浏览器上网时，网站的书签名称"));
        add("website_name"   ,new button("百度一下"     ,method_sel.text,"测试浏览器上网时，网站完全打开后，显示在url栏中的名称，用来确定打开网站正确"));
        add("hyperlink_name" ,new button("百度新闻"     ,method_sel.text,"测试浏览器上网并点击其中超链接时，点开超链接后显示在url栏中的名称，用来确定超链接打来正确"));
        add("hyperlink_x"    ,new button("50"           ,method_sel.text,"测试浏览器上网点击超链接时，超链接所在X轴位置"));
        add("hyperlink_y"    ,new button("600"          ,method_sel.text,"测试浏览器上网点击超链接时，超链接所在Y轴位置"));
        add("text_mark"      ,new button("TEXT"         ,method_sel.text,"测试浏览器下载文本文件时，对应网址的书签名称"));
        add("text_name"      ,new button("TEXT.txt"     ,method_sel.text,"测试浏览器下载文本文件时，下载下来后的文件名称"));
        add("aud_mark"       ,new button("MP3"          ,method_sel.text,"测试浏览器下载音频文件时，对应网址的书签名称"));
        add("aud_name"       ,new button("mp3.mp3"      ,method_sel.text,"测试浏览器下载音频文件时，下载下来后的文件名称"));
        add("pic_mark"       ,new button("JPG"          ,method_sel.text,"测试浏览器下载图片文件时，对应网址的书签名称"));
        add("pic_name"       ,new button("Picteure.jpg" ,method_sel.text,"测试浏览器下载图片文件时，下载下来后的文件名称"));
        add("vdo_mark"       ,new button("3GP"          ,method_sel.text,"测试浏览器下载视频文件时，对应网址的书签名称"));
        add("vdo_name"       ,new button("3Gp.3gp"      ,method_sel.text,"测试浏览器下载视频文件时，下载下来后的文件名称"));
        add("online_mark"    ,new button("STRAE"        ,method_sel.text,"测试浏览器在线播放视频时，对应网址的书签名称"));
        add("online_name"    ,new button("COMCAT"       ,method_sel.text,"测试浏览器在线播放视频时，打开网址后再url栏中显示的名称，用来确定online的书签正确打开"));
        add("online_x"       ,new button(""       ,method_sel.text,"测试浏览器在线播放视频时，视频文件所在位置的X轴坐标，需要点击该超链接，才开始在线播放"));
        add("online_y"       ,new button(""       ,method_sel.text,"测试浏览器在线播放视频时，视频文件所在位置的Y轴坐标，需要点击该超链接，才开始在线播放"));
        add("folder_name"    ,new button("010"          ,method_sel.text,"测试文件管理器新建文件夹时，新建的文件夹的名称"));
    }
}
