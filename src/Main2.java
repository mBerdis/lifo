public class Main2
{

    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        System.out.println(list);
        list.append("Uvod");
        list.append("Ciele");
        System.out.println(list);
        System.out.println(list.getLength());
        System.out.println(list.getList());
        list.prepend("last");
        System.out.println(list.getList());
        Node index1 = list.getNode(1);
        System.out.println(index1.hodnota);
        list.setValue(1,"AAAA");
        System.out.println(list.getList());
        list.delete("AAAA");
        System.out.println(list.getList());
        list.delete("last");
        System.out.println(list.getList());
    }
}
