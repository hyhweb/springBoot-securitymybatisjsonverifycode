package com.springboot.securitymybatisjsonverifycode.common.controller;

import com.springboot.securitymybatisjsonverifycode.common.res.ApiResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
* Created by  hyhong admin on 2018/11/20.
*/
@RestController
public abstract class CommonController extends BaseController  {
@ApiOperation(value="查看",notes="查看接口")
@RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
public abstract ApiResult get(@PathVariable Long id);

@ApiOperation(value = "列表下拉",notes = "列表下拉接口")
@RequestMapping(value = "/list",method=RequestMethod.GET)
public abstract ApiResult list(@RequestBody String json);

@ApiOperation(value="新增",notes = "新增接口")
@RequestMapping(value = "/add",method = RequestMethod.POST)
public  abstract ApiResult add(@RequestBody String json);

@ApiOperation(value = "删除",notes = "删除接口")
@RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
public  abstract ApiResult delete(@PathVariable Long id);

@ApiOperation(value = "编辑", notes = "编辑接口")
@RequestMapping(value = "/update",method = RequestMethod.POST)
public abstract ApiResult update(@RequestBody String json);

@ApiOperation(value = "分页列表", notes = "分页列表接口")
@RequestMapping(value = "/pageList", method=RequestMethod.POST)
@ApiImplicitParam(name = "json", value = "{\"startRow\":0,\"parameter\":{},\"pageSize\":20,\"page\":1}")
public abstract ApiResult pageList(@RequestBody String json);

@ApiOperation(value = "删除多条记录",notes = "删除多条记录接口")
@RequestMapping(value = "/deleteByIds",method = RequestMethod.POST)
public abstract ApiResult deleteByIds(@RequestBody String json);
}
