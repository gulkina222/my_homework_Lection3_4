public class Award {


    static {
        System.out.println("Init Award class");
    }

    private final int value;
    public float soli;

    public Award(int value, float soli) {
        this.value = value;
        this.soli = soli;
    }

    public Award(int x) {
        value = x;
    }

    public float getSoli() {
        return soli;
    }

    public void setSoli(float soli) {
        this.soli = soli;
    }

    public int getValue() {
        return value;
    }


}



