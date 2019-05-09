package uiautomatorrpc;

import com.googlecode.jsonrpc4j.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import utils.AdbOperation;
/**
 *
 * <p>Title: JsonRpcService.</p>
 * <p>Description: ����JsonRPC server�˵�����/�ر�  �Լ�client�˵�����.</p>
 *
 * @author XiaPeiyong(xiapeiyong@hisense.com) 2014-4-16.
 * @version $Id$
 */
public class JsonRpcService {

    protected static final String URL="http://localhost:6008/jsonrpc/0";
    protected static final String UIAUTOMATOR_PROCESS_NAME="uiautomator";

    private static JsonRpcService jsonrpc = new JsonRpcService();
    private JsonRpcService(){

    }

    public static JsonRpcService getInstance(){
        return jsonrpc;
    }


    /**
     *
     * <p>Title: PC������client����.</p>
     * <p>Description: PC������client����.</p>
     *
     * @return
     */
    public JsonRpcHttpClient startClient(){
        try {
            return new JsonRpcHttpClient(new URL(URL));
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     *
     * <p>Description: ����Android�豸�˵�Json����.</p>
     *
     * @param deviceName
     */
    public void startServer(String deviceName){
        if(!isServerStarted(deviceName)){
            JsonRpcServerThread rpcserver = new JsonRpcServerThread(deviceName);
            System.out.println("start server of "+deviceName);
            rpcserver.start();
        }

//        //���ó�ʱʱ��10s  ÿ��0.1���ж�һ��server�Ƿ�����
//        double timeout = 10;
//        while(!isServerStarted(deviceName) && timeout>0){
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            timeout -= 0.1;
//        }
//        //��10s��server��δ���������׳��쳣
//        if(!isServerStarted(deviceName)){
//            throw new Exception("RPC server not started!");
//        }
    }

    /**
     *
     * <p>Description: �ж�Json�����Ƿ�������.</p>
     *
     * @param deviceName
     * @return
     */
    public boolean isServerStarted(String deviceName) {
        try {
            String adbDevice = "";
            if (deviceName != null && !"".equals(deviceName)) {
                adbDevice = " -s " + deviceName;
            }
            Process adbshell = AdbOperation.execCmdCommand("adb " + adbDevice + " shell ps");
            BufferedReader stdout = new BufferedReader(new InputStreamReader(adbshell.getInputStream()));
            String line = null;
            while ((line = stdout.readLine()) != null) {
                //System.out.println(line);
                if (line.contains(UIAUTOMATOR_PROCESS_NAME)) {
                    System.out.println("Uiautomator server has started! ");
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     *
     * <p>Title: �豸��ֹͣjson rpc����.</p>
     * <p>Description: �豸��ֹͣjson rpc����.</p>
     *
     * @param deviceName �豸��
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void stopServer(String deviceName){
        try {
            Process adbshell = AdbOperation.execCmdCommand("adb -s " + deviceName + " shell ps -C " + UIAUTOMATOR_PROCESS_NAME);
            BufferedReader stdout = new BufferedReader(new InputStreamReader(adbshell.getInputStream()));
            String line = null;
            int pidIndex = -1;
            while ((line = stdout.readLine()) != null) {
                line = line.replaceAll("\\s+", "@#");
                //System.out.println(line);
                if(line.contains("PID")){
                    ArrayList list = new ArrayList(Arrays.asList(line.split("@#")));
                    pidIndex = list.indexOf("PID");
                    //System.out.println("PID index is : "+pidIndex);
                }
                if(line.contains(UIAUTOMATOR_PROCESS_NAME)){
                    if(pidIndex>-1){
                        ArrayList list = new ArrayList(Arrays.asList(line.split("@#")));
                        AdbOperation.execCmdCommand("adb -s " + deviceName + " shell kill -9 " + list.get(pidIndex));
                    }

                }
            }
            System.out.println("stop server "+deviceName);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
