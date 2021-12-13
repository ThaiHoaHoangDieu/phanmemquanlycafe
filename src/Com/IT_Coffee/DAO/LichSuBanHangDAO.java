/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.IT_Coffee.DAO;

import Com.IT_Coffee.Entity.LichSuBanHang;
import Com.IT_Coffee.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dang
 */
public class LichSuBanHangDAO extends IT_Coffee_DAO<LichSuBanHang, String> {

    @Override
    public void insert(LichSuBanHang entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(LichSuBanHang entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LichSuBanHang selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LichSuBanHang> selectAll() {
        String sql = "SELECT ChiTietHoaDon.MaDonHang , MaNV, MaSanPham ,TenSanPham, NgayThem , Gio, SoLuong,TongTien\n"
                + "                FROM HoaDon INNER JOIN ChiTietHoaDon\n"
                + "                ON HoaDon.MaDonHang = ChiTietHoaDon.MaDonHang";
        return this.selectBySql(sql);
    }

    @Override
    protected List<LichSuBanHang> selectBySql(String sql, Object... args) {
        List<LichSuBanHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    LichSuBanHang entity = new LichSuBanHang();
                    entity.setMaDH(rs.getString("MaDonHang"));
                    entity.setMaNV(rs.getString("MaNV"));
                    entity.setMaSP(rs.getString("MaSanPham"));
                    entity.setTenSP(rs.getString("TenSanPham"));
                    entity.setNgayThem(rs.getDate("NgayThem"));
                    entity.setGio(rs.getString("Gio"));
                    entity.setSoLuong(rs.getInt("SoLuong"));
                    entity.setTongTien(rs.getDouble("TongTien"));
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<LichSuBanHang> selectByKeywordMAHD(String keyword) {
        String sql = "SELECT ChiTietHoaDon.MaDonHang , MaNV, MaSanPham,TenSanPham , NgayThem , Gio, SoLuong,TongTien\n"
                + "                FROM HoaDon INNER JOIN ChiTietHoaDon\n"
                + "                ON HoaDon.MaDonHang = ChiTietHoaDon.MaDonHang\n"
                + "				where ChiTietHoaDon.MaDonHang Like ? ";
        return this.selectBySql(sql, "%" + keyword + "%");
    }

    public List<LichSuBanHang> selectByKeywordMANV(String keyword) {
        String sql = "\n"
                + "SELECT ChiTietHoaDon.MaDonHang , MaNV, MaSanPham,TenSanPham , NgayThem , Gio, SoLuong,TongTien\n"
                + "                FROM HoaDon INNER JOIN ChiTietHoaDon\n"
                + "                ON HoaDon.MaDonHang = ChiTietHoaDon.MaDonHang\n"
                + "				where MaNV Like ? ";
        return this.selectBySql(sql, "%" + keyword + "%");
    }

    public List<LichSuBanHang> selectByKeywordMASP(String keyword) {
        String sql = "\n"
                + "SELECT ChiTietHoaDon.MaDonHang , MaNV, MaSanPham,TenSanPham , NgayThem , Gio, SoLuong,TongTien\n"
                + "                FROM HoaDon INNER JOIN ChiTietHoaDon\n"
                + "                ON HoaDon.MaDonHang = ChiTietHoaDon.MaDonHang\n"
                + "				where MaSanPham Like ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }

    public List<LichSuBanHang> selectByKeywordMANT(String keyword) {
        String sql = "\n"
                + "SELECT ChiTietHoaDon.MaDonHang , MaNV, MaSanPham,TenSanPham , NgayThem , Gio, SoLuong,TongTien\n"
                + "                FROM HoaDon INNER JOIN ChiTietHoaDon\n"
                + "                ON HoaDon.MaDonHang = ChiTietHoaDon.MaDonHang\n"
                + "				where NgayThem Like ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }

//    public List<LichSuBanHang> selectByKeywordSL(Integer keyword) {
//        String sql = "\n"
//                + "SELECT ChiTietHoaDon.MaDonHang , MaNV, MaSanPham , NgayThem , Gio, SoLuong,TongTien\n"
//                + "                FROM HoaDon INNER JOIN ChiTietHoaDon\n"
//                + "                ON HoaDon.MaDonHang = ChiTietHoaDon.MaDonHang\n"
//                + "				where SoLuong = ?";
//        return this.selectBySql(sql, keyword );
//    }
}
