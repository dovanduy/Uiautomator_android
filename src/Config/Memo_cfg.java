package Config;

/**
 * Created by qiumin on 2015/8/18.
 */
public class Memo_cfg extends module_config {
    public Memo_cfg(){
        super();
    }
    
    @Override
    public void set_default() {
        this.name="Memo";
        this.pkg="memo";
    }
}
