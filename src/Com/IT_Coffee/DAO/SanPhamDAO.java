/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.IT_Coffee.DAO;

import Com.IT_Coffee.Entity.SanPham;
import Com.IT_Coffee.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HMD
 */
public class SanPhamDAO extends IT_Coffee_DAO<SanPham, String> {

    String INSERT_SQL = "INSERT INTO SanPham (MaSanPham, TenSanPham, DonGia, Size, Hinh, MaLoai) VALUES (?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE SanPham SET TenSanPham=?, DonGia=?, Size=?, Hinh=?, MaLoai=? WHERE MaSanPham=?";
    String DELETE_SQL = "DELETE FROM SanPham WHERE MaSanPham=?";
    String SELECT_ALL_SQL = "SELECT * FROM SanPham";
    String SELECT_BY_ID_SQL = "SELECT * FROM SanPham WHERE MaSanPham =?";

    @Override
    public void insert(SanPham entity) {
        XJdbc.update(INSERT_SQL, entity.getMaSP(), entity.getTenSP(), entity.getDonGia(), entity.getSize(), entity.getHinh(), entity.getLoaiSP());
    }

    @Override
    public void update(SanPham entity) {
        XJdbc.update(UPDATE_SQL, entity.getTenSP(), entity.getDonGia(), entity.getSize(), entity.getHinh(), entity.getLoaiSP(), entity.getMaSP());
    }

    @Override
    public void delete(String id) {
        XJdbc.update(DELETE_SQL, id);
    }

    @Override
    public SanPham selectById(String id) {
        List<SanPham> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<SanPham> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<SanPham> selectBySql(String sql, Object... args) {
        List<SanPham> list = new ArrayList<SanPham>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                SanPham entity = new SanPham();
                entity.setMaSP(rs.getString("MaSanPham"));
                entity.setTenSP(rs.getString("TenSanPham"));
                entity.setDonGia(rs.getDouble("DonGia"));
                entity.setLoaiSP(rs.getString("MaLoai"));
                entity.setSize(rs.getString("Size"));
                entity.setHinh(rs.getString("Hinh"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public List<SanPham> selectByLoaiSP(String maLoai) {
        String sql = "SELECT * FROM SanPham WHERE MaLoai = ?";
        return this.selectBySql(sql, maLoai);
    }

    public List<String> selectByLoaiSPKhongTrungTen(String maLoai) {
        String sql = "SELECT TenSanPham FROM SanPham WHERE MaLoai = ? GROUP BY TenSanPham";
        List<String> list = new ArrayList<String>();
        try {
            ResultSet rs = XJdbc.query(sql, maLoai);
            while (rs.next()) {
                list.add(rs.getString("TenSanPham"));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public List<String> selectByTenVaGia(String tenSP, String size) {
        String sql = "SELECT TOP(1) MaSanPham, DonGia FROM SanPham WHERE TenSanPham = ? AND Size = ?";
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, tenSP, size);
            while (rs.next()) {
                list.add(rs.getString("MaSanPham"));
                list.add(rs.getString("DonGia"));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public List<SanPham> selectByTenSP(String tenSP) {
        String sql = "SELECT * FROM SanPham WHERE TenSanPham = ?";
        return this.selectBySql(sql, tenSP);
    }

    public List<SanPham> selectByKeyWord(String Keyword) {
        String sql = "Select * from SanPham Where TenSanPham Like ?";
        return this.selectBySql(sql, "%" + Keyword + "%");
    }
}
