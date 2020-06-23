package com.springboot.securitymybatisjsonverifycode.sys.req;


import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.springboot.securitymybatisjsonverifycode.sys.entity.Role;

/**<p>Title:Role </p>
 * <p>Description:对应表名：t_sys_role  </p>
 * <p>作者：hyhong</p>
 * <p>日期：2020-06-22 10:31:55</p>
 * <p>版本：1.0</p>
 */
public class RoleReq extends Role {
	
	/*Auto generated properties start*/
	
	private Long roleId;
	private String name;
	private String nameText;

	
	
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

	


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
    }
}
