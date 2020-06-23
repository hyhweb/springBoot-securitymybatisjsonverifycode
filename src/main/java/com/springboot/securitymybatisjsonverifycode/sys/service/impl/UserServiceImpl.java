package com.springboot.securitymybatisjsonverifycode.sys.service.impl;
import com.springboot.securitymybatisjsonverifycode.common.res.ApiResult;
import com.springboot.securitymybatisjsonverifycode.sys.dao.UserRoleDao;
import com.springboot.securitymybatisjsonverifycode.sys.entity.Role;
import com.springboot.securitymybatisjsonverifycode.sys.req.UserReq;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.securitymybatisjsonverifycode.common.service.impl.BaseServiceImpl;


import com.springboot.securitymybatisjsonverifycode.sys.entity.User;
import com.springboot.securitymybatisjsonverifycode.sys.dao.UserDao;
import com.springboot.securitymybatisjsonverifycode.sys.service.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;

/**<p>Title:User 服务实现类 </p>
 * <p>Description: </p>
 * <p>作者：hyhong</p>
 * <p>日期：2020-06-22 10:31:55</p>
 * <p>版本：1.0</p>
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User,Long> implements UserService, UserDetailsService {

    @Autowired
	private UserDao userDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userDao.getUserByName(userName);
        if(user ==null){
            throw new UsernameNotFoundException("账户不存在");
        }
        List<Role> roles = userDao.getRolesByUserId(user.getId());
        user.setRoles(roles);
        Set<String> permissions = userDao.getPermissionByUserId(user.getId());
        user.setPermissions(permissions);
        return user;
    }

    @Override
    @Transactional(readOnly = false)
    public ApiResult register(UserReq user) {
        try{
            User userInfo= userDao.getUserByName(user.getUsername());
            if(userInfo !=null){
                return ApiResult.fail("用户已存在,请使用其他用户名进行操作");
            }else{
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
                user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
                userDao.add(user);
                return ApiResult.success(user);
            }
        }catch (Exception e){
            return ApiResult.fail(e.getMessage());
        }


    }


    @Override
    @Transactional(readOnly = false)
    public ApiResult bindRole(UserReq user) {
        try{
            String roleIds = user.getRoleIds();

            List list = Arrays.asList(StringUtils.delimitedListToStringArray(roleIds, ","));
            userRoleDao.deleteBatchByUserId(user.getId());
            if(list.size() !=0){
                Map map = new HashMap<String,Object>();
                map.put("userId", user.getId());
                map.put("roleIds",list);
                userRoleDao.insetBatchByUserId(map);
                User userInfo = new User();
                userInfo.setId(user.getId());
                userInfo.setRoleIds(user.getRoleIds());
                userInfo.setRoleNames(user.getRoleNames());
                userDao.update(userInfo);
                return  ApiResult.success();
            }else{
                return ApiResult.fail("请选择需要绑定的角色");
            }
        }catch (Exception e){
            return  ApiResult.fail(e.getMessage());
        }

    }



}
