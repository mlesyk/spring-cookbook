
Gradle
https://docs.gradle.org/current/userguide/writing_build_scripts.html
https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/



- p1
plain Spring xml configuration, ClassPathXmlApplicationContext
scopes prototype/singleton
maven/gradle build configuration

- p2
Autowire with javax.annotation.Resource annotation
plain Spring xml configuration, GenericXmlApplicationContext
https://stackoverflow.com/questions/63313382/genericxmlapplicationcontext-vs-classpathxmlapplicationcontext
maven/gradle build configuration

- p3_gradle
Autowire with javax.inject.Inject annotation

- p4_gradle
AnnotationConfigApplicationContext
BeanPostProcessor
Constructor -> postProcessBeforeInitialization -> PostConstruct -> InitializingBean afterPropertiesSet -> initMethod -> postProcessAfterInitialization -> PreDestroy -> DisposableBean destroy -> destroyMethod
Scope("prototype") does not invoke destroy methods
Lazy initiatization
DependsOn

- p5_gradle
Profiles, "scan" is necessary before "refresh" to activate profile
context.getEnvironment().setActiveProfiles("profile") -> context.scan("org.package") -> context.refresh()

- p6_gradle
*Aware interfaces
https://stackoverflow.com/questions/24904269/implementing-beannameaware-breaks-autowired
MessageSource is prototype bean

- p7_gradle
AOP
Logback+SLF4j

- p8_gradle
Spring Events

- p9_gradle
spring webmvc
jstl
interceptors

- p10_gradle
locales
resource bundle
exception error page
forms
validation

- p11_gradle
plain Jdbc + JdbcTemplate examples

- p12_gradle
Hibernate-xml/Hibernate-annotated/JPA DAO

- p13_gradle
Spring DI + Hibernate/JPA

- p14_gradle
Hibernate/JPA transactional

- p15_gradle
Spring Data JPA

- p16_gradle
Spring JMS Plain/Template

- p17_gradle
Spring RabbitMQ Plain/Template

- p18_gradle
Spring Kafka