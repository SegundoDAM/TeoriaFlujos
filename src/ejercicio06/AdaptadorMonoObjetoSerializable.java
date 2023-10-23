package ejercicio06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class AdaptadorMonoObjetoSerializable<S extends Serializable> implements IAdaptadorLectorMonoObjeto<S>,IAdaptadorGrabador<S> {
	private String path;
	
	public AdaptadorMonoObjetoSerializable(String path) {
		super();
		this.path = path;
	}

	@Override
	public S leer() {
		File file = new File(path);
		FileInputStream flujoR = null;
		S retorno=null;
		if (file.exists()) {
			try {
				flujoR = new FileInputStream(file);
				ObjectInputStream conversorR = new ObjectInputStream(flujoR);
				retorno=(S) conversorR.readObject();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				flujoR.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return retorno;
	}

	@Override
	public boolean grabar(S objeto) {
		ObjectOutputStream serializador = null;
		boolean retorno=false;
		try {
			serializador=new ObjectOutputStream(new FileOutputStream(path));
			serializador.writeObject(objeto);
			retorno=true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			serializador.close();
		} catch (IOException e) {
			retorno=false;
			e.printStackTrace();
		}
		return retorno;
	}

}
