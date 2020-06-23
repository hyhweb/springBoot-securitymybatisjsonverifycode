package com.springboot.securitymybatisjsonverifycode.sys.entity;


import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.springboot.securitymybatisjsonverifycode.common.entity.CreateUpdateEntity;

/**<p>Title:Permission </p>
 * <p>Description:对应表名：t_sys_permission  </p>
 * <p>作者：hyhong</p>
 * <p>日期：2020-06-22 10:31:55</p>
 * <p>版本：1.0</p>
 */
@ApiModel(value = "t_sys_permission")
public class Permission extends CreateUpdateEntity{

	private static final long serialVersionUID = -5611920795752071940L;
	
	/*Auto generated properties start*/
	
	/**
	 * 权限ID
	 */
    @ApiModelProperty(value = "权限ID")
	private Long permissionId;
	/**
	 * 权限名称
	 */
    @ApiModelProperty(value = "权限名称")
	private String permissionName;
	/**
	 * 权限编码
	 */
    @ApiModelProperty(value = "权限编码")
	private String permissionCode;

	
	
	public Long getPermissionId(){
		return permissionId;
	}
	
	public void setPermissionId(Long permissionId){
		this.permissionId = permissionId;
	}

	public String getPermissionName(){
		return permissionName;
	}
	
	public void setPermissionName(String permissionName){
		this.permissionName = permissionName;
	}

	public String getPermissionCode(){
		return permissionCode;
	}
	
	public void setPermissionCode(String permissionCode){
		this.permissionCode = permissionCode;
	}

	


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
    }
}
