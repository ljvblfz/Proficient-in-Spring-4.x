/*
 * XML Type:  userType
 * Namespace: 
 * Java type: com.smart.oxm.xmlbeans.UserType
 *
 * Automatically generated - do not modify.
 */
package com.smart.oxm.xmlbeans;


/**
 * An XML userType(@).
 *
 * This is a complex type.
 */
public interface UserType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(UserType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s89313323D390BE07A83A0DA958C9965D").resolveHandle("usertypea30etype");
    
    /**
     * Gets the "userId" element
     */
    java.lang.String getUserId();
    
    /**
     * Gets (as xml) the "userId" element
     */
    org.apache.xmlbeans.XmlString xgetUserId();
    
    /**
     * Sets the "userId" element
     */
    void setUserId(java.lang.String userId);
    
    /**
     * Sets (as xml) the "userId" element
     */
    void xsetUserId(org.apache.xmlbeans.XmlString userId);
    
    /**
     * Gets the "userName" element
     */
    java.lang.String getUserName();
    
    /**
     * Gets (as xml) the "userName" element
     */
    org.apache.xmlbeans.XmlString xgetUserName();
    
    /**
     * Sets the "userName" element
     */
    void setUserName(java.lang.String userName);
    
    /**
     * Sets (as xml) the "userName" element
     */
    void xsetUserName(org.apache.xmlbeans.XmlString userName);
    
    /**
     * Gets the "password" element
     */
    java.lang.String getPassword();
    
    /**
     * Gets (as xml) the "password" element
     */
    org.apache.xmlbeans.XmlString xgetPassword();
    
    /**
     * Sets the "password" element
     */
    void setPassword(java.lang.String password);
    
    /**
     * Sets (as xml) the "password" element
     */
    void xsetPassword(org.apache.xmlbeans.XmlString password);
    
    /**
     * Gets the "credits" element
     */
    int getCredits();
    
    /**
     * Gets (as xml) the "credits" element
     */
    org.apache.xmlbeans.XmlInt xgetCredits();
    
    /**
     * Sets the "credits" element
     */
    void setCredits(int credits);
    
    /**
     * Sets (as xml) the "credits" element
     */
    void xsetCredits(org.apache.xmlbeans.XmlInt credits);
    
    /**
     * Gets the "lastIp" element
     */
    java.lang.String getLastIp();
    
    /**
     * Gets (as xml) the "lastIp" element
     */
    org.apache.xmlbeans.XmlString xgetLastIp();
    
    /**
     * Sets the "lastIp" element
     */
    void setLastIp(java.lang.String lastIp);
    
    /**
     * Sets (as xml) the "lastIp" element
     */
    void xsetLastIp(org.apache.xmlbeans.XmlString lastIp);
    
    /**
     * Gets the "logs" element
     */
    com.smart.oxm.xmlbeans.UserType.Logs getLogs();
    
    /**
     * Sets the "logs" element
     */
    void setLogs(com.smart.oxm.xmlbeans.UserType.Logs logs);
    
    /**
     * Appends and returns a new empty "logs" element
     */
    com.smart.oxm.xmlbeans.UserType.Logs addNewLogs();
    
    /**
     * An XML logs(@).
     *
     * This is a complex type.
     */
    public interface Logs extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Logs.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s89313323D390BE07A83A0DA958C9965D").resolveHandle("logsf3f3elemtype");
        
        /**
         * Gets array of all "loginLog" elements
         */
        com.smart.oxm.xmlbeans.LogType[] getLoginLogArray();
        
        /**
         * Gets ith "loginLog" element
         */
        com.smart.oxm.xmlbeans.LogType getLoginLogArray(int i);
        
        /**
         * Returns number of "loginLog" element
         */
        int sizeOfLoginLogArray();
        
        /**
         * Sets array of all "loginLog" element
         */
        void setLoginLogArray(com.smart.oxm.xmlbeans.LogType[] loginLogArray);
        
        /**
         * Sets ith "loginLog" element
         */
        void setLoginLogArray(int i, com.smart.oxm.xmlbeans.LogType loginLog);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "loginLog" element
         */
        com.smart.oxm.xmlbeans.LogType insertNewLoginLog(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "loginLog" element
         */
        com.smart.oxm.xmlbeans.LogType addNewLoginLog();
        
        /**
         * Removes the ith "loginLog" element
         */
        void removeLoginLog(int i);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.smart.oxm.xmlbeans.UserType.Logs newInstance() {
              return (com.smart.oxm.xmlbeans.UserType.Logs) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.smart.oxm.xmlbeans.UserType.Logs newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.smart.oxm.xmlbeans.UserType.Logs) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.smart.oxm.xmlbeans.UserType newInstance() {
          return (com.smart.oxm.xmlbeans.UserType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.smart.oxm.xmlbeans.UserType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.smart.oxm.xmlbeans.UserType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.smart.oxm.xmlbeans.UserType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.smart.oxm.xmlbeans.UserType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.smart.oxm.xmlbeans.UserType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.smart.oxm.xmlbeans.UserType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.smart.oxm.xmlbeans.UserType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.smart.oxm.xmlbeans.UserType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.smart.oxm.xmlbeans.UserType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.smart.oxm.xmlbeans.UserType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.smart.oxm.xmlbeans.UserType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.smart.oxm.xmlbeans.UserType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.smart.oxm.xmlbeans.UserType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.smart.oxm.xmlbeans.UserType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.smart.oxm.xmlbeans.UserType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.smart.oxm.xmlbeans.UserType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.smart.oxm.xmlbeans.UserType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.smart.oxm.xmlbeans.UserType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.smart.oxm.xmlbeans.UserType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.smart.oxm.xmlbeans.UserType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.smart.oxm.xmlbeans.UserType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.smart.oxm.xmlbeans.UserType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.smart.oxm.xmlbeans.UserType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.smart.oxm.xmlbeans.UserType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.smart.oxm.xmlbeans.UserType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.smart.oxm.xmlbeans.UserType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.smart.oxm.xmlbeans.UserType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.smart.oxm.xmlbeans.UserType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.smart.oxm.xmlbeans.UserType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.smart.oxm.xmlbeans.UserType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.smart.oxm.xmlbeans.UserType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.smart.oxm.xmlbeans.UserType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.smart.oxm.xmlbeans.UserType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.smart.oxm.xmlbeans.UserType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
