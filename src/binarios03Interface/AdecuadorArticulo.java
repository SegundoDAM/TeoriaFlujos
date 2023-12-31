package binarios03Interface;

import java.io.DataOutputStream;
import java.io.IOException;

public class AdecuadorArticulo implements Adecuador {

	@Override
	public boolean graba(DataOutputStream conversor, Object objeto) {
		assert objeto instanceof Articulo && conversor != null;
		boolean retorno = true;
		Articulo articulo = (Articulo) objeto;
		try {
			conversor.writeInt(articulo.id);
			conversor.writeUTF(articulo.nombre);

		} catch (IOException e) {
			retorno = false;
		}
		return false;
	}

}
