package pe.edu.cibertec.web.view.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public interface JsfUtil {

    static HttpSession getSession(boolean createSession) {
        return (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(createSession);
    }

    static HttpSession getSession() {
        return getSession(true);
    }
}
