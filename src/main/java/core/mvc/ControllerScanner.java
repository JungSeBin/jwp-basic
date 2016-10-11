package core.mvc;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Maps;

public class ControllerScanner {
	private static final Logger log = LoggerFactory.getLogger(ControllerScanner.class);
	
	private Reflections reflections;
	
	public ControllerScanner(Object... basePackage) {
		reflections = new Reflections(basePackage);
	}
	
	public Map<Class<?>, Object> getControllers() {
		Set<Class<?>> preInitiatedControllers  = 
				reflections.getTypesAnnotatedWith((Class<? extends Annotation>) Controller.class);
		return instantiateControllers(preInitiatedControllers);
	}
	
	Map<Class<?>, Object> instantiateControllers(Set<Class<?>> preInitatedControllers) {
		Map<Class<?>, Object> controllers = Maps.newHashMap();
		try {
			for (Class<?> clazz : preInitatedControllers) {
				controllers.put(clazz, clazz.newInstance());
			}
		} catch (InstantiationException | IllegalAccessException e) {
			log.error(e.getMessage());
		}
		return controllers;
	}
}
