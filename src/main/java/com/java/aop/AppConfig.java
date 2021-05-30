package com.java.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy// for springAOP working
@ComponentScan("com.java.aop")
public class AppConfig {
}
