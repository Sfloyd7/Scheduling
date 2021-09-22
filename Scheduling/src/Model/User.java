package Model;

import java.time.LocalDateTime;

public class User {
    private int UserId;
    private String UserName;
    private String Password;
    private LocalDateTime CreateDate;
    private String CreateBy;
    private LocalDateTime LastUpdate;
    private String UpdateBy;

    public User(int userId, String userName, String password, LocalDateTime createDate, String createBy, LocalDateTime lastUpdate, String updateBy) {
        UserId = userId;
        UserName = userName;
        Password = password;
        CreateDate = createDate;
        CreateBy = createBy;
        LastUpdate = lastUpdate;
        UpdateBy = updateBy;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public LocalDateTime getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        CreateDate = createDate;
    }

    public String getCreateBy() {
        return CreateBy;
    }

    public void setCreateBy(String createBy) {
        CreateBy = createBy;
    }

    public LocalDateTime getLastUpdate() {
        return LastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        LastUpdate = lastUpdate;
    }

    public String getUpdateBy() {
        return UpdateBy;
    }

    public void setUpdateBy(String updateBy) {
        UpdateBy = updateBy;
    }
}
