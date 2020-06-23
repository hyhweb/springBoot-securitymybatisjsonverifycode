package com.springboot.securitymybatisjsonverifycode.sys.web.controller.admin;
import com.springboot.securitymybatisjsonverifycode.sys.entity.Permission;
import com.springboot.securitymybatisjsonverifycode.sys.req.PermissionReq;
import com.springboot.securitymybatisjsonverifycode.sys.service.PermissionService;
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

/**<p>Title:Permission 控制器 </p>
 * <p>Description: </p>
 * <p>作者：hyhong</p>
 * <p>日期：2020-06-22 10:31:55</p>
 * <p>版本：1.0</p>
 */
@RestController
@RequestMapping("/admin/sys/permission")
@Api(description = "接口")
public class PermissionController extends CommonController {

    @Autowired
    private PermissionService permissionService;


    /**
     * 查询单条记录
     * @param id
     * @return ApiResult
     */
    @Override
    public ApiResult get(@PathVariable Long id) {
        return permissionService.get(id);
    }


    /**
     * 保存
     * @param json
     * @return ApiResult
     */
    @Override
    public ApiResult add(@RequestBody String json) {
            return permissionService.add(JSON.parseObject(json, PermissionReq.class));
    }


    /**
     * 更新
     * @param json
     * @return ApiResult
     */
    @Override
    public ApiResult update(@RequestBody String json) {
       return permissionService.update(JSON.parseObject(json, PermissionReq.class));
    }


    /**
     * 批量删除
     * @param json
     * @return ApiResult
     */
    @Override
    public ApiResult deleteByIds(@RequestBody String json) {
       return  permissionService.deleteByIds(JSONArray.parseArray(json,Long.class));
    }

    /**
     * 分页列表查询
     * @param json
     * @return ApiResult
     */
    @Override
    public ApiResult<PageList<Permission>> pageList(@RequestBody(required = false) String json) {
        QueryReq queryReq = JSON.parseObject(json, QueryReq.class);
        PageList<Permission> pageList = permissionService.pageList(queryReq);
        return ApiResult.success(pageList);
    }


    @Override
    public ApiResult delete(@PathVariable Long id) {
        try {
        return permissionService.delete(id);
        } catch (Exception e) {
        return ApiResult.fail(e.toString());
        }
    }

    @Override
    public ApiResult list(@RequestBody(required = false) String json) {
        try {
        return permissionService.list();
        } catch (Exception e) {
        return ApiResult.fail(e.toString());
        }
    }
}
