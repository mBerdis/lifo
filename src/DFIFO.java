public class DFIFO
{
    private Node head;
    private Node tail;

    public void vlozit(String slovo)
    {
        Node temp = new Node(slovo);

        if (head == null && tail == null)
        {
            head = temp;
            tail = temp;
        }
        else
        {
            head.next = temp;
            head = temp;
        }
    }

    public String vybrat()
    {
        String pomocna = "";

        if (tail == null)
        {
            System.err.println("404 - No value at that index.");
        }
        else
        {
            pomocna = tail.hodnota;
            tail = tail.next;
            if(tail == null)
            {
                head = null;
            }
        }
        return pomocna;
    }

    @Override
    public String toString()
    {
        return "DFIFO{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
}
