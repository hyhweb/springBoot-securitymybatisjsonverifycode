package com.springboot.securitymybatisjsonverifycode.common.req;

import java.io.Serializable;


/**
 * 基础实体类
 * @author yong
 *
 * @param <PK>
 */
public abstract class BaseReq<PK extends Serializable> implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

}
