package com.example.optap2_1;

public class Activity21KH {
    int Id;
    String Ten;
    String HocPhi;
    public  Activity21KH(int id,String ten,String hocphi)
    {
        Id = id;
        Ten = ten;
        HocPhi = hocphi;
    }
    public int getID()
    {
        return Id;
    }
    public void setID(int id)
    {
        Id = id;
    }
    public String getTen()
    {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getHocPhi() {
        return HocPhi;
    }

    public void setHocPhi(String hocPhi) {
        HocPhi = hocPhi;
    }
    @Override
    public String toString(){
        return "" + Id+"";
    }
}
