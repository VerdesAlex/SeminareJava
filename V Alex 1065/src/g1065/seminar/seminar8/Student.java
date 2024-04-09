package g1065.seminar.seminar8;

public class Student implements  Comparable<Student>{
    private String nume;

    private double media;

    public Student() {

    }

    public Student(String nume, double media) {
        this.nume = nume;
        this.media = media;
    }

    @Override
    public String toString() {
        return nume + ", " + media;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    @Override
    public int compareTo(Student student) {
        return Double.compare(media,student.media);
    }
}
