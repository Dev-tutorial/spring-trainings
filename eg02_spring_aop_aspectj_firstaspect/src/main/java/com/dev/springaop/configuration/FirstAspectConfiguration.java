package com.dev.springaop.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages="com.dev.springaop")
@EnableAspectJAutoProxy
public class FirstAspectConfiguration {

}
