/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.IT_Coffee.DAO;

import Com.IT_Coffee.Entity.NhanVien;
import Com.IT_Coffee.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dang
 */
public class NhanVienDAO extends IT_Coffee_DAO<NhanVien, String> {

    String INSERT_SQL = "INSERT INTO NhanVien (MaNV, MatKhau, HoTen,GioiTinh, VaiTro,DiaChi,SDT,Email,Luong,Hinh) VALUES (?, ?, ?,?,?, ?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE NhanVien SET MatKhau=?, HoTen=?, GioiTinh=?,VaiTro=?,DiaChi=?,SDT=?,Email=?,Luong=?,Hinh=? WHERE MaNV=?";
    String DELETE_SQL = "DELETE FROM NhanVien WHERE MaNV=?";
    String SELECT_ALL_SQL = "SELECT * FROM NhanVien";
    String SELECT_BY_ID_SQL = "select * from NhanVien where MaNV =?";

    public void insert(NhanVien entity) {
        XJdbc.update(INSERT_SQL,
                entity.getMaNV(),
                entity.getMatKhau(),
                entity.getHoTen(),
                entity.isGioiTinh(),
                entity.isVaiTro(),
                entity.getDiaChi(),
                entity.getsDT(),
                entity.getEmail(),
                entity.getLuong(),
                entity.getHinh()
        );
    }

    public void update(NhanVien entity) {
        XJdbc.update(UPDATE_SQL,
                entity.getMatKhau(),
                entity.getHoTen(),
                entity.isGioiTinh(),
                entity.isVaiTro(),
                entity.getDiaChi(),
                entity.getsDT(),
                entity.getEmail(),
                entity.getLuong(),
                entity.getHinh(),
                entity.getMaNV()
        );
    }

    public void delete(String id) {
        XJdbc.update(DELETE_SQL, id);
    }

    public NhanVien selectById(String manv) {
        List<NhanVien> list = this.selectBySql(SELECT_BY_ID_SQL, manv);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<NhanVien> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    NhanVien entity = new NhanVien();
                    entity.setMaNV(rs.getString("MaNV"));
                    entity.setMatKhau(rs.getString("MatKhau"));
                    entity.setHoTen(rs.getString("HoTen"));
                    entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                    entity.setVaiTro(rs.getBoolean("VaiTro"));
                    entity.setDiaChi(rs.getString("DiaChi"));
                    entity.setsDT(rs.getString("SDT"));
                    entity.setEmail(rs.getString("Email"));
                    entity.setLuong(rs.getDouble("Luong"));
                    entity.setHinh(rs.getString("hinh"));
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

    public List<NhanVien> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM NhanVien WHERE HoTen LIKE ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }

}
