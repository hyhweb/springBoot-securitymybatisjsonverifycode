package com.springboot.securitymybatisjsonverifycode.common.dao;

import java.io.Serializable;
import java.util.List;

import com.springboot.securitymybatisjsonverifycode.common.req.QueryReq;
/**
 * 数据对象基础操作类
 * @author hyhong
 * 
 */
public interface BaseDao<T,PK extends Serializable> {
	
	/**
	 * 增加对象
	 * @param obj
	 */
	public void add(T obj);

	/**
	 * 修改对象
	 * @param obj
	 */
	public int update(T obj);

	/**
	 * 删除对象
	 * @param pk
	 */
	public int delete(PK pk);

	/**
	 * 得到某个对象
	 * @param pk
	 */
	public T get(PK pk);

    /**
     * 得到一组对象
     */
	public int deleteByIds(List<PK> ids);

    /**
    * 得到总数
    */
    public  Long count(QueryReq queryReq);

    /**
    * 得到分页列表
    */
    public <V extends T> List<V> pageList(QueryReq queryReq);

	/**
	* 得到列表
	*/
	public <V extends T> List<V> list();
	/**
	* 得到列表
	*/
	public <V extends T> List<V> list(T obj);

}
