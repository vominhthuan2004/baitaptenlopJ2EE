package baitaptenlopJ2EE;

public class Sach {
    private int maSach;
    private String tenSach;
    private String tacGia;
    private double donGia;
    
    public Sach(int maSach, String tenSach, String tacGia, double donGia){
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.donGia = donGia;
    }
    public int getMaSach(){
        return maSach;
    }
    public String getTenSach(){
        return tenSach;
    }
    public String getTacGia(){
        return tacGia;
    }
    public double getDonGia(){
        return donGia;
    }
   
    public void setTenSach(String tenSach){
        this.tenSach = tenSach;
    }
    public void setTacGia(String tacGia){
        this.tacGia = tacGia;
    }
    public void setDonGia(double donGia){
        this.donGia = donGia;
    }
    public String toString(){
        return maSach + " | " +tenSach+" | " + tacGia +" | " + donGia;
    }
    
}
