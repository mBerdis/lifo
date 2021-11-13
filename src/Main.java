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
            ArrayList<String> options = getOptions();
            System.out.println(Arrays.toString(options.toArray()));
            String choice = sc.nextLine();

            switch (choice)
            {
                case "SEVER":
                    if (options.contains("SEVER")) currentPoint[0] = currentPoint[0] - 1;
                    else System.err.println("WRONG MOVE");
                    break;
                case "VYCHOD":
                    if (options.contains("VYCHOD")) currentPoint[1] = currentPoint[1] + 1;
                    else System.err.println("WRONG MOVE");
                    break;
                case "JUH":
                    if (options.contains("JUH")) currentPoint[0] = currentPoint[0] + 1;
                    else System.err.println("WRONG MOVE");
                    break;
                case "ZAPAD":
                    if (options.contains("ZAPAD")) currentPoint[1] = currentPoint[1] - 1;
                    else System.err.println("WRONG MOVE");
                    break;
                default:
                    System.err.println("WRONG MOVE");
                    break;
            }
        }
    }

    public static ArrayList<String> getOptions()
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
        ArrayList<String> options = new ArrayList<>();

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
            options.add("ZAPAD");
            room -= 8;
        }
        if (room >= 4)
        {
            options.add("JUH");
            room -= 4;
        }
        if (room >= 2)
        {
            options.add("VYCHOD");
            room -= 2;
        }
        if (room >= 1)
        {
            options.add("SEVER");
            room -= 1;
        }

        return options;
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
