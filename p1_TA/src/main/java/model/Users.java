package model;

public class Users {
    private int usersId;
    private String userName;
    private String userPassword;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private int userRoleId;
    String userRole;

    public Users() {
    }

    public Users(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public Users(int usersId, String userName, String userPassword, String userFirstName, String userLastName, String userEmail, int userRoleId) {
        this.usersId = usersId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userRoleId = userRoleId;
    }

    public Users(int usersId, String userName, String userPassword, String userFirstName, String userLastName, String userEmail, int userRoleId, String userRole) {
        this.usersId = usersId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userRoleId = userRoleId;
        this.userRole = userRole;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "Users{" +
                "Users ID = " + usersId +
                ", Username = '" + userName + '\'' +
                ", User password = '" + userPassword + '\'' +
                ", User First Name = '" + userFirstName + '\'' +
                ", User Last Name = '" + userLastName + '\'' +
                ", User Email = '" + userEmail + '\'' +
                ", User Role Id = " + userRoleId +
                ", User Role = '" + userRole + '\'' +
                '}';
    }
}
