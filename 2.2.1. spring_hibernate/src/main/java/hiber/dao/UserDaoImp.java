package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {

       TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
       return query.getResultList();
   }
   @Override
   public User getUser(long id){
      return sessionFactory.getCurrentSession().get(User.class, id);
   }

   @Override
   public  List<User> listUserOwningModelAndSeries(String m, int s) {

      String HQL = "FROM User AS u WHERE u.car.model = :paramModel AND u.car.series = :paramSeries";
      Query query = sessionFactory.getCurrentSession().createQuery(HQL);
      query.setParameter("paramModel", m);
      query.setParameter("paramSeries", s);

      return query.getResultList();
   }
}
