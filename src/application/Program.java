package application;

import db.DB;
import db.DbException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");

        Connection conn = null;
        PreparedStatement st = null;
        try{
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "INSERT INTO seller "
                    + "(Name,Email,BirthDate,BaseSalary,DepartmentId)"
                    + "VALUES "
                    +"(?,?,?,?,?)");
            st.setString(1,"Pedro Yellow");
            st.setString(2,"pedroyeallow@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("16/04/2003").getTime()));
            st.setDouble(4,4000.0);
            st.setInt(5,4);

           int rowsAffected =  st.executeUpdate();
            System.out.println("DOne! Rows Updated: " + rowsAffected);
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e){
            e.printStackTrace();
        }finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}