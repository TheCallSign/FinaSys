/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finasys;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.drda.NetworkServerControl;

/**
 *
 * @author stjohn
 */
public class ServerThread extends Thread {

    private NetworkServerControl server;
    public ServerThread(){
    }
    public void shutdown() throws Exception {
        System.out.println("[Server Thread] Stopping Derby server.");
        server.shutdown();
    }

    @Override
    public void run() {
        try {
            server = new NetworkServerControl();
            System.out.println("[Server Thread] Starting Derby server...");
            PrintWriter pw = new PrintWriter(System.out);
            server.start(null);
        } catch (Exception ex) {
            Logger.getLogger(FinaSys.class.getName()).log(java.util.logging.Level.WARNING, null, ex);
        }
    } 
}
