package com.HPS.cuoos;

public class food {
    public String name;
    String Hname;
    String Fname;

    public food(String name, String hname, String fname) {
        this.name = name;
        Hname = hname;
        Fname = fname;
    }

    public food() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHname() {
        return Hname;
    }

    public void setHname(String hname) {
        Hname = hname;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }
}
