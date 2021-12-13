/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.IT_Coffee.DAO;

import Com.IT_Coffee.Entity.HoaDon;
import Com.IT_Coffee.utils.XJdbc;
import java.util.List;

/**
 *
 * @author Dang
 */
public class HoaDonDAO extends IT_Coffee_DAO<HoaDon, String> {

    String INSERT_SQL = "INSERT INTO HoaDon values  (?,?,?,?)";

    @Override
    public void insert(HoaDon entity) {
        XJdbc.update(INSERT_SQL,
                entity.getMaHD(),
                entity.getMaNV(),
                entity.getNgayThem(),
                entity.getGio()
        );
    }

    @Override
    public void update(HoaDon entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HoaDon selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HoaDon> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<HoaDon> selectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
