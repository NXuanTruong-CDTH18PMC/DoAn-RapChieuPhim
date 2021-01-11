package com.example.doan;

public class ThanhVien {
private String Ten, Email, SDT;

    public ThanhVien(String ten,String email, String sdt) {
        Ten=ten;
        Email=email;
        SDT=sdt;
    }


    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
}
