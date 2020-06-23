package com.springboot.securitymybatisjsonverifycode.sys.req;


import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.springboot.securitymybatisjsonverifycode.sys.entity.User;

/**<p>Title:User </p>
 * <p>Description:对应表名：t_sys_user  </p>
 * <p>作者：hyhong</p>
 * <p>日期：2020-06-22 10:31:55</p>
 * <p>版本：1.0</p>
 */
public class UserReq extends User {

	/*Auto generated properties start*/

	/**
	 * 用户ID
	 */
	private Long id;
	/**
	 * 用户名
	 */
	private String username;
	private String password;
	private Boolean enabled;
	private Boolean locked;



	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}

	public String getUsername(){
		return username;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public boolean getEnabled(){
		return enabled;
	}

	public void setEnabled(boolean enabled){
		this.enabled = enabled;
	}

	public boolean getLocked(){
		return locked;
	}

	public void setLocked(boolean locked){
		this.locked = locked;
	}




    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
    }
}
