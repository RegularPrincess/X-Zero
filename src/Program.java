import PlayingPlace.PlaceForNullX;
import Web.Server;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by user on 28.12.2014.
 */
public class Program {
    private  static PlaceForNullX place;
    private static Scanner sc;
    private static Server server;
    private static String namePlayer0 = null;
    private static String namePlayerX = null;
    private static int i, j;

    private static void stepPlayer0() throws IOException{
        System.out.print("Ваш ход: ");
        i = sc.nextInt();
        j = sc.nextInt();
        if (place.setValue(i - 1, j - 1, 0 )){
            place.print();
        }else {
            System.out.println("Сделайте другой ход: ");
            stepPlayer0();
        }
        server.out(i);
        server.out(j);
    }
    private static void stepPlayerX() throws IOException{
        System.out.println("Ожидание хода противника...");
        i = server.inInt();
        j = server.inInt();
        if(place.setValue(i - 1, j - 1, 1)) {
            place.print();
        }else{
            System.out.println("Противник сделал не корректный ход.");
            stepPlayerX();
        }
    }

    public static void main(String[] args) throws IOException{
        place = new PlaceForNullX();
        sc = new Scanner(System.in);
        server = new Server();
        System.out.print("Введите имя: ");
        namePlayer0 = sc.nextLine();
        server.out(namePlayer0);
        System.out.println();
        System.out.print("Ожидание имени соперника...: ");
        namePlayerX = server.inStr();
        System.out.println(namePlayerX);

        Random random = new Random(namePlayer0.length() + namePlayerX.length());
        int rand = random.nextInt(2);
        server.out(rand);

        if (rand == 0) {
            while (true) {
                stepPlayer0();
                if (place.win0()) {
                    System.out.println(namePlayer0 + " победил!");
                    break;
                }
                stepPlayerX();
                if (place.win1()) {
                    System.out.println(namePlayerX + " победил!");
                    break;
                }
            }
        }else{
            while (true) {
                stepPlayerX();
                if (place.win1()) {
                    System.out.println(namePlayerX + " победил!");
                    break;
                }
                stepPlayer0();
                if (place.win0()) {
                    System.out.println(namePlayer0 + " победил!");
                    break;
                }
            }
        }
        server.close();
    }
}
