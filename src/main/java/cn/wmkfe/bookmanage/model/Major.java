package cn.wmkfe.bookmanage.model;


import java.util.List;

public class Major {

  private long id;
  private String majorName;
  private long collegeId;
  private List<Class> classList;

  public List<Class> getClassList() {
    return classList;
  }

  public void setClassList(List<Class> classList) {
    this.classList = classList;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getMajorName() {
    return majorName;
  }

  public void setMajorName(String majorName) {
    this.majorName = majorName;
  }


  public long getCollegeId() {
    return collegeId;
  }

  public void setCollegeId(long collegeId) {
    this.collegeId = collegeId;
  }

}
