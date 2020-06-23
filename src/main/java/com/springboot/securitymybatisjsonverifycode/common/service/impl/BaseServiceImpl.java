package com.springboot.securitymybatisjsonverifycode.common.service.impl;

import com.springboot.securitymybatisjsonverifycode.common.req.QueryReq;
import com.springboot.securitymybatisjsonverifycode.common.res.ApiResult;
import com.springboot.securitymybatisjsonverifycode.common.res.PageList;
import com.springboot.securitymybatisjsonverifycode.common.service.BaseService;
import com.springboot.securitymybatisjsonverifycode.common.dao.BaseDao;
import com.springboot.securitymybatisjsonverifycode.common.entity.BaseEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
* Created by  hyhong admin on 2018/11/17.
*/
@Transactional(readOnly = true)
@Lazy
public class BaseServiceImpl<T extends BaseEntity,ID extends Serializable> implements BaseService<T,ID> {
    protected static Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
    public String generateUID() {
    return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }

    @Autowired
    BaseDao<T,ID> baseDao;
    @Override
    public ApiResult get(ID id) {
    return  ApiResult.success(baseDao.get(id));
    }

    @Override
    public ApiResult list() {
    return  ApiResult.success(baseDao.list());
    }

    /*    @Override
    @Transactional(readOnly = false)
    public ApiResult add(T t) {
    if(t == null) return  ApiResult.fail("数据不能为空");
    T vt = baseDao.add(t);
    return ApiResult.success();
    }*/

    @Override
    @Transactional(readOnly = false)
    public ApiResult add(T t) {
    if(t == null) return  ApiResult.fail("数据不能为空");
    baseDao.add(t);
    return ApiResult.success(t);
    }

    @Override
    @Transactional(readOnly = false)
    public ApiResult delete(ID id) {
    if(id == null) return ApiResult.fail("参数不能为空");
    final int count = baseDao.delete(id);
    if(count>0){
    return ApiResult.success();
    }else{
    return ApiResult.fail("删除失败");
    }

    }

    @Override
    @Transactional(readOnly = false)
    public ApiResult update(T obj) {
    if(obj ==null) return ApiResult.fail("参数不能为空");
    final int count = baseDao.update(obj);
    if(count>0){
    return ApiResult.success(obj);
    }else {
    return  ApiResult.fail("更新失败");
    }
    }

    @Override
    public <V extends T> PageList<V> pageList(QueryReq queryReq) {
        List<V> list =  baseDao.pageList(queryReq);
            Long count = baseDao.count(queryReq);
            return new PageList<V>(list,count);
                }

                @Override
                @Transactional(readOnly = false)
                public ApiResult deleteByIds(List<ID> ids) {
                    if(ids ==null) return ApiResult.fail("参数不能为空");
                    final int count = baseDao.deleteByIds(ids);
                    if(count>0){
                    return ApiResult.success();
                    }else{
                    return ApiResult.fail("删除失败");
                    }
                    }


                    /*    @Override
                    public ApiResult Add(T obj) {
                    return null;
                    }

                    @Override
                    public ApiResult Update(T obj) {
                    return null;
                    }

                    @Override
                    public ApiResult Delete(ID id) {
                    return null;
                    }
                    @Override
                    public ApiResult DeleteByIds(List<ID> ids) {
                        return null;
                        }

                        @Override
                        public ApiResult list() {
                        return null;
                        }

                        @Override
                        public <V extends T> ApiResult<V> PageList() {
                            return null;
                            }*/
 }
