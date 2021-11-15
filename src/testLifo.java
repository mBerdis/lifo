public class testLifo
{
    public static void main(String[] args)
    {
        LIFO lifo = new LIFO(5);
        System.out.println(lifo);
        lifo.push("jedna");
        System.out.println(lifo);
        System.out.println(lifo.pop());
        System.out.println(lifo);
        System.out.println(lifo.pop());
        lifo.push("dva");
        lifo.push("tri");
        lifo.push("styri");
        System.out.println(lifo);
        System.out.println(lifo.pop());
        System.out.println(lifo);
        lifo.push("pat");
        System.out.println(lifo);
        System.out.println(lifo.pop());
        System.out.println(lifo);
    }
}
