package com.springboot.securitymybatisjsonverifycode.common.entity;

import java.io.Serializable;


/**
 * 基础实体类
 * @author yong
 *
 * @param <PK>
 */
public abstract class BaseEntity<PK extends Serializable> implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 得到主键
	 * @return
	 */
}
