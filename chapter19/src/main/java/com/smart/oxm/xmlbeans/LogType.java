/*
 * XML Type:  logType
 * Namespace: 
 * Java type: com.smart.oxm.xmlbeans.LogType
 *
 * Automatically generated - do not modify.
 */
package com.smart.oxm.xmlbeans;


/**
 * An XML logType(@).
 *
 * This is a complex type.
 */
public interface LogType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(LogType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s89313323D390BE07A83A0DA958C9965D").resolveHandle("logtype8215type");
    
    /**
     * Gets the "loginLogId" element
     */
    java.lang.String getLoginLogId();
    
    /**
     * Gets (as xml) the "loginLogId" element
     */
    org.apache.xmlbeans.XmlString xgetLoginLogId();
    
    /**
     * Sets the "loginLogId" element
     */
    void setLoginLogId(java.lang.String loginLogId);
    
    /**
     * Sets (as xml) the "loginLogId" element
     */
    void xsetLoginLogId(org.apache.xmlbeans.XmlString loginLogId);
    
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
     * Gets the "ip" element
     */
    java.lang.String getIp();
    
    /**
     * Gets (as xml) the "ip" element
     */
    org.apache.xmlbeans.XmlString xgetIp();
    
    /**
     * Sets the "ip" element
     */
    void setIp(java.lang.String ip);
    
    /**
     * Sets (as xml) the "ip" element
     */
    void xsetIp(org.apache.xmlbeans.XmlString ip);
    
    /**
     * Gets the "loginDate" element
     */
    java.util.Calendar getLoginDate();
    
    /**
     * Gets (as xml) the "loginDate" element
     */
    org.apache.xmlbeans.XmlDate xgetLoginDate();
    
    /**
     * Sets the "loginDate" element
     */
    void setLoginDate(java.util.Calendar loginDate);
    
    /**
     * Sets (as xml) the "loginDate" element
     */
    void xsetLoginDate(org.apache.xmlbeans.XmlDate loginDate);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.smart.oxm.xmlbeans.LogType newInstance() {
          return (com.smart.oxm.xmlbeans.LogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.smart.oxm.xmlbeans.LogType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.smart.oxm.xmlbeans.LogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.smart.oxm.xmlbeans.LogType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.smart.oxm.xmlbeans.LogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.smart.oxm.xmlbeans.LogType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.smart.oxm.xmlbeans.LogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.smart.oxm.xmlbeans.LogType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.smart.oxm.xmlbeans.LogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.smart.oxm.xmlbeans.LogType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.smart.oxm.xmlbeans.LogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.smart.oxm.xmlbeans.LogType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.smart.oxm.xmlbeans.LogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.smart.oxm.xmlbeans.LogType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.smart.oxm.xmlbeans.LogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.smart.oxm.xmlbeans.LogType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.smart.oxm.xmlbeans.LogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.smart.oxm.xmlbeans.LogType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.smart.oxm.xmlbeans.LogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.smart.oxm.xmlbeans.LogType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.smart.oxm.xmlbeans.LogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.smart.oxm.xmlbeans.LogType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.smart.oxm.xmlbeans.LogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.smart.oxm.xmlbeans.LogType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.smart.oxm.xmlbeans.LogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.smart.oxm.xmlbeans.LogType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.smart.oxm.xmlbeans.LogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.smart.oxm.xmlbeans.LogType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.smart.oxm.xmlbeans.LogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.smart.oxm.xmlbeans.LogType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.smart.oxm.xmlbeans.LogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.smart.oxm.xmlbeans.LogType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.smart.oxm.xmlbeans.LogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.smart.oxm.xmlbeans.LogType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.smart.oxm.xmlbeans.LogType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
