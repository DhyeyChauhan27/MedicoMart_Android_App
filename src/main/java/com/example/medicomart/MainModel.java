package com.example.medicomart;

public class MainModel
{
    String mname,mprice,mdeliver,image;

    public MainModel(String mname, String mprice, String mdeliver, String image) {
        this.mname = mname;
        this.mprice = mprice;
        this.mdeliver = mdeliver;
        this.image = image;
    }

    public MainModel(){
    }

    public String getMname() {
        return mname;
    }

    public String getMprice() {
        return mprice;
    }

    public String getMdeliver() {
        return mdeliver;
    }

    public String getImage() {
        return image;
    }
}
