package com.springboot.securitymybatisjsonverifycode.sys.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.securitymybatisjsonverifycode.common.service.impl.BaseServiceImpl;


import com.springboot.securitymybatisjsonverifycode.sys.entity.PermissionRole;
import com.springboot.securitymybatisjsonverifycode.sys.dao.PermissionRoleDao;
import com.springboot.securitymybatisjsonverifycode.sys.service.PermissionRoleService;

/**<p>Title:PermissionRole 服务实现类 </p>
 * <p>Description: </p>
 * <p>作者：hyhong</p>
 * <p>日期：2020-06-22 10:31:55</p>
 * <p>版本：1.0</p>
 */
@Service
public class PermissionRoleServiceImpl extends BaseServiceImpl<PermissionRole,Long> implements PermissionRoleService {

    @Autowired
	private PermissionRoleDao permissionRoleDao;




}
