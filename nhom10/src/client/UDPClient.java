/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import model.Answer;
import model.Student;

/**
 *
 * @author Hi
 */
public class UDPClient {

    private static String SERVER_IP = "10.20.122.67";
    private static int PORT = 9910;
    public final static byte[] BUFFER = new byte[4096];
    private static DatagramSocket mySocket;

    public static void main(String[] args) throws SocketException {
        mySocket = new DatagramSocket();
        UDPClient client = new UDPClient();
        Student tao = new Student("B19DCCN208", "Nguyen Dinh Truong Giang", 10);
        client.send(tao);
        client.receive();
    }

    public void send(Student s) {
        try {
            ByteArrayOutputStream bStream = new ByteArrayOutputStream();
            ObjectOutput oo = new ObjectOutputStream(bStream);
            oo.writeObject(s);
            oo.close();
            byte[] serializedMessage = bStream.toByteArray();
            InetAddress address = InetAddress.getByName(SERVER_IP);
            DatagramPacket sendPakage = new DatagramPacket(serializedMessage, serializedMessage.length, address, PORT);
            mySocket.send(sendPakage);
            System.out.println("OKE! Student: " + s);
        } catch (Exception e) {

        }
    }

    public void receive() {
        try {
            DatagramPacket receivePacket = new DatagramPacket(BUFFER, BUFFER.length);
            mySocket.receive(receivePacket);
            ByteArrayInputStream bais = new ByteArrayInputStream(BUFFER);
            ObjectInputStream ois = new ObjectInputStream(bais);
//           byte[] received = receivePacket.getData();
            Answer answerReceive = (Answer)ois.readObject() ;
            System.out.println("OKE! Answer: " + answerReceive.toString());
        } catch (Exception e) {

        }
    }
}
