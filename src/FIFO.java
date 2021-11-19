public class FIFO
{
    private int head;
    private int tail;
    private int buffer;
    private String [] FIFO;

    public FIFO(int buffer)
    {
        this.buffer = buffer;
        head = 0;
        tail = 0;
        FIFO = new String[buffer];
    }

    public void vlozit(String data)
    {
        if (FIFO[head] == null)
        {
            FIFO[head] = data;
            head = increment(head);
        }
        else
        {
            System.err.println("DATA LOST");
        }
    }

    public String vybrat()
    {
        if (FIFO[tail] != null)
        {
            String value = FIFO[tail];
            FIFO[tail] = null;
            tail = increment(tail);
            return value;
        }
        else
            return "NO DATA";
    }
    public void obsah()
    {
        int currIndex = tail;
        if (FIFO[currIndex] == null)
        {
            System.err.println("NO DATA");
        }
        else
        {
            String res = "[ ";
            if (head != tail)
            {
                while (currIndex != head)
                {
                    res += FIFO[currIndex] +", ";
                    currIndex = increment(currIndex);
                }
            }
            else
            {
                do
                {
                    res += FIFO[currIndex] +", ";
                    currIndex = increment(currIndex);
                }
                while (currIndex != head);
            }
            res+= "]";
            System.out.println("Obsah: " +res);
        }
    }

    private int increment(int number)
    {
        if (number >= buffer-1)
        {
            return 0;
        }
        else
            return number+1;
    }

    private int decrement(int number)
    {
        if (number <= 0)
        {
            return buffer-1;
        }
        else
            return number-1;
    }

}
