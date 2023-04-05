package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CarDaoImp implements  CarDao {
    private SessionFactory sessionFactory;
    @Autowired
    public CarDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getUser(String model, int series){
        return sessionFactory.getCurrentSession()
                .createQuery("FROM User where car.model = :model and car.series = :series")
                .setParameter("model", model)
                .setParameter("series", series).getResultList();
    }
}
