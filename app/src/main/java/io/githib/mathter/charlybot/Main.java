package io.githib.mathter.charlybot;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = "io.githib.mathter.charlybot"
)
@Configurable
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
