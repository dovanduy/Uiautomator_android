package uiautomatorrpc;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
/**
 * Created by qiumin on 2015/8/14.
 */
public class UiObject {
    protected static final long WAIT_FOR_WINDOW_TMEOUT = 5500;

    private JsonRpcHttpClient client = null;

    //    private UiSelector mSelector;
    private Object mSelector;


    public UiObject(UiSelector selector) {
        client = JsonRpcService.getInstance().startClient();
        mSelector = selector;
    }

    public UiObject(String selectorString) {
        client = JsonRpcService.getInstance().startClient();
        mSelector = selectorString;
    }

    public UiObject(){
        //client = jsonrpc.startClient();
        client = JsonRpcService.getInstance().startClient();
    }

//    public final UiSelector getSelector() {
//        return mSelector;
//    }


    /**
     * Creates a new UiObject representing a child UI element of the element currently represented
     * by this UiObject.
     *
     * @param selector for UI element to match
     * @return a new UiObject representing the matched UI element
     * @throws Throwable
     * @since API Level 16
     */
    public String getChild(UiSelector selector) throws Throwable {
        return client.invoke("getChild", new Object[] {mSelector,selector}, String.class);
    }


    /**
     *
     * <p>Title: ��ȡ�ֵ�Ԫ��.</p>
     * <p>Description: ��ȡ�ֵ�Ԫ��.</p>
     *
     * @param selector����ƥ���UiSelector
     * @return ���ش����ҵ�UiObject
     * @throws Throwable
     */
    public UiObject getFromParent(UiSelector selector) throws Throwable {
        return new UiObject(client.invoke("getFromParent", new Object[] {mSelector,selector}, String.class));
    }


    /**
     *
     * <p>Title: ͨ���ı����Ի�ȡ��Ԫ��.</p>
     * <p>Description: ͨ���ı����Ի�ȡ��Ԫ��.</p>
     *
     * @param text���ı�����
     * @return ������Ԫ��
     * @throws Throwable
     */
    public UiObject childByText(String text) throws Throwable {
        String result = null;
//        UiSelector selector = new UiSelector().className("android.widget.TextView");
        UiSelector selector = new UiSelector().text(text);
        result = client.invoke("childByText", new Object[] {mSelector,selector,text,true}, String.class);
        return new UiObject(result);
    }

    /**
     *
     * <p>Title: ͨ��Description���Ի�ȡ��Ԫ��..</p>
     * <p>Description: ͨ��Description���Ի�ȡ��Ԫ��.</p>
     *
     * @param selector:��Ԫ�ص�uiselector������new UiSelector().className("android.widget.TextView");
     * @param description����Ԫ�ص�description����
     * @return
     * @throws Throwable
     */
    public UiObject childByDescription(UiSelector selector,String description) throws Throwable {
        return new UiObject(client.invoke("childByDescription", new Object[] {mSelector,selector,description,true}, String.class));
    }

    /**
     *
     * <p>Title: ͨ��Instance��ȡ��Ԫ��.</p>
     * <p>Description: ͨ��Instance��ȡ��Ԫ��.</p>
     *
     * @param selector:��Ԫ�ص�uiselector������new UiSelector().className("android.widget.TextView");
     * @param instance:int���ͣ�instance�Ĵ���
     * @return
     * @throws Throwable
     */
    public UiObject childByInstance(UiSelector selector,int instance) throws Throwable {
        return new UiObject(client.invoke("childByInstance", new Object[] {mSelector,selector,instance}, String.class));
    }


    /**
     *
     * <p>Title: exist.</p>
     * <p>Description: exist.</p>
     *
     * @return
     * @throws Throwable
     */
    public boolean exist() throws Throwable{
        return client.invoke("exist", new Object[] {mSelector}, boolean.class);
    }


    /**
     *
     * <p>Title: click.</p>
     * <p>Description: click.</p>
     *
     * @return
     * @throws Throwable
     */
    public boolean click() throws Throwable{
        return client.invoke("click", new Object[] {mSelector}, boolean.class);
    }

    /**
     *
     * <p>Title: longclick.</p>
     * <p>Description: longclick.</p>
     *
     * @return
     * @throws Throwable
     */
    public boolean longClick() throws Throwable{
        return client.invoke("longClick", new Object[] {mSelector}, boolean.class);
    }


    /**
     *
     * <p>Title: clickAndWaitForNewWindow.</p>
     * <p>Description: clickAndWaitForNewWindow.</p>
     *
     * @param timeout
     * @return
     * @throws Throwable
     */
    public boolean clickAndWaitForNewWindow(long timeout) throws Throwable{
        return client.invoke("clickAndWaitForNewWindow", new Object[] {mSelector,timeout}, boolean.class);
    }


