package com.springboot.securitymybatisjsonverifycode.sys.service;

import java.util.List;

import com.springboot.securitymybatisjsonverifycode.common.res.ApiResult;
import com.springboot.securitymybatisjsonverifycode.common.service.BaseService;
import com.springboot.securitymybatisjsonverifycode.sys.entity.Role;
import com.springboot.securitymybatisjsonverifycode.sys.req.RoleReq;

/**<p>Title:Role 服务接口 </p>
 * <p>Description: </p>
 * <p>作者：hyhong</p>
 * <p>日期：2020-06-22 10:31:55</p>
 * <p>版本：1.0</p>
 */
public interface RoleService extends BaseService<Role,Long> {
    public ApiResult bindPermission(RoleReq role);
}
