package htmlNenavizhu.service;

import htmlNenavizhu.dao.UserDaoImp;
import htmlNenavizhu.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserDaoImp userDao;

    @Transactional(readOnly = true)
    @Override
    public List<Car> listCars() {
        return userDao.listCars();
    }
}
