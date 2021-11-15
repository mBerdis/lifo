import java.util.Arrays;

public class LIFO
{
    int top;
    int capacity;
    String[] LIFO;

    public LIFO(int capacity)
    {
        top = -1;
        this.capacity = capacity;
        LIFO = new String[capacity];
    }

    public void push(String data)
    {
        top++;
        if (top > capacity-1)
        {
            top--;
            System.err.println("Stack overflow");
        }
        else
        {
            LIFO[top] = data;
        }
    }

    public String pop()
    {
        if (top==-1)
        {
            return "NO DATA";
        }
        else
        {
             top--;
             return LIFO[top+1];
        }
    }

    @Override
    public String toString()
    {
        String res = "{ ";
        for (int i = 0; i <= top; i++)
        {
            res += LIFO[i] +", ";
        }
        res += "}";
        return "LIFO{" +
                "top=" + top +
                ", capacity=" + capacity +
                ", LIFO[free:" +((capacity-top)-1) +"]=" +res +
                '}';
    }
}
