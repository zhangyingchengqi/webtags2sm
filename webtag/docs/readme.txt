       struts2+mybatis+spring+maven

         mybatis用了redis作二级缓存，但是可以去掉(如果自己的机器上没有redis的话)

主要优化的地方是:
         1. 使用了中间表tf维护 favorite和tag表的关系， 这样查询更准确.
         2. 添加网址时，使用了批量添加中间表tf数据和批量更新已有的tag数量,提高了数据库访问。
         3. tag数据是在容器启动时加载的，技术上面使用了一个监听器， 这里有一个问题: 在listener中如何取得spring的容器（因为spring容器也是在web容器启动启动的). 采用了  WebApplicationContext ,而不能重新   new ClassPathXmlApplicationContext();