package com.java12.spring.springinaction.Chapter_01.knight.knights.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.habuma.soundsystem", 
               excludeFilters = { @Filter(Configuration.class) })
public class SoundSystemConfig {
}
