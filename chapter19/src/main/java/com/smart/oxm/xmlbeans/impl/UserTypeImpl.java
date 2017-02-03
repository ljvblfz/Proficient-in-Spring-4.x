/*
 * XML Type:  userType
 * Namespace: 
 * Java type: com.smart.oxm.xmlbeans.UserType
 *
 * Automatically generated - do not modify.
 */
package com.smart.oxm.xmlbeans.impl;
/**
 * An XML userType(@).
 *
 * This is a complex type.
 */
public class UserTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.smart.oxm.xmlbeans.UserType
{
    private static final long serialVersionUID = 1L;
    
    public UserTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName USERID$0 = 
        new javax.xml.namespace.QName("", "userId");
    private static final javax.xml.namespace.QName USERNAME$2 = 
        new javax.xml.namespace.QName("", "userName");
    private static final javax.xml.namespace.QName PASSWORD$4 = 
        new javax.xml.namespace.QName("", "password");
    private static final javax.xml.namespace.QName CREDITS$6 = 
        new javax.xml.namespace.QName("", "credits");
    private static final javax.xml.namespace.QName LASTIP$8 = 
        new javax.xml.namespace.QName("", "lastIp");
    private static final javax.xml.namespace.QName LOGS$10 = 
        new javax.xml.namespace.QName("", "logs");
    
    
    /**
     * Gets the "userId" element
     */
    public java.lang.String getUserId()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(USERID$0, 0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(USERID$0, 0);
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
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(USERID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(USERID$0);
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
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(USERID$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(USERID$0);
            }
            target.set(userId);
        }
    }
    
