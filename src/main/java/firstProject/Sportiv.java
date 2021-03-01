package firstProject;

import java.time.LocalDate;

public class Sportiv
{
    public int cod;
    public String nume;
    public String prenume;
    public char gen;
    public int greutate;
    public int inaltime;
    public String probaSportiva;
    public String studiiSuperioare;
    public int varsta;
    public LocalDate dataNasterii;

    public Sportiv(int cod, String nume, String prenume, char gen, int greutate, int inaltime, String probaSportiva, String studiiSuperioare, int varsta, LocalDate dataNasterii)
    {
        this.cod = cod;
        this.nume = nume;
        this.prenume = prenume;
        this.gen = gen;
        this.greutate = greutate;
        this.inaltime = inaltime;
        this.probaSportiva  = probaSportiva;
        this.studiiSuperioare = studiiSuperioare;
        this.varsta = varsta;
        this.dataNasterii  = dataNasterii;
    }

    public Sportiv()
    {

    }

    public void afisareSportiv()
    {
        System.out.println("\n===============================");
        System.out.println("Cod: " + String.valueOf(this.cod));
        System.out.println("Nume: " + this.nume);
        System.out.println("Prenume: " + this.prenume);
        System.out.println("Gen: " + this.gen);
        System.out.println("Greutate: " + String.valueOf(this.greutate));
        System.out.println("Inaltime: " + this.inaltime);
        System.out.println("Proba Sportiva: " + this.probaSportiva);
        System.out.println("Studii superioare: " + this.studiiSuperioare);
        System.out.println("Varsta: " + this.varsta);
        System.out.println("Data Nasterii: " + this.dataNasterii);
        System.out.println("===============================\n");
    }
}
