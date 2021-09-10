package model;

public class UserRoles {
    private int userRoleId;
    private String userRole;

    public UserRoles() {
    }

    public UserRoles(int userRoleId, String userRole) {
        this.userRoleId = userRoleId;
        this.userRole = userRole;
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
        return "UserRoles{" +
                "User Role Id = " + userRoleId +
                ", User Role = '" + userRole + '\'' +
                '}';
    }
}
