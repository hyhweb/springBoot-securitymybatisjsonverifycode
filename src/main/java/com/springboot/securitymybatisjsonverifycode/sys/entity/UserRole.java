package com.springboot.securitymybatisjsonverifycode.sys.entity;


import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.springboot.securitymybatisjsonverifycode.common.entity.CreateUpdateEntity;

/**<p>Title:UserRole </p>
 * <p>Description:对应表名：t_sys_user_role  </p>
 * <p>作者：hyhong</p>
 * <p>日期：2020-06-22 10:31:55</p>
 * <p>版本：1.0</p>
 */
@ApiModel(value = "t_sys_user_role")
public class UserRole extends CreateUpdateEntity{

	private static final long serialVersionUID = 162755006246812631L;
	
	/*Auto generated properties start*/
	
	/**
	 * ID
	 */
    @ApiModelProperty(value = "ID")
	private Long userRoleId;
	/**
	 * user_id
	 */
    @ApiModelProperty(value = "user_id")
	private Long userId;
	/**
	 * role_id
	 */
    @ApiModelProperty(value = "role_id")
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
