package firstProject;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.time.LocalDate;

public class Importer 
{
    private String path;
    
    public Importer(String path)
    {

        this.path = path;
    }    

    public ArrayList<Sportiv> FetchFileData()
    {
        File file = new File(this.path);

        ArrayList<Sportiv> listSportivi = new ArrayList<Sportiv>();

        try
        {
            Scanner scan = new Scanner(file);
            String rowContent = null;

            while (scan.hasNextLine())
            {
                rowContent = scan.nextLine();
                String[] coloane = rowContent.split(", ");

                if(coloane.length < 9)
                {
                    throw new Exception("Linia nu contine toate proprietatile sportivului");
                }

                Sportiv sportiv = new Sportiv();
                sportiv.cod = Integer.parseInt(coloane[0]);
                sportiv.nume = coloane[1];
                sportiv.prenume = coloane[2];
                sportiv.gen = coloane[3].charAt(0);
                sportiv.greutate = Integer.parseInt(coloane[4]);
                sportiv.inaltime = Integer.parseInt(coloane[5]);   
                sportiv.probaSportiva = coloane[6];
                sportiv.studiiSuperioare = coloane[7];
                sportiv.varsta = Integer.parseInt(coloane[8]);
                sportiv.dataNasterii = LocalDate.parse(coloane[9]);

                listSportivi.add(sportiv);
            }
        }
        catch(FileNotFoundException exception)
        {
            System.out.println("Fisierul nu a fost gasit");
        }
        catch(Exception exception)
        {
            System.out.println("Au aparut errori la parsarea fisierului:");
            System.out.println(exception.getMessage());
        }

        return listSportivi;
    }

    public void RewriteFile(ArrayList<Sportiv> listaSportivi)
    {
        if(listaSportivi.size() == 0)
        {
            System.out.println("Nu ai nici un sportiv in lista. Nu ai ce importa");
            return;
        }

        try
        {
            FileWriter writer = new FileWriter(this.path);
            String fileContent = "";

            for(Sportiv sportiv: listaSportivi)
            {
                fileContent += sportiv.cod + ", ";
                fileContent += sportiv.nume + ", ";
                fileContent += sportiv.prenume + ", ";
                fileContent += sportiv.gen + ", ";
                fileContent += sportiv.greutate + ", ";
                fileContent += sportiv.inaltime + ", ";
                fileContent += sportiv.probaSportiva + ", ";
                fileContent += sportiv.studiiSuperioare + ", ";
                fileContent += sportiv.varsta + ", ";
                fileContent += sportiv.dataNasterii + "\n";
            }

            writer.write(fileContent);
            writer.close();
        }
        catch(Exception exception)
        {
            System.out.println("A aparut o eroare in timpul inscrierii in fisier:");
            System.out.println(exception.getMessage());
        }

        System.out.println("Importul s-a efecutat cu succes!");
    }
}
