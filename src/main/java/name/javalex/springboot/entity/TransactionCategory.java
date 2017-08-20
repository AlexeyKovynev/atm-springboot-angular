package name.javalex.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import name.javalex.springboot.enums.TransactionType;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "transaction_category")
@XmlRootElement
public class TransactionCategory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "category_name")
    private String categoryName;

    @Basic(optional = true)
    @Column(name = "category_description")
    private String categoryDescription;

    @JsonIgnore
    @OneToMany(mappedBy = "transactionCategory")
    private Set<AccountTransaction> accountTransactions;

    @SuppressWarnings("unused")
    public TransactionCategory() {
        //empty constructor required for proper entity work
    }

    public TransactionCategory(String categoryName, String categoryDescription, Set<AccountTransaction> accountTransactions) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.accountTransactions = accountTransactions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public Set<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionCategory that = (TransactionCategory) o;

        if (!id.equals(that.id)) return false;
        if (!categoryName.equals(that.categoryName)) return false;
        if (categoryDescription != null ? !categoryDescription.equals(that.categoryDescription) : that.categoryDescription != null)
            return false;
        return accountTransactions != null ? accountTransactions.equals(that.accountTransactions) : that.accountTransactions == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + categoryName.hashCode();
        result = 31 * result + (categoryDescription != null ? categoryDescription.hashCode() : 0);
        return result;
    }
}
