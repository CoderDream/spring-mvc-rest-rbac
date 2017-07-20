# spring-mvc-rest-rbac
基于角色的访问控制,shiro,spring mvc,rest



版本0.2
----------

使用这几张表：

	sys_user(包含role_ids);
	sys_role;
	sys_resource;
	sys_organization;

http://localhost:8080/rest/getPermissions/admin

返回结果：


	[
	    "user:*",
	    "role:*",
	    "resource:*",
	    "session:*",
	    "organization:*"
	]


版本0.1
----------



使用PostMan访问下面的URL：

http://localhost:8080/rest/getPermissions/zhang
	
返回结果：

	[
	    "user:create",
	    "user:update",
	    "menu:create"
	]






