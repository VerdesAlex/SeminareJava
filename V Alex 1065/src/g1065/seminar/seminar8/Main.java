package g1065.seminar.seminar8;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 50;
//        Double[] x = new Double[n];
//        for (int i = 0; i < n; i++)
//            x[i] = Math.random() * n;
//        SubSir<Double> subSir= new SubSir<>(x,0,n-1);

        Student[] x = new Student[n];

        for(int i =0;i< n;i++)
            x[i]=new Student("Nume"+i, Math.random()*5+5);
        SubSir<Student> subSir = new SubSir<>(x,0,n-1);
//        subSir.sort();

//        Thread fir = new Thread(subSir);
//        fir.start();
//        try {
//            fir.join();
//        }
//        catch (Exception ex){}
        int m=n/2;
        SubSir<Student> subSir1 = new SubSir<>(x,0,m);
        SubSir<Student> subSir2 = new SubSir<>(x, m+1, n-1);

        Thread fir1 = new Thread(subSir1);
        Thread fir2 = new Thread(subSir2);

        fir2.start();
        fir1.start();
        try{
            fir1.join();
            fir2.join();
        }
        catch (InterruptedException ex){}

//        subSir1.interclasare(0, m, n - 1, new Alocare<Student>() {
//            @Override
//            public Student[] aloc(int n) {
//                return new Student[n];
//            }
//        });

        subSir1.interclasare(0,m,n-1,nr->new Student[nr]);
        System.out.println(Arrays.toString(subSir.getX()));
    }
}
