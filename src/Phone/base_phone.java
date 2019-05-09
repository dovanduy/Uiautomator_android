package Phone;

import java.awt.Event;
import java.util.ArrayList;

import Config.Configs;
import Config.button;
import Config.module_config;
import Modules.*;

import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import uiautomatorrpc.UiObject;
import uiautomatorrpc.UiSelector;

/**
 * Created by qiumin on 2015/8/24.
 */

public class base_phone extends module {
    Configs all_config =new Configs();

    public Call      my_call     =new Call();
    public Contacts  my_contacts =new Contacts();
    public Messaging my_messaging=new Messaging();
    public Email     my_email    =new Email();
    public Browser   my_browser  =new Browser();
    public Downloads my_downloads=new Downloads();
    public Calendar  my_calendar =new Calendar();
    public Clock     my_clock    =new Clock();
    public Recorder  my_recorder =new Recorder();
    public Music     my_music    =new Music();
    public Files     my_files    =new Files();
    public Camera    my_camera   =new Camera();
    public Gallery   my_gallery  =new Gallery();
    public Calculator my_calculator=new Calculator();
    public Settings my_settings  =new Settings();
    public Memo     my_memo      =new Memo();
    public Videos   my_videos    = new Videos();

    private final Marker MARKER = MarkerManager.getMarker("BASE_PHONE");


   public void version_download_test() throws Exception{
	   logger.info(MARKER, "******** 版本升级测试 ********");
	   my_videos.open_apk();
	   my_videos.check_if_terminated();
	   if(my_videos.button_exist("upload")){
		   my_videos.clicks("upload|D20");
		   if(!my_videos.button_exist("ok1"))
		   {
			   clicks("D10");
		   }
		   my_videos.clicks("ok1|D1|install|D14|open");
		   //vivo手机权限提示
		   if(my_videos.button_exist("allow"))
		   {
			   my_videos.clicks("allow|D5");
		   }
		   //新版本去掉引导图
		   click(263,1240);
		   if(my_videos.button_exist("second_page")){
			   logger.info("升级版本成功");
		   }else{
			   logger.error("升级版本失败");
			   throw new Exception();
		   }
	   }else{
		   logger.error("未检测到升级版本");
		   throw new Exception();
	   }   
   }
   
   public void company_report_test() throws Exception{
	   logger.info(MARKER, "******** 企业报告测试 ********");
	   my_videos.open_apk();
	   my_videos.check_if_terminated();
	   my_videos.clicks("first_page|D1|company|D3");
	   //检索信息在此是固定的  中诚信征信
	   my_videos.write_button("search", "中诚信征信");
	   if(my_videos.button_exist("match1")){
		   my_videos.clicks("match1|D5|register|D2");
		   if(my_videos.button_exist("credit_code")){
			   logger.info("企业报告查询成功");
		   }else{
			   logger.error("企业报告查询失败");
			   throw new Exception();
		   }
	   }else{
		   logger.error("检测模糊匹配项失败");
		   throw new Exception();
	   }
   }
   
   public void person_report_test() throws Exception{
	   logger.info(MARKER, "******** 个人报告测试 ********");
	   my_videos.open_apk();
	   my_videos.check_if_terminated();
	   my_videos.clicks("first_page|D1|company|D1");
	   //打开case02中的历史查询记录
	   if(my_videos.button_exist("match1")){
		   my_videos.clicks("match1|D5|manager|D2|match2|D2|holder");
		   if(my_videos.button_exist("match3")){
			   logger.info("个人报告查询成功");
		   }else{
			   logger.error("个人报告查询失败");
			   throw new Exception();
		   }
	   }else{
		   logger.error("检测历史纪录失败");
		   throw new Exception();
	   }
   }
   
   public void dishonest_test() throws Exception{
	   logger.info(MARKER, "******** 失信人测试 ********");
	   my_videos.open_apk();
	   my_videos.check_if_terminated();
	   my_videos.clicks("first_page|D1|dishonest|D3");
	   //检索信息在此是固定的  姚欣
	   my_videos.write_button("search", "姚欣");
	   if(my_videos.button_exist("0636")){
		   my_videos.clicks("0636");
		   if(my_videos.button_exist("dishonest_address")){
			   logger.info("失信人信息查询成功");
		   }else{
			   logger.error("失信人信息查询失败");
			   throw new Exception();
		   }
	   }else{
		   logger.error("检测模糊匹配项失败");
		   throw new Exception();
	   }
   }
   
