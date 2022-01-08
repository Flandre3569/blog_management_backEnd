# Blog Management System（适合于springboot+vue前后端分离入门的练习作品）

> 博客管理系统---后端部分

### Blog Management System 是基于 Vue3、Vuex、VueRouter、Vite、less、gsap、ElementPlus、Navie UI、md-editor-v3、JavaScript、Echart5

## 功能点：

1. 登录
2. echarts信息总览
3. 用户增删改查
4. 模拟博客发布
5. 待审核博客的总览和博客审核
6. 博客的总览和删除
7. 标签管理
8. 后台日志打印
9. 路由守卫
10. token的支持（拦截器实现token和加载动画的拦截）
11. 信息反馈（申诉成功后会在自己邮箱收到相应邮件）
12. 文件上传
13. md5加密
14. 分页
15. proxy解决跨域问题

## 页面展示：

![image-20220107212143359](http://mingxuan3569.oss-cn-beijing.aliyuncs.com/image/image-20220107212143359.png)

![image-20220107212921899](http://mingxuan3569.oss-cn-beijing.aliyuncs.com/image/image-20220107212921899.png)

![image-20220107213103986](http://mingxuan3569.oss-cn-beijing.aliyuncs.com/image/image-20220107213103986.png)

![image-20220107213121770](http://mingxuan3569.oss-cn-beijing.aliyuncs.com/image/image-20220107213121770.png)

![image-20220107213135960](http://mingxuan3569.oss-cn-beijing.aliyuncs.com/image/image-20220107213135960.png)

![image-20220107213147754](http://mingxuan3569.oss-cn-beijing.aliyuncs.com/image/image-20220107213147754.png)

![image-20220107213202680](http://mingxuan3569.oss-cn-beijing.aliyuncs.com/image/image-20220107213202680.png)


![image-20220107213256810](http://mingxuan3569.oss-cn-beijing.aliyuncs.com/image/image-20220107213247034.png)

![image-20220107213319525](http://mingxuan3569.oss-cn-beijing.aliyuncs.com/image/image-20220107213256810.png)

## 目录结构：

``` 
│  App.vue
│  main.js
│
├─assets
│  ├─css
│  │      global.less     
│  │      index.less      
│  │
│  └─img
│          logo.png       
│
├─components
│  ├─animate
│  │  │  index.js
│  │  │
│  │  └─src
│  │          number.vue  
│  │
│  ├─card
│  │  │  index.js
│  │  │
│  │  └─src
│  │          card.vue
│  │
│  └─descriptions
│      │  index.js
│      │
│      └─src
│              index.vue
│
├─router
│      index.js
│
├─service
│  │  index.js
│  │
│  ├─login
│  │      index.js
│  │
│  └─request
│          config.js
│          index.js
│
├─store
│  │  index.js
│  │
│  └─login
│          login.js
│
├─utils
│      localCache.js
│
└─views
    │  blog.vue
    │  check.vue
    │  dialog.vue
    │  imitate.vue
    │  label.vue
    │  notFound.vue
    │  overview.vue
    │  technology.vue
    │  users.vue
    │
    ├─login
    │  │  login.vue
    │  │
    │  └─rules
    │          accountRules.js
    │
    ├─main
    │      main.vue
    │      nav-menu.vue
    │      user-info.vue
    │
    └─p-config
            dependencies.js
            dev-dependencies.js
            index.js
            overviewPie.js
            project-dir.js
            technology-stacks.js
```



## 项目解释：

该项目本身做的比较仓促，课程设计给了3天时间完成的，本身页面的设计和代码的设计都不够出色，该项目旨在练习的一下前后端分离的各项技术操作，各种技术只是涉猎，并没有深入的使用，vuex只完成了login操作，为了用而用哈哈，echarts和gasp也是采用的最笨的直接使用的方法，并没有进行任何封装，拦截器和localCache是在学习vue3的时候学习编写的，直接拿过来使用了。本身项目并不算太难，但是可以很好的入门包括echarts、vuex、拦截器和markdown的基本支持和使用，异步函数的解决用了比较取巧的方法，使用setTimeout将要使用的同步函数转为异步函数，然后用async和await进行顺序实现。还有一些小地方也不够完善，大家有兴趣的拿来做前后端分离的初学练习就好。（service目录下的拦截器封装和store的实现逻辑适用于老手，新手看起来可能会略微吃力）。

**有问题欢迎联系我**

