public class Account implements Comparable<Account> {
    private long money;
    private String accNumber;
    private volatile boolean isAlive;
    public Integer id;

    public Account() {
    }

    public Account(String accNumber, long money, boolean isAlive, int id) {
        this.isAlive = isAlive;
        this.accNumber = accNumber;
        this.money = money;
        this.id = id;
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

    public Integer getId() {
        return id;
    }


    @Override
    public int compareTo(Account account) {

        return this.id.compareTo(account.id);
    }
}
