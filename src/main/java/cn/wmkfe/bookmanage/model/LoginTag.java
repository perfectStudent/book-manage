package cn.wmkfe.bookmanage.model;

public class LoginTag {
    private Object obj;

    public Object getObj() {
        return obj;
    }

    public LoginTag(Object obj) {
        this.obj=obj;
    }

    public String getLoginTagUserName() {
        if (Reader.class == obj.getClass()) {
            Reader reader = (Reader) obj;
            return reader.getName();
        } else {
            Admin admin = (Admin) obj;
            return admin.getAdminName();
        }
    }

    public String getLoginTagClassName() {
        if (Reader.class == obj.getClass()) {
            Reader reader = (Reader) obj;
            return reader.getClassModel().getClassName();
        }
        return null;
    }

    public String getLoginTagMajorName() {
        if (Reader.class == obj.getClass()) {
            Reader reader = (Reader) obj;
            return reader.getMajorModel().getMajorName();
        }
        return null;
    }

    public String getLoginTagCollegeName() {
        if (Reader.class == obj.getClass()) {
            Reader reader = (Reader) obj;
            return reader.getCollegeModel().getCollegeName();
        }
        return null;
    }

    public String getLoginTagRole() {
        if (Reader.class == obj.getClass()) {
            Reader reader = (Reader) obj;
            return reader.getRole();
        } else {
            Admin admin = (Admin) obj;
            return admin.getRole();
        }
    }

    public String getLoginTagPhone() {
        if (Reader.class == obj.getClass()) {
            Reader reader = (Reader) obj;
            return reader.getPhone();
        }
        return null;
    }

    public String getLoginTagGenderName() {
        if (Reader.class == obj.getClass()) {
            Reader reader = (Reader) obj;
            return reader.getGenderModel().getGenderName();
        }
        return null;
    }

    public String getLoginTagId() {
        if (Reader.class == obj.getClass()) {
            Reader reader = (Reader) obj;
            return reader.getReaderId();
        } else {
            Admin admin = (Admin) obj;
            return admin.getAdminId();
        }
    }


}
