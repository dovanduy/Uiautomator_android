package Test;


import uiautomatorrpc.JsonRpcService;

public class Rpc_start1 {
	  /**
     * <p>Title: TODO.</p>
     * <p>Description: TODO.</p>
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Main start.....");
        
        JsonRpcService rpc = JsonRpcService.getInstance();
        rpc.startClient();
        
        System.out.println("startServer");
        rpc.startServer("emulator-5554");
      //U4J7Y5BANV8POF95
      //e9d1b1d9
      //emulator-5554
//       System.out.println("stopServer");
//       rpc.stopServer("emulator-5554"); 
        
        
        
    }
}
