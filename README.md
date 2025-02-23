# Demeter

# 对象类型职责与特点汇总表

| **对象类型**       | **全称**               | **职责/作用**                       | **是否包含业务逻辑** | **典型场景**                          |
|----------------|----------------------|---------------------------------|--------------|-----------------------------------|
| **VO**         | View Object          | 在项目中的职责主要是面向视图层，处理数据的展示。        | 不包含          | 前端展示、REST API 响应                  |
| **DTO**        | Data Transfer Object | 在项目中用户跨层传输数据。                   | 不包含          | 从请求中提取数据、Controller和Service之间传输数据 |
| **PO**         | Persistent Object    | 数据库持久化对象，与表结构一一对应               | 不包含          | 数据持久化（ORM 映射）                     |
| **BO**         | Business Object      | 业务对象，封装复杂业务逻辑和规则                | 包含复杂逻辑       | 业务层方法实现                           |
| **Entity**     | Entity               | 业务实体，代表业务领域中的对象                 | 可以包含逻辑       | DDD 领域模型、ORM 框架                   |
| **DO**         | Domain Object        | 领域对象，DDD 中用于描述核心业务概念和规则         | 包含业务逻辑       | 复杂业务系统中的核心模型                      |
| **DAO**        | Data Access Object   | 数据访问对象，封装数据库操作逻辑                | 不包含          | DAO 层、CRUD 操作                     |
| **Service**    | Service Object       | 业务服务对象，组织和实现业务逻辑                | 包含业务逻辑       | Service 层，协调 DAO、BO、Entity 等      |
| **Factory**    | Factory Object       | 工厂对象，封装对象的创建过程                  | 不包含          | 对象创建，工厂模式                         |
| **Converter**  | Converter Object     | 对象转换器，负责对象类型之间的转换               | 不包含          | DTO/VO 与 Entity 转换                |
| **Mapper**     | Mapper Object        | 对象映射器，通常用于 PO、DTO、Entity 等对象的映射 | 不包含          | 使用 MyBatis、手动映射类                  |
| **Aggregate**  | Aggregate            | 聚合对象，DDD 中聚合根，保证业务一致性           | 包含复杂逻辑       | 聚合根操作（如订单聚合）                      |
| **Repository** | Repository           | 仓储对象，管理领域对象的持久化与查询              | 不包含          | DDD 仓储层，聚合或实体的存取                  |
| **Model**      | Model                | 模型对象，表示应用状态或 UI 数据              | 可能包含简单逻辑     | MVC/MVVM 模式中的 Model 层             |
| **Request**    | Request Object       | 请求对象，定义 API 输入参数                | 不包含          | 接口请求参数封装                          |
| **Response**   | Response Object      | 响应对象，定义 API 输出数据                | 不包含          | 接口返回数据封装                          |
| **Event**      | Event Object         | 事件对象，表示业务操作完成后的事件               | 不包含          | 事件驱动架构、异步事件通知                     |
| **Handler**    | Handler Object       | 处理器对象，专门处理特定业务逻辑或事件             | 包含业务逻辑       | CQRS、事件驱动架构                       |
| **Command**    | Command Object       | 命令对象，表示系统的一个操作请求                | 不包含          | CQRS 命令处理                         |
