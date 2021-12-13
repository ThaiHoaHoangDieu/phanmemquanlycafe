/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.IT_Coffee.DAO;

import Com.IT_Coffee.Entity.BHChiTietHD;
import Com.IT_Coffee.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dang
 */
public class BHChiTietHDDAO extends IT_Coffee_DAO<BHChiTietHD, String> {

    String INSERT_SQL = "INSERT INTO ChiTietHoaDon values (?,?,?,?,?)";
    String SELECT_BY_ID_SQL = "select * from ChiTietHoaDon where MaDonHang =?";
    String SELECT_ALL_SQL = "Select * from ChiTietHoaDon";

    @Override
    public void insert(BHChiTietHD entity) {
        XJdbc.update(INSERT_SQL,
                entity.getMaHD(),
                entity.getMaSP(),
                entity.getTenSP(),
                entity.getSoLuong(),
                entity.getTongTien()
        );
    }

    @Override
    public void update(BHChiTietHD entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BHChiTietHD> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<BHChiTietHD> selectBySql(String sql, Object... args) {
        List<BHChiTietHD> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    BHChiTietHD entity = new BHChiTietHD();
                    entity.setMaHD(rs.getString("MaDonHang"));
                    entity.setMaSP(rs.getString("MaSanPham"));
                    entity.setTenSP(rs.getString("TenSanPham"));
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

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BHChiTietHD selectById(String id) {
        List<BHChiTietHD> list = this.selectBySql(SELECT_BY_ID_SQL, id);
        return list.size() > 0 ? list.get(0) : null;
    }
}
