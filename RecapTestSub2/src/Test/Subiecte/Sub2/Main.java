package Test.Subiecte.Sub2;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        List<Punct> puncte=citireFisier("E:\\Micoma\\Fac\\Faza 2\\S2\\JAVrA\\RecapTestSub2\\src\\puncte.csv");
        System.out.println(NrPct(puncte));
        Map<String, Long> cerinta3 = puncte.stream().collect(Collectors.groupingBy(Punct::getFigura,Collectors.counting()));
        System.out.println("\nCerinta 3:\n");
        cerinta3.keySet().forEach(figura-> System.out.println(figura+": "+cerinta3.get(figura)));
        Cerinta4(puncte);
    }


    public static List<Punct> sortareDesc(List<Punct> puncte){
        List<Punct> cerinta4 = puncte.stream().sorted((p1, p2)->Double.compare(p2.distanta(),p1.distanta())).toList();
        return cerinta4;
    }

    public static void SalvareFisier(String fileName, List<Punct> lista){
        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fileName))){
            for(Punct p:lista){
                out.writeObject(p);
            }
        }
        catch (Exception ex){
            System.err.println(ex);
        }
    }

    public static void Cerinta4(List<Punct> puncte){
        List<Punct> lista=sortareDesc(puncte);
        SalvareFisier("distante1.csv",lista);
    }

    public static int NrPct(List<Punct> puncte){
        int contor=0;
        for(Punct p:puncte){
            contor++;
        }
        return contor;
    }

    public static List<Punct> citireFisier(String FileName){
        List<Punct> puncte = new ArrayList<>();
        try(BufferedReader in = new BufferedReader(new FileReader(FileName))){
            String linie;
            while((linie=in.readLine())!=null){
                Punct p = new Punct();
                String[] elemente=linie.split(",");
                p.setFigura(elemente[0]);
                p.setEticheta(elemente[1]);
                p.setCoordOX(Double.parseDouble(elemente[2]));
                p.setCoordOY(Double.parseDouble(elemente[3]));
                puncte.add(p);
            }
        }
        catch (Exception ex){
            System.err.println(ex);
        }
        return puncte;
    }
}
