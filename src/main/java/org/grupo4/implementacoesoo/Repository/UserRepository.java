package org.grupo4.implementacoesoo.Repository;
import org.grupo4.implementacoesoo.Domain.User;
public interface UserRepository<T extends User> {
    public T getInfo(String id);
    public void saveInfo(User user);

}
