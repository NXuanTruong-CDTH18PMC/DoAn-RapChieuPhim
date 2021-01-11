package com.example.doan;

public class Phim {
    private String TenPhim,MaGhe,SoLuong,ThanhTien;

    public Phim(String tenphim, String maghe, String soLuong, String thanhTien) {
        this.TenPhim=tenphim;
        this.MaGhe=maghe;
        this.SoLuong=soLuong;
        this.ThanhTien=thanhTien;
    }


    public String getTenPhim() {
        return TenPhim;
    }

    public void setTenPhim(String tenPhim) {
        TenPhim = tenPhim;
    }

    public String getMaGhe() {
        return MaGhe;
    }

    public void setMaGhe(String maGhe) {
        MaGhe = maGhe;
    }

    public String getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(String soLuong) {
        SoLuong = soLuong;
    }

    public String getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(String thanhTien) {
        ThanhTien = thanhTien;
    }
}
