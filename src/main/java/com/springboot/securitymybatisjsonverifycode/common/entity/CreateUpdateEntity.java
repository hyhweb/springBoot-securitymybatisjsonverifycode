package com.springboot.securitymybatisjsonverifycode.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体类
 * @author hyhong
 *
 * @param <PK>
 */
public abstract class CreateUpdateEntity extends BaseEntity  {

    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 创建人id
    */
    private Long createrId;
    /**
    * 创建人名称
    */
    private String createrName;
    /**
    * 更新人id
    */
    private Long updaterId;
    /**
    * 更新人名称
    */
    private String updaterName;

    public Date getCreateTime() {
    return createTime;
    }

    public void setCreateTime(Date createTime) {
    this.createTime = createTime;
    }

    public Date getUpdateTime() {
    return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
    }

    public Long getCreaterId() {
    return createrId;
    }

    public void setCreaterId(Long createrId) {
    this.createrId = createrId;
    }

    public String getCreaterName() {
    return createrName;
    }

    public void setCreaterName(String createrName) {
    this.createrName = createrName;
    }

    public Long getUpdaterId() {
    return updaterId;
    }

    public void setUpdaterId(Long updaterId) {
    this.updaterId = updaterId;
    }

    public String getUpdaterName() {
    return updaterName;
    }

    public void setUpdaterName(String updaterName) {
    this.updaterName = updaterName;
    }
	

}
