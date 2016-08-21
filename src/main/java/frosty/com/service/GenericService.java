package frosty.com.service;

import java.util.List;

/**
 * Created by lalka on 8/16/2016.
 */
public interface GenericService<E, K> {
    public void saveOrUpdate(E entity);
    public List<E> getAll();
    public E get(K id);
    public void add(E entity);
    public void update(E entity);
    public void remove(E entity);
}
