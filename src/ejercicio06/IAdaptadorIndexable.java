package ejercicio06;

public interface IAdaptadorIndexable<K, S> {

	public S leer(K k);

	public boolean grabar(S s, K k);
}
