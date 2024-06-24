package com.example.properties;

import ch.qos.logback.core.util.StringUtil;
import jakarta.annotation.PostConstruct;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
/*-----------------------------3번----------------------------------------------------*/
@EnableConfigurationProperties
@SpringBootApplication
/*----------------------------2번-----------------------------------------------------*/
//@Configuration
/*------------------------------1번---------------------------------------------------*/
//@PropertySource("some.properties")
public class PropertiesApplication {
    private final Log log = LogFactory.getLog(getClass());
    /*-----------------------------------3번방법----------------------------------------------*/
    @Autowired
    public PropertiesApplication(ConfigurationProjectProperties cp ) {
        log.info("configurationProjectProperties.projectName = " + cp.getProjectName());
    }
    /*------------------------------------2번 방법---------------------------------------------*/
//    @Bean
//    static PropertySourcesPlaceholderConfigurer pspc() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }
//
//    @Configuration
//    @Profile("prod")
//    @PropertySource("some-prod.properties")
//    public static class ProdConfiguration {
//        @Bean
//        InitializingBean init() {
//            return () -> LogFactory.getLog(getClass())
//                    .info("prod InitializingBean");
//        }
//    }
//
//    @Configuration
//    @Profile({"default", "dev"})
//    @PropertySource("some.properties")
//    public static class DefaultConfiguration {
//        @Bean
//        InitializingBean init() {
//            return () -> LogFactory.getLog(getClass())
//                    .info("default InitializingBean");
//        }
//    }
//    @Bean
//    InitializingBean which(Environment e, @Value("${configuration.projectName}") String projectName) {
//        return () -> {
//            log.info("activeProfiles : '"
//                    + StringUtils.arrayToCommaDelimitedString(e.getActiveProfiles()) + "'");
//            log.info("configuration.projectName: " + projectName);
//        };
//    }
    public static void main(String[] args)  throws Throwable {
        /*-------------------------------------3번 방법--------------------------------------------*/
        SpringApplication.run(PropertiesApplication.class);
        /*-------------------------------------2번 방법--------------------------------------------*/
//        AnnotationConfigApplicationContext ac =
//                new AnnotationConfigApplicationContext();
//        ac.getEnvironment().setActiveProfiles("dev");
//        ac.register(PropertiesApplication.class);
//        ac.refresh();

        /*-------------------------------------1번 방법--------------------------------------------*/
//        new ClassPathXmlApplicationContext("classic.xml");
//        SpringApplication.run(PropertiesApplication.class, args);
    }

    /*---------------------------------1번 방법------------------------------------------------*/
//
//    @Value("${configuration.projectName}")
//    private String filedValue;
//
//    @Autowired
//    PropertiesApplication(@Value("${configuration.projectName}") String pn) {
//        log.info("Properties Application constructor: " +pn);
//    }
//
//    @Bean
//    InitializingBean both(Environment env, @Value("${configuration.projectName}") String projectName) {
//        return () -> {
//            log.info("@Bean with dependencies (projectName): " + projectName);
//            log.info("@Bean with dependencies (env): " + env.getProperty("configuration.projectName"));
//        };
//    }
//
//    @PostConstruct
//    void afterPropertiesSet() throws Throwable{
//        log.info("filedValue: "+ this.filedValue);
//    }
//
//    public void setConfigurationProjectName(String pn) {
//        LogFactory.getLog(getClass())
//                .info("the configuration project name is" + pn);
//    }

}
/*------------------------------------3번----------------------------*/
@Component
@ConfigurationProperties("configuration")
class ConfigurationProjectProperties {
    private String projectName;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
