package Config;

/**
 * Created by qiumin on 2015/8/18.
 */
public class Music_cfg extends module_config {
    public Music_cfg(){
        super();
    }

    @Override
    public void set_default() {
        this.name="Music";
        this.pkg="music";
        add("play_pause"  ,new button(".+pause"          ,method_sel.id  ,"播放和停止按钮"));
        add("add_to_list" ,new button("Add to playlist"  ,method_sel.text,"添加到播放列表按钮"));
        add("albums"      ,new button("ALBUMS"           ,method_sel.text,"音乐专辑/唱片视图"));
        add("artists"     ,new button("ARTISTS"          ,method_sel.text,"音乐艺术家视图"));
//        add("auto_off"    ,new button("Music auto off"   ,method_sel.text,""));
//        add("now_playing" ,new button(".+btn_now_playing",method_sel.id  ,""));
        add("up"          ,new button(".+up"             ,method_sel.id  ,"返回键，类似back"));
        add("cancel"      ,new button("Cancel"           ,method_sel.text,"取消键"));
        add("ok"          ,new button("OK"               ,method_sel.text,"确认键"));
        add("current_list",new button("Current playlist" ,method_sel.text,"当前播放列表按钮"));
        add("repeat"      ,new button(".+repeat"         ,method_sel.id  ,"音乐播放界面的循环播放按钮"));
        add("delete"      ,new button("Delete"           ,method_sel.text,"删除键"));
        add("directory"   ,new button("DIRECTORY"        ,method_sel.text,"音乐文件夹视图"));
        add("genres"      ,new button("GENRES"           ,method_sel.text,"音乐流派视图"));
        add("lyric"       ,new button("Lyric"            ,method_sel.text,"音乐播放界面的歌词按钮"));
        add("more"        ,new button("More options"     ,method_sel.desc,"音乐播放界面的more键，更多操作，类似menu"));
        add("multi"       ,new button(".+multidelbtn"    ,method_sel.id  ,"确认删除多个按钮"));
        add("next"        ,new button(".+next"           ,method_sel.id  ,"播放下一首按钮"));
        add("pre"         ,new button(".+prev"           ,method_sel.id  ,"播放前一首按钮"));
//        add("playall"     ,new button("Play all"         ,method_sel.text,""));
        add("playlist"    ,new button("Playlist"         ,method_sel.text,"音乐播放界面的播放列表按钮"));
        add("playlists"   ,new button("PLAYLISTS"        ,method_sel.text,"播放列表视图"));
        add("shuffle"     ,new button(".+shuffle"        ,method_sel.id  ,"播放界面的随机播放按钮"));
        add("select_all"  ,new button("Select all"       ,method_sel.text,"全选键"));
//        add("shuffle_all" ,new button("Shuffle all"      ,method_sel.text,""));
        add("songs"       ,new button("SONGS"            ,method_sel.text,"音乐曲目视图"));
        add("song_name"   ,new button(".+line1"          ,method_sel.id  ,"歌曲名称控件，每个代表一首歌曲"));
    }
}
