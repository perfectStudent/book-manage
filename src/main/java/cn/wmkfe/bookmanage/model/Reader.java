package cn.wmkfe.bookmanage.model;


public class Reader {
  private String readerId;
  private String password;
  private String name;
  private long gender;
  private String avatar;
  private String phone;
  private long collegeId;
  private long majorId;
  private long classId;
  private static  final String role="reader";
  private Class classModel;

  private Gender genderModel;

  private College collegeModel;

  private Major majorModel;

  @Override
  public String toString() {
    return "Reader{" +
            "readerId='" + readerId + '\'' +
            ", password='" + password + '\'' +
            ", name='" + name + '\'' +
            ", gender=" + gender +
            ", avatar='" + avatar + '\'' +
            ", phone='" + phone + '\'' +
            ", collegeId=" + collegeId +
            ", majorId=" + majorId +
            ", classId=" + classId +
            ", classModel=" + classModel +
            ", genderModel=" + genderModel +
            ", collegeModel=" + collegeModel +
            ", majorModel=" + majorModel +
            '}';
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

  public long getGender() {
    return gender;
  }

  public void setGender(long gender) {
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

  public long getCollegeId() {
    return collegeId;
  }

  public void setCollegeId(long collegeId) {
    this.collegeId = collegeId;
  }

  public long getMajorId() {
    return majorId;
  }

  public void setMajorId(long majorId) {
    this.majorId = majorId;
  }

  public long getClassId() {
    return classId;
  }

  public void setClassId(long classId) {
    this.classId = classId;
  }

  public static String getRole() {
    return role;
  }

  public Class getClassModel() {
    return classModel;
  }

  public void setClassModel(Class classModel) {
    this.classModel = classModel;
  }

  public Gender getGenderModel() {
    return genderModel;
  }

  public void setGenderModel(Gender genderModel) {
    this.genderModel = genderModel;
  }

  public College getCollegeModel() {
    return collegeModel;
  }

  public void setCollegeModel(College collegeModel) {
    this.collegeModel = collegeModel;
  }

  public Major getMajorModel() {
    return majorModel;
  }

  public void setMajorModel(Major majorModel) {
    this.majorModel = majorModel;
  }
}
