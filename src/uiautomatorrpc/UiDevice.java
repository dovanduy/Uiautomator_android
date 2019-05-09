package uiautomatorrpc;

import  com.googlecode.jsonrpc4j.*;

import java.io.File;

import org.apache.logging.log4j.*;

import utils.AdbOperation;
/**
 * Created by qiumin on 2015/8/14.
 */
public class UiDevice {

    protected static final String TEMP_DIR_IN_DEVICE ="/data/local/tmp/" ;
    public Logger logger = LogManager.getLogger(this.getClass());

    //add by qiumin
    private static UiDevice device = new UiDevice();
    //add end

    private JsonRpcHttpClient client = null;
    public UiDevice(){
        client = JsonRpcService.getInstance().startClient();
    }

    public static UiDevice getInstance(){
        return device;
    }

    private static String deviceName = "";

    /**
     *
     * <p>
     * Description: ��ȡ�豸��ƣ���127.0.0.1:5555.
     * </p>
     *
     * @return
     */
    public static String getDeviceName() {
        return deviceName;
    }

    /**
     *
     * <p>
     * Description: �����豸��ƣ���127.0.0.1:5555.
     * </p>
     *
     * @param deviceName
     */
    public static void setDeviceName(String deviceName) {
        UiDevice.deviceName = deviceName;
    }

    /**
     *
     * <p>Title: pressKeyCode.</p>
     * <p>Description: ���¼�ֵ.</p>
     *
     * @param keycode:��ֵ��
     * @return �Ƿ�ִ�гɹ�
     * @throws Throwable
     */
    public boolean pressKeyCode(int keycode) throws Throwable{
        return client.invoke("pressKeyCode", new Object[] {keycode}, boolean.class);

    }

    public void wakeUp() throws Throwable{
        client.invoke("wakeUp", null);
    }

    public void sleep() throws Throwable{
        client.invoke("sleep", null);
    }


    /**
     *
     * <p>Title: ����ң������up��.</p>
     * <p>Description: ����ң������up��.</p>
     *
     * @return �Ƿ�ɹ�ִ��
     * @throws Throwable
     */
    public boolean pressUp() throws Throwable{
        return pressKeyCode(19);
    }

    public boolean pressHome() throws Throwable{
        return pressKeyCode(3);
    }

    public boolean pressCall() throws Throwable{
        return pressKeyCode(5);
    }

    public boolean pressEndCall() throws Throwable{
        return pressKeyCode(6);
    }

    public boolean pressVolumeUp() throws Throwable{
        return pressKeyCode(24);
    }

    public boolean pressVolumeDown() throws Throwable{
        return pressKeyCode(25);
    }

    public boolean pressPower() throws Throwable{
        return pressKeyCode(26);
    }

    public boolean pressCamera() throws Throwable{
        return pressKeyCode(27);
    }

    public boolean pressFocus() throws Throwable{
        return pressKeyCode(80);
    }

    public boolean pressClear() throws Throwable{
        return pressKeyCode(28);
    }

    public boolean pressMenu() throws Throwable{
        return pressKeyCode(82);
    }

    /**
     *
     * <p>Title: ����ң������down��.</p>
     * <p>Description: ����ң������down��.</p>
     *
     * @return �Ƿ�ɹ�ִ��
     * @throws Throwable
     */
    public boolean pressDown() throws Throwable{
        return pressKeyCode(20);
    }


    /**
     *
     * <p>Title: ����ң������left��.</p>
     * <p>Description: ����ң������left��.</p>
     *
     * @return �Ƿ�ɹ�ִ��
     * @throws Throwable
     */
    public boolean pressLeft() throws Throwable{
        return pressKeyCode(21);
    }

    /**
     *
     * <p>Title: ����ң������right��.</p>
     * <p>Description: ����ң������right��.</p>
     *
     * @return �Ƿ�ɹ�ִ��
     * @throws Throwable
     */
    public boolean pressRight() throws Throwable{
        return pressKeyCode(22);
    }


    /**
     *
     * <p>Title: ����ң������ok��.</p>
     * <p>Description: ����ң������ok��.</p>
     *
     * @return �Ƿ�ɹ�ִ��
     * @throws Throwable
     */
    public boolean pressOk() throws Throwable{
        return pressKeyCode(23);
    }

    /**
     *
     * <p>Title: ����ң������back��.</p>
     * <p>Description: ����ң������back��.</p>
     *
     * @return �Ƿ�ɹ�ִ��
     * @throws Throwable
     */
    public boolean pressBack() throws Throwable{
        return pressKeyCode(4);
    }


    /**
     *
     * <p>Title: �������.</p>
     * <p>Description: �������.</p>
     *
     * @param x��x���
     * @param y��y���
     * @return �Ƿ����ɹ�
     * @throws Throwable
     */
    public boolean click(int x,int y) throws Throwable{
        return client.invoke("click", new Object[] {x,y}, boolean.class);
    }


    /**
     *
     * <p>Title: drag.</p>
     * <p>Description: Performs a swipe from one coordinate to another using the number of steps to determine smoothness and speed.</p>
     *
     * @param startX X-axis value for the starting coordinate
     * @param startY Y-axis value for the starting coordinate
     * @param endX   X-axis value for the ending coordinate
     * @param endY   Y-axis value for the ending coordinate
     * @param steps  is the number of move steps sent to the system
     * @return false if the operation fails or the coordinates are invalid
     * @throws Throwable
     */
    public boolean drag(int startX, int startY, int endX, int endY, int steps) throws Throwable{
        return client.invoke("drag", new Object[] {startX, startY, endX, endY, steps}, boolean.class);
    }


    /**
     *
     * <p>Title: drag.</p>
     * <p>Description: Performs a swipe from one coordinate to another using the number of steps to determine smoothness and speed.</p>
     *
     * @param startX X-axis value for the starting coordinate
     * @param startY Y-axis value for the starting coordinate
     * @param endX   X-axis value for the ending coordinate
     * @param endY   Y-axis value for the ending coordinate
     * @param steps  is the number of move steps sent to the system
     * @return false if the operation fails or the coordinates are invalid
     * @throws Throwable
     */
    public boolean swipe(int startX, int startY, int endX, int endY, int steps) throws Throwable{
        return client.invoke("swipe", new Object[] {startX, startY, endX, endY, steps}, boolean.class);
    }

    /**
     *
     * <p>Title: Register a ClickUiObjectWatcher.</p>
     * <p>Description: ע��һ��watcher����������ʱ���ָ����UiObject.</p>
     *
     * @param name Watcher name
     * @param conditions  If all UiObject in the conditions match, the watcher should be triggered
     * @param target The target UiObject should be clicked if all conditions match.
     * @throws Throwable
     */
    public void registerClickUiObjectWatcher(String name, UiSelector[] conditions, UiSelector target) throws Throwable{
        client.invoke("registerClickUiObjectWatcher", new Object[] {name, conditions, target}, boolean.class);
    }

    /**
     *
     * <p>Title: Register a PressKeysWatcher.</p>
     * <p>Description: ע��һ��watcher����������ʱ���ָ����UiObject.</p>
     *
     * @param name Watcher name
     * @param conditions  If all UiObject in the conditions match, the watcher should be triggered
     * @param target The target UiObject should be clicked if all conditions match.
     * @throws Throwable
     */
    public void registerPressKeyskWatcher(String name, UiSelector[] conditions, String[] keys) throws Throwable{
        client.invoke("registerPressKeyskWatcher", new Object[] {name, conditions, keys}, boolean.class);
    }


    /**
     *
     * <p>Title: runWatchers.</p>
     * <p>Description: ʹ���е�watcher��Ч.</p>
     *
     * @throws Throwable
     */
    public void runWatchers() throws Throwable{
        client.invoke("runWatchers", null);
    }


    /**
     *
     * <p>Title: ��ͼ.</p>
     * <p>Description: �����ͼ ������PC����.</p>
     *
     * @param filepath ͼƬ��ŵ�Ŀ¼(pc��)
     * @param filename ͼƬ���������(pc��)
     * @throws Throwable
     */
    public void takeScreenshot(String filepath,String filename) throws Throwable{
        takeScreenshot(filepath,filename,1.0f,100);
        String result = client.invoke("takeScreenshot", new Object[] {filename,1.0f,100} ,String.class);
        AdbOperation.execCmdCommand("adb pull " + result + " "+ filename + filename);
        //System.out.println("pic is :"+result);
    }


