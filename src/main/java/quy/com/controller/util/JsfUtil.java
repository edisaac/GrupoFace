package quy.com.controller.util;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;

import quy.com.facebook.FaceBookUser;

public class JsfUtil {
		private static final Logger logger = Logger.getLogger(JsfUtil.class);
		
	  public static void addErrorMessage(String msg) {
	        
	        if (FacesContext.getCurrentInstance() ==null){
	        	System.out.println(msg);
				logger.trace(msg);				
	        }else{
	        	FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, "");
	        	FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		        FacesContext.getCurrentInstance().validationFailed(); // Invalidate JSF page if we raise an error message
		   }   
	    }
	    public static  void addSuccessMessage(String msg) {
	        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, "");
	        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
	    }
	  public static void addErrorMessage(Exception ex, String defaultMsg) {
	        String msg = ex.getLocalizedMessage();
	        if (msg != null && msg.length() > 0) {
	            addErrorMessage(msg);
	        } else {
	            addErrorMessage(defaultMsg);
	        }
	    }
	
	    public static Throwable getRootCause(Throwable cause) {
	        if (cause != null) {
	            Throwable source = cause.getCause();
	            if (source != null) {
	                return getRootCause(source);
	            } else {
	                return cause;
	            }
	        }
	        return null;
	    }

	    public static boolean isValidationFailed() {
	        return FacesContext.getCurrentInstance().isValidationFailed();
	    }
	    public static void setException(Exception ex)	    {
	    	Throwable cause = getRootCause(ex.getCause());
	    	System.out.println("Error>>" + ex);
            if (cause != null) {
                if (cause instanceof ConstraintViolationException) {
                    ConstraintViolationException excp = (ConstraintViolationException) cause;
                    
                   /* for (ConstraintViolation s : excp.getConstraintViolations()) {
                        addErrorMessage(s.getMessage());
                    }*/
                    addErrorMessage(ex.getLocalizedMessage());
                } else {
                    String msg = cause.getLocalizedMessage();
                    if (msg.length() > 0) {
                        addErrorMessage(msg);
                    } else {
                        addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                    }
                }
            }else {
            	addErrorMessage(ex.toString());
            }
	    }
}		
