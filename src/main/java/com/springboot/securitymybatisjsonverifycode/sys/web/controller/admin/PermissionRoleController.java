package com.springboot.securitymybatisjsonverifycode.sys.web.controller.admin;
import com.springboot.securitymybatisjsonverifycode.sys.entity.PermissionRole;
import com.springboot.securitymybatisjsonverifycode.sys.req.PermissionRoleReq;
import com.springboot.securitymybatisjsonverifycode.sys.service.PermissionRoleService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSON;

import com.springboot.securitymybatisjsonverifycode.common.req.QueryReq;
import com.springboot.securitymybatisjsonverifycode.common.controller.CommonController;
import com.springboot.securitymybatisjsonverifycode.common.res.ApiResult;
import com.springboot.securitymybatisjsonverifycode.common.res.PageList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
        import io.swagger.annotations.Api;
import java.util.HashMap;

/**<p>Title:PermissionRole 控制器 </p>
 * <p>Description: </p>
 * <p>作者：hyhong</p>
 * <p>日期：2020-06-22 10:31:55</p>
 * <p>版本：1.0</p>
 */
@RestController
@RequestMapping("/admin/sys/permissionRole")
@Api(description = "接口")
public class PermissionRoleController extends CommonController {

    @Autowired
    private PermissionRoleService permissionRoleService;


    /**
     * 查询单条记录
     * @param id
     * @return ApiResult
     */
    @Override
    public ApiResult get(@PathVariable Long id) {
        return permissionRoleService.get(id);
    }


    /**
     * 保存
     * @param json
     * @return ApiResult
     */
    @Override
    public ApiResult add(@RequestBody String json) {
            return permissionRoleService.add(JSON.parseObject(json, PermissionRoleReq.class));
    }


    /**
     * 更新
     * @param json
     * @return ApiResult
     */
    @Override
    public ApiResult update(@RequestBody String json) {
       return permissionRoleService.update(JSON.parseObject(json, PermissionRoleReq.class));
    }


    /**
     * 批量删除
     * @param json
     * @return ApiResult
     */
    @Override
    public ApiResult deleteByIds(@RequestBody String json) {
       return  permissionRoleService.deleteByIds(JSONArray.parseArray(json,Long.class));
    }

    /**
     * 分页列表查询
     * @param json
     * @return ApiResult
     */
    @Override
    public ApiResult<PageList<PermissionRole>> pageList(@RequestBody(required = false) String json) {
        QueryReq queryReq = JSON.parseObject(json, QueryReq.class);
        PageList<PermissionRole> pageList = permissionRoleService.pageList(queryReq);
        return ApiResult.success(pageList);
    }


    @Override
    public ApiResult delete(@PathVariable Long id) {
        try {
        return permissionRoleService.delete(id);
        } catch (Exception e) {
        return ApiResult.fail(e.toString());
        }
    }

    @Override
    public ApiResult list(@RequestBody(required = false) String json) {
        try {
        return permissionRoleService.list();
        } catch (Exception e) {
        return ApiResult.fail(e.toString());
        }
    }
}
