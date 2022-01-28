package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server{

    private static List<ClientHandler> clients=new ArrayList();

    public static List<ClientHandler> getClients(){
        return clients;
    }

    public static void main(String[] args) {
        ServerSocket serverSocket= null;
        int clientCount=0;
        try {
            serverSocket = new ServerSocket(5454);
            System.out.println("Server is waiting...");
            while(true){
                Socket socket= null;
                try {
                    socket = serverSocket.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Client connected "+ ++clientCount);
                ClientHandler client= new ClientHandler(socket,Integer.toString(clientCount));
                clients.add(client);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
