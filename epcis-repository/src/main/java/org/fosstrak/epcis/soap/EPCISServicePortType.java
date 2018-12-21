package org.fosstrak.epcis.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF (incubator) 2.0.4-incubator Wed Jan 30
 * 15:43:44 CET 2008 Generated source version: 2.0.4-incubator
 */

@WebService(targetNamespace = "urn:epcglobal:epcis:wsdl:1", name = "EPCISServicePortType")
//@WebService
@XmlSeeAlso({org.fosstrak.epcis.model.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface EPCISServicePortType {

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebMethod
    @WebResult(name = "GetStandardVersionResult", targetNamespace = "urn:epcglobal:epcis-query:xsd:1", partName = "getStandardVersionReturn")
    public java.lang.String getStandardVersion(
            @WebParam(partName = "parms", name = "GetStandardVersion", targetNamespace = "urn:epcglobal:epcis-query:xsd:1")
            org.fosstrak.epcis.model.EmptyParms parms) throws ImplementationExceptionResponse, SecurityExceptionResponse,
            ValidationExceptionResponse;

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebMethod
    @WebResult(name = "QueryResults", targetNamespace = "urn:epcglobal:epcis-query:xsd:1", partName = "pollReturn")
    public org.fosstrak.epcis.model.QueryResults poll(
            @WebParam(partName = "parms", name = "Poll", targetNamespace = "urn:epcglobal:epcis-query:xsd:1")
            org.fosstrak.epcis.model.Poll parms) throws ImplementationExceptionResponse,
            QueryTooComplexExceptionResponse, QueryTooLargeExceptionResponse, SecurityExceptionResponse,
            ValidationExceptionResponse, NoSuchNameExceptionResponse, QueryParameterExceptionResponse;

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebMethod
    @WebResult(name = "GetQueryNamesResult", targetNamespace = "urn:epcglobal:epcis-query:xsd:1", partName = "getQueryNamesReturn")
    public org.fosstrak.epcis.model.ArrayOfString getQueryNames(
            @WebParam(partName = "parms", name = "GetQueryNames", targetNamespace = "urn:epcglobal:epcis-query:xsd:1")
            org.fosstrak.epcis.model.EmptyParms parms) throws ImplementationExceptionResponse, SecurityExceptionResponse,
            ValidationExceptionResponse;

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebMethod
    @WebResult(name = "GetSubscriptionIDsResult", targetNamespace = "urn:epcglobal:epcis-query:xsd:1", partName = "getSubscriptionIDsReturn")

    public org.fosstrak.epcis.model.ArrayOfString getSubscriptionIDs(
            @WebParam(partName = "parms", name = "GetSubscriptionIDs", targetNamespace = "urn:epcglobal:epcis-query:xsd:1")
            org.fosstrak.epcis.model.GetSubscriptionIDs parms) throws ImplementationExceptionResponse,
            SecurityExceptionResponse, ValidationExceptionResponse, NoSuchNameExceptionResponse;

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebMethod
    @WebResult(name = "GetVendorVersionResult", targetNamespace = "urn:epcglobal:epcis-query:xsd:1", partName = "getVendorVersionReturn")
    public java.lang.String getVendorVersion(
            @WebParam(partName = "parms", name = "GetVendorVersion", targetNamespace = "urn:epcglobal:epcis-query:xsd:1")
            org.fosstrak.epcis.model.EmptyParms parms) throws ImplementationExceptionResponse, SecurityExceptionResponse,
            ValidationExceptionResponse;

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebMethod
    @WebResult(name = "UnsubscribeResult", targetNamespace = "urn:epcglobal:epcis-query:xsd:1", partName = "unsubscribeReturn")

    public org.fosstrak.epcis.model.VoidHolder unsubscribe(
            @WebParam(partName = "parms", name = "Unsubscribe", targetNamespace = "urn:epcglobal:epcis-query:xsd:1")
            org.fosstrak.epcis.model.Unsubscribe parms) throws ImplementationExceptionResponse,
            SecurityExceptionResponse, ValidationExceptionResponse, NoSuchSubscriptionExceptionResponse;

    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebMethod
    @WebResult(name = "SubscribeResult", targetNamespace = "urn:epcglobal:epcis-query:xsd:1", partName = "subscribeReturn")

    public org.fosstrak.epcis.model.VoidHolder subscribe(
            @WebParam(partName = "parms", name = "Subscribe", targetNamespace = "urn:epcglobal:epcis-query:xsd:1")
            org.fosstrak.epcis.model.Subscribe parms) throws DuplicateSubscriptionExceptionResponse,
            ImplementationExceptionResponse, QueryTooComplexExceptionResponse, SecurityExceptionResponse,
            InvalidURIExceptionResponse, ValidationExceptionResponse, SubscribeNotPermittedExceptionResponse,
            NoSuchNameExceptionResponse, SubscriptionControlsExceptionResponse, QueryParameterExceptionResponse;
}
