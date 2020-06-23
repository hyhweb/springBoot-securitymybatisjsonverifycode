package com.springboot.securitymybatisjsonverifycode.sys.service;

import java.util.List;

import com.springboot.securitymybatisjsonverifycode.common.res.ApiResult;
import com.springboot.securitymybatisjsonverifycode.common.service.BaseService;
import com.springboot.securitymybatisjsonverifycode.sys.entity.User;
import com.springboot.securitymybatisjsonverifycode.sys.req.UserReq;

/**<p>Title:User 服务接口 </p>
 * <p>Description: </p>
 * <p>作者：hyhong</p>
 * <p>日期：2020-06-22 10:31:55</p>
 * <p>版本：1.0</p>
 */
public interface UserService extends BaseService<User,Long> {
    public ApiResult register(UserReq user);
    public ApiResult bindRole(UserReq user);
}