    /**
     * Gets the "userName" element
     */
    public java.lang.String getUserName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(USERNAME$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "userName" element
     */
    public org.apache.xmlbeans.XmlString xgetUserName()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(USERNAME$2, 0);
            return target;
        }
    }
    
    /**
     * Sets the "userName" element
     */
    public void setUserName(java.lang.String userName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(USERNAME$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(USERNAME$2);
            }
            target.setStringValue(userName);
        }
    }
    
    /**
     * Sets (as xml) the "userName" element
     */
    public void xsetUserName(org.apache.xmlbeans.XmlString userName)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(USERNAME$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(USERNAME$2);
            }
            target.set(userName);
        }
    }
    
    /**
     * Gets the "password" element
     */
    public java.lang.String getPassword()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PASSWORD$4, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "password" element
     */
    public org.apache.xmlbeans.XmlString xgetPassword()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PASSWORD$4, 0);
            return target;
        }
    }
    
    /**
     * Sets the "password" element
     */
    public void setPassword(java.lang.String password)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(PASSWORD$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(PASSWORD$4);
            }
            target.setStringValue(password);
        }
    }
    
    /**
     * Sets (as xml) the "password" element
     */
    public void xsetPassword(org.apache.xmlbeans.XmlString password)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(PASSWORD$4, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(PASSWORD$4);
            }
            target.set(password);
        }
    }
    
    /**
     * Gets the "credits" element
     */
    public int getCredits()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CREDITS$6, 0);
            if (target == null)
            {
                return 0;
            }
            return target.getIntValue();
        }
    }
    
    /**
     * Gets (as xml) the "credits" element
     */
    public org.apache.xmlbeans.XmlInt xgetCredits()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInt target = null;
            target = (org.apache.xmlbeans.XmlInt)get_store().find_element_user(CREDITS$6, 0);
            return target;
        }
    }
    
    /**
     * Sets the "credits" element
     */
    public void setCredits(int credits)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CREDITS$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CREDITS$6);
            }
            target.setIntValue(credits);
        }
    }
    
    /**
     * Sets (as xml) the "credits" element
     */
    public void xsetCredits(org.apache.xmlbeans.XmlInt credits)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlInt target = null;
            target = (org.apache.xmlbeans.XmlInt)get_store().find_element_user(CREDITS$6, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlInt)get_store().add_element_user(CREDITS$6);
            }
            target.set(credits);
        }
    }
    
    /**
     * Gets the "lastIp" element
     */
    public java.lang.String getLastIp()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LASTIP$8, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "lastIp" element
     */
    public org.apache.xmlbeans.XmlString xgetLastIp()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LASTIP$8, 0);
            return target;
        }
    }
    
    /**
     * Sets the "lastIp" element
     */
    public void setLastIp(java.lang.String lastIp)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LASTIP$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LASTIP$8);
            }
            target.setStringValue(lastIp);
        }
    }
    
    /**
     * Sets (as xml) the "lastIp" element
     */
    public void xsetLastIp(org.apache.xmlbeans.XmlString lastIp)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(LASTIP$8, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(LASTIP$8);
            }
            target.set(lastIp);
        }
    }
    
    /**
     * Gets the "logs" element
     */
    public com.smart.oxm.xmlbeans.UserType.Logs getLogs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.smart.oxm.xmlbeans.UserType.Logs target = null;
            target = (com.smart.oxm.xmlbeans.UserType.Logs)get_store().find_element_user(LOGS$10, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "logs" element
     */
    public void setLogs(com.smart.oxm.xmlbeans.UserType.Logs logs)
    {
        generatedSetterHelperImpl(logs, LOGS$10, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "logs" element
     */
    public com.smart.oxm.xmlbeans.UserType.Logs addNewLogs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.smart.oxm.xmlbeans.UserType.Logs target = null;
            target = (com.smart.oxm.xmlbeans.UserType.Logs)get_store().add_element_user(LOGS$10);
            return target;
        }
    }
    /**
     * An XML logs(@).
     *
     * This is a complex type.
     */
    public static class LogsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.smart.oxm.xmlbeans.UserType.Logs
    {
        private static final long serialVersionUID = 1L;
        
        public LogsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName LOGINLOG$0 = 
            new javax.xml.namespace.QName("", "loginLog");
        
        
        /**
         * Gets array of all "loginLog" elements
         */
        public com.smart.oxm.xmlbeans.LogType[] getLoginLogArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(LOGINLOG$0, targetList);
                com.smart.oxm.xmlbeans.LogType[] result = new com.smart.oxm.xmlbeans.LogType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "loginLog" element
         */
        public com.smart.oxm.xmlbeans.LogType getLoginLogArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.smart.oxm.xmlbeans.LogType target = null;
                target = (com.smart.oxm.xmlbeans.LogType)get_store().find_element_user(LOGINLOG$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "loginLog" element
         */
        public int sizeOfLoginLogArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(LOGINLOG$0);
            }
        }
        
        /**
         * Sets array of all "loginLog" element  WARNING: This method is not atomicaly synchronized.
         */
        public void setLoginLogArray(com.smart.oxm.xmlbeans.LogType[] loginLogArray)
        {
            check_orphaned();
            arraySetterHelper(loginLogArray, LOGINLOG$0);
        }
        
        /**
         * Sets ith "loginLog" element
         */
        public void setLoginLogArray(int i, com.smart.oxm.xmlbeans.LogType loginLog)
        {
            generatedSetterHelperImpl(loginLog, LOGINLOG$0, i, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_ARRAYITEM);
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "loginLog" element
         */
        public com.smart.oxm.xmlbeans.LogType insertNewLoginLog(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.smart.oxm.xmlbeans.LogType target = null;
                target = (com.smart.oxm.xmlbeans.LogType)get_store().insert_element_user(LOGINLOG$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "loginLog" element
         */
        public com.smart.oxm.xmlbeans.LogType addNewLoginLog()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.smart.oxm.xmlbeans.LogType target = null;
                target = (com.smart.oxm.xmlbeans.LogType)get_store().add_element_user(LOGINLOG$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "loginLog" element
         */
        public void removeLoginLog(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(LOGINLOG$0, i);
            }
        }
    }
}
