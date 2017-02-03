/*
 * An XML document type.
 * Localname: Users
 * Namespace: 
 * Java type: com.smart.oxm.xmlbeans.UsersDocument
 *
 * Automatically generated - do not modify.
 */
package com.smart.oxm.xmlbeans.impl;
/**
 * A document containing one Users(@) element.
 *
 * This is a complex type.
 */
public class UsersDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.smart.oxm.xmlbeans.UsersDocument
{
    private static final long serialVersionUID = 1L;
    
    public UsersDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName USERS$0 = 
        new javax.xml.namespace.QName("", "Users");
    
    
    /**
     * Gets the "Users" element
     */
    public com.smart.oxm.xmlbeans.UsersDocument.Users getUsers()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.smart.oxm.xmlbeans.UsersDocument.Users target = null;
            target = (com.smart.oxm.xmlbeans.UsersDocument.Users)get_store().find_element_user(USERS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Users" element
     */
    public void setUsers(com.smart.oxm.xmlbeans.UsersDocument.Users users)
    {
        generatedSetterHelperImpl(users, USERS$0, 0, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_SINGLETON);
    }
    
    /**
     * Appends and returns a new empty "Users" element
     */
    public com.smart.oxm.xmlbeans.UsersDocument.Users addNewUsers()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.smart.oxm.xmlbeans.UsersDocument.Users target = null;
            target = (com.smart.oxm.xmlbeans.UsersDocument.Users)get_store().add_element_user(USERS$0);
            return target;
        }
    }
    /**
     * An XML Users(@).
     *
     * This is a complex type.
     */
    public static class UsersImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.smart.oxm.xmlbeans.UsersDocument.Users
    {
        private static final long serialVersionUID = 1L;
        
        public UsersImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName USER$0 = 
            new javax.xml.namespace.QName("", "user");
        
        
        /**
         * Gets array of all "user" elements
         */
        public com.smart.oxm.xmlbeans.UserType[] getUserArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(USER$0, targetList);
                com.smart.oxm.xmlbeans.UserType[] result = new com.smart.oxm.xmlbeans.UserType[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "user" element
         */
        public com.smart.oxm.xmlbeans.UserType getUserArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.smart.oxm.xmlbeans.UserType target = null;
                target = (com.smart.oxm.xmlbeans.UserType)get_store().find_element_user(USER$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "user" element
         */
        public int sizeOfUserArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(USER$0);
            }
        }
        
        /**
         * Sets array of all "user" element  WARNING: This method is not atomicaly synchronized.
         */
        public void setUserArray(com.smart.oxm.xmlbeans.UserType[] userArray)
        {
            check_orphaned();
            arraySetterHelper(userArray, USER$0);
        }
        
        /**
         * Sets ith "user" element
         */
        public void setUserArray(int i, com.smart.oxm.xmlbeans.UserType user)
        {
            generatedSetterHelperImpl(user, USER$0, i, org.apache.xmlbeans.impl.values.XmlObjectBase.KIND_SETTERHELPER_ARRAYITEM);
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "user" element
         */
        public com.smart.oxm.xmlbeans.UserType insertNewUser(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.smart.oxm.xmlbeans.UserType target = null;
                target = (com.smart.oxm.xmlbeans.UserType)get_store().insert_element_user(USER$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "user" element
         */
        public com.smart.oxm.xmlbeans.UserType addNewUser()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.smart.oxm.xmlbeans.UserType target = null;
                target = (com.smart.oxm.xmlbeans.UserType)get_store().add_element_user(USER$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "user" element
         */
        public void removeUser(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(USER$0, i);
            }
        }
    }
}
