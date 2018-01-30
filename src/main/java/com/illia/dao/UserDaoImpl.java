package com.illia.dao;

import com.illia.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public User addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
        return user;
    }

    public User findById(Long id) {
        String query = "select u from  User as u " +
                "inner join ProductOrder as o " +
                "on u.id = o.id " +
                "where u.id =:id";
        User user = (User) sessionFactory
                .getCurrentSession()
                .createQuery(query)
                .setParameter("id", id)
                .uniqueResult();
        return user;
    }
}




/*private JdbcTemplate jdbcTemplate;

    public User addUser(User user) {
        String sql = "INSERT INTO USERS " +
                "(ID, EMAIL, PASSWORD, FIRST_NAME, LAST_NAME, REGISTER_DATE)" +
                " VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getRegisterDate()
        );
        return user;
    }*/

