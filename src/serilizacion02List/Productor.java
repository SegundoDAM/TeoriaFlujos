package serilizacion02List;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import serializacion01.Cliente;

public class Productor {
public static void main(String[] args) {
	ArrayList<Cliente> clientes=new ArrayList<>();
	clientes.add(new Cliente(1, "donald", true, 10000000f));
	clientes.add(new Cliente(1, "paquito", true, 10000000f));
	clientes.add(new Cliente(1, "zapatero", true, 10000000f));
	ObjectOutputStream serializador = null;
	try {
		serializador=new ObjectOutputStream(new FileOutputStream("cliente.dat"));
		serializador.writeObject(clientes);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		serializador.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
