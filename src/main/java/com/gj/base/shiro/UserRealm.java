package com.gj.base.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.gj.user.beans.User;
import com.gj.user.service.IUserService;

/**
 * 验证用户登录
 * 
 * @author Administrator
 */
@Component("userRealm")
public class UserRealm extends AuthorizingRealm {
	
	public static final String CURRENT_USER ="currentUser";

	@Autowired
	@Lazy
	private IUserService userService;

	public UserRealm() {
		setName("UserRealm");
		// 采用MD5加密
		setCredentialsMatcher(new HashedCredentialsMatcher("md5"));
	}

	// 权限资源角色
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		String userName = (String) principals.getPrimaryPrincipal();
		User user = userService.selectByUserName(userName);
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// add Permission Resources
		// info.setStringPermissions(userService.findPermissions(username));
		// add Roles String[Set<String> roles]
		// info.setRoles(roles);
		return info;
	}

	// 登录验证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upt = (UsernamePasswordToken) token;
		String userName = upt.getUsername();
		User user = userService.selectByUserName(userName);
		if (user == null) {
			throw new UnknownAccountException();
		}
		String password = user.getPassword();
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName, password, getName());
		return info;
	}
}
