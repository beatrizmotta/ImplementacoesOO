package Repository;
import Domain.User;
public interface UserRepository<T extends User> {
    public T getInfo(String id);
    public void saveInfo(User user);

}
