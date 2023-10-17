package serializacion04AccesoUnitario;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import serializacion01.Cliente;

public class Consumidor {

	public static void main(String[] args) {
		Consumidor consumidor = new Consumidor();
		Object obtenerObjeto = consumidor.obtenerObjeto(1);
		obtenerObjeto.toString();
	}

	public Object obtenerObjeto(int posicion) {
		ObjectInputStream deserilizador = null;
		Object readObject=null;
		try {
			deserilizador=new ObjectInputStream(new FileInputStream("clientes.dat"));
			int contador=1;
			while(contador++<=posicion) {
				readObject = deserilizador.readObject();
			}
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
		return readObject;
	}

}
