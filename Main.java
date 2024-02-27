package g1065.seminar.seminar1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Seminar1");
        //vizualizare parametri pusi in edit cnfig
        int n= args.length/2;
        double[][] x = new double[n][];
        for (int i = 0; i < n; i++) {
            int m= Integer.parseInt(args[i*2].trim());
            x[i]= new double[m];
            for (int j = 0; j < m; j++) {
                x[i][j]= Double.parseDouble(args[i*2+1].trim());
            }
        }
        afisareMatrice(x,"matrice initiala: ");
        try {
            x = inserareLinie(x, new double[]{Math.PI, Math.E}, 1);
            afisareMatrice(x,"\n\nMatricea dupa inserare: ");
        }
        catch(Exception e){
            System.err.println(e);
        }
        try{
            x=stergereLinie(x, 1);
            afisareMatrice(x,"\n\nMatricea dupa stergere: ");
            schimbareLinie(x,1,new double[]{9.99,99.9});
            afisareMatrice(x,"Matricea dupa schimbare linia 1: ");
            adaugareValori(x,1,new double[]{100,-100,1000,-1000});
            afisareMatrice(x,"Matricea dupa adaugare elm pe linia 1: ");
        }
        catch(Exception e){
            System.err.println(e);
        }

        double[][][] y=citire();
        if(y!=null){
            for (double[][] v : y) {
                afisareMatrice(v,"\n ");
            }
        }
    }

    private static double[][] inserareLinie(double[][]x, double[] v,int k) throws Exception {
        int n=x.length;
        if(k<0 || k>n) {
            throw new Exception("Index linie invalid!");

        }
        double[][]y = new double[n+1][];
        for (int i = 0; i < k; i++) {
            y[i]= Arrays.copyOf(x[i], x[i].length);
        }
        y[k]=Arrays.copyOf(v,v.length);
        for (int i = k+1; i <= n; i++) {
            y[i]= Arrays.copyOf(x[i-1], x[i-1].length);
        }
        return y;
    }

    private static void adaugareValori(double[][] x, int k, double[] v )throws Exception{
        int n=x.length;
        if(k<0 || k>=n){
            throw new Exception("Linie invalida!");
        }
        double[] y=new double[x[k].length+v.length];
        System.arraycopy(x[k],0,y,0,x[k].length);
        System.arraycopy(v,0,y,x[k].length,v.length);
        x[k]=y;
    }
    private static void schimbareLinie(double[][] x, int k, double[] v) throws Exception {
        int n=x.length;
        if(k<0 || k>=n){
            throw new Exception("Linie invalida!");
        }
        x[k]=v;


    }
    private static double[][] stergereLinie(double[][]x, int k) throws Exception {
        int n=x.length;
        if(k<0 || k>n) {
            throw new Exception("Index linie invalid!");

        }
        double[][]y = new double[n][];
        for (int i = 0; i < k; i++) {
            y[i]= Arrays.copyOf(x[i], x[i].length);
        }
        for (int i = k; i < n; i++) {
            y[i]= Arrays.copyOf(x[i-1], x[i-1].length);
        }
        return y;
    }

    private static void afisareMatrice(double[][] x, String mesaj){
        System.out.println(mesaj);
        for (double[] v:x) {
            System.out.println(Arrays.toString(v));
        }
    }

    private static double[][][] citire() {
        double[][][] x=null;
        try(Scanner scanner=new Scanner(System.in)){
            int n=Integer.parseInt(scanner.nextLine().trim());
            x = new double[n][][];
            double v=0;
            for (int i=0;i<n;i++, v+=1){
                String[] linie=scanner.nextLine().trim().split(",");
                x[i]=new double[linie.length][];
                for (int j = 0; j < x[i].length; j++) {
                    x[i][j]=new double[Integer.parseInt(linie[j].trim())];
                    for (int k = 0; k < x[i][j].length; k++) {
                        x[i][j][k]=v;
                    }
                }
            }

        }
        catch (Exception ex){
            System.err.println(ex);
        }
        return x;
    }

}


