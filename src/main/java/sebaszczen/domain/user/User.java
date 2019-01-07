package sebaszczen.domain.user;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Sex sex;

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public User() {
    }

    private enum Sex {
        WOMAN,MAN,NOTSURE
    }
}
