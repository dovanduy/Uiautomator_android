package Config;

/**
 * Created by qiumin on 2015/8/18.
 */
public class Camera_cfg extends module_config{
    public Camera_cfg(){
        super();
    }

    @Override
    public void set_default() {
        this.name="Camera";
        this.pkg="camera2";
        add("video"     ,new button("Video"        ,method_sel.text,"拍照视图"));
        add("photo"     ,new button("Photo"        ,method_sel.text,"拍视频视图"));
        add("shutter"   ,new button(".+shuter.+"   ,method_sel.id  ,"快门键"));
        add("switcher"  ,new button(".+switcher"   ,method_sel.id  ,"前后摄像头切换键"));
        add("flash"     ,new button(".+flash.+"    ,method_sel.id  ,"闪光灯键"));
        add("thumbnail" ,new button(".+thumbnail.*",method_sel.id  ,"缩略图，点击可进入图库"));
    }
}
