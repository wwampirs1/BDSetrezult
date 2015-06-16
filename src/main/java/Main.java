import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
 * Created by Dmytro on 16.06.2015.
 */
public class Main {

    private static final String INSERT_NEW = "insert into user(username,password) values (?,?);";
    private static final String GET_ALL = "SELECT * FROM user;";
    private static final String DELETE = "delete from user where id=?;";

    public static void main(String[] args) {
//        mPprepareStatement();
        //getAll();
        delete();
    }

    public static void delete() {
        DBWorker worker = new DBWorker();
        PreparedStatement preparedStatement=null;

        try {
            preparedStatement = worker.getConnection().prepareStatement(DELETE);
            preparedStatement.setInt(1,1);
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }


    public static void getAll() {
        DBWorker dbWorker = new DBWorker();
        try {
            PreparedStatement preparedStatement = dbWorker.getConnection().prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("{ Id=" + resultSet.getInt("id") +
                        " userName=" + resultSet.getString("userName") +
                        " password=" + resultSet.getString("password") + "}");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void mPprepareStatement() {
        DBWorker dbWorker = new DBWorker();
        try {
            PreparedStatement preparedStatement = dbWorker.getConnection().prepareStatement(INSERT_NEW);
            preparedStatement.setString(1, "dima");
            preparedStatement.setString(2, "dima");
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void result() {
        DBWorker dbWorker = new DBWorker();
        String query = "SELECT * FROM user;";

        try {
            Statement statement = dbWorker.getConnection().createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                System.out.println(user.toString());
            }
            System.out.println("-------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
