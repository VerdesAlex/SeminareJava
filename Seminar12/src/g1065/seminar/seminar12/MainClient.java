package g1065.seminar.seminar12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.Buffer;

public class MainClient {
    public static void  main(String[] args){
        try(BufferedReader cin=new BufferedReader(new InputStreamReader(System.in))) {
            int optiune;
            while ((optiune=citesteOptiune(cin))!=10){
                switch (optiune){
                    case 5:

                }
            }
        }
        catch (Exception ex){
            System.err.println(ex);
        }

    }

    private static void stopServer(){
        try(Socket socket= new Socket("localhost",2020);
            ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream())){
                out.writeObject("stop");
        }
        catch (Exception ex){
            System.err.println(ex);
        }
    }

    private static int citesteOptiune(BufferedReader cin){
        System.out.println("Optiuni:");
        System.out.println("1 - Returnarea unui mijloc fix după număr inventar");
        System.out.println("5 - Inchidere sever");
        System.out.println("10 - Inchidere client");
        System.out.println("Optiune: ");
        int optiune=-1;
        try{
            optiune=Integer.parseInt(cin.readLine().trim());
        }
        catch(Exception ex){
            System.err.println(ex);
        }
        return optiune;
    }
}
