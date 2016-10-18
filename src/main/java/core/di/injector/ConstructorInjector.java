package core.di.injector;

import java.util.Set;

import com.google.common.collect.Sets;

import core.di.factory.BeanFactory;

public class ConstructorInjector extends AbstractInjector{
	public ConstructorInjector(BeanFactory beanFactory) {
		super(beanFactory);
	}
	
	@Override
	Set<?> getInjectedBeans(Class<?> clazz) {
		return Sets.newHashSet();
	}
	
	@Override
	Class<?> getBeanClass(Object injectedBean) {
		return null;
	}
	
	@Override
	void inject(Object injectedBean, Object bean, BeanFactory beanFactory) {
		
	}
}
