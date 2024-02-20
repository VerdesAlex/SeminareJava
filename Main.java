package g1065.seminar.seminar1;

import java.util.Arrays;

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
        }
        catch(Exception e){
            System.err.println(e);
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

}


