package cn.wmkfe.bookmanage.model;

public class Reader {
    private String readerId;

    private String password;

    private String name;

    private Integer gender;

    private String avatar;

    private String phone;

    private Integer department;

    private Integer classId;

    private Book book;

    private ClassTable classTable;

    private Gender genderModel;

    private Department departmentModel;

    public Department getDepartmentModel() {
        return departmentModel;
    }

    public void setDepartmentModel(Department departmentModel) {
        this.departmentModel = departmentModel;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public ClassTable getClassTable() {
        return classTable;
    }

    public void setClassTable(ClassTable classTable) {
        this.classTable = classTable;
    }

    public Gender getGenderModel() {
        return genderModel;
    }

    public void setGenderModel(Gender genderModel) {
        this.genderModel = genderModel;
    }
}