/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Tables;
import GiaoDien.QuanLyBan;
import Utilities.DBUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TRI
 */
public class TablesDAO {

    private static TablesDAO instance;

    public TablesDAO() {
    }

    public static TablesDAO getInstance() {
        if (instance == null) {
            instance = new TablesDAO();
        }
        return instance;
    }

    public static void setInstance(TablesDAO instance) {
        TablesDAO.instance = instance;
    }

    public List<Tables> LoadListTables() {
        List<Tables> listTable = new ArrayList<Tables>();

        Connection con = DBUtility.openConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `tables`");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Tables tables = new Tables(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4) == 0 ? "Còn trống" : "Đã đặt");
                listTable.add(tables);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TablesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTable;
    }
    
    public String getTableNameById(int tableId) {
        String tableName = "";
        // Kiểm tra id trước khi thực hiện truy vấn
        if (tableId <= 0) {
            return "Bàn không hợp lệ";
        }
        
        String query = "SELECT table_name FROM tables WHERE id = ?";

        try (Connection con = DBUtility.openConnection(); 
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, tableId); // Thiết lập giá trị cho câu truy vấn

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                tableName = rs.getString("table_name"); // Lấy tên bàn từ cột "table_name"
            } else {
                tableName = "Bàn không tìm thấy"; // Nếu không có kết quả
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            tableName = "Lỗi kết nối cơ sở dữ liệu"; // Thông báo lỗi kết nối
        }

        return tableName;
    }
}
