package utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 封装常用的adb shell命令
 */
public class AdbOperation {


    private AdbOperation() {

    }

    /**
     * 执行adb shell命令
     */
    public static Process execCmdCommand(String command){
        Process result = null;
        try {
            result = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * this function execute a command
     *
     * @param command
     *            : command what to execute
     */
    public static void excuteCmdWait(String command) {
        StringBuffer log = new StringBuffer();
        log.append("");
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(new String[] { "cmd.exe", "/c", command });
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            do {
                line = bufferedReader.readLine();
                log.append(line);
                log.append("\n");
            } while (line != null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (process != null) {
            process.destroy();
        }
    }

}
