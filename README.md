# shiro

springboot中shiro的使用
shiro重要的三个API
  1、Subject ：用户主体（把操作交给SecurityManager）
  2、SecurityManager： 安全管理器（关联Realm）
  3、Realm：Shiro链接数据的桥梁
在项目中主要包含一下内容：
  1、shiro认证配置类的配置ShiroConfig
  2、自定义Realm
  3、Shiro整合mybatis数据库实现用户登录
  4、用户权限控制
  5、配置ShiroDialect,用于thymeleaf和shiro的标签配合使用(控制界面的元素的显示)

