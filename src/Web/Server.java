package Web;

import Web.InterfaceWeb.ClientServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server implements ClientServer {
    private final int NAME_LENGTH = 100;
    private ServerSocket servac = null;
    private Socket client = null;

    private InputStreamReader inInt;
    private OutputStreamWriter outInt;

    public  Server() throws IOException {
// Создание сервера
        try {
            servac = new ServerSocket(4446);
            System.out.println("Ожидание подключения...");
        } catch (IOException e) {
            System.out.println("Ошибка(порт занят) " + e);
            System.exit(-1);
        }

// Подключение клиента
        try {
            client = servac.accept();
        } catch (IOException e) {
            System.out.println(e);
            System.exit(-1);
        }
        System.out.println("Клиент подключен");

// Создание потоков ввода вывода

        inInt = new InputStreamReader(client.getInputStream());

        outInt = new OutputStreamWriter(client.getOutputStream());
    }

    public void close() throws IOException{
        outInt.close();
        inInt.close();
        client.getInputStream().close();
        client.getOutputStream().close();
        client.close();
        servac.close();
    }

// Методы отправки данных клиенту
    public void out(int c) throws IOException{
        outInt.write(c);
        outInt.flush();
    }
    public void out(String str) throws IOException{
        client.getOutputStream().write(str.getBytes());
        client.getOutputStream().flush();
    }

// Методы получения данных
    public int inInt() throws IOException{
        int a;
        a = inInt.read();
        return a;
    }
    public String inStr() throws IOException{
        byte b[] = new byte[NAME_LENGTH];
        int size;
        size = client.getInputStream().read(b);
        String str = new String(b, 0, size);
        return str;
    }
}

