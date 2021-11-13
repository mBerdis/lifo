import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    static ArrayList<String[]> map = new ArrayList<String[]>();
    static int[] startPoint;
    static int[] currentPoint;

    public static void main(String[] args)
    {
        driverCode();
    }

    public static void driverCode()
    {
        loadMap();
        showMap();

        startPoint = findStart();
        System.out.println("START > " + Arrays.toString(startPoint));

        currentPoint = startPoint;

        gameplayLoop();
    }

    public static void gameplayLoop()
    {
        Scanner sc = new Scanner(System.in);

        while(true)
        {
            getOptions();
            String choice = sc.nextLine();
        }
    }

    public static void getOptions()
    {
        /*
        Vysvetlivky:
        DVERE NA SEVER +1
        DVERE NA VYCHOD +2
        DVERE NA JUH +4
        DVERE NA ZAPAD +8
        START +16
        KLUC +32
        */

        int room = Integer.parseInt(map.get(currentPoint[0])[currentPoint[1]]);

        // reset values to common ground so you can then calculate door that room has
        if (room > 32)
        {
            // TODO mas kluc
            room -= 32;
        }
        else if (room > 16)
        {
            room -= 16;
        }

        if (room >= 8)
        {
            // TODO dvere na zapad
            System.out.println("ZAPAD");
            room -= 8;
        }
        if (room >= 4)
        {
            // TODO dvere na juh
            System.out.println("JUH");
            room -= 4;
        }
        if (room >= 2)
        {
            // TODO dvere na vychod
            System.out.println("VYCHOD");
            room -= 2;
        }
        if (room >= 1)
        {
            // TODO dvere na sever
            System.out.println("SEVER");
            room -= 1;
        }

    }

    public static void loadMap()
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("labyrint.txt"));
            String line = br.readLine();
            while (line != null)
            {
                String[] tempArr = line.split(" ");
                map.add(tempArr);
                line = br.readLine();
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void showMap()
    {
        for (String[] line: map)
        {
            System.out.println(Arrays.toString(line));
        }
    }

    public static int[] findStart()
    {
//        for (String[] line: map)
//        {
//            for (String room: line)
//            {
//                if (Integer.parseInt(room) > 16 && Integer.parseInt(room) < 32)
//                {
//                    return
//                }
//            }
//        }

        for (int i = 0; i < map.size(); i++)
        {
            for (int j = 0; j < map.get(i).length; j++)
            {
                if (Integer.parseInt(map.get(i)[j]) > 16 && Integer.parseInt(map.get(i)[j]) < 32)
                {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

}
