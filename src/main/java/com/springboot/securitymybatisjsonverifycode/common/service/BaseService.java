package com.springboot.securitymybatisjsonverifycode.common.service;

/**
 * 数据对象基础服务类
 * @author yong
 * 
 */
import com.springboot.securitymybatisjsonverifycode.common.req.QueryReq;
import com.springboot.securitymybatisjsonverifycode.common.res.ApiResult;
import com.springboot.securitymybatisjsonverifycode.common.entity.BaseEntity;
import com.springboot.securitymybatisjsonverifycode.common.res.PageList;

import java.io.Serializable;
import java.util.List;

/**
* Created by  hyhong admin on 2019/7/26.
*/
public interface BaseService<T extends BaseEntity,ID extends Serializable> {
    String generateUID();
    public ApiResult get(ID id);
    public ApiResult list();
    public ApiResult add(T obj);
    public ApiResult delete(ID id);
    public ApiResult update(T obj);
    public <V extends T> PageList<V> pageList(QueryReq queryReq);
    public ApiResult deleteByIds(List<ID> ids);


            /*
            public ApiResult Update(T obj);
            public ApiResult Delete(ID id);
            public ApiResult DeleteByIds(List<ID> ids);

                public <V extends T> ApiResult<V>  PageList();*/

 }
