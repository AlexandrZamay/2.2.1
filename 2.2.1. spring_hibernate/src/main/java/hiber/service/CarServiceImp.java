package hiber.service;

import hiber.dao.CarDao;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CarServiceImp implements CarService {
    @Autowired
    CarDao carDao;
    @Override
    @Transactional
    public List<User> getUser(String model, int series){
        return  carDao.getUser(model, series);
    }
}
