package com.springboot.securitymybatisjsonverifycode.sys.entity;


import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.springboot.securitymybatisjsonverifycode.common.entity.CreateUpdateEntity;

/**<p>Title:Role </p>
 * <p>Description:对应表名：t_sys_role  </p>
 * <p>作者：hyhong</p>
 * <p>日期：2020-06-22 10:31:55</p>
 * <p>版本：1.0</p>
 */
@ApiModel(value = "t_sys_role")
public class Role extends CreateUpdateEntity{

	private static final long serialVersionUID = 7527087928315925243L;

	/*Auto generated properties start*/

    @ApiModelProperty(value = "")
	private Long roleId;
    @ApiModelProperty(value = "")
	private String name;
    @ApiModelProperty(value = "")
	private String nameText;

	@ApiModelProperty(value = "权限ID")
	private String permissionIds;
	@ApiModelProperty(value = "权限名称")
	private String permissionNames;


	public Long getRoleId(){
		return roleId;
	}

	public void setRoleId(Long roleId){
		this.roleId = roleId;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getNameText(){
		return nameText;
	}

	public void setNameText(String nameText){
		this.nameText = nameText;
	}

	public String getPermissionIds() {
		return permissionIds;
	}

	public void setPermissionIds(String permissionIds) {
		this.permissionIds = permissionIds;
	}

	public String getPermissionNames() {
		return permissionNames;
	}

	public void setPermissionNames(String permissionNames) {
		this.permissionNames = permissionNames;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
    }
}
