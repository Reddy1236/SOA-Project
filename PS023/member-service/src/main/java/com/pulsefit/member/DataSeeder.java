package com.pulsefit.member;
import org.springframework.boot.CommandLineRunner; import org.springframework.context.annotation.Bean; import org.springframework.context.annotation.Configuration;
@Configuration public class DataSeeder { @Bean CommandLineRunner seed(MemberRepository r){return a->{if(r.count()==0){Member m=new Member();m.setName("Demo Member");m.setEmail("demo@pulsefit.com");m.setPhone("9876543210");m.setStatus("ACTIVE");r.save(m);}};} }
