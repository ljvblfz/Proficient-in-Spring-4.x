package com.smart;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.io.Serializable;

/**
 * @author 陈雄华
 * @version 1.0
 */
@Entity
@Table(name="T_USER")
public class User implements Serializable{
    @Id
    @Column(name = "USER_NAME")
    private String userName;

    private String password;

    private int score;

    @Column(name = "LAST_LOGON_TIME")
    private long lastLogonTime = 0;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getLastLogonTime() {
        return lastLogonTime;
    }

    public void setLastLogonTime(long lastLogonTime) {
        this.lastLogonTime = lastLogonTime;
    }


    public String toString() {
        return (new ReflectionToStringBuilder(this) {
            protected boolean accept(Field f) {
                if(f.getType().isPrimitive() || f.getType() == String.class ){
                    return true;
                }else{
                    return false;
                }
            }
        }).toString();
    }
}
