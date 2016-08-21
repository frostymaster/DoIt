package frosty.com.dao.user.impl;

import frosty.com.dao.GenericDaoImpl;
import frosty.com.dao.entity.BaseUser;
import frosty.com.dao.user.UserDao;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by lalka on 8/16/2016.
 */
@Repository
public class UserDaoImpl extends GenericDaoImpl<BaseUser, Integer>
        implements UserDao {
    @Override
    public boolean removeUser(Integer id) {
        Query employeeTaskQuery = currentSession().createQuery(
                "from BaseUser u where :id");
        employeeTaskQuery.setParameter("id", id);
        return employeeTaskQuery.executeUpdate() > 0;
    }

    @Override
    public boolean isAdminRegistered(String userName, String password) {
        /*You can use any character instead of 'A'. If a record is found,
        only single character, in this example 'A', will return from database
        */
        Query employeeTaskQuery = currentSession().createQuery(
                "select 'A' from BaseUser u where username=:username and password=:password");
        employeeTaskQuery.setParameter("username", userName);
        employeeTaskQuery.setParameter("password", password);
        return employeeTaskQuery.list().size() > 0;
    }


    @Override
    public BaseUser getUser(String username) {
        Query query = currentSession().createQuery(
                "from BaseUser " +
                        "where username=:username");
        query.setParameter("username", username);
        return (BaseUser) query.uniqueResult();

    }
}
