package connectioOperationact2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
       
            Socket socket = new Socket("localhost", 1234);
           
            System.out.println("je suis un client connecté");

            // Demander à l'utilisateur d'entrer les nombres et l'opération
            Scanner scan=new Scanner(System.in);
            System.out.println("Entrez le premier nombre : ");
            int op1 = scan.nextInt();
            System.out.println("Entrez le deuxième nombre : ");
            int op2 =scan.nextInt();
           char o = 0;
           do {
          System.out.println("donner une de ses operations(+,-,/,*)");
         
           }while(o != '+' && o != '-' && o != '*' && o != '/' );
         
            // Créer un objet Operation et l'envoyer au serveur
            Operation op= new Operation(op1, op2, o);
            ObjectOutputStream os=new ObjectOutputStream(socket.getOutputStream());
            os.writeObject(op);
           
            ObjectInputStream is=new ObjectInputStream(socket.getInputStream());
            Operation res=(Operation)is.readObject();
            System.out.println("Le résultat est : " + res.getResultat());

            // Fermer les flux et la socket
            socket.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

/*
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

public static void main(String[]args) {
  try {
Socket s=new Socket("localhost",1234);
System.out.println("je suis connecté au serveur");
int op1 = 0,op2=0,res=0;
String operation;
// Récupère les flux d'entrée et de sortie du socket pour communiquer avec le serveur
    InputStream is=s.getInputStream();
    OutputStream os = s.getOutputStream();
  //ObjectOutputStream oos=new ObjectOutputStream(os);
    (new ObjectOutputStream(s.getOutputStream())).writeObject(new Operation(op1,operation,op2));
  //l os jeybetha mn aand socket
    //printwriter hiyya li bch tekteb bl carac bl carac
    //os bch tnajm tekteb beha bl octet bl octet w true tab3eth kol haja tlamadha
    Scanner scan=new Scanner(System.in);
    System.out.println("donner le 1er nombre");
    op1=scan.nextInt();
    System.out.println("donner le 1er nombre");
    op2=scan.nextInt();
    do {
    System.out.println("donner une operation(+,-,/,%)");
        operation=scan.nextLine();
    }
    while(!operation.equals("+") && !operation.equals("-") && !operation.equals("/") && !operation.equals("%"));
    PrintWriter pw=new PrintWriter(os,true);
pw.println(op1);
    pw.println(op2);
    pw.println(operation);
   
    System.out.println(op1+" "+operation+" "+op2+" = "+(Operation)(new ObjectInputStream(s.getInputStream())).readObject())).getRes());
   

} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}


}

}*/
/*package connectioOperationact2;

import java.io.IOException;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
public static void main(String[] args) {
        try {

            // Crée un socket client pour se connecter au serveur sur le localhost et le port 1234
            Socket s = new Socket("localhost",1234);
            // Affiche un message indiquant que le client est connecté au serveur
            System.out.println("Je suis connecté au serveur");
            int op1,op2;
            String operation;
         // Récupère les flux d'entrée et de sortie du socket pour communiquer avec le serveur
            InputStream is=s.getInputStream();
            OutputStream os = s.getOutputStream();
            //ObjectOutputStream oos=new ObjectOutputStream(os);
            (new ObjectOutputStream(s.getOutputStream())).writeObject(new Operation(op1,operation,op2));
            //l os jeybetha mn aand socket
            //printwriter hiyya li bch tekteb bl carac bl carac
            //os bch tnajm tekteb beha bl octet bl octet w true tab3eth kol haja tlamadha
            Scanner scan=new Scanner(System.in);
            System.out.println("donner un nombre");
            op1=scan.nextInt();
            System.out.println("donner le premier nombre");
            op1=scan.nextInt();
            System.out.println("donner le deuxieme nombre");
            op2=scan.nextInt();
            do {
            System.out.println("donner une operation(+,-,/,%)");
                operation=scan.nextLine();
            }
            while(!operation.equals("+") && !operation.equals("-") && !operation.equals("/") && !operation.equals("%"));
            PrintWriter pw=new PrintWriter(os,true);
pw.println(op1);
            pw.println(op2);
            pw.println(operation);
            /*ObjectInputStream ois=new ObjectInputStream(is);
ois.readObject();
System.out.println(op1+" "+operation+" "+op2+" = "+(Operation)(new ObjectInputStream(s.getInputStream())).readObject())).getRes());
            // Affiche un message de déconnexion du client
            System.out.println("Déconnexion client");

            // Ferme le socket du client (déconnexion)
            s.close();

        } catch (IOException e) {
            // En cas d'erreur d'entrée/sortie
            e.printStackTrace();
        }
    }

}

*/