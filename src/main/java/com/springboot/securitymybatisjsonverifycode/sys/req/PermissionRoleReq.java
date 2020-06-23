package com.springboot.securitymybatisjsonverifycode.sys.req;


import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.springboot.securitymybatisjsonverifycode.sys.entity.PermissionRole;

/**<p>Title:PermissionRole </p>
 * <p>Description:对应表名：t_sys_permission_role  </p>
 * <p>作者：hyhong</p>
 * <p>日期：2020-06-22 10:31:55</p>
 * <p>版本：1.0</p>
 */
public class PermissionRoleReq extends PermissionRole {
	
	/*Auto generated properties start*/
	
	/**
	 * 权限角色ID
	 */
	private Long permissionRoleId;
	/**
	 * 权限ID
	 */
	private Long permissionId;
	/**
	 * 角色ID
	 */
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
