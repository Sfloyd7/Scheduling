package Model;

import java.sql.Timestamp;

public class Countries {

    private int CountryId;
    private String Country;
    private Timestamp CreateDate;
    private String CreateBy;
    private Timestamp LastUpdated;
    private String UpdatedBy;

    public int getCountryId() {
        return CountryId;
    }

    public void setCountryId(int countryId) {
        CountryId = countryId;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public Timestamp getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Timestamp createDate) {
        CreateDate = createDate;
    }

    public String getCreateBy() {
        return CreateBy;
    }

    public void setCreateBy(String createBy) {
        CreateBy = createBy;
    }

    public Timestamp getLastUpdated() {
        return LastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        LastUpdated = lastUpdated;
    }

    public String getUpdatedBy() {
        return UpdatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        UpdatedBy = updatedBy;
    }

    public Countries(int countryId, String country, Timestamp createDate, String createBy, Timestamp lastUpdated, String updatedBy) {
        CountryId = countryId;
        Country = country;
        CreateDate = createDate;
        CreateBy = createBy;
        LastUpdated = lastUpdated;
        UpdatedBy = updatedBy;
    }

    @Override
    public String toString(){
        return (Country);
    }


}
