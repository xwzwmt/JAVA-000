package io.tyj.xml;

import java.util.List;

public class user {
    private String username;
    private Integer password;
    private List<String> list;

    public user(String username, Integer password, List<String> list) {
        this.username = username;
        this.password = password;
        this.list = list;
    }

    public user() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public Integer getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password +
                ", list=" + list + "]";
    }
}
