package com.sp.mehta.applications.web.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import com.sp.mehta.applications.model.User;

public class ApplicationUserDetails extends User implements UserDetails {

	private static final long serialVersionUID = 1L;

	List<String> roleList;

	public ApplicationUserDetails(User user, List<String> roleList) {
		super(user);
		this.roleList = roleList;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String roles = StringUtils.collectionToCommaDelimitedString(roleList);
		return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return super.getActive();
	}

	@Override
	public boolean isAccountNonLocked() {
		return super.getActive();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return super.getActive();
	}

	@Override
	public boolean isEnabled() {
		return super.getActive();
	}

}
