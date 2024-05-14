package g1065.seminar.seminar12;
import seminar.seminar2.g1065.MijlocFix;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.List;

public class MainServer implements AutoCloseable{
    private ServerSocket serverSocket;
    private boolean stopServer;

    private List<MijlocFix> mijloaceFixe;
    public MainServer() throws  Exception{
        serverSocket=new ServerSocket(2020);
    }

    public static void main(String[] args){
        try(MainServer appServer = new MainServer()){
            appServer.start();
        }
        catch (Exception ex){
            System.err.println(ex);
        }
    }

    public void start() throws Exception{
        System.out.println("Start Auschwitz!");
        citireDate();
        while(!stopServer){
            try{
                Socket socket = serverSocket.accept();
                Thread firStreang = new Thread(()->prelucrareCerere(socket));
                firStreang.start();
            }
            catch(Exception ex){
                System.err.println(ex);
            }
        }
    }

    private void citireDate() throws Exception{
        try(Connection c = DriverManager.getConnection("jdbc:sqlite:g1065.db")){
            System.out.println("Conexiune creata");
            DatabaseMetaData dbmt=c.getMetaData();
            try(ResultSet rdbm = dbmt.getTables(null,null,"MIJLOACE_FIXE", new String[]{"TABLE"})){
                if(!rdbm.next()){
                    System.out.println("Tabela MIJLOACE_FIXE nu exista!");
                    System.out.println("Creare tabela.");
                    try(Statement statement = c.createStatement()){
                        String comandaCreare = "create table MIJLOACE_FIXE("+
                                "denumire varchar(30),"+
                        "nr_inventar bigint primary key, " +
                        "valoare double,"+
                        "data_achizitie varchar(10),"+
                        "categorie varchar(30),"+
                        "durata_normata integer,"+
                        "locatie varchar(50)"+
                        ")";
                        statement.executeUpdate(comandaCreare);
                        System.out.println("Tabela creata.");
                    }
                }
            }
        }
    }

    public void prelucrareCerere(Socket socket) {
        try(
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream())
        ){
                String mesaj=in.readObject().toString();
                switch (mesaj.toLowerCase()){
                    case "stop":
                        stopServer=  true;
                        break;

                }
        }
        catch (Exception ex){
            System.err.println(ex);
        }

    }
    @Override
    public void close() throws Exception{
        System.out.println("Inchidere Auschwitz!");
        if(!serverSocket.isClosed()){
            serverSocket.close();
        }
    }
}
