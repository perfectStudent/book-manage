package cn.wmkfe.bookmanage.model;

public class ClassTable {
    private Integer id;

    private String className;

    private Integer departmentId;

    @Override
    public String toString() {
        return "ClassTable{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }
}