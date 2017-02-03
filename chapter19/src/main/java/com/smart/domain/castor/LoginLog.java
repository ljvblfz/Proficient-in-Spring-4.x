/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.smart.domain.castor;

/**
 * Class LoginLog.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings("serial")
public class LoginLog implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _loginLogId.
     */
    private java.lang.String _loginLogId;

    /**
     * Field _userId.
     */
    private java.lang.String _userId;

    /**
     * Field _ip.
     */
    private java.lang.String _ip;

    /**
     * Field _loginDate.
     */
    private org.exolab.castor.types.Date _loginDate;


      //----------------/
     //- Constructors -/
    //----------------/

    public LoginLog() {
        super();
    }


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'ip'.
     * 
     * @return the value of field 'Ip'.
     */
    public java.lang.String getIp(
    ) {
        return this._ip;
    }

    /**
     * Returns the value of field 'loginDate'.
     * 
     * @return the value of field 'LoginDate'.
     */
    public org.exolab.castor.types.Date getLoginDate(
    ) {
        return this._loginDate;
    }

    /**
     * Returns the value of field 'loginLogId'.
     * 
     * @return the value of field 'LoginLogId'.
     */
    public java.lang.String getLoginLogId(
    ) {
        return this._loginLogId;
    }

    /**
     * Returns the value of field 'userId'.
     * 
     * @return the value of field 'UserId'.
     */
    public java.lang.String getUserId(
    ) {
        return this._userId;
    }

    /**
     * Method isValid.
     * 
     * @return true if this object is valid according to the schema
     */
    public boolean isValid(
    ) {
        try {
            validate();
        } catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    }

    /**
     * 
     * 
     * @param out
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void marshal(
            final java.io.Writer out)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, out);
    }

    /**
     * 
     * 
     * @param handler
     * @throws java.io.IOException if an IOException occurs during
     * marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     */
    public void marshal(
            final org.xml.sax.ContentHandler handler)
    throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Marshaller.marshal(this, handler);
    }

    /**
     * Sets the value of field 'ip'.
     * 
     * @param ip the value of field 'ip'.
     */
    public void setIp(
            final java.lang.String ip) {
        this._ip = ip;
    }

    /**
     * Sets the value of field 'loginDate'.
     * 
     * @param loginDate the value of field 'loginDate'.
     */
    public void setLoginDate(
            final org.exolab.castor.types.Date loginDate) {
        this._loginDate = loginDate;
    }

    /**
     * Sets the value of field 'loginLogId'.
     * 
     * @param loginLogId the value of field 'loginLogId'.
     */
    public void setLoginLogId(
            final java.lang.String loginLogId) {
        this._loginLogId = loginLogId;
    }

    /**
     * Sets the value of field 'userId'.
     * 
     * @param userId the value of field 'userId'.
     */
    public void setUserId(
            final java.lang.String userId) {
        this._userId = userId;
    }

    /**
     * Method unmarshal.
     * 
     * @param reader
     * @throws org.exolab.castor.xml.MarshalException if object is
     * null or if any SAXException is thrown during marshaling
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     * @return the unmarshaled com.smart.domain.castor.LoginLog
     */
    public static com.smart.domain.castor.LoginLog unmarshal(
            final java.io.Reader reader)
    throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException {
        return (com.smart.domain.castor.LoginLog) org.exolab.castor.xml.Unmarshaller.unmarshal(com.smart.domain.castor.LoginLog.class, reader);
    }

    /**
     * 
     * 
     * @throws org.exolab.castor.xml.ValidationException if this
     * object is an invalid instance according to the schema
     */
    public void validate(
    )
    throws org.exolab.castor.xml.ValidationException {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    }

}
