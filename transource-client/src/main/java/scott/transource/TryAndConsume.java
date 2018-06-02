package scott.transource;

public interface TryAndConsume<T,X extends Throwable> {

    void accept(T object) throws X;

}
