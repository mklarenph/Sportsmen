package firstProject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager
{
    private ArrayList<Sportiv> sportsmeni;

    public Manager()
    {
        this.sportsmeni = new ArrayList<Sportiv>();
    }

    public Manager(ArrayList<Sportiv> listSportivi)
    {
        this.sportsmeni = listSportivi;
    }

    public void celMaiInvarstSportivCarePracticaFotbal()
    {
        Sportiv sportsmenulCautat = null;

        for(Sportiv sportsmen: this.sportsmeni)
        {
            if(sportsmen.probaSportiva != "Fotball")
            {
                continue;
            }

            if(sportsmenulCautat == null)
            {
                sportsmenulCautat = sportsmen;
                continue;
            }

            if(sportsmenulCautat.varsta > sportsmen.varsta)
            {
                continue;
            }

            sportsmenulCautat = sportsmen;
        }

        if(sportsmenulCautat == null)
        {
            System.out.println("Nu a fost gasit nici un sportiv dupa criteriul de cautare!");
            return;
        }

        sportsmenulCautat.afisareSportiv();
    }

    public void afisareGreutateaMedie()
    {
        if(this.sportsmeni.size() == 0)
        {
            System.out.println("Nu se poate calcula greutatea medie! Nu sunt sportivi in lista");
            return;
        }

        int sumaGreutati = 0;
        int numarSportivi = this.sportsmeni.size();

        for(Sportiv sportsmen: this.sportsmeni)
        {
            sumaGreutati += sportsmen.greutate;
        }

        System.out.println("Greutatea medie a sportivilor este: " + sumaGreutati/numarSportivi);
    }

    public void adugareSportsmen(Sportiv sportiv)
    {
        this.sportsmeni.add(sportiv);
    }

    public void afisareaTuturorSportivilor()
    {
        for(Sportiv sportiv: this.sportsmeni)
        {
            sportiv.afisareSportiv();
        }
    }

    public void afisareSportivGenFemininEtc()
    {
        ArrayList<Sportiv> sportsmeniiCautati = new ArrayList<Sportiv>();

        for(Sportiv sportsmen: this.sportsmeni)
        {
            if(sportsmen.gen != 'F' || sportsmen.varsta >= 12 || sportsmen.probaSportiva != "Tennis" )
            {
                continue;
            }

            sportsmeniiCautati.add(sportsmen);
        }

        for(Sportiv sportsmen: sportsmeniiCautati)
        {
            sportsmen.afisareSportiv();
        }
    }

    public void afisareCelMaiInailtSportivProba()
    {
        Sportiv sportsmenulCautat = null;

        for(Sportiv sportsmen: this.sportsmeni)
        {
            if(sportsmenulCautat == null)
            {
                sportsmenulCautat = sportsmen;
                continue;
            }

            if(sportsmenulCautat.inaltime > sportsmen.inaltime)
            {
                continue;
            }

            sportsmenulCautat = sportsmen;
        }

        if(sportsmenulCautat == null)
        {
            System.out.println("Nu a fost gasit nici un sportiv dupa criteriul de cautare");
            return;
        }

        System.out.println("Proba celui mai inalt sportiv este: " + sportsmenulCautat.probaSportiva);
    }

    public void afisareCelMaiInailtSportivFemininInotStudiiSuperioare() 
    {
        Sportiv sportsmenulCautat = null;

        for (Sportiv sportsmen : this.sportsmeni) 
        {
            if (sportsmen.gen != 'F' && sportsmen.probaSportiva != "Inot" && sportsmen.studiiSuperioare != "DA") 
            {
                continue;
            }

            if (sportsmenulCautat == null) 
            {
                sportsmenulCautat = sportsmen;
                continue;
            }

            if(sportsmenulCautat.varsta > sportsmen.varsta)
            {
                continue;
            }

            sportsmenulCautat = sportsmen;
        }

        if (sportsmenulCautat == null) 
        {
            System.out.println("Nu a fost gasit nici un sportiv dupa criteriul de cautare");
            return;
        }

        sportsmenulCautat.afisareSportiv();
    }

    public ArrayList<Sportiv> extrageListSportivi()
    {
        return this.sportsmeni;
    }

    public Sportiv citireSportiv()
    {
        Sportiv sportivNou = new Sportiv();
        Scanner scanner = new Scanner(System.in);

        System.out.println("-----------------------------------");
        System.out.print("Cod: ");
        sportivNou.cod = scanner.nextInt();
        
        System.out.print("Nume: ");
        sportivNou.nume = scanner.next();

        System.out.print("Prenume: ");
        sportivNou.prenume = scanner.next();

        System.out.print("Gen: ");
        sportivNou.gen = scanner.next().charAt(0);

        System.out.print("Greutate: ");
        sportivNou.greutate = scanner.nextInt();

        System.out.print("Inaltime: ");
        sportivNou.inaltime = scanner.nextInt();

        System.out.print("Proba Sportiva: ");
        sportivNou.probaSportiva = scanner.next();

        System.out.print("Studii superioare: ");
        sportivNou.studiiSuperioare = scanner.next();

        System.out.print("Varsta: ");
        sportivNou.varsta = scanner.nextInt();

        System.out.print("Data Nasterii (in formatul yyyy-MM-dd): ");
        sportivNou.dataNasterii = LocalDate.parse(scanner.next());

        System.out.println("-----------------------------------");
        scanner.close();

        return sportivNou;
    }
}
