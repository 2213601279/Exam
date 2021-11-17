package com.exam.config;

import com.exam.pojo.entity.User;
import com.exam.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 数据库设计：
 1、用户 -n-n-> 角色 -n-n-> 权限--> 资源
 2、用户 --> 角色 用户 --> 权限
 3、用户 --> 角色
 4、用户 --> 权限
 */
public class UserRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权");
        //获取身份信息
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        //根据主身份信息获取角色和权限信息
        User user = userService.findUserAndRoleByUsername(primaryPrincipal);
        //获得user的所有角色信息
        if (!CollectionUtils.isEmpty(user.getRoles())){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            //将角色加入到授权中
            user.getRoles().forEach(role -> {
                info.addRole(role.getRoleName());
                System.out.println(role.getRoleName());
            });
            return info;
        }
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证");
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;

        //获取token中的 username
        String principal = (String) token.getPrincipal();

        //根据username从MYSQL查对象
        User user = userService.findUserByName(principal);

        //查到的对象不为null则执行密码匹配策略
        if(!ObjectUtils.isEmpty(user)){
            //参数1：数据库用户名，参数2：MD5+salt加密密码，参数3：注册时的随机salt，参数4：realm的名字
            return new SimpleAuthenticationInfo(user.getName(),user.getPassword(), ByteSource.Util.bytes(user.getSalt()),this.getName());
        }
        return null; // 抛出 UnknownAccountException异常
    }
}
