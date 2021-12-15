public class LinkedList
{
    Node first;

   public void append(String x)
    {
        Node newNode = new Node(x);
        if (first == null)
        {
            first = newNode;
        }
        else
        {
        Node i = first;
        while (true)
        {
            if (i.next == null)
            {
                i.next = newNode;
                break;
            }
            i = i.next;
        }  }
    }

    public void prepend(String x) {
        Node node = new Node(x);
        node.next = first;
        first = node;
    }
    public int getLength()
    {
        int length = 0;
        for (Node i = first; i != null ; i = i.next)
        {
            length++;
        }
        return length;
    }
    public String getList()
    {
        String res = "";
        for (Node i = first; i != null ; i = i.next)
        {
            res+=i.hodnota +"->";
        }
        return res;
    }
    public Node getNode(int index){
        int currIndex = 0;
        for (Node i = first; i!=null ; i = i.next) {
            if (index == currIndex){
                return i;
            }
            currIndex++;
        }
        return null;
    }
    public String getValue(Node ukazovatel) {
       if (ukazovatel==null) return null;
        for (Node i = first; i != null; i = i.next) {
            if (ukazovatel == i) {
                return i.hodnota;
            }
        }
        return null;
    }
    public void setValue(int index, String value) {
        int currIndex = 0;
        for (Node i = first; i!=null ; i = i.next) {
            if (index == currIndex){
                i.hodnota = value;
                break;
            }
            currIndex++;
        }
    }
    public void delete(String value) {
           for (Node i = first; i!=null ; i = i.next)
           {
               if (i.next.hodnota.equals(value))
               {
                   i.next = i.next.next;
               }

           }
    }
    @Override
    public String toString()
    {
        return "LinkedList{" +
                "first=" + first +
                '}';
    }
}
