public interface Frontier<T>{

    public void add(T value);

    public T next();

    public boolean hasNext();

}
