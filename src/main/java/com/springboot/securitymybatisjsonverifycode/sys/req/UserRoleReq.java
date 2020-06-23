package com.springboot.securitymybatisjsonverifycode.sys.req;


import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.springboot.securitymybatisjsonverifycode.sys.entity.UserRole;

/**<p>Title:UserRole </p>
 * <p>Description:对应表名：t_sys_user_role  </p>
 * <p>作者：hyhong</p>
 * <p>日期：2020-06-22 10:31:55</p>
 * <p>版本：1.0</p>
 */
public class UserRoleReq extends UserRole {
	
	/*Auto generated properties start*/
	
	/**
	 * ID
	 */
	private Long userRoleId;
	/**
	 * user_id
	 */
	private Long userId;
	/**
	 * role_id
	 */
	private Long roleId;

	
	
	public Long getUserRoleId(){
		return userRoleId;
	}
	
	public void setUserRoleId(Long userRoleId){
		this.userRoleId = userRoleId;
	}

	public Long getUserId(){
		return userId;
	}
	
	public void setUserId(Long userId){
		this.userId = userId;
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
