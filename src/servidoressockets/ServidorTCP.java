/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidoressockets;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author MIRKO
 */
public class ServidorTCP {
    public static void main(String args[]){
        DataInputStream entrada;
        DataOutputStream salida;
        ServerSocket servidor;
        Socket socket;
        
        try {
            servidor = new ServerSocket(5000);
            System.out.println("Se inicio el servidor en el puerto 5000");
            
            socket = servidor.accept();
            System.out.println("Cliente aceptado");
            
            entrada = new DataInputStream(socket.getInputStream());
            salida = new DataOutputStream(socket.getOutputStream());
            
            salida.writeUTF("Bienvenido, cual es tu nombre?");
            String texto_recibido = entrada.readUTF();
            salida.writeUTF("hola" + texto_recibido);
            
            servidor.close();
            System.out.println("conexion cerrada");
        } catch (Exception e) {
            System.out.println(e);
        }
                
    }
}
