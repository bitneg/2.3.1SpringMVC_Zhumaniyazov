package web.service;



import org.springframework.stereotype.Repository;
import web.DAO.UserDao;
import web.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user){
         userDao.update(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}