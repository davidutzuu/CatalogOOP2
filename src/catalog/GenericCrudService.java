package catalog;

public interface GenericCrudService<T> {
    void create(T entity);
    T read(int id);
    void update(T entity);
    void delete(int id);
}