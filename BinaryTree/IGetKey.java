package src;

/**
 * @author MAAG
 *
 */
public interface IGetKey<K, V> {
	K getKeyFromValue(V value);
}