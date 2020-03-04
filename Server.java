import java.util.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.net.*;
import java.util.Date;


public class Server implements Serializable {
    public static void main(String[] args) {

        //Specifies and port
        ServerSocket serverSocket = null;
        final int PORT = 8888;
        //seversocket becomes the port that we specified
        try {
          serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("WAITING FOR CLIENT TO CONNECT...");
        while (true) {

            //if the same socket is entered from client side it will prompt the message else it will keep listening.
            Socket myServerSocket = null;
            try {
                myServerSocket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("CLIENT IS CONNECTED ON : " + PORT);


            //database connection thats needed
            String host = "localhost";
            String dbname = "pt";
            String url = "jdbc:mysql://" + host + "/" + dbname;
            String username = "root";
            String password = "";
            Connection con = null;
            try {
                con = DriverManager.getConnection(url, username, password);


                Statement stmt = con.createStatement();
                //streams that are needed for data to flow between server and client
                ObjectOutputStream os = new ObjectOutputStream(myServerSocket.getOutputStream());
                ObjectInputStream is = new ObjectInputStream(myServerSocket.getInputStream());
                String input1 = (String) is.readObject();

                //all 8 if statements that are needed for the client to interact with the server
                if (input1.equals("1")) {

                    String clientid = (String) is.readObject();
                    String trainerid = (String) is.readObject();
                    String focus = (String) is.readObject();
                    String duration = (String) is.readObject();
                    String date = (String) is.readObject();
                    String time = (String) is.readObject();

                    //executes stream given from client into the database
                    stmt.executeUpdate("INSERT INTO booking(clientid,trainerid,focusid,duration,date,time) VALUES('" + clientid + "'" + "," + "'" + trainerid + "'" + ", " + "'" + focus + "'" + "," + duration + "," + "'" + date + "'" + "," + "'" + time + "')");

                    //upon successful execution the client will receive this message telling them that they've executed their query successfully
                    os.writeObject("Booking has been Successfully Added");

                }


                    if (input1.equals("2")) {
                    //executes stream given from client into the database
                    ResultSet rs = stmt.executeQuery("SELECT * FROM  booking");
                    //while loop is needed to extract all the information requested
                    String loop1 = "";

                    while (rs.next()) {

                        String loop = "";


                        String bookingid = rs.getString("bookingid");
                        String clientid = rs.getString("clientid");
                        String trainerid = rs.getString("trainerid");
                        String focus = rs.getString("focusid");
                        Integer duration = rs.getInt("duration");
                        Date date = rs.getDate("date");
                        String time = rs.getString("time");
                        os.flush();


                        loop = ("|   " + bookingid + "     |    " + clientid + "  |       " + trainerid + "  |      " + focus + "  |          " + duration + "  |        " + date + "  |      " + time + "  |  \n");
                        loop1 = loop1 + loop;


                    }
                    //outputs all requested information to client
                    os.writeObject("| booking | client | trainer   | focus    | duration     |    date            |       time     |\n------------------------------------------------------------------------------------------------\n" + loop1 + "\n------------------------------------------------------------------------------------------------\n");
                    os.flush();
                }


                if (input1.equals("3")) {


                    String td = (String) is.readObject();


                    ResultSet rs = stmt.executeQuery("SELECT * FROM  booking where trainerid= '" + td + "'");

                    //while loop is needed to extract all the information requested
                    String loop1 = "";

                    while (rs.next()) {

                        String loop = "";


                        String bookingid = rs.getString("bookingid");
                        String clientid = rs.getString("clientid");
                        String trainerid = rs.getString("trainerid");
                        String focus = rs.getString("focusid");
                        Integer duration = rs.getInt("duration");
                        Date date = rs.getDate("date");
                        String time = rs.getString("time");
                        os.flush();


                        loop = ("|   " + bookingid + "     |    " + clientid + "  |       " + trainerid + "  |      " + focus + "  |          " + duration + "  |        " + date + "  |      " + time + "  |  \n");
                        loop1 = loop1 + loop;

                    }
                    //outputs all requested information to client
                    os.writeObject("| booking | client | trainer   | focus    | duration     |    date            |       time     |\n------------------------------------------------------------------------------------------------\n" + loop1 + "\n------------------------------------------------------------------------------------------------\n");
                    os.flush();
                }


                if (input1.equals("4")) {


                    String fid = (String) is.readObject();


                    ResultSet rs = stmt.executeQuery("SELECT * FROM  booking where clientid= '" + fid + "'");

                    //while loop is needed to extract all the information requested
                    String loop1 = "";

                    while (rs.next()) {

                        String loop = "";


                        String bookingid = rs.getString("bookingid");
                        String clientid = rs.getString("clientid");
                        String trainerid = rs.getString("trainerid");
                        String focus = rs.getString("focusid");
                        Integer duration = rs.getInt("duration");
                        Date date = rs.getDate("date");
                        String time = rs.getString("time");
                        os.flush();


                        loop = ("|   " + bookingid + "     |    " + clientid + "  |       " + trainerid + "  |      " + focus + "  |          " + duration + "  |        " + date + "  |      " + time + "  |  \n");
                        loop1 = loop1 + loop;


                    }
                    //outputs all requested information to client
                    os.writeObject("| booking | client | trainer   | focus    | duration     |    date            |       time     |\n------------------------------------------------------------------------------------------------\n" + loop1 + "\n------------------------------------------------------------------------------------------------\n");
                    os.flush();
                }


                if (input1.equals("5")) {

                    String did = (String) is.readObject();


                    ResultSet rs = stmt.executeQuery("SELECT * FROM  booking where date= '" + did + "'");

                    //while loop is needed to extract all the information requested
                    String loop1 = "";

                    while (rs.next()) {

                        String loop = "";


                        String bookingid = rs.getString("bookingid");
                        String clientid = rs.getString("clientid");
                        String trainerid = rs.getString("trainerid");
                        String focus = rs.getString("focusid");
                        Integer duration = rs.getInt("duration");
                        Date date = rs.getDate("date");
                        String time = rs.getString("time");
                        os.flush();


                        loop = ("|   " + bookingid + "     |    " + clientid + "  |       " + trainerid + "  |      " + focus + "  |          " + duration + "  |        " + date + "  |      " + time + "  |  \n");
                        loop1 = loop1 + loop;


                    }
                    //outputs all requested information to client
                    os.writeObject("| booking | client | trainer   | focus    | duration     |    date            |       time     |\n------------------------------------------------------------------------------------------------\n" + loop1 + "\n------------------------------------------------------------------------------------------------\n");
                    os.flush();
                }


                if (input1.equals("6")) {


                    String bid1 = (String) is.readObject();

                    String ai1 = (String) is.readObject();

                    String nv1 = (String) is.readObject();


                    stmt.executeUpdate("UPDATE booking SET  " + ai1 + " = " + " ' " + nv1 + " ' " + "WHERE bookingid = " + bid1);

                    //upon successful execution the client will receive this message telling them that they've executed their query successfully
                    os.writeObject("Booking has been Successfully Update");

                }
                if (input1.equals("7")) {

                    String bid = (String) is.readObject();

                    //executes stream given from client into the database
                    stmt.executeUpdate("DELETE FROM booking WHERE bookingid ='" + bid + "'");

                    //upon successful execution the client will receive this message telling them that they've executed their query successfully
                    os.writeObject("Booking has been Successfully Removed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }
    }


}








