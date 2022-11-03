package gRPC.assignment3_1.database;

import java.sql.*;
import java.util.ArrayList;

import static gRPC.assignment3_1.database.DatabaseConnection.getConnection;

public class Retrieve {
    public static ArrayList<Integer> getRegNum(String packageid) {
        ArrayList<Integer> packagesIdList = new ArrayList<>();

        try (Connection conn = getConnection()) {
            if (conn != null) System.out.println("Connection to Database is Success");

            PreparedStatement statement = conn.prepareStatement("SELECT animalid FROM slaughterhouse.animalpackage WHERE packageid = " + packageid + ";");
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                packagesIdList.add(rs.getInt("packageid"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


        return packagesIdList;
    }

    public static ArrayList<Integer> getPackages(String regNum) {
        ArrayList<Integer> packagesIdList = new ArrayList<>();

        try (Connection conn = getConnection()) {
            System.out.println("Connection to Database is Success");
            PreparedStatement statement = conn.prepareStatement("SELECT animalid FROM slaughterhouse.animalpackage WHERE packageid = " + regNum + ";");
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                packagesIdList.add(rs.getInt("animalid"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


        return packagesIdList;
    }

}
