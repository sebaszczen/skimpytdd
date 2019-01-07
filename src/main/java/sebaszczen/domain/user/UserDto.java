package sebaszczen.domain.user;

import java.util.Date;

public class UserDto {
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Sex sex;
    private Date creationDate;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Sex getSex() {
        return sex;
    }

    enum Sex{
        MAN,WOMAN,NOTSURE
    }

    UserDto(UserBuilder userBuilder) {
        this.name = userBuilder.name;
        this.lastName = userBuilder.lastName;
        this.email = userBuilder.email;
        this.password = userBuilder.password;
        this.sex = userBuilder.sex;
    }

    public static class UserBuilder {
        private String name;
        private String lastName;
        private String email;
        private String password;
        private Sex sex;

        public void setName(String name) {
            this.name = name;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setSex(Sex sex) {
            this.sex = sex;
        }

        public UserDto build() {
            return new UserDto(this);
        }
    }
}
