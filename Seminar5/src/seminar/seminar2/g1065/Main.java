package seminar.seminar2.g1065;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yyyy");

    public static void main(String[] args) {
        try {
            Locatie locatie = new Locatie("Brasov", "Strada 1 Decembrie,nr. 100");
            MijlocFix mijlocFix = new MijlocFix("Autoturism Renault", 111L, 100000,
                    fmt.parse("10.10.2021"),
                    locatie,
                    Categorie.MIJLOACE_TRANSPORT, 10);
            System.out.println(mijlocFix);
            ObiectInventar obiectInventar = new ObiectInventar();
            obiectInventar.setLocatie(locatie);
            obiectInventar.setGestionar("Pop Adrian");
            obiectInventar.setNrInventar(100L);
//            ...
            System.out.println(obiectInventar);
            MijlocFix mijlocFix2 = new MijlocFix(111L);
//            mijlocFix2.setDataAchizitie(fmt.parse("01.01.2023"));
            if (mijlocFix.equals(mijlocFix2)) {
                System.out.println("Obiecte egale.");
            } else {
                System.out.println("Obiecte diferite.");
            }
            System.out.println(mijlocFix.compareTo(mijlocFix2));

            MijlocFix clona = (MijlocFix) mijlocFix.clone();
            mijlocFix.getLocatie().setDenumire("sdauhfiduh");
            System.out.println("Obiect mijloc fix sursa:\n" + mijlocFix);
            System.out.println("Clona:\n" + clona);

            List<MijlocFix> mijloaceFixe = citireDate("mf.csv");
            System.out.println("Mijloace fixe citite din fisier:");
            for (MijlocFix mf : mijloaceFixe) {
                System.out.println(mf);
            }

            System.out.println("Sortare mijloace fixe dupa data achizitie:");
            Collections.sort(mijloaceFixe);
            for (MijlocFix mf : mijloaceFixe) {
                System.out.println(mf);
            }

            System.out.println("Sortare dupa valoare:");
            Collections.sort(mijloaceFixe, new Comparator<MijlocFix>() {
                @Override
                public int compare(MijlocFix mijlocFix, MijlocFix t1) {
                    if (mijlocFix.getValoare() == t1.valoare) {
                        return 0;
                    } else {
                        return mijlocFix.valoare < t1.valoare ? -1 : 1;
                    }
                }
            });
            for (MijlocFix mf : mijloaceFixe) {
                System.out.println(mf);
            }



            System.out.println("Sortare dupa numarul de inventar:");
            Collections.sort(mijloaceFixe,new ComparatorNumarInventar());
            for (MijlocFix mf : mijloaceFixe) {
                System.out.println(mf);
            }

            System.out.println("Cautare");
            mijlocFix2 = new MijlocFix(3);
            int k = mijloaceFixe.indexOf(mijlocFix2);
            if (k==-1){
                System.out.println("Nu am gasit mijlocul fix cu nr inventar="+mijlocFix2.nrInventar);
            } else {
                System.out.println("Mijlocul fix cautat:");
                System.out.println(mijloaceFixe.get(k));
            }

            mijlocFix2.setValoare(500000);
            Comparator<MijlocFix> comparator= new Comparator<MijlocFix>() {
                @Override
                public int compare(MijlocFix mijlocFix, MijlocFix t1) {
                    return Double.compare(mijlocFix.valoare,t1.valoare);
                }
            };

            Collections.sort(mijloaceFixe, comparator);
            k=Collections.binarySearch(mijloaceFixe, mijlocFix2, comparator);
            if(k<0){
                System.out.println("Mijlocul fix "+mijlocFix2);
            }

            System.out.println("Uzura mijloace fixe: ");
            for(MijlocFix mf:mijloaceFixe){
                System.out.println(mf.uzura());
            }

            salvareUzura("uzura.csv",mijloaceFixe);

            System.out.println("Salvare lista.");
            salvare(mijloaceFixe,"mf.dat");

            System.out.println("Restaurare elemente din fisier: ");
            mijloaceFixe=resturare("mf.dat");
            for(MijlocFix mf:mijloaceFixe)
                System.out.println(mf);

        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    public static void salvareUzura(String  numeFisier, List<MijlocFix> mijoaceFixe) throws Exception{
        try(PrintWriter out= new PrintWriter(numeFisier)){
            for(MijlocFix mf:mijoaceFixe){
                out.println(mf.nrInventar+", "+mf.denumire+", "+mf.uzura());
            }
        }
        catch(Exception ex){
            System.err.println(ex);
        }
    }

    public  static void salvare(List<MijlocFix> mijloaceFixe, String numeFisier){
        try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(numeFisier))){
            for(MijlocFix mf:mijloaceFixe){
                out.writeObject(mf);
            }
        }
        catch (Exception ex){
            System.err.println(ex);
        }
    }

    public static List<MijlocFix> resturare(String numeFisier){
        List<MijlocFix> mijloaceFixe= new ArrayList<>();
        try(FileInputStream in1 = new FileInputStream(numeFisier);
            ObjectInputStream in=new ObjectInputStream(in1)){
            while(in1.available() !=0){
                mijloaceFixe.add((MijlocFix) in.readObject());
            }
        }
        catch (Exception ex){
            System.err.println(ex);
        }
        return mijloaceFixe;
    }
    public static List<MijlocFix> citireDate(String numeFisier) {
        List<MijlocFix> mijloaceFixe = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(numeFisier))) {
            String linie;
            while ((linie = in.readLine()) != null) {
                MijlocFix mijlocFix = new MijlocFix();
                String[] elemente = linie.split(",");
                mijlocFix.setDenumire(elemente[0].trim());
                mijlocFix.setNrInventar(Long.parseLong(elemente[1].trim()));
                mijlocFix.setValoare(Double.parseDouble(elemente[2].trim()));
                mijlocFix.setDataAchizitie(fmt.parse(elemente[3].trim()));
                mijlocFix.setCategorie(Categorie.valueOf(elemente[4].trim().toUpperCase()));
                mijlocFix.setDurataNormata(Integer.valueOf(elemente[5].trim()));
                elemente = in.readLine().split(",");
                Locatie locatie = new Locatie(elemente[0].trim(), elemente[1].trim());
                mijlocFix.setLocatie(locatie);
                mijloaceFixe.add(mijlocFix);
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return mijloaceFixe;
    }
}
