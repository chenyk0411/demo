# demo

#### 介绍
做一些常用技术的demo

1.1、使用lombok简化代码

1.2、使用mybatis插件快速跳转

1.3、rabbitMq

-     打开管理界面命令：rabbitmq-plugins enable rabbitmq_management
-     停止：net stop RabbitMQ
-     启动：net start RabbitMQ
-     后台管理地址：http://127.0.0.1:15672/
-     使用默认账号登录：guest/ guest

20191114学习要点：
交换机与队列的绑定，交换机根据RoutingKey找到对应的队列，其中RoutingKey的命名规则，key.*匹配.后面的一个词,如key.abc
key.#匹配.后面的任意词语,如key.abc.123,key.cde.123等


20191202
springboot的controller返回一个实体对象的时候，如果报No converter found for return value of type的错误，通过设置getter和setter可以解决

20191207
使用mybatis-generator-maven-plugin快速生成mybatis的相关文件

20191208
使用springboot集成mybatis的demo代码

20191222
使用springboot集成quartz的代码

20200101
使用javaMail发送邮件的代码实例




1. 使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2. 码云官方博客 [blog.gitee.com](https://blog.gitee.com)
3. 你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解码云上的优秀开源项目
4. [GVP](https://gitee.com/gvp) 全称是码云最有价值开源项目，是码云综合评定出的优秀开源项目
5. 码云官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6. 码云封面人物是一档用来展示码云会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)