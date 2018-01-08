public class Nominator {


    static {
        System.out.println("Init Nominator class");
    }

    private String name;
    private int nominatorAwardQuantityLimit;
    private float nominatorAwardAmountLimit;
    private int givenAwardQuantity;
    private float givenAwardAmount;

    public Nominator(int nominatorAwardQuantityLimit, float nominatorAwardAmountLimit) {
        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
        this.nominatorAwardAmountLimit = nominatorAwardAmountLimit;
    }

    public Nominator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGivenAwardQuantity() {
        return givenAwardQuantity;
    }

    public void setGivenAwardQuantity(int givenAwardQuantity) {
        this.givenAwardQuantity = givenAwardQuantity;
    }

    public float getGivenAwardAmount() {
        return givenAwardAmount;
    }

    public void setGivenAwardAmount(float givenAwardAmount) {
        this.givenAwardAmount = givenAwardAmount;
    }

    public int getNominatorAwardQuantityLimit() {
        return nominatorAwardQuantityLimit;
    }

    public void setNominatorAwardQuantityLimit(int nominatorAwardQuantityLimit) {
        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
    }

    public float getNominatorAwardAmountLimit() {
        return nominatorAwardAmountLimit;
    }

    public void setNominatorAwardAmountLimit(float nominatorAwardAmountLimit) {
        this.nominatorAwardAmountLimit = nominatorAwardAmountLimit;
    }

    public void nominate(Award award, Nominee nominee) {
        System.out.println("Nominator: " + name + " tries to give an award with amount: " + award.getValue() + " to Nominee: " + nominee.getName());

        // check if Nominator can give this award and Nominee can receive this award
        if ((nominatorAwardQuantityLimit >= givenAwardQuantity + 1) &
                (nominatorAwardAmountLimit >= givenAwardAmount + award.getValue()) &
                (nominee.getNomineeAwardQuantityLimit() >= nominee.getReceivedAwardQuantity() + 1) &
                (nominee.getNomineeAwardAmountLimit() >= nominee.getReceivedAwardAmount() + award.getValue())) {


            // Nominator's award quantity is changed on 1
            givenAwardQuantity++;
            // Nominator's award amount is changed on award amount
            givenAwardAmount = givenAwardAmount + award.getValue();
            // Nominee's award quantity is changed on 1
            final int newReceivedQuantity = nominee.getReceivedAwardQuantity() + 1;
            nominee.setReceivedAwardQuantity(newReceivedQuantity);
            // Nominee's award amount is changed on award amount
            final float newReceivedAmount = nominee.getReceivedAwardAmount() + award.getValue();
            nominee.setReceivedAwardAmount(newReceivedAmount);

            System.out.println("Result: Award is given, Nominator's and Nominee's spend has been changed. " +
                    "Nominator's given spend is: " + givenAwardAmount + ". Nominee's received spend is: " + nominee.getReceivedAwardAmount());


        } else {
            if (nominatorAwardQuantityLimit < givenAwardQuantity + 1) {
                System.out.println("Result: Award is NOT given. Nominator: " + name + " has reached his award quantity limit, which is equal to: "
                        + nominatorAwardQuantityLimit + ". Quantity of awards that Nominator has given: " + givenAwardQuantity);
            }
            if (nominatorAwardAmountLimit < givenAwardAmount + award.getValue()) {
                System.out.println("Result: Award is NOT given. Nominator: " + name + " has reached his award amount limit, which is equal to: "
                        + nominatorAwardAmountLimit + ". Nominator has given: " + givenAwardAmount +
                        ". Award with amount: " + award.getValue() + " cannot be given.");
            }
            if (nominee.getNomineeAwardQuantityLimit() < nominee.getReceivedAwardQuantity() + 1) {
                System.out.println("Result: Award is NOT received. Nominee: " + nominee.getName() + " has reached his award quantity limit, which is equal to: "
                        + nominee.getNomineeAwardQuantityLimit() + ". Quantity of awards that Nominee has received: " + nominee.getReceivedAwardQuantity());
            }
            if (nominee.getNomineeAwardAmountLimit() < nominee.getReceivedAwardAmount() + award.getValue()) {
                System.out.println("Result: Award is NOT received. Nominee: " + nominee.getName() + " has reached his award amount limit, which is equal to: "
                        + nominee.getNomineeAwardAmountLimit() + ". Nominee has received: " + nominee.getReceivedAwardAmount() +
                        ". Award with amount: " + award.getValue() + " cannot be received.");
            }
        }


    }


}



