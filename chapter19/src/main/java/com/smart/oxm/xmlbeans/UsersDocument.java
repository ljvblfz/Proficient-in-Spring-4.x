/*
 * An XML document type.
 * Localname: Users
 * Namespace: 
 * Java type: com.smart.oxm.xmlbeans.UsersDocument
 *
 * Automatically generated - do not modify.
 */
package com.smart.oxm.xmlbeans;


/**
 * A document containing one Users(@) element.
 *
 * This is a complex type.
 */
public interface UsersDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(UsersDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s89313323D390BE07A83A0DA958C9965D").resolveHandle("usersf90fdoctype");
    
    /**
     * Gets the "Users" element
     */
    com.smart.oxm.xmlbeans.UsersDocument.Users getUsers();
    
    /**
     * Sets the "Users" element
     */
    void setUsers(com.smart.oxm.xmlbeans.UsersDocument.Users users);
    
    /**
     * Appends and returns a new empty "Users" element
     */
    com.smart.oxm.xmlbeans.UsersDocument.Users addNewUsers();
    
    /**
     * An XML Users(@).
     *
     * This is a complex type.
     */
    public interface Users extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Users.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s89313323D390BE07A83A0DA958C9965D").resolveHandle("users3d73elemtype");
        
        /**
         * Gets array of all "user" elements
         */
        com.smart.oxm.xmlbeans.UserType[] getUserArray();
        
        /**
         * Gets ith "user" element
         */
        com.smart.oxm.xmlbeans.UserType getUserArray(int i);
        
        /**
         * Returns number of "user" element
         */
        int sizeOfUserArray();
        
        /**
         * Sets array of all "user" element
         */
        void setUserArray(com.smart.oxm.xmlbeans.UserType[] userArray);
        
        /**
         * Sets ith "user" element
         */
        void setUserArray(int i, com.smart.oxm.xmlbeans.UserType user);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "user" element
         */
        com.smart.oxm.xmlbeans.UserType insertNewUser(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "user" element
         */
        com.smart.oxm.xmlbeans.UserType addNewUser();
        
        /**
         * Removes the ith "user" element
         */
        void removeUser(int i);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.smart.oxm.xmlbeans.UsersDocument.Users newInstance() {
              return (com.smart.oxm.xmlbeans.UsersDocument.Users) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.smart.oxm.xmlbeans.UsersDocument.Users newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.smart.oxm.xmlbeans.UsersDocument.Users) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.smart.oxm.xmlbeans.UsersDocument newInstance() {
          return (com.smart.oxm.xmlbeans.UsersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.smart.oxm.xmlbeans.UsersDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.smart.oxm.xmlbeans.UsersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.smart.oxm.xmlbeans.UsersDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.smart.oxm.xmlbeans.UsersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.smart.oxm.xmlbeans.UsersDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.smart.oxm.xmlbeans.UsersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.smart.oxm.xmlbeans.UsersDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.smart.oxm.xmlbeans.UsersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.smart.oxm.xmlbeans.UsersDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.smart.oxm.xmlbeans.UsersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.smart.oxm.xmlbeans.UsersDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.smart.oxm.xmlbeans.UsersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.smart.oxm.xmlbeans.UsersDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.smart.oxm.xmlbeans.UsersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.smart.oxm.xmlbeans.UsersDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.smart.oxm.xmlbeans.UsersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.smart.oxm.xmlbeans.UsersDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.smart.oxm.xmlbeans.UsersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.smart.oxm.xmlbeans.UsersDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.smart.oxm.xmlbeans.UsersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.smart.oxm.xmlbeans.UsersDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.smart.oxm.xmlbeans.UsersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.smart.oxm.xmlbeans.UsersDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.smart.oxm.xmlbeans.UsersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.smart.oxm.xmlbeans.UsersDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.smart.oxm.xmlbeans.UsersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.smart.oxm.xmlbeans.UsersDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.smart.oxm.xmlbeans.UsersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.smart.oxm.xmlbeans.UsersDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.smart.oxm.xmlbeans.UsersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.smart.oxm.xmlbeans.UsersDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.smart.oxm.xmlbeans.UsersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.smart.oxm.xmlbeans.UsersDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.smart.oxm.xmlbeans.UsersDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
