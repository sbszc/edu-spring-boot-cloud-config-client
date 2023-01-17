package com.sbszc.eduspringbootcloudconfigclient.valueexample;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties("db")
//requires matching names(user-info=userInfo), getters, setters
//Nested properties can be objects(static class) or maps, also require getters and setters, @NestedConfigurationProperty is optional
public class DbProperties {
    private String conn;
    private User userInfo;
    private Map<String, Integer> version;

    public String getConn() {
        return conn;
    }

    public void setConn(String conn) {
        this.conn = conn;
    }

    public User getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(User userInfo) {
        this.userInfo = userInfo;
    }

    public Map<String, Integer> getVersion() {
        return version;
    }

    public void setVersion(Map<String, Integer> version) {
        this.version = version;
    }

    public static class User {
        private String user;
        private String pass;

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }
    }
}
