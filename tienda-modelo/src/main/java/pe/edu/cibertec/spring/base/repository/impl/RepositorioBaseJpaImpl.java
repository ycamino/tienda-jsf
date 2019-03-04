package pe.edu.cibertec.spring.base.repository.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.core.GenericTypeResolver;
import pe.edu.cibertec.spring.base.dominio.base.Entidad;
import pe.edu.cibertec.spring.base.repository.Repositorio;

public abstract class RepositorioBaseJpaImpl<E extends Entidad> implements Repositorio<E> {

    @PersistenceContext
    protected EntityManager em;

    protected Class<E> claseEntidad;

    @SuppressWarnings("unchecked")
	public RepositorioBaseJpaImpl() {
        claseEntidad = (Class<E>) GenericTypeResolver
                .resolveTypeArguments(getClass(),
                        RepositorioBaseJpaImpl.class)[0];
    }

    @Override
    public void guardar(E entidad) {
        em.persist(entidad);
    }

    @Override
    public void actualizar(E entidad) {
        em.merge(entidad);
    }

    @Override
    public void eliminar(E entidad) {
        em.remove(entidad);
    }

    @Override
    public E obtenerPorId(Integer id) {
        return em.find(claseEntidad, id);
    }

    @Override
    public List<E> obtenerTodos() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<E> query = cb.createQuery(claseEntidad);
        Root<E> root = query.from(claseEntidad);
        TypedQuery<E> tquery = em.createQuery(query.select(root));
        return tquery.getResultList();
    }

    private void agregarParametros(TypedQuery<?> tquery, Map<String, Object> parametros) {
        if (parametros != null && !parametros.isEmpty()) {
            parametros.entrySet().forEach(e -> tquery.setParameter(e.getKey(), e.getValue()));
        }
    }

    protected List<E> obtenerComoLista(String jpql) {
        return obtenerComoLista(jpql, Collections.emptyMap());
    }

    protected List<E> obtenerComoLista(String jpql, Map<String, Object> parametros) {
        TypedQuery<E> tquery = em.createQuery(jpql, claseEntidad);
        agregarParametros(tquery, parametros);
        return tquery.getResultList();
    }

    protected E obtenerUnicoResultado(String jpql, Map<String, Object> parametros) {
        List<E> lista = obtenerComoLista(jpql, parametros);
        return lista.isEmpty() || lista.size() > 1 ? null : lista.get(0);
    }

}
