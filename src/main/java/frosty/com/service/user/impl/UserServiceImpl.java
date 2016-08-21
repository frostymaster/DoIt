package frosty.com.service.user.impl;

import frosty.com.dao.GenericDao;
import frosty.com.dao.entity.BaseUser;
import frosty.com.dao.user.UserDao;
import frosty.com.service.impl.GenericServiceImpl;
import frosty.com.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lalka on 8/16/2016.
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<BaseUser, Integer>
        implements UserService {

    private UserDao adminDao;
    public UserServiceImpl(){

    }
    @Autowired
    public UserServiceImpl(
            @Qualifier("userDaoImpl") GenericDao<BaseUser, Integer> genericDao) {
        super(genericDao);
        this.adminDao = (UserDao) genericDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean removeUser(Integer id) {
        return adminDao.removeUser(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public boolean isAdminRegistered(String userName, String password) {
        return adminDao.isAdminRegistered(userName, password);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public BaseUser getUser(String userName) {
        return adminDao.getUser(userName);
    }

    @Override
    public void createUser(BaseUser user) {
        adminDao.saveOrUpdate(user);
    }
}
