/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schuh_nobeldij;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static schuh_nobeldij.Schuh_NobelDij.NobelDijList;
import java.util.Map;

/**
 *
 * @author Soma
 */
public class Schuh_NobelDij{
    static ArrayList<NobelDijAdatok> NobelDijList= new ArrayList<>();
    static ArrayList<String> Tipusok=new ArrayList<>();
    static Map<String, Integer> Statisztika=new HashMap<String, Integer>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.println("\n--------------------\n");
        Feladatat2Beolvasas(); System.out.println("\n--------------------\n");
        Feladat3(); System.out.println("\n--------------------\n");
        Feladat4(); System.out.println("\n--------------------\n");
        Feladat5(); System.out.println("\n--------------------\n");
        Feladat6(); System.out.println("\n--------------------\n");
        Feladat7(); System.out.println("\n--------------------\n");
        Feladat8();
        
    }

    private static void Feladatat2Beolvasas() 
    {
        System.out.println("2.Feladat: Adatok beolvasása");
        try 
        {
            System.setProperty("file.encoding", "UTF8");
            FileReader fajl=new FileReader("nobel.txt");
            int db=0;
            try (BufferedReader br = new BufferedReader(fajl))
            {
                int i=0;
                String sor=null;                
                while ((sor = br.readLine())!=null)
                {
                    String[] dbok=sor.split(";");
                    int Ev=Integer.parseInt(dbok[0]);
                    String Tipus=dbok[1];
                    String Keresztnev=dbok[2];
                    String Vezeteknev=dbok[3];
                    String Nev=dbok[2]+" "+dbok[3];
                    NobelDijAdatok NDA=new NobelDijAdatok(Ev, Tipus, Keresztnev, Vezeteknev, Nev);
                    NobelDijList.add(NDA);
                    db++;                                     
                }
            }
            if(0<db)
            {
                System.out.println("\tSikeres beolvasás, beolvasott sorok száma:  "+db);
            }
            
        } 
        catch (IOException| NumberFormatException e) 
        {
            System.out.println("Hiba: " + e);
        }
    }

    private static void Feladat3() 
    {
        System.out.println("3.Feladat: Határozza meg milyen Nobel-díjat kapott Arthur B. McDonald");
        for (NobelDijAdatok nobelDijAdatok : NobelDijList)
        {
         if(nobelDijAdatok.Nev.contains("Arthur B.  McDonald"))   
         {
             System.out.println("\tArthur B. McDonald -> "+nobelDijAdatok.Tipus +" Nobel-díjat kapott");
         }
        }
    }

    private static void Feladat4()
    {
        System.out.println("4.Feladat: ki kapott 2017-ben irodalmi Nobel-díjat");
        for (NobelDijAdatok nobelDijAdatok : NobelDijList)
        {
            if(nobelDijAdatok.Ev==2017 && nobelDijAdatok.Tipus.contains("irodalmi"))
            {
              System.out.println("\tA 2017-es irodalmi Nobel-díjat: "+nobelDijAdatok.Nev+" kapta");
            }          
        }        
    }

    private static void Feladat5() 
    {
        System.out.println("5.Feladat: Mely szervezetek kaptak napjainkig Béke Nobel-díjat");
        for (NobelDijAdatok nobelDijAdatok : NobelDijList)
        {
            if( 1990 <= nobelDijAdatok.Ev && nobelDijAdatok.Vezeteknev.contains("  ") && nobelDijAdatok.Tipus.contains("béke"))
            {
                System.out.println("\t"+nobelDijAdatok.Ev+" : "+nobelDijAdatok.Nev);
            }
        }
    }

    private static void Feladat6() 
    {
        System.out.println("6.Feladat: Határozza meg, hogy a Curie család mely tagjai kaptak Nobel-díjat");
        for (NobelDijAdatok nda : NobelDijList)
        {
            if(nda.Vezeteknev.contains("Curie"))
            {
                System.out.println("\t "+nda.Ev+" "+nda.Nev+" ->"+ nda.Tipus);
            }
        }
    }

    private static void Feladat7() {
        System.out.println("7.Feladat: határozza meg, melyik Nóbel-díjból hány darabot osztottak ki");
        Tipusok=new ArrayList<String>();
        Statisztika=new HashMap<>();
        for (NobelDijAdatok nobelDijAdatok : NobelDijList)
        {
            if(!Tipusok.contains(nobelDijAdatok.Tipus))
            {
                Tipusok.add(nobelDijAdatok.Tipus);
            }
        }
        for (int i = 0; i < Tipusok.size(); i++)
        {
            //System.out.println("\t"+Tipusok.get(i));   
        }
        for (int i = 0; i < Tipusok.size(); i++)
        {
            int db=0;
            for (int j = 0; j < NobelDijList.size(); j++)
            {
                if(NobelDijList.get(j).Tipus.contains(Tipusok.get(i)))
                {
                   db++; 
                }                    
            }
            Statisztika.put(Tipusok.get(i),db);
            //System.out.println("\t"+Tipusok.get(i)+" : "+db);
        }
        for (Object s : Statisztika.keySet())
        {
            System.out.println("\t"+s+" : "+Statisztika.get(s));
        }
        
    }

    private static void Feladat8()
    {
        System.out.println("8.Feladat: Orvosi Nobel-díjak adatai");
        for (int i = 0; i < NobelDijList.size(); i++)
        {
          if(NobelDijList.get(i).Tipus.contains("orvosi"))  
          {
              System.out.println("\t "+NobelDijList.get(i).Ev+":"+ NobelDijList.get(i).Nev);
          }
        }
        
    }
}
