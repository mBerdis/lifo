public class Node
{
    String hodnota;
    Node next;
    Node first;

    public Node(String hodnota)
    {
        this.hodnota = hodnota;
    }

    @Override
    public String toString()
    {
        return "Node{" +
                "hodnota='" + hodnota + '\'' +
                ", next=" + next +
                '}';
    }
}
