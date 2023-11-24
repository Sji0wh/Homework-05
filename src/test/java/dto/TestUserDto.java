package dto;

public class TestUserDto {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;

    private int code;
    private String type;

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public TestUserDto(String username, String firstName, String lastName, String email, String password, String phone) {
        this.id = 0;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userStatus = 0;
    }

    public TestUserDto() {
        this.id = 0;
        this.userStatus = 0;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

}