    /**
     *
     * <p>Title: ��ͼ.</p>
     * <p>Description: �����ͼ ������PC����.</p>
     *
     * @param filepath ͼƬ��ŵ�Ŀ¼(pc��)
     * @param filename ͼƬ���������(pc��)
     * @param scale     scale the screenshot down if needed; 1.0f for original size
     * @param quality   quality of the PNG compression; range: 0-100
     */
    public void takeScreenshot(String filepath, String filename, float scale,
                               int quality) throws Throwable {
        String targetDevice = "";
        if (!"".equals(deviceName)) {
            targetDevice = " -s " + deviceName;
        }
        String result = client.invoke("takeScreenshot", new Object[] {
                "Screenshot.png", scale, quality }, String.class);
        logger.info("@@@@@@@ result is : "+result);
        Process pull = AdbOperation.execCmdCommand("adb " + targetDevice
                + " pull " + result + " \"" + filepath + File.separator
                + filename + "\"");
        logger.info("@@@@@@@@ adb command is : "+"adb " + targetDevice
                + " pull " + result + " \"" + filepath + File.separator
                + filename + "\"");
        pull.waitFor();
        AdbOperation.execCmdCommand("adb " + targetDevice + " shell rm "
                + result);
        // System.out.println("pic is :"+result);
    }
    /**
     *
     * @author Sevens
     @descrption ��Ҫ����ѹ��ͼ�� ��4k2k�ͷ�4k24����Ч
      * @param filepath ͼ��·��
     * @param filenameͼ������
     * @param scaleѹ������ ֻ����0.x,0.1���ѹ��Ϊԭ����ʮ��֮һ�Դ�����
     * @param quality ���� 1-100
     * @throws Throwable
     */
    public void takeScreenshotByCompress(String filepath, String filename, float scale,
                                         int quality) throws Throwable {
        String targetDevice = "";
        if (!"".equals(deviceName)) {
            targetDevice = " -s " + deviceName;
        }
        String result = client.invoke("takeScreenshotByCompress", new Object[] {
                filename, scale, quality }, String.class);
        Process pull = AdbOperation.execCmdCommand("adb " + targetDevice
                + " pull " + result + " \"" + filepath + File.separator
                + filename + "\"");
        pull.waitFor();
        AdbOperation.execCmdCommand("adb " + targetDevice + " shell rm "
                + result);
        // System.out.println("pic is :"+result);
    }
    public void takeScreenshotByROI(String filepath, int x,int y,int width,int height,String filename, float scale,
                                    int quality) throws Throwable {
        String targetDevice = "";
        if (!"".equals(deviceName)) {
            targetDevice = " -s " + deviceName;
        }
        String result = client.invoke("takeScreenshotByROI", new Object[] {
                filename, x,y,width,height,scale, quality }, String.class);
        Process pull = AdbOperation.execCmdCommand("adb " + targetDevice
                + " pull " + result + " \"" + filepath + File.separator
                + filename + "\"");
        pull.waitFor();
        AdbOperation.execCmdCommand("adb " + targetDevice + " shell rm "
                + result);
        // System.out.println("pic is :"+result);
    }
    public void ScreenshotFull(String filepath, int width,int height,String filename) throws Throwable {
        String targetDevice = "";
        if (!"".equals(deviceName)) {
            targetDevice = " -s " + deviceName;
        }
        String result = client.invoke("ScreenshotFull", new Object[] {
                filename,width,height}, String.class);
        Process pull = AdbOperation.execCmdCommand("adb " + targetDevice
                + " pull " + result + " \"" + filepath + File.separator
                + filename + "\"");
        pull.waitFor();
        AdbOperation.execCmdCommand("adb " + targetDevice + " shell rm "
                + result);
        // System.out.println("pic is :"+result);
    }
    public void ScreenshotROI(String filepath,String filename,int x,int y,int width,int height) throws Throwable {
        String targetDevice = "";
        if (!"".equals(deviceName)) {
            targetDevice = " -s " + deviceName;
        }
        String result = client.invoke("ScreenshotUpperROI", new Object[] {
                filename,x,y,width,height }, String.class);
        Process pull = AdbOperation.execCmdCommand("adb " + targetDevice
                + " pull " + result + " \"" + filepath + File.separator
                + filename + "\"");
        pull.waitFor();
        AdbOperation.execCmdCommand("adb " + targetDevice + " shell rm "
                + result);
        // System.out.println("pic is :"+result);
    }
    public void ScreenshotUpperFull(String filepath, int width,int height,String filename) throws Throwable {
        String targetDevice = "";
        if (!"".equals(deviceName)) {
            targetDevice = " -s " + deviceName;
        }
        String result = client.invoke("ScreenshotUpperFull", new Object[] {
                filename,width,height}, String.class);
        Process pull = AdbOperation.execCmdCommand("adb " + targetDevice
                + " pull " + result + " \"" + filepath + File.separator
                + filename + "\"");
        pull.waitFor();
        AdbOperation.execCmdCommand("adb " + targetDevice + " shell rm "
                + result);
        // System.out.println("pic is :"+result);
    }
    public void ScreenshotUpperROI(String filepath,String filename,int x,int y,int width,int height) throws Throwable {
        String targetDevice = "";
        if (!"".equals(deviceName)) {
            targetDevice = " -s " + deviceName;
        }
        String result = client.invoke("ScreenshotROI", new Object[] {
                filename,x,y,width,height }, String.class);
        Process pull = AdbOperation.execCmdCommand("adb " + targetDevice
                + " pull " + result + " \"" + filepath + File.separator
                + filename + "\"");
        pull.waitFor();
        AdbOperation.execCmdCommand("adb " + targetDevice + " shell rm "
                + result);
        // System.out.println("pic is :"+result);
    }


    /**
     * add by qiumin
     */
    public boolean openNotification() throws Throwable{
        return client.invoke("openNotification", null, boolean.class);
    }
    public void dumpWindowHierarchy(Boolean compressed,String fileName) throws Throwable{
    	 String targetDevice = "";
         if (!"".equals(deviceName)) {
             targetDevice = " -s " + deviceName;
         }
    	String result=client.invoke("dumpWindowHierarchy", new Object[] {compressed,fileName}, String.class);
    	Process pull =AdbOperation.execCmdCommand("adb"+targetDevice+" pull "+ result+ " \""+fileName+"\"");
    }

}