   public void enforce_test() throws Exception{
	   logger.info(MARKER, "******** 被执行人测试 ********");
	   my_videos.open_apk();
	   my_videos.check_if_terminated();
	   my_videos.clicks("first_page|D1|enforce|D3");
	   //检索信息在此是固定的  姚欣
	   my_videos.write_button("search", "姚欣");
	   if(my_videos.button_exist("0636")){
		   my_videos.clicks("0636");
		   if(my_videos.button_exist("enforce_state")){
			   logger.info("被执行人信息查询成功");
		   }else{
			   logger.error("被执行人信息查询失败");
			   throw new Exception();
		   }
	   }else{
		   logger.error("检测模糊匹配项失败");
		   throw new Exception();
	   }
   }
   
   public void creditcardbanner_test() throws Exception{
	   logger.info(MARKER, "******** 信用卡banner测试 ********");
	   my_videos.open_apk();
	   my_videos.check_if_terminated();
	   my_videos.clicks("second_page|creditcard|creditcard_banner|D3");
	   if(my_videos.button_exist("banner_name")||my_videos.button_exist("banner_name1")){
		   logger.info("打开信用卡banner页成功");
	   }else{
		   logger.error("打开信用卡banner页失败");
		   throw new Exception();
	   }
   }
   
   public void creditcardtop5_test() throws Exception{
	   logger.info(MARKER, "******** 信用卡TOP5测试 ********");
	   my_videos.open_apk();
	   my_videos.check_if_terminated();
	   my_videos.clicks("second_page|creditcard|D1|creditcard_top5|D1");
	   if(my_videos.button_exist("")){
		   
		   logger.info("打开信用卡TOP5成功");
	   }else{
		   logger.error("打开信用卡TOP5失败");
		   throw new Exception();
	   }
   }
   
   public void login_test() throws Exception{
	   logger.info(MARKER, "******** 登陆测试 ********");
	   my_videos.open_apk();
	   my_videos.check_if_terminated();
	   my_videos.clicks("fourth_page|D1|login|D1");
	   if(my_videos.button_exist("enter")){
		   my_videos.clear_button("username");
		   my_videos.write_button("username", "15092269471");
		   my_videos.write_button("password", "test123");
		   my_videos.clicks("enter|D1");
		   if(my_videos.button_exist("account")){
			   logger.info("登陆成功");
		   }else{
			   logger.error("登陆失败");
			   throw new Exception();
		   }
	   }else{
		   logger.error("跳转登陆界面失败");
		   throw new Exception();
	   }
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   



    //******* Config 操作 ********/

    public void get_config(Configs in_all_cfg) throws Exception{
        this.all_config=in_all_cfg;
        set_configs();
    }
    public void set_configs() throws Exception{
    	
        this.set_cfg(all_config.configs[0]);
        my_browser.set_cfg(all_config.configs[1]);
        my_calculator.set_cfg(all_config.configs[2]);
        my_calendar.set_cfg(all_config.configs[3]);
        my_call.set_cfg(all_config.configs[4]);
        my_camera.set_cfg(all_config.configs[5]);
        my_clock.set_cfg(all_config.configs[6]);
        my_contacts.set_cfg(all_config.configs[7]);
        my_downloads.set_cfg(all_config.configs[8]);
        my_email.set_cfg(all_config.configs[9]);
        my_files.set_cfg(all_config.configs[10]);
        my_gallery.set_cfg(all_config.configs[11]);
        my_messaging.set_cfg(all_config.configs[12]);
        my_music.set_cfg(all_config.configs[13]);
        my_recorder.set_cfg(all_config.configs[14]);
        my_settings.set_cfg(all_config.configs[15]);
        my_memo.set_cfg(all_config.configs[16]);
        my_videos.set_cfg(all_config.configs[17]);
        
    }
    public String get_deviceid() throws Exception{
    	return this.get_attr("device_id");
    }

}
