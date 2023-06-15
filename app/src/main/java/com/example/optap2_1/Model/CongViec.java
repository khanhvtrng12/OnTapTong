package com.example.optap2_1.Model;

public class CongViec {
    private int id;
    private String tenCV;
    private String thoiGianThucHien;

    // constructors
    public CongViec() {

    }

    public CongViec(int id, String tenCV, String thoiGianThucHien) {
        this.id = id;
        this.tenCV = tenCV;
        this.thoiGianThucHien = thoiGianThucHien;
    }

    // getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

    public String getThoiGianThucHien() {
        return thoiGianThucHien;
    }

    public void setThoiGianThucHien(String thoiGianThucHien) {
        this.thoiGianThucHien = thoiGianThucHien;
    }

    // override toString method to display job information
    @Override
    public String toString() {
        return "Job [ID=" + id + ", tenCV=" + tenCV + ", thoiGianThucHien=" + thoiGianThucHien + "]";
    }
}