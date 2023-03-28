/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidoressockets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MIRKO
 */
public class ServidorUDP {
   
    public static void main(String args[]) throws IOException{
        DatagramSocket socketUDP;
        byte[] buffer ;
        DatagramPacket peticion;
        DatagramPacket respuesta;
        
        try {
            socketUDP = new DatagramSocket(6000);
            System.out.println("Servidor UDP corriendo en el puerto 6000");
            while (true) {              
                buffer = new byte[1024];
                
                peticion = new DatagramPacket(buffer, buffer.length);
                socketUDP.receive(peticion);
                
                respuesta = new DatagramPacket(peticion.getData(), peticion.getLength(), peticion.getAddress(), peticion.getPort());
                socketUDP.send(respuesta);
            }
        } catch (SocketException ex) {
            Logger.getLogger(ServidorUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
