
import java.net.URL;
import java.sql.*;
import java.util.*;


import static java.sql.DriverManager.getConnection;

public class curd {
    private static final String URL = "jdbc:mysql://localhost:3306/Emp";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";
    private static Connection con;

    static {
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Database connection failed.");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void read() throws SQLException {
        PreparedStatement stm = curd.con.prepareStatement("select * from student ");
//                System.out.println(" READ Enter the roll no.(rollNO,name,address,deptId) ");
//                int Rno = sc.nextInt();
//               stm.setInt(1, Rno);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            System.out.print(rs.getInt("rollNo") + " ");
            System.out.print(rs.getString("name") + " ");
            System.out.print(rs.getString("address") + " ");
            System.out.println(rs.getInt(4) + " ");

        }

        stm.close();
    }

    public static void insert() throws SQLException {
        PreparedStatement stm = con.prepareStatement("insert into student values(?,?,?,?)");
        System.out.println("Enter INSERT the student detail(rollNo,name,address,deptId)");
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        String N = sc.next();
        String A = sc.next();
        int D = sc.nextInt();
        stm.setInt(1, R);
        stm.setString(2, N);
        stm.setString(3, A);
        stm.setInt(4, D);
        stm.executeUpdate();
        read();
        stm.close();
    }

    public static void update() throws SQLException {
        PreparedStatement stm = con.prepareStatement("update student set name=?,address=?,deptId=? where rollNo=?");
        search();
        System.out.println("UPDATE the student detail via name,address,deptId,rollNo");
        Scanner sc = new Scanner(System.in);

        String N = sc.next();
        String A = sc.next();
        int D = sc.nextInt();
        int R = sc.nextInt();

        stm.setString(1, N);
        stm.setString(2, A);
        stm.setInt(3, D);
        stm.setInt(4, R);
        stm.executeUpdate();
        read();
        stm.close();
    }

    public static void delete() throws SQLException {
        PreparedStatement stm = con.prepareStatement("delete from student  where rollNo=?");
        System.out.println("Enter DELETE  rollNo.");
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        stm.setInt(1, R);
        stm.executeUpdate();
        read();
        stm.close();
    }

    public static void search() throws SQLException {
        PreparedStatement stm = con.prepareStatement("select * from student where name like ?");
        System.out.println("SEARCH name Enter name ");
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        stm.setString(1, N);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            System.out.print(rs.getInt("rollNo") + " ");
            System.out.print(rs.getString("name") + " ");
            System.out.print(rs.getString("address") + " ");
            System.out.println(rs.getInt(4) + " ");
        }

        stm.close();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String opretn = sc.nextLine();
        switch (opretn) {
            case "read":
                read();
                opretn = sc.nextLine();
                break;
            case "insert":
                insert();
                break;
            case "update":
                update();
                break;
            case "delete":
                delete();
                break;
            case "search":
                search();
                break;
        }
    }
}
