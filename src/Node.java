public class Node
{
    String hodnota;
    Node next;

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
