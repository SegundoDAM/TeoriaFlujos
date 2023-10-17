package serializacion04AccesoUnitario;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import serializacion01.Cliente;

public class Consumidor {

	public static void main(String[] args) {
		Consumidor consumidor = new Consumidor();
		Object obtenerObjeto = consumidor.obtenerObjeto(3);
	}

	public Object obtenerObjeto(int posicion) {
		ObjectInputStream deserilizador = null;
		Object readObject = null;
		try {
			deserilizador = new ObjectInputStream(new FileInputStream("clientes.dat"));
			if (deserilizador != null) {
				int contador = 1;
				while (contador++ <= posicion) {
					readObject = deserilizador.readObject();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			readObject = null;
		} catch (EOFException e) {
			readObject = null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			deserilizador.close();
		} catch (Exception e) {
		}
		return readObject;
	}

}