    /**
     *
     * <p>Title: clickAndWaitForNewWindow.</p>
     * <p>Description: cliclickAndWaitForNewWindowck.</p>
     *
     * @return
     * @throws Throwable
     */
    public boolean clickAndWaitForNewWindow() throws Throwable{
        return client.invoke("clickAndWaitForNewWindow", new Object[] {mSelector,WAIT_FOR_WINDOW_TMEOUT}, boolean.class);
    }


    /**
     *
     * <p>Title: clearTextField.</p>
     * <p>Description: clearTextField.</p>
     *
     * @return
     * @throws Throwable
     */
    public void clearTextField() throws Throwable{
        client.invoke("clearTextField", new Object[] {mSelector}, void.class);
    }


    /**
     *
     * <p>Title: getText.</p>
     * <p>Description: getText.</p>
     *
     * @return
     * @throws Throwable
     */
    public String getText() throws Throwable {
        return client.invoke("getText", new Object[] {mSelector}, String.class);
    }


    public String getClassName() throws Throwable{
        return client.invoke("getClassName", new Object[] {mSelector}, String.class);
    }

    public String getPackageName() throws Throwable{
        return client.invoke("getPackageName", new Object[] {mSelector}, String.class);
    }

    public boolean isCheckable() throws Throwable{
        return client.invoke("isCheckable",new Object[] {mSelector},boolean.class);
    }

    public boolean isChecked() throws Throwable{
        return client.invoke("isChecked",new Object[] {mSelector},boolean.class);
    }

    public boolean isSelected() throws Throwable{
        return client.invoke("isSelected",new Object[] {mSelector},boolean.class);
    }

    public boolean isEnabled() throws Throwable{
        return client.invoke("isEnabled",new Object[] {mSelector},boolean.class);
    }

    public boolean isClickable() throws Throwable{
        return client.invoke("isClickable",new Object[] {mSelector},boolean.class);
    }

    public boolean isFocused() throws Throwable{
        return client.invoke("isFocused",new Object[] {mSelector},boolean.class);
    }

    public boolean isFocusable() throws Throwable{
        return client.invoke("isFocusable",new Object[] {mSelector},boolean.class);
    }

    public boolean isScrollable() throws Throwable{
        return client.invoke("isScrollable",new Object[] {mSelector},boolean.class);
    }

    public boolean isLongClickable() throws Throwable{
        return client.invoke("isLongClickable",new Object[] {mSelector},boolean.class);
    }

    /**
     *
     * <p>Title: setText.</p>
     * <p>Description: setText.</p>
     *
     * @param text:������ı�
     * @return
     * @throws Throwable
     */
    public boolean setText(String text) throws Throwable {
        return client.invoke("setText", new Object[] {mSelector,text}, boolean.class);
    }


    /**
     *
     * <p>Title: Get the count of the UiObject instances by the selector.</p>
     * <p>Description: Get the count of the UiObject instances by the selector.</p>
     *
     * @return the count of instances.
     * @throws Throwable
     */
    public int count() throws Throwable{
        return client.invoke("count", new Object[] {mSelector}, int.class);
    }


    /**
     *
     * <p>Title: waitForExists�ȴ�Ԫ�س���.</p>
     * <p>Description: waitForExists�ȴ�Ԫ�س���.</p>
     *
     * @param timeout����ʱʱ��
     * @return �����Ƿ����
     * @throws Throwable
     */
    public boolean waitForExists(long timeout) throws Throwable{
        return client.invoke("waitForExists", new Object[] {mSelector}, boolean.class);
    }

    /**
     *
     * <p>Title: waitUntilGone�ȴ�Ԫ����ʧ.</p>
     * <p>Description: waitUntilGone�ȴ�Ԫ����ʧ.</p>
     *
     * @param timeout����ʱʱ��
     * @return �����Ƿ���ʧ
     * @throws Throwable
     */
    public boolean waitUntilGone(long timeout) throws Throwable{
        return client.invoke("waitUntilGone", new Object[] {mSelector}, boolean.class);
    }


    /**
     *
     * <p>Title: ������ָ��Ԫ��λ��.</p>
     * <p>Description: Perform a scroll forward action to move through the scrollable layout element until a visible item that matches the selector is found.</p>
     *
     * @param targetObj:the item matches the selector to be found
     * @param isVertical:vertical or horizontal
     * @return true on scrolled, else false
     * @throws Throwable
     */
    public boolean scrollTo(UiSelector targetObj, boolean isVertical) throws Throwable{
        return client.invoke("scrollTo", new Object[] {mSelector,targetObj,isVertical}, boolean.class);
    }


    //add by qiumin
    public boolean swipe(String dir, int steps) throws Throwable{
        return client.invoke("swipe", new Object[] {mSelector,dir,steps}, boolean.class);
    }

    public boolean dragTo(int destX,int destY,int steps) throws Throwable{
        return client.invoke("dragTo", new Object[] {mSelector, destX,destY,steps},boolean.class);
    }
}
