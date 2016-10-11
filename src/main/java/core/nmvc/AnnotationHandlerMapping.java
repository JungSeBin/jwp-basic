package core.nmvc;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;

import core.annotation.RequestMapping;
import core.annotation.RequestMethod;
import core.mvc.ControllerScanner;

public class AnnotationHandlerMapping {
	private static final Logger logger = 
			LoggerFactory.getLogger(AnnotationHandlerMapping.class);

    private Object[] basePackage;

    private Map<HandlerKey, HandlerExecution> handlerExecutions = Maps.newHashMap();

    public AnnotationHandlerMapping(Object... basePackage) {
        this.basePackage = basePackage;
    }

    public void initialize() {
    	ControllerScanner controllerScanner = 
    			new ControllerScanner(basePackage);
    	Map<Class<?>, Object> controllers = 
    			controllerScanner.getControllers();
    	Set<Method> methods = getRequestMappingMethods(controllers.keySet());
    	for(Method method : methods) {
    		RequestMapping rm = method.getAnnotation(RequestMapping.class);
    		logger.debug("register handlerExecution : url is {}, method is {}"
    				rm.value(), method);
    	}
    }

    public HandlerExecution getHandler(HttpServletRequest request) {
        String requestUri = request.getRequestURI();
        RequestMethod rm = RequestMethod.valueOf(request.getMethod().toUpperCase());
        return handlerExecutions.get(new HandlerKey(requestUri, rm));
    }
}
