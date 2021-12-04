public class Main
{
    public static void main(String[] args)
    {
        DFIFO test = new DFIFO();
        System.out.println(test.toString());
        test.vlozit("TEST");
        System.out.println(test.toString());
        test.vlozit("JE");
        System.out.println(test.toString());
        System.out.println(test.vybrat());
        System.out.println(test.vybrat());
        System.out.println(test.vybrat());
        System.out.println(test.vybrat());
    }
}
