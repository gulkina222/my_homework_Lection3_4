public class Lection4Homework {


    public static void main(String[] args) {

        /**
         * create new object Nominator with parameters: max quantity of award that can give Nominator; max amount of award that can give Nominator
         * */
        Nominator nominator = new Nominator(5, 800.00f);
        nominator.setName("Liam");

        /**
         * create new object Nominee with parameters: max quantity of award that can receive Nominee; max amount of award that can receive Nominee
         */
        Nominee nominee = new Nominee(4, 900.00f);
        nominee.setName("Patrick");

        Award a, b, c, d, e, f, g;
        a = new Award(25);
        b = new Award(50);
        c = new Award(100);
        d = new Award(150);
        e = new Award(250);
        f = new Award(500);
        g = new Award(0);

        /**
         * call 'nominate' method until nominator's or nominee's Award Amount or Award Quantity restrictions will happen
         * */

        nominator.nominate(b, nominee);
        nominator.nominate(c, nominee);
        nominator.nominate(d, nominee);
        nominator.nominate(e, nominee);
        nominator.nominate(f, nominee);
        nominator.nominate(a, nominee);
        nominator.nominate(g, nominee);
    }
}
