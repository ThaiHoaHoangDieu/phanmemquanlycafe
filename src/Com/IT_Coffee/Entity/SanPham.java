/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.IT_Coffee.Entity;

/**
 *
 * @author HMD
 */
public class SanPham {

    String loaiSP;
    String maSP;
    String tenSP;
    String size;
    double donGia;
    String hinh;

    public SanPham() {
    }

    public SanPham(String loaiSP, String maSP, String tenSP, String size, double donGia, String hinh) {
        this.loaiSP = loaiSP;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.size = size;
        this.donGia = donGia;
        this.hinh = hinh;
    }

    @Override
    public String toString() {
        return this.tenSP;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

}
