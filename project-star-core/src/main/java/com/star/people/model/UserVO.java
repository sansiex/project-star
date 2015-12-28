package com.star.people.model;

/**
 * Created by zuhai.jiang on 2015/12/27.
 */
public class UserVO extends BaseEntity{
    int id;
    String name;
    int role;

    public UserVO fromAdminLoginInfo(AdminLoginInfo ali){
        setId(ali.getId());
        setName(ali.getName());
        setRole(ali.getRole());
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
