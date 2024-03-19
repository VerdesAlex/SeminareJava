package seminar.seminar2.g1065;

import java.util.Comparator;

public class ComparatorNumarInventar implements Comparator<MijlocFix> {

    @Override
    public int compare(MijlocFix mijlocFix, MijlocFix t1) {
        if (mijlocFix.nrInventar == t1.nrInventar) {
            return 0;
        } else {
            return mijlocFix.nrInventar < t1.nrInventar ? -1 : 1;
        }
    }
}
