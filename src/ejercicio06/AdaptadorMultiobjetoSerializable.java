package ejercicio06;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class AdaptadorMultiobjetoSerializable<T extends Serializable> implements IAdaptadorLectorMultiObjetos<T>,IAdaptadorGrabador<T> {

	String path;

	public AdaptadorMultiobjetoSerializable(String path) {
		super();
		this.path = path;
	}

	@Override
	public T leer(int posicion) {
		ObjectInputStream deserilizador = null;
		Object readObject = null;
		try {
			deserilizador = new ObjectInputStream(new FileInputStream(path));
			if (deserilizador != null) {
				int contador = 1;
				while (contador++ <= posicion) {
					readObject = deserilizador.readObject();
				}
			}
		} catch (FileNotFoundException e) {
			readObject = null;
		} catch (EOFException e) {
			readObject = null;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			deserilizador.close();
		} catch (Exception e) {
		}
		return (T) readObject;
	}

	@Override
	public boolean grabar(T objeto) {
		ObjectOutputStream serializador = null;
		boolean retorno = true;
		try {
			boolean exists = new File(path).exists();
			FileOutputStream out = new FileOutputStream(path, true);
			if (exists) {
				serializador = new MyObjectOutputStream(out);
			} else {
				serializador = new ObjectOutputStream(out);
			}
			serializador.writeObject(objeto);
		} catch (Exception e) {
			retorno = false;
		}
		try {
			serializador.close();
		} catch (IOException e) {
			retorno = false;
			e.printStackTrace();
		}
		return retorno;
	}
}
