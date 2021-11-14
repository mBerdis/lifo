import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Karaoke
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        BufferedReader br = new BufferedReader(new FileReader("song.text"));
        FIFO fifo = new FIFO(10);
        String line;
        while ((line = br.readLine()) != null)
        {
            line = line.trim();
            String [] words = line.split(" ");
            int currWord = 0;
            while (currWord < words.length)
            {
                if (sc.nextLine().equals(" "))
                {
                    fifo.obsah();
                }
                else
                {
                    if (r.nextInt(2) == 0)
                    {
                        fifo.vlozit(words[currWord]);
                        currWord++;
                    }
                    else
                    {
                        System.out.println(fifo.vybrat());
                    }
                }
            }

        }

    }
}
