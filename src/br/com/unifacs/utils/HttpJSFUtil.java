package br.com.unifacs.utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpJSFUtil{
    private HttpJSFUtil()
    {
    }
   
    public static HttpSession getSession()
    {
    return (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession( true );
    }
   
       
    public static HttpServletRequest getRequest()
    {
    return (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    public static HttpServletResponse getResponse()
    {
    return (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
    }
   
    public static Object getManagedBean(String name)
    {
        return FacesContext.getCurrentInstance().getApplication().createValueBinding(name).getValue( FacesContext.getCurrentInstance() );   
    }

    public static Object getManagedBean(FacesContext fc, String name)
    {
        return fc.getApplication().createValueBinding(name).getValue(fc);   
    }   
   
}
 
