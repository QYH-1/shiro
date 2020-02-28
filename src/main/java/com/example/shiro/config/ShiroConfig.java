package com.example.shiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro的配置类
 */
@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加Shiro内置过滤器
        /**
         *Shiro内置过滤器，实现权限相关的拦截
         * 常用过滤器：
         *      anon：无需认证（登录）可以访问
         *      authc:必须认证才能访问
         *      user：如果使用rememberme的功能可以直接访问
         *      perms：该资源必须资源权限才可以访问
         *      role：该资源必须得到角色权限才能访问
         */
        Map<String,String> filterMap = new LinkedHashMap<String, String>();
        //放行的资源
        filterMap.put("/hello","anon");
        filterMap.put("/login","anon");
        //授权过滤器
        //注意：当前授权拦截后，shiro会自动跳转到未授权界面
        filterMap.put("/add","perms[user:add]");
        filterMap.put("/update","perms[user:update]");
        //其他资源全部限制
        filterMap.put("/*","authc");
        //修改跳转的登录的页面
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        //设置未授权界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }
    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联Realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    /**
     * 创建Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }
    /**
     * 配置ShiroDialect,用于thymeleaf和shiro的标签配合使用
     */
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
