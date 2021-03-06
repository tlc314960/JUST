## 平台简介

软件工程项目设计（占学分8分)  
项目形式：小组合作  
总体来上说来说是对大二大三所学的东西的整合提高，然后做出一个有实际意义的应用系统出来，基本上包含了前后端所有的技术栈。  
项目的初衷是为了解决学校请假过程的繁琐和纸质假条对于纸张的浪费。由于今年疫情的影响，学校采取了严格的出入校门政策，学生以及老师出入校门都要经过层层上报审批，最后拿到纸质假条才能出入校门。我觉得大可不必如此麻烦，所以决定开发出一个请假销假的系统，可以供学校学生，班导师，学院管理员，学生事务中心还有安保人员共同使用。将原本线下的请假流程搬到线上解决。我这个项目是基于一个开源项目上完成的，叫做若依管理系统，当然不是抄袭照搬，因为我和他需求不同，许多功能还是要我自己实现。我是用他的基本框架，避免做一些费时费力的基础开发，从而专注于我这个项目的设计实现。
既然是软件工程的项目设计，是要有一些软件工程的知识运用的。项目从确立题目后，就要经过可行性分析，需求分析，总体设计，详细设计和实现以及测试几个步骤去完成，软件在开发的过程中，为了确保质量，还要采取阶段性开发的方法，用增量模型和迭代模型去完成开发。




## 内置功能

1. 学生：请假销假，通知查看，生成请假二维码
2. 班导师：学生管理、销假批准管理，通知查看
3. 学院管理员：院系管理，销假批准查看，通知发布
4. 学生事务中心：最终请假盖章，通知发布
5. 安保部门：学生信息查看，核销二维码
6. 超级管理员：以上所有功能，用户管理，院系管理，角色管理，系统监控等等

## 主要技术

主要涉及到的编程语言：Java、HTML、Javascript、SQL等  
运用的开发工具：IntelliJ IDEA、Mysql、Navicat、Chrome、阿里云轻应用Linux服务器  
核心框架：Spring Boot。  
安全框架：Apache Shiro。  
模板引擎：Thymeleaf。    
持久层框架：MyBatis。  
数据库连接池：Druid。  
工具类：Fastjson。  
更多……

## 在线体验
注册功能已但实现未开放，校内服务网站不应开放注册，系统可以批量导入用户，可以由各班级收集学生信息填入Excel表格然后导入。

演示地址：http://atang.icu

## 演示图

![login](ruoyi-admin/src/main/resources/static/readme/login.png
 "login")
![index](ruoyi-admin/src/main/resources/static/readme/index.png
  "index")

