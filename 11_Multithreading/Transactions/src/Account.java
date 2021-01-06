public class Account {
    private long money;
    private String accNumber;
    private volatile boolean isAlive;

    public Account() {
    }

    public Account(String accNumber, long money, boolean isAlive) {
        this.isAlive = isAlive;
        this.accNumber = accNumber;
        this.money = money;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

}
