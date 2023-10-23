package ejercicio06;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class AdaptadorSerializadoMapeable<K, T extends Serializable & Keyable<K>>
		implements IAdaptadorIndexable<K, T>, IAdaptadorGrabador<T>, Erasable<K> {
	private AdaptadorMultiobjetoSerializable<T> elementosAdaptador;
	private AdaptadorMonoObjetoSerializable<HashMap<K, Integer>> mapaAdaptador;
	private AdaptadorMonoObjetoSerializable<Integer> posicionAdaptador;
	private String pathElementos;
	private String pathMapa;
	private Map<K, Integer> mapa;
	private int lastNumber = 0;

	public AdaptadorSerializadoMapeable(String pathElementos, String pathMapa, String posicionadorPath) {
		this.pathElementos = pathElementos;
		this.pathMapa = pathMapa;
		inicializarMapa();
		mapa = mapaAdaptador.leer();
		elementosAdaptador = new AdaptadorMultiobjetoSerializable<>(pathElementos);
		posicionAdaptador = new AdaptadorMonoObjetoSerializable<Integer>(posicionadorPath);
		Integer leer = posicionAdaptador.leer();
		if (leer == null)
			lastNumber = 0;
		else
			lastNumber = leer;
	}

	private void inicializarMapa() {
		mapaAdaptador = new AdaptadorMonoObjetoSerializable<>(pathMapa);
		if (mapaAdaptador.leer() == null) {
			mapaAdaptador.grabar(new HashMap<K, Integer>());
		}
	}

	@Override
	public T leer(K k) {
		if (!mapa.isEmpty() && mapa.get(k) != null)
			return elementosAdaptador.leer(mapa.get(k));
		return null;
	}

	@Override
	public boolean grabar(T t) {
		boolean retorno = false;
		if(!mapa.containsKey(t.getKey()))
				retorno=elementosAdaptador.grabar(t);
		if (retorno) {
			Integer numeroNuevo = getNumeroNuevo();
			mapa.put(t.getKey(), numeroNuevo);
			mapaAdaptador.grabar((HashMap<K, Integer>) mapa);
			posicionAdaptador.grabar(numeroNuevo);
		}
		return retorno;
	}

	private Integer getNumeroNuevo() {
		return ++lastNumber;
	}

	// private Integer getUltimoElemento() {
	// return mapa.entrySet().stream().mapToInt(Entry::getValue).max().orElse(0);
	// }

	@Override
	public boolean borrar(K k) {
		Integer remove = mapa.remove(k);
		mapaAdaptador.grabar((HashMap<K, Integer>) mapa);
		return remove != null;
	}

}
