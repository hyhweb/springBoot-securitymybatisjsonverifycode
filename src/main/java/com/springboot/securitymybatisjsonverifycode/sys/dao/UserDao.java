package com.springboot.securitymybatisjsonverifycode.sys.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.springboot.securitymybatisjsonverifycode.sys.entity.Role;
import com.springboot.securitymybatisjsonverifycode.sys.entity.User;
import com.springboot.securitymybatisjsonverifycode.common.dao.BaseDao;
import com.springboot.securitymybatisjsonverifycode.sys.req.UserReq;

/**<p>Title:User 持久化接口 </p>
 * <p>Description: </p>
 * <p>作者：hyhong</p>
 * <p>日期：2020-06-22 10:31:55</p>
 * <p>版本：1.0</p>
 */
public interface UserDao extends BaseDao<User,Long> {
    public User getUserByName(String userName);
    public List<Role> getRolesByUserId(Long userId);
    public Set<String> getPermissionByUserId(Long userId);
    public void register(UserReq user);
    public List<Role> getRolesByUserIds(Long userId);
}
