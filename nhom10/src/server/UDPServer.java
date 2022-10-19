/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import model.Student;
import model.Answer;

/**
 *
 * @author Hi
 */
public class UDPServer {

    private static String SERVER_IP = "10.20.122.67";
    private static int PORT = 9910;
    DatagramPacket receivePacket;
    DatagramSocket serverSocket;
    public static void main(String[] args) throws SocketException, IOException {
        UDPServer udpServer = new UDPServer();
        Student get = udpServer.receiveFile();
        udpServer.sendBack(new Answer(get));
    }

    public UDPServer() throws SocketException {
        this.serverSocket = new DatagramSocket(PORT);
    }

    public Student receiveFile() throws IOException {
        Student g = null;
        byte[] receiveData = new byte[1024];

        try {
            System.out.println("Server is opened on port " + PORT);
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            InetAddress inetAddress = receivePacket.getAddress();
            ByteArrayInputStream bais = new ByteArrayInputStream(
                    receivePacket.getData());
            System.out.println("Receiving file...");
            ObjectInputStream ois = new ObjectInputStream(bais);
            Student studentGet = (Student) ois.readObject();
            if (studentGet != null) {
                System.out.println(studentGet);
                g = studentGet;
                System.out.println("Done!");
            }
        } catch (Exception e) {
            System.err.println(e);
        }             return g;
    }

    private void sendBack(Answer answer) {
        try {
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            System.out.println(IPAddress + " " + port);
            ByteArrayOutputStream bStream = new ByteArrayOutputStream();
            ObjectOutput oo = new ObjectOutputStream(bStream);
            oo.writeObject(answer);
            byte[] sendData = bStream.toByteArray();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        } catch (SocketException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);

        }
    } //To change body of generated methods, choose Tools | Templates.
}


