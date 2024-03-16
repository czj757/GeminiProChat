package com.boots.atomikos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 服务启动类
 * @author：溪云阁
 * @date：2020年5月2日
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.module", "com.boots" })
public class BootsAtomikosApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootsAtomikosApplication.class, args);
    }

}
