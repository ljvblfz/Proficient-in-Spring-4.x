/*
 * XML Type:  logType
 * Namespace: 
 * Java type: com.smart.oxm.xmlbeans.LogType
 *
 * Automatically generated - do not modify.
 */
package com.smart.oxm.xmlbeans.impl;
/**
 * An XML logType(@).
 *
 * This is a complex type.
 */
public class LogTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.smart.oxm.xmlbeans.LogType
{
    private static final long serialVersionUID = 1L;
    
    public LogTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName LOGINLOGID$0 = 
        new javax.xml.namespace.QName("", "loginLogId");
    private static final javax.xml.namespace.QName USERID$2 = 
        new javax.xml.namespace.QName("", "userId");
    private static final javax.xml.namespace.QName IP$4 = 
        new javax.xml.namespace.QName("", "ip");
    private static final javax.xml.namespace.QName LOGINDATE$6 = 
        new javax.xml.namespace.QName("", "loginDate");
    
    
    /**
     * Gets the "loginLogId" element
     */
    public java.lang.String getLoginLogId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LOGINLOGID$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "loginLogId" element
     */
    public org.apache.xmlbeans.XmlString xgetLoginLogId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LOGINLOGID$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "loginLogId" element
     */
    public void setLoginLogId(java.lang.String loginLogId)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LOGINLOGID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LOGINLOGID$0);
            }
            target.setStringValue(loginLogId);
        }
    }
    
    /**
     * Sets (as xml) the "loginLogId" element
     */
    public void xsetLoginLogId(org.apache.xmlbeans.XmlString loginLogId)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LOGINLOGID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(LOGINLOGID$0);
            }
            target.set(loginLogId);
        }
    }
    
    /**
     * Gets the "userId" element
     */
    public java.lang.String getUserId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(USERID$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "userId" element
     */
    public org.apache.xmlbeans.XmlString xgetUserId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(USERID$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "userId" element
     */
    public void setUserId(java.lang.String userId)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(USERID$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(USERID$2);
            }
            target.setStringValue(userId);
        }
    }
    
    /**
     * Sets (as xml) the "userId" element
     */
    public void xsetUserId(org.apache.xmlbeans.XmlString userId)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(USERID$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(USERID$2);
            }
            target.set(userId);
        }
    }
    
    /**
     * Gets the "ip" element
     */
    public java.lang.String getIp()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(IP$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ip" element
     */
    public org.apache.xmlbeans.XmlString xgetIp()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(IP$4, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ip" element
     */
    public void setIp(java.lang.String ip)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(IP$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(IP$4);
            }
            target.setStringValue(ip);
        }
    }
    
    /**
     * Sets (as xml) the "ip" element
     */
    public void xsetIp(org.apache.xmlbeans.XmlString ip)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(IP$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(IP$4);
            }
            target.set(ip);
        }
    }
    
    /**
     * Gets the "loginDate" element
     */
    public java.util.Calendar getLoginDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LOGINDATE$6, 0);
            if (target == null)
            {
                return null;
            }
            return target.getCalendarValue();
        }
    }
    
    /**
     * Gets (as xml) the "loginDate" element
     */
    public org.apache.xmlbeans.XmlDate xgetLoginDate()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDate target = null;
            target = (org.apache.xmlbeans.XmlDate)get_store().find_element_user(LOGINDATE$6, 0);
            return target;
        }
    }
    
    /**
     * Sets the "loginDate" element
     */
    public void setLoginDate(java.util.Calendar loginDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LOGINDATE$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LOGINDATE$6);
            }
            target.setCalendarValue(loginDate);
        }
    }
    
    /**
     * Sets (as xml) the "loginDate" element
     */
    public void xsetLoginDate(org.apache.xmlbeans.XmlDate loginDate)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlDate target = null;
            target = (org.apache.xmlbeans.XmlDate)get_store().find_element_user(LOGINDATE$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlDate)get_store().add_element_user(LOGINDATE$6);
            }
            target.set(loginDate);
        }
    }
}
