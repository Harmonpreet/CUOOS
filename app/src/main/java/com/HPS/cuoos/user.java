package com.HPS.cuoos;


    public class user {
        String id;
        String email;
        String name;
        String phonenumber;
        public user(String id, String e, String n,String p)
        {
            this.id= id;
            this.email=e;
            this.name=n;
            this.phonenumber=p;

        }
        public String getEmail()
        {
            return email;
        }
        public String getName()
        {
            return name;
        }

        public String getPhonenumber() {
            return phonenumber;
        }

    }

