package name.javalex.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "account_transaction")
@XmlRootElement
public class AccountTransaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "transaction_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;

    @Basic(optional = false)
    @Column(name = "amount")
    private Integer amount;

    @Column(name = "note")
    private String note;

    @JoinColumn(name = "transaction_category_id", referencedColumnName = "id")
    @ManyToOne
    private TransactionCategory transactionCategory;

    @JsonIgnore
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User user;

    @SuppressWarnings("unused")
    public AccountTransaction() {
        //empty constructor required for proper entity work
    }

    public AccountTransaction(Date transactionDate, Integer amount, String note, TransactionCategory transactionCategory, User user) {
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.note = note;
        this.transactionCategory = transactionCategory;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public TransactionCategory getTransactionCategory() {
        return transactionCategory;
    }

    public void setTransactionCategory(TransactionCategory transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountTransaction that = (AccountTransaction) o;

        if (!id.equals(that.id)) return false;
        if (!transactionDate.equals(that.transactionDate)) return false;
        if (!amount.equals(that.amount)) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (!transactionCategory.equals(that.transactionCategory)) return false;
        return user.equals(that.user);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + transactionDate.hashCode();
        result = 31 * result + amount.hashCode();
        result = 31 * result + (note != null ? note.hashCode() : 0);
        result = 31 * result + transactionCategory.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }
}
