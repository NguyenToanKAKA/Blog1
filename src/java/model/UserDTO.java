package model;

public class UserDTO {
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String avatar; // Avatar của người dùng
    private String city; // Thành phố của người dùng

    public UserDTO() {
    }

    public UserDTO(int userId, String firstName, String lastName, String email, String avatar, String city) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.avatar = avatar;
        this.city = city;
    }

    // Các phương thức getter và setter
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
