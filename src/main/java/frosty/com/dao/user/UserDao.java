package frosty.com.dao.user;

import frosty.com.dao.GenericDao;
import frosty.com.dao.entity.BaseUser;

/**
 * Created by lalka on 8/16/2016.
 */
public interface  UserDao extends GenericDao<BaseUser, Integer> {

    public boolean removeUser(Integer id);
    public boolean isAdminRegistered(String userName, String password);
    public BaseUser getUser(String username);

}
