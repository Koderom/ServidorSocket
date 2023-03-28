
package servidoressockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author MIRKO
 */
public class ClienteUDP {
    public static void main(String args[]){
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        InetAddress address;
        int puerto = 6000;
        
        DatagramSocket socketUDP;
        DatagramPacket peticion;
        DatagramPacket respuesta;
        byte[] buffer = new byte[1024];
        
        try {
            address = InetAddress.getLocalHost();
            socketUDP = new DatagramSocket();
            String mensaje = "";
            
            mensaje = leer.readLine();
            buffer = mensaje.getBytes();

            peticion = new DatagramPacket(buffer, buffer.length, address, puerto);
            socketUDP.send(peticion);
            
            byte res[] = new byte[1024];
            respuesta = new DatagramPacket(res, res.length);
            socketUDP.receive(respuesta);
            System.out.println(new String(respuesta.getData()));

            socketUDP.close();
            
        } catch (Exception e) {
        }
    }
}
