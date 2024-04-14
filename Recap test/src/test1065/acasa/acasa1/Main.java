package test1065.acasa.acasa1;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        List<Element> elemMatrice = citiredinFis("E:\\Micoma\\Fac\\Faza 2\\S2\\JAVrA\\Recap test\\src\\matricerara.csv");
        System.out.println("Elementele matricii citite: \n");
        for(Element e : elemMatrice){
            System.out.println(e);
        }
        System.out.println("\nMedia Coloanelor:\n");
//        MedLinie1(elemMatrice);

        Map<Integer, Double> cerinta3 = elemMatrice.stream().collect(Collectors.groupingBy(Element::getColoana, Collectors.averagingDouble((Element::getElement))));
        System.out.println("\nCerinta 3:\n");
        cerinta3.keySet().forEach(coloana -> System.out.println("Index_"+coloana+": "+cerinta3.get(coloana)));
    }

    public static void salvareInBinar(String NumeFisier, List<Element> elemente){
        
    }

    public static List<Element> citiredinFis(String fileName){
        List<Element> ls= new ArrayList<>();
        try(BufferedReader bf=new BufferedReader(new FileReader(fileName))){
            String linie;
            while((linie = bf.readLine())!=null){
                Element elm = new Element();
                String[] elemente = linie.split(",");
                elm.setLinie(Integer.parseInt(elemente[0]));
                elm.setColoana(Integer.parseInt(elemente[1]));
                elm.setElement(Double.parseDouble(elemente[2]));
                ls.add(elm);
            }
        }
        catch (Exception e){
            System.err.println(e);
        }
        return ls;
    }

    public static int nrElmNegative(List<Element> LE){
        int nr=0;
        for(Element e : LE)
            if(e.getElement() < 0 )
                nr++;
        return 1;
    }

    public static int NrLinii(List<Element> e){
        int nrL=0;
        for(Element elm:e){
            if(elm.getLinie()>nrL)
                nrL= elm.getLinie();
        }
        return nrL;
    }

    public static int NrColoane(List<Element> e){
        int nrC=0;
        for(Element elm:e){
            if(elm.getColoana()>nrC)
                nrC= elm.getColoana();
        }
        return nrC;
    }

    public static void MedLinie1(List<Element> LE){
        int nC=NrColoane(LE);
        int nL=NrLinii(LE);
        ArrayList<Double> vector = new ArrayList<>(nC);
        for(int i =0 ;i<nC;i++)
            vector.add(i,0.0);
        for(Element e:LE){
            vector.set(e.getColoana()-1, vector.get(e.getColoana()-1)+e.getElement()/nL);
        }
        System.out.println("\nLista mediilor per coloane:\n");
        for(int i =0 ;i<nC;i++)
            System.out.println("Index_" + i + " : "+vector.get(i));
    }

}
