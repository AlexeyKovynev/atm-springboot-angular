package name.javalex.springboot.model;

import java.util.List;

public class Withdrawal {

    private String amount;
    private List<Integer> banknotes;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public List<Integer> getBanknotes() {
        return banknotes;
    }

    public void setBanknotes(List<Integer> banknotes) {
        this.banknotes = banknotes;
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "amount='" + amount + '\'' +
                ", banknotes=" + banknotes +
                '}';
    }
}
