package g1065.seminar.seminar8;

public class Sir<T> extends Comparable<T> implements Alocare<T> {
    protected T[] x;

    public Sir(T[] x) {
        this.x = x;
    }

    public Sir() {
    }

    public T[] getX() {
        return x;
    }

    public void setX(T[] x) {
        this.x = x;
    }

    public void interclasare(int p, int m, int u, Alocare<T> alocare) {
        int n = u - p + 1;
        T[] tmp = alocare.aloc(n);
        int i = p, j = m + 1, k = 0;
        if (x[i].compareTo(x[j])> 0) {
            tmp[k++] = x[i++];
        } else {
            tmp[k++] = x[j++];
        }


        if (i <= m) {
            for (int l = i; l <= m; l++) {
                tmp[k++] = x[l];
            }
        } else {
            for (int l = j; l <= u; l++) {
                tmp[k++] = x[l];
            }
        }
        x=tmp;
    }

    @Override
    public T[] aloc(int n) {
        return null;
    }

    @Override
    public int compareTo(T t) {
        return 0;
    }

//    @Override
//    public int compareTo(T t) {
//        return ;
//    }
}
