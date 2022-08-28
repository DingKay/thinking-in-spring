package com.dk.geek.config;

import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.ResourceBundle;

/**
 * @author dkay
 * @version 1.0
 */
public class LogConfig {
    private static final String SERVER_NAME_KEY = "server-name";
    public static void initLog() {
        ResourceBundle bundle = ResourceBundle.getBundle("config");
        if (Objects.isNull(bundle)) {
            return;
        }

        String serverName = bundle.getString(SERVER_NAME_KEY);
        if (StringUtils.hasText(serverName)) {
            System.setProperty(SERVER_NAME_KEY, serverName);
        }
    }

    public static void main(String[] args) {
        initLog();
        System.out.println(System.getProperty(SERVER_NAME_KEY));
    }
}
