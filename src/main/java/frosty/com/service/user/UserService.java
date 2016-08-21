package frosty.com.service.user;

import frosty.com.dao.entity.BaseUser;
import frosty.com.service.GenericService;

/**
 * Created by lalka on 8/16/2016.
 */
public interface UserService extends GenericService<BaseUser,Integer> {
    public boolean removeUser(Integer id);
    public boolean isAdminRegistered(String userName, String password);
    public BaseUser getUser(String userName);
    public void createUser(BaseUser user);
}
