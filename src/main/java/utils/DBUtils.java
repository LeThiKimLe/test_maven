package utils;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.MonHoc;

public class DBUtils {
	
	public static List<MonHoc> listMonHoc(Connection conn) throws SQLException {
        String sql = "Select maso_monhoc, ten_monhoc, sotinchi from MONHOC";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        
        List<MonHoc> list = new ArrayList<MonHoc>();
        
        while (rs.next()) {
            int ma_mon = rs.getInt("maso_monhoc");
            String ten_mon = rs.getString("ten_monhoc");
            int so_tinchi = rs.getInt("sotinchi");
            
            MonHoc mh = new MonHoc();
            mh.setMaso_monhoc(ma_mon);
            mh.setTen_monhoc(ten_mon);
            mh.setSotinchi(so_tinchi);          
            list.add(mh);
        }
        return list;
    }
    public static MonHoc findMonHoc(Connection conn, int maMon) throws SQLException {
        String sql = "Select a.maso_monhoc, a.ten_monhoc, a.sotinchi from MONHOC a where a.maso_monhoc=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        pstm.setInt(1, maMon);
        
        //"Select a.id, a.name, a.address from Student a where a.id=12";
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) 
        {
        	int ma_mon = rs.getInt("maso_monhoc");
            String ten_mon = rs.getString("ten_monhoc");           
            int so_tinchi = rs.getInt("sotinchi");
            
            MonHoc mh = new MonHoc(ma_mon, ten_mon, so_tinchi);
            return mh;
        }
        return null;
    }
	public static void updateMonhoc(Connection conn, MonHoc mh) throws SQLException {
        String sql = "Update MONHOC set ten_monhoc=?, sotinchi=? where maso_monhoc=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,mh.getTen_monhoc());
        pstm.setInt(2, mh.getSotinchi());
        pstm.setInt(3, mh.getMaso_monhoc());
        pstm.executeUpdate();
    }
	public static void insertMonHoc(Connection conn, MonHoc mh) throws SQLException {
        String sql = "Insert MONHOC values (?, ?, ?)";
 //
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, mh.getMaso_monhoc());
        pstm.setString(2,mh.getTen_monhoc());
        pstm.setInt(3, mh.getSotinchi());
        
        pstm.executeUpdate();
    }
	public static void deleteMonHoc(Connection conn, int maMon) throws SQLException {
        String sql = "Delete from MONHOC where maso_monhoc=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, maMon);  
        
        pstm.executeUpdate();
    }

}
