package name.javalex.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Set;

@Entity
@Table(name = "authorities")
@XmlRootElement
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    private String username;

    private String authority;

    @OneToMany(mappedBy = "authority")
    @JsonIgnore
    private Set<User> users;

    @SuppressWarnings("unused")
    public Authority() {
        //empty constructor required for proper entity work
    }

    public Authority(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authority authority1 = (Authority) o;

        if (id != null ? !id.equals(authority1.id) : authority1.id != null) return false;
        if (username != null ? !username.equals(authority1.username) : authority1.username != null) return false;
        if (authority != null ? !authority.equals(authority1.authority) : authority1.authority != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (authority != null ? authority.hashCode() : 0);
        return result;
    }
}
