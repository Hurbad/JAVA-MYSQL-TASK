import java.util.*;
import java.io.*;
import java.net.*;
import java.sql.*;

public class Client implements Serializable {
    public static void main(String[] args) {
        //Specifies and port
        int SERVER_PORT = 8888;
        String info = "";

        while (true) {


            try {
                //connects to server using localhost and the specified port above
                Socket clientSocket = new Socket("localhost", SERVER_PORT);
                //streams that are needed for data to flow between server and client
                ObjectOutputStream os = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream is = new ObjectInputStream(clientSocket.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("------------------------------------------------------------------------------------------------");
                System.out.println("Please Select What Protocol you would like :\n------------------------------------------------------------------------------------------------\n [1] ADD \n [2] LISTALL \n [3] LISTPT\n [4] LIST CLIENT\n [5] LISTDAY\n [6] UPDATE\n [7] REMOVE\n [8] Exit");
                System.out.println("------------------------------------------------------------------------------------------------");
                info = br.readLine();
                os.writeObject(info);

                //all 8 if statements that are needed for the client to interact with the server
                if (info.equals("1")) {
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println("Enter Client ID :");
                    System.out.println("------------------------------------------------------------------------------------------------");
                    String clientid = br.readLine();
                    os.writeObject(clientid);
                    os.flush();
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println("Enter TrainerID : ");
                    System.out.println("------------------------------------------------------------------------------------------------");
                    String trainerid = br.readLine();
                    os.writeObject(trainerid);
                    os.flush();
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println("Enter FocusID: ");
                    System.out.println("------------------------------------------------------------------------------------------------");
                    String focus = br.readLine();
                    os.writeObject(focus);
                    os.flush();
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println("Enter Duration ");
                    System.out.println("------------------------------------------------------------------------------------------------");
                    String duration = br.readLine();
                    os.writeObject(duration);
                    os.flush();
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println("Enter date ");
                    System.out.println("------------------------------------------------------------------------------------------------");
                    String date = br.readLine();
                    os.writeObject(date);
                    os.flush();
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println("Enter Time ");
                    System.out.println("------------------------------------------------------------------------------------------------");
                    String time = br.readLine();
                    os.writeObject(time);
                    String serverMessage = (String) is.readObject();
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println(serverMessage);


                }


                if (info.equals("2")) {

                    String serverMessage = (String) is.readObject();
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println(serverMessage);

                }

                if (info.equals("3")) {
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println("Please enter TrainerID\n| T1 | Billy\n| T2 | Matthew\n| T3 | Jessica\n| T4 | Eve");
                    System.out.println("------------------------------------------------------------------------------------------------");
                    String td = br.readLine();
                    os.writeObject(td);
                    System.out.println("------------------------------------------------------------------------------------------------");
                    String serverMessage = (String) is.readObject();
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println(serverMessage);

                }

                if (info.equals("4")) {
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println("Please enter ClientID\n| C1 | Tom  | Smith\n| C2 | John | Harris\n| C3 | Sam  | Max\n| C4 | Bob  | Mike");
                    System.out.println("------------------------------------------------------------------------------------------------");;
                    String fid = br.readLine();
                    os.writeObject(fid);
                    System.out.println("------------------------------------------------------------------------------------------------");;
                    String serverMessage = (String) is.readObject();
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println(serverMessage);

                }

                if (info.equals("5")) {
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println("Please enter date (YYYY-MM-DD)");
                    System.out.println("------------------------------------------------------------------------------------------------");
                    String did = br.readLine();
                    os.writeObject(did);
                    System.out.println("------------------------------------------------------------------------------------------------");
                    String serverMessage = (String) is.readObject();
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println(serverMessage);

                }

                if (info.equals("6")) {
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println("BookingID : ");
                    System.out.println("------------------------------------------------------------------------------------------------");
                    String bid1 = br.readLine();
                    os.writeObject(bid1);
                    os.flush();
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println("Enter Column : ");
                    System.out.println("------------------------------------------------------------------------------------------------");;
                    String ai1 = br.readLine();
                    os.writeObject(ai1);
                    os.flush();
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println("Enter Value : ");
                    System.out.println("------------------------------------------------------------------------------------------------");
                    String nv1 = br.readLine();
                    os.writeObject(nv1);
                    os.flush();
                    String serverMessage = (String) is.readObject();
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println(serverMessage);


                }
                if (info.equals("7")) {
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println("Please enter BookingID you want to remove : ");
                    System.out.println("------------------------------------------------------------------------------------------------");
                    String bid = br.readLine();
                    os.writeObject(bid);

                    String serverMessage = (String) is.readObject();
                    System.out.println("------------------------------------------------------------------------------------------------");
                    System.out.println(serverMessage);

                }
                if (info.equals("8")) {
                    break;
                }
                //if 8 is pressed then the while loop breaks and clientSocket is closed
                clientSocket.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
    }
}


