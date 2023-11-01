package connectioOperationact2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
public static void main(String[]args) throws ClassNotFoundException

{

try {
System.out.println("je suis un serveur");
ServerSocket serversocket =new ServerSocket(1234);
//creation un objet Socket et attend la connexion du client
Socket s=serversocket.accept();
// Affiche un message indiquant qu'un client est connecté
System.out.println("un client est connecté");
// Récupère les flux d'entrée et de sortie du socket pour communiquer avec le client
ObjectInputStream is=new ObjectInputStream(s.getInputStream());
Operation o1 = (Operation) is.readObject();
int op1=o1.getOp1();
int op2=o1.getOp2();
char operation=o1.getOperation();

int resultat=0;
switch(operation)
{
case'+':resultat=op1+op2;break;
case'-':resultat=op1-op2;break;
case'/':resultat=op1/op2;break;
case'*':resultat=op1*op2;break;
}
o1.setResultat(resultat);
ObjectOutputStream os=new ObjectOutputStream(s.getOutputStream());
os.writeObject(o1);
System.out.println("Serveur:Le resultat a envoyer a le client");
System.out.println("Déconnexion Serveur");
// Ferme le socket (déconnexion de la communication entre le serveur et le client)
//déconnexion et Fermeture de ServerSocket
s.close();
serversocket.close();

} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

}


}
