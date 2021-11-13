import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
    static ArrayList<String[]> map = new ArrayList<String[]>();
    static int[] startPoint;

    public static void main(String[] args)
    {
        driverCode();
    }

    public static void driverCode()
    {
        loadMap();
        showMap();
        startPoint = findStart();
        System.out.println(Arrays.toString(startPoint));
    }

    public static void loadMap()
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
