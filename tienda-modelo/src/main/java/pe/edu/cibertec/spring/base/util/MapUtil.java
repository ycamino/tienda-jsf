package pe.edu.cibertec.spring.base.util;

import java.util.HashMap;
import java.util.Map;

public interface MapUtil {

    static <K, V> Map<K, V> crearMapa(K llave, V valor) {
        Map<K, V> mapa = new HashMap<>();
        mapa.put(llave, valor);
        return mapa;
    }

    static <K, V> Map<K, V> crearMapa(K llave1, V valor1, K llave2, V valor2) {
        Map<K, V> mapa = new HashMap<>();
        mapa.put(llave1, valor1);
        mapa.put(llave2, valor2);
        return mapa;
    }
}
