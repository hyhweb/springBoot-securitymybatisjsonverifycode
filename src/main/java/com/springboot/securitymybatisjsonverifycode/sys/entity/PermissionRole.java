package com.springboot.securitymybatisjsonverifycode.sys.entity;


import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.springboot.securitymybatisjsonverifycode.common.entity.CreateUpdateEntity;

/**<p>Title:PermissionRole </p>
 * <p>Description:对应表名：t_sys_permission_role  </p>
 * <p>作者：hyhong</p>
 * <p>日期：2020-06-22 10:31:55</p>
 * <p>版本：1.0</p>
 */
@ApiModel(value = "t_sys_permission_role")
public class PermissionRole extends CreateUpdateEntity{

	private static final long serialVersionUID = 9126232389151743325L;
	
	/*Auto generated properties start*/
	
	/**
	 * 权限角色ID
	 */
    @ApiModelProperty(value = "权限角色ID")
	private Long permissionRoleId;
	/**
	 * 权限ID
	 */
    @ApiModelProperty(value = "权限ID")
	private Long permissionId;
	/**
	 * 角色ID
	 */
    @ApiModelProperty(value = "角色ID")
	private Long roleId;

	
	
	public Long getPermissionRoleId(){
		return permissionRoleId;
	}
	
	public void setPermissionRoleId(Long permissionRoleId){
		this.permissionRoleId = permissionRoleId;
	}

	public Long getPermissionId(){
		return permissionId;
	}
	
	public void setPermissionId(Long permissionId){
		this.permissionId = permissionId;
	}

	public Long getRoleId(){
		return roleId;
	}
	
	public void setRoleId(Long roleId){
		this.roleId = roleId;
	}

	


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
    }
}
