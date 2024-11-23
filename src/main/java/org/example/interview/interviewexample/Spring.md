Spring
Advantages of using Spring framework?
Open source
Reduce code
Dependency Injection
Modular, lightweight framework
Excellent integration with a number of frameworks like Hibernate
Autoconfiguration feature
Support AOP,which separates business logic from system services.
Spring provides an API for translating technology-specific exception into unchecked exceptions.
Testable code and tdd
List of modules of spring framework

Tight coupling

Loose coupling

Application.properties file
Used to configure property values to run the application in different environment
What design patterns are used in the Spring framework?
Factory : BeanFactory and applicationContext class
Singleton: Singleton-scoped beans
Prototype: Prototype-scoped beans
Proxy: Spring Aspect Oriented Programming support
Template Method: JdbcTemplate, JpaTemplate etc.
Data Access Object: Spring DAO support
Model View Controller: Spring MVC
Front Controller : DispatcherServlet in Spring MVC
View Helper Pattern：custom JSP tags separate code from presentation in views.
Adapter Pattern: JDBC adapters in Spring Integration
Describe some standard Spring events.
ApplicationContext: in Spring publishes certain events during the lifecycle of a Spring application.
ContextStartedEvent: triggered when the context is start.
ContextRefreshedEvent: triggered when the context is either initialized or refreshed using the refresh() method.
ContextStoppedEvent: triggered when the context is stopped using the stop() method.
ContextClosedEvent: when the close() method is called on the ApplicationContext
RequestHandledEvent: triggered to let all beans know that an HTTP request has been handled.
Ioc (Inversion of Control)
The control of creating dependency shifts from the class to the framework. This is called Inversion of Control (IoC).
Advantages of Ioc
Minimizes the amount of code
Loose coupling
Better testability as mock objects
Support eager instantiation as well as lazy loading
Responsibility of an IoC container
Instantiates the application
Identifies the beans along with their dependencies and wires the dependencies
Manages the lifecycle of the beans
Two type of Ioc containers
BeanFactory
Basic function
ApplicationContext
AOP
message resource handling for internationalization
WebApplicationContext
Example of BeanFactory implementation
XmlBeanFacotry class
This container reads the metadata from an XML config file to create a fully configured application.
ApplicationContext?
Type of Ioc container
Extends BeanFactory interface
Load bean definitions
Wire beans together
Return beans upon request.
AOP
Internationaliztion
Application layer-specific contexts like WebApplicationContext.
Examples of ApplicationContext implementations
ClassPathApplicationXmlContext
AnnotationConfigApplicationContext
AnnotationConfigWebApplicationContext | WebXmlApplicationContext
Diff BeanFactory and ApplicationContext?
BeanFactory ->Lazy initialization | do it when getBean() called
ApplciationContext extends the BeanFactory interface ->eager initializationdefault ->when the application starts
ApplicationContext configured in Spring?
XML
ClassPathXmlApplicationContext, FileSystemXmlApplicationContext, or GenericXmlApplicationContext
Annotation
@Component ( @controller, @service, @Repository )
AnnotationConfigApplicationContext
@Configuration and @Bean   ->AnnotationConfigApplicationContext
Dependency Injection
Process of finding a bean to be autowired.
Types of DI
Field
Setter
Constructor
Diff between constructor and setter injection?
Constructor is not partial
Setter injection overrides constructor
Setter injection is flexible
Circular dependency, how should it be resolved?
beanA ->beanB->beanC->beanD->beanA
If setter or field injection, the beans are created but their dependencies are injected when they are needed.
@lazy used to tell spring init the bean when inject
Beans
Java object
@component tell spring to manage the lifecycle of the objects of class
Lifecycle of a spring bean
Spring container instantiates a bean and initializes it.
Inject the required dependencies.
All the initialized beans are destroyed when the context is destroyed.
Post initialization and pre destruction methods for custom tasks.
Custom bean lifecycle methods
@PostConstruct
@PreDestroy
Provide a bean id when using annotations?
Bean id

Register myBean class as a been, retrieves the bean:

MyBean ->default bean id myBean


What’s @Bean annotation do?

@Component Vs @Bean
@Component enables Spring to auto-detect and auto-configure beans
Class level | keeps the bean definition and class declaration together

Explicitly declare bean
Method level
Decouple bean definition and class declaration
Diff scopes of a bean?

Default singleton bean
Singleton and prototype scopes
The IoC container handles both types differently. It manages the entire lifecycle of singleton beans but does not do so in the case of prototype beans. The developer is responsible for destroying the prototype beans.
Bean scope defined?

According to the Singleton design pattern, there can be one bean per Java class. In Spring, singleton scope means one bean per bean id per Spring container (ApplicationContext).
Singleton beans are not thread safe.  | Prototype scope on the other hand is thread safe
For a prototype bean, the initialization method is called but the destruction method is not called
Spring Annotations
@Component annotation is used to define a bean.
@Component can be used in any layer of the application, whereas the other three are specific to layers. @Controller is used in the web layer, @Service is used on classes in the business layer and @Repository is used in the data layer and provides the additional functionality of making unchecked exceptions translated as Spring DataAccessException

@Primary -> one engine interface , two class with @component, compiler error, choose as primary choice.
@Qualifier
When both the @Primary and @Qualifer annotations are present, then @Qualifier takes precedence
@Autowired
The order of dependency injection of both the annotations is as follows:
By type
Using @Qualifer annotation
By name.
@Inject is a CDI annotation which makes it framework-independent and @Autowired is a Spring framework annotation.

