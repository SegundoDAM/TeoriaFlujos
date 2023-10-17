package serializacion03Conjunto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import serializacion01.Cliente;

public class Consumidor {

	public static void main(String[] args) {
		ObjectInputStream deserilizador = null;
		Cliente cliente=null;
		try {
			deserilizador=new ObjectInputStream(new FileInputStream("clientes.dat"));
			cliente=(Cliente) deserilizador.readObject();
			System.out.println(cliente);
			cliente=(Cliente) deserilizador.readObject();
			System.out.println(cliente);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			deserilizador.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
