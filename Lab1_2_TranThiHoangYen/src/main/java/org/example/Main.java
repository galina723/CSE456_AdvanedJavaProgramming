package org.example;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        //Sử dụng các class cung cấp sẵn có trong thư viên JDBC (có trong JAVA SDK)
        //JDBC sẽ tự động kết nối với MySQL JDBC Server (MySQL connector/java)
        try {

            String url = "jdbc:mysql://localhost:3306/CSE456";

            //Đối với Java mới thì Driver sẽ được tự động dò tìm trong URL mà ko cần lệnh này.
            //Class.forName("com.mysql.cj.jdbc.Driver");

            String username = "root";
            String password = "123456789";
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database successfully");

            //Sau khi kết nối thành công thì tiếp tục thực hiện truy vấn bằng SQL
            //Tạo Class PreparedStatement để thực hiện câu truy vấn.

            //thuc hien truy van
            PreparedStatement pstmt = conn.prepareStatement("select * from Student"); //go lenh chua chay
            ResultSet rs = pstmt.executeQuery(); //chay lenh sql va luu danh sach va rs

            //duyet qua list de xuat ket qua
//            while (rs.next()) {
//                System.out.print(rs.getString(1) + "|");
//                System.out.print(rs.getString("FirstName") + "|");
//                System.out.print(rs.getString("LastName") + "|");
//                System.out.print(rs.getString("YOB") + "|");
//                System.out.println(rs.getString("GPA") + "|");
//            }

            while (rs.next()) {
                System.out.printf("|%4s|%-10s|%-10s|%4s|%4s\n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }

//            while (rs.next()) {
//                String code = rs.getString("code");
//                String name = rs.getString("name");
//                int Credits = rs.getInt("Credits");
//                int StudyHours = rs.getInt("StudyHours");
//                System.out.println(code + "|" + name + "|" + Credits + "|" + StudyHours);
//                System.out.printf("|%10s|%-40s|%2d|%4d|\n",code,name,Credits,StudyHours);
//            }
            conn.close();
            System.out.println("Connection closed");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}