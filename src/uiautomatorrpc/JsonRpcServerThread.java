package uiautomatorrpc;


import utils.AdbOperation;

public class JsonRpcServerThread extends Thread{

    private String adbDevice = "";

    public JsonRpcServerThread(String deviceName) {
        if (deviceName != null && !"".equals(deviceName)) {
            this.adbDevice = " -s " + deviceName;
        }
    }
 

    public void run(){
//    	AdbOperation.excuteCmdWait("adb" +adbDevice
//    			+ " rm /data/local/tmp/bundle.jar");
//    	AdbOperation.excuteCmdWait("adb" +adbDevice
//    			+ " rm /data/local/tmp/uiautomator-stub.jar");
        AdbOperation.excuteCmdWait("adb" + adbDevice
                + " push ./config/uiautomatorServerLibs/bundle.jar /data/local/tmp/");
        AdbOperation.excuteCmdWait("adb" + adbDevice
                + " push ./config/uiautomatorServerLibs/uiautomator-stub.jar /data/local/tmp/");
        AdbOperation.excuteCmdWait("adb" + adbDevice + " forward tcp:6008 tcp:6008");
        AdbOperation.execCmdCommand("adb"
                + adbDevice
                + " shell uiautomator runtest bundle.jar uiautomator-stub.jar -c com.github.uiautomatorstub.Stub");
    }
}
