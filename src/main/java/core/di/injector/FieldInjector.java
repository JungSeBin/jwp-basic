package core.di.injector;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.di.factory.BeanFactory;
import core.di.factory.BeanFactoryUtils;

public class FieldInjector extends AbstractInjector {
	private static final Logger logger = 
			LoggerFactory.getLogger(FieldInjector.class);
	
	public FieldInjector(BeanFactory beanFactory) {
		super(beanFactory);
	}
	
	Set<?> getInjectedBeans(Class<?> clazz) {
		return BeanFactoryUtils.getInjectedConstructor(clazz);
	}
	
	void inject(Object injectedBeant)
}
