package com.springboot.securitymybatisjsonverifycode.sys.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.springboot.securitymybatisjsonverifycode.common.entity.CreateUpdateEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**<p>Title:User </p>
 * <p>Description:对应表名：t_sys_user  </p>
 * <p>作者：hyhong</p>
 * <p>日期：2020-06-22 10:31:55</p>
 * <p>版本：1.0</p>
 */
@ApiModel(value = "t_sys_user")
public class User extends CreateUpdateEntity implements UserDetails {

	private static final long serialVersionUID = 3454100755464018418L;

	/*Auto generated properties start*/

	/**
	 * 用户ID
	 */
    @ApiModelProperty(value = "用户ID")
	private Long id;
	/**
	 * 用户名
	 */
    @ApiModelProperty(value = "用户名")
	private String username;
    @ApiModelProperty(value = "")
	private String password;

	@ApiModelProperty(value = "角色ID")
	private String roleIds;

	@ApiModelProperty(value = "角色名称")
	private String roleNames;


    @ApiModelProperty(value = "")
	private boolean enabled;
    @ApiModelProperty(value = "")
	private boolean locked;

	private List<Role> roles;

	private Set<String> permissions;

	private List<UserRole> userRole;



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

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public String getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
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
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		/*
		//绑定角色的授权方法
		if(roles !=null){
			for (Role sysRole : roles) {
				authorities.add(new SimpleGrantedAuthority(sysRole.getRoleCode()));
			}
		}*/

		//绑定权限的授权方法
		if(permissions !=null){
			for (String permission : permissions){
				authorities.add(new SimpleGrantedAuthority(permission));
			}
		}


		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}


	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Set<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}

	public List<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(List<UserRole> userRole) {
		this.userRole = userRole;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
    }
}
