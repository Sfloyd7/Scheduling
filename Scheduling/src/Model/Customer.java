package Model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Customer {

    private Integer CustomerId;
    private String CustomerName;
    private String Address;
    private String PostalCode;
    private String Phone;
    private LocalDateTime CreateDate;
    private String CreateBy;
    private LocalDateTime LastUpdate;
    private String UpdateBy;
    private Integer DivisionId;

    public Customer(Integer customerId, String customerName, String address, String postalCode, String phone, LocalDateTime createDate, String createBy, LocalDateTime lastUpdate, String updateBy, Integer divisionId) {
        CustomerId = customerId;
        CustomerName = customerName;
        Address = address;
        PostalCode = postalCode;
        Phone = phone;
        CreateDate = createDate;
        CreateBy = createBy;
        LastUpdate = lastUpdate;
        UpdateBy = updateBy;
        DivisionId = divisionId;
    }

    public Integer getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
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

    public int getDivisionId() {
        return DivisionId;
    }

    public void setDivisionId(Integer divisionId) {
        DivisionId = divisionId;
    }

    @Override
    public String toString(){
        return (CustomerName);
    }
}
