
package servidoressockets;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author MIRKO
 */
public class ClienteTCP {
    public static void main(String args[]){
        BufferedReader consola_input = new BufferedReader(new InputStreamReader(System.in));
        
        DataInputStream entrada;
        DataOutputStream salida;
        Socket socket;
        try {
            socket = new Socket("127.0.0.1", 5000);
            entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());
            
            System.out.println( entrada.readUTF());
            String nombre = consola_input.readLine();
            salida.writeUTF(nombre);
            System.out.println(entrada.readUTF());
            
            //socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
