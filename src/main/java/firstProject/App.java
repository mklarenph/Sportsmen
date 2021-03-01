package firstProject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("\n\n\n");

        Importer importer = new Importer("/Users/bogdankalinovski/Documents/Projects/JavaLearning/com.firstProject/src/main/java/firstProject/Sportsmeni.txt");
        ArrayList<Sportiv> sportiviiImportati = importer.FetchFileData();
        Manager manager = new Manager(sportiviiImportati);

        int rezultat = afiseazaMeniu();
        
        switch (rezultat)
        {
            case 1:
                System.out.println("1) Introducerea unui nou sportiv in fisier;");
                Sportiv sportivNou = manager.citireSportiv();
                manager.adugareSportsmen(sportivNou);
                importer.RewriteFile(manager.extrageListSportivi());
                break;

            case 2:
                System.out.println("1) Afișarea datelor din fișier;");
                manager.afisareaTuturorSportivilor();
                break;

            case 3:
                System.out.println("2) Afișarea celui mai în vârstă sportiv care practică fotbal;");
                manager.celMaiInvarstSportivCarePracticaFotbal();
                break;

            case 4:
                System.out.println("3) Afișarea greutății medii a tuturor sportivilor;");
                manager.afisareGreutateaMedie();
                break;

            case 5:
                System.out.println("4) Afișarea listei sportivilor de gen femenin, sub 12 ani care practică tenisul;");
                manager.afisareSportivGenFemininEtc();
                break;

            case 6:
                System.out.println("5) Afișarea denumirii probei practicată de cel mai înalt sportiv;");
                manager.afisareCelMaiInailtSportivProba();
                break;

            case 7:
                System.out.println("6) Afișarea datelor celui mai înalt sportiv de gen femenin care practică înotul și are studii superioare.");
                manager.afisareCelMaiInailtSportivFemininInotStudiiSuperioare();
                break;

            default:
                System.out.println("!!! ATI INTRODUS UN NUMAR GRESIT !!!");
        }
    }

    public static int afiseazaMeniu()
    {
        System.out.println("----------------------------------------------------------------");
        System.out.println("                    || Meniul de actiuni ||                     ");
        System.out.println("----------------------------------------------------------------");
        System.out.println("     *Pentru a efectua sarcinile, aleceti una din optiuni*   \n");
        System.out.println("1) Introducerea unui nou sportiv in fisier;");
        System.out.println("2) Afișarea datelor din fișier;");
        System.out.println("3) Afișarea celui mai în vârstă sportiv care practică fotbal;");
        System.out.println("4) Afișarea greutății medii a tuturor sportivilor;");
        System.out.println("5) Afișarea listei sportivilor de gen femenin, sub 12 ani care practică tenisul;");
        System.out.println("6) Afișarea denumirii probei practicată de cel mai înalt sportiv;");
        System.out.println("7) Afișarea datelor celui mai înalt sportiv de gen femenin care practică înotul și are studii superioare.");

        int rezultat = 0;
        Scanner scanner = new Scanner(System.in);
        rezultat = scanner.nextInt();

        return rezultat;
    }
}
