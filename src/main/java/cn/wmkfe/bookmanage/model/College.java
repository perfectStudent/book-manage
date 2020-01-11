package cn.wmkfe.bookmanage.model;


import java.util.List;

public class College {

  private long id;
  private String collegeName;
  private List<Major> majorsList;

  public List<Major> getMajorsList() {
    return majorsList;
  }

  public void setMajorsList(List<Major> majorsList) {
    this.majorsList = majorsList;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCollegeName() {
    return collegeName;
  }

  public void setCollegeName(String collegeName) {
    this.collegeName = collegeName;
  }

}
