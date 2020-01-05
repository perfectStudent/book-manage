package cn.wmkfe.bookmanage.model;

public class Gender {
    private Integer id;

    private String genderName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName == null ? null : genderName.trim();
    }
}