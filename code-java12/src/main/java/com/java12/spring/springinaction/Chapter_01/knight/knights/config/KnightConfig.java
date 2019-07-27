package com.java12.spring.springinaction.Chapter_01.knight.knights.config;

import com.java12.spring.springinaction.Chapter_01.knight.knights.BraveKnight;
import com.java12.spring.springinaction.Chapter_01.knight.knights.Knight;
import com.java12.spring.springinaction.Chapter_01.knight.knights.Quest;
import com.java12.spring.springinaction.Chapter_01.knight.knights.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class KnightConfig {

  @Bean
  public Knight knight() {
    return new BraveKnight(quest());
  }
  
  @Bean
  public Quest quest() {
    return new SlayDragonQuest(System.out);
  }

}
