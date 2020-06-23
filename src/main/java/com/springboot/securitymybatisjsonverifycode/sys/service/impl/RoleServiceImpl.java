package com.springboot.securitymybatisjsonverifycode.sys.service.impl;
import com.springboot.securitymybatisjsonverifycode.common.res.ApiResult;
import com.springboot.securitymybatisjsonverifycode.sys.dao.PermissionRoleDao;
import com.springboot.securitymybatisjsonverifycode.sys.req.RoleReq;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.securitymybatisjsonverifycode.common.service.impl.BaseServiceImpl;


import com.springboot.securitymybatisjsonverifycode.sys.entity.Role;
import com.springboot.securitymybatisjsonverifycode.sys.dao.RoleDao;
import com.springboot.securitymybatisjsonverifycode.sys.service.RoleService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**<p>Title:Role 服务实现类 </p>
 * <p>Description: </p>
 * <p>作者：hyhong</p>
 * <p>日期：2020-06-22 10:31:55</p>
 * <p>版本：1.0</p>
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role,Long> implements RoleService {

    @Autowired
	private RoleDao roleDao;

    @Autowired
    private PermissionRoleDao rolePermissionDao;

    @Override
    @Transactional(readOnly = false)
    public ApiResult bindPermission(RoleReq role) {
        try{
            String permissionIds = role.getPermissionIds();

            List list = Arrays.asList(StringUtils.delimitedListToStringArray(permissionIds, ","));
            rolePermissionDao.deleteBatchByRoleId(role.getRoleId());
            if(list.size() !=0){
                Map map = new HashMap<String,Object>();
                map.put("roleId", role.getRoleId());
                map.put("permissionIds",list);
                rolePermissionDao.insetBatchByRoleId(map);
                Role roleInfo = new Role();
                roleInfo.setRoleId(role.getRoleId());
                roleInfo.setPermissionIds(role.getPermissionIds());
                roleInfo.setPermissionNames(role.getPermissionNames());
                roleDao.update(roleInfo);
                return  ApiResult.success();
            }else{
                return ApiResult.fail("请选择需要绑定的角色");
            }
        }catch (Exception e){
            return  ApiResult.fail(e.getMessage());
        }
    }


}
