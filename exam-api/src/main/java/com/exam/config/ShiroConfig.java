package com.exam.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //负责拦截所有请求
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        /*
         * map中 value 的取值
         * anon:  无需认证
         * authc: 必须认证
         * user:  必须拥有 记住我 功能
         * perms:  拥有对某个资源的权限
         * role：拥有某个角色权限
         */
        Map<String, String> filterMap = new LinkedHashMap<>();

//        filterMap.put("/add","perms[admin:add]"); // url:add,角色为admin有add权限
//        filterMap.put("/update","perms[user:update]");
        filterMap.put("/login","anon");
        filterMap.put("/loginUser","anon");
        filterMap.put("/register","anon");
        filterMap.put("/toRegister","anon");

//
        filterMap.put("/index","authc");
        filterMap.put("/","authc");
        filterMap.put("/index.html","authc");


        bean.setFilterChainDefinitionMap(filterMap);

        //若没有认证就转到这个 /toLogin ,再由Controller转到登录页面
        // 不设置次属性会有默认的登录页
        bean.setLoginUrl("login.html");

        return bean;
    }
    //创建安全管理器
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getSecurityManager(Realm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    //创建自定义realm
    @Bean
    public Realm UserRealm(){
        UserRealm userRealm = new UserRealm();
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //设置加密算法
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        //设置哈希散列的次数为 1024次
        hashedCredentialsMatcher.setHashIterations(1024);
        //设置匹配规则
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return userRealm;
    }

    //加方言,否则标签不生效
    @Bean(name = "shiroDialect")
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

    /**
     *  开启shiro aop 注解支持. 否则注解不生效
     *  使用代理方式;所以需要开启代码支持;
     * @return
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }
    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}

