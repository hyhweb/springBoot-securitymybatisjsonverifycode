package com.springboot.securitymybatisjsonverifycode.sys.dao;

import java.util.List;
import java.util.Map;

import com.springboot.securitymybatisjsonverifycode.sys.entity.UserRole;
import com.springboot.securitymybatisjsonverifycode.common.dao.BaseDao;

/**<p>Title:UserRole 持久化接口 </p>
 * <p>Description: </p>
 * <p>作者：hyhong</p>
 * <p>日期：2020-06-22 10:31:55</p>
 * <p>版本：1.0</p>
 */
public interface UserRoleDao extends BaseDao<UserRole,Long> {
    public void insetBatchByUserId(Map map);
    public void deleteBatchByUserId(Long userId);
}
