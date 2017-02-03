package com.smart.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class SystemPropertyBean {
    @Value("#{systemProperties['os.name']}")
	private String osName;

    @Value("#{systemProperties['java.home']}")
    private String javaHome;

    @Value("#{systemProperties['java.class.path']}")
    private String classPath;

    @Value("#{systemProperties['java.version']}")
    private String javaVersion;


    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getJavaHome() {
        return javaHome;
    }

    public void setJavaHome(String javaHome) {
        this.javaHome = javaHome;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }
}
