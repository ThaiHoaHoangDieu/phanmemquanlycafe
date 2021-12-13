/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.IT_Coffee.DAO;

import Com.IT_Coffee.Entity.LoaiSP;
import Com.IT_Coffee.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HMD
 */
public class LoaiSPDAO extends IT_Coffee_DAO<LoaiSP, String> {

    String INSERT_SQL = "INSERT INTO LoaiSanPham (MaLoai, TenLoai) VALUES (?, ?)";
    String UPDATE_SQL = "UPDATE LoaiSanPham SET TenLoai=? WHERE MaLoai=?";
    String DELETE_SQL = "DELETE FROM LoaiSanPham WHERE MaLoai=?";
    String SELECT_ALL_SQL = "SELECT * FROM LoaiSanPham";
    String SELECT_BY_ID_SQL = "SELECT * FROM LoaiSanPham WHERE MaLoai =?";

    public void insert(LoaiSP entity) {
        XJdbc.update(INSERT_SQL, entity.getMaLoaiSP(), entity.getTenLoaiSP());
    }

    public void update(LoaiSP entity) {
        XJdbc.update(UPDATE_SQL, entity.getTenLoaiSP(), entity.getMaLoaiSP());
    }

    public void delete(String id) {
        XJdbc.update(DELETE_SQL, id);
    }

    public LoaiSP selectById(String id) {
        List<LoaiSP> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<LoaiSP> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    protected List<LoaiSP> selectBySql(String sql, Object... args) {
        List<LoaiSP> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    LoaiSP entity = new LoaiSP();
                    entity.setMaLoaiSP(rs.getString("MaLoai"));
                    entity.setTenLoaiSP(rs.getString("TenLoai"));
                    list.add(entity);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<LoaiSP> selectByKeyword2(String keyword) {
        String sql = "Select * from LoaiSanPham where TenLoai Like ? ";
        return this.selectBySql(sql, "%" + keyword + "%");
    }

}
