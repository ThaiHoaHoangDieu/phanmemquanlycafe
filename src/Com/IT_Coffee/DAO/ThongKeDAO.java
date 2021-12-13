/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.IT_Coffee.DAO;

import Com.IT_Coffee.utils.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author HMD
 */
public class ThongKeDAO {

    private List<Object[]> getListOfArray (String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Object[]> getTopSPTheoNgay(Date dateBegin, Date dateEnd){
        String sql = "{CALL sp_TopSP(?,?)}";
        String[] cols = {"MaSanPham", "TenSanPham", "DaBan"};
        return this.getListOfArray(sql, cols, dateBegin, dateEnd);
    }
    
    public List<Object[]> getTopSPTheoThang(int month, int year){
        String sql = "{CALL sp_TopSP3(?,?)}";
        String[] cols = {"MaSanPham", "TenSanPham", "DaBan"};
        return this.getListOfArray(sql, cols, month, year);
    }

    public List<Object[]> getDoanhThu(){
        String sql = "{CALL sp_DoanhThu}";
        String[] cols = {"NgayThem", "DoanhThu"};
        return this.getListOfArray(sql, cols);
    }
    
    public List<Object[]> getDoanhThu2(Date date){
        String sql = "{CALL sp_DoanhThu2(?)}";
        String[] cols = {"NgayThem", "DoanhThu"};
        return this.getListOfArray(sql, cols, date);
    }
}
