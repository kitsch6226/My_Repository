package controller;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.reflections.Reflections;

import store.Component;



public class ApplicationContext {
	
	public ApplicationContext(String propertiesPath) throws Exception{
		System.out.println("어플리케이션 콘텍스트 시작");
		System.out.println("어플리케이션콘텍스트 propertiesPath: "+propertiesPath);
		
		Properties props = new Properties();
		props.load(new FileReader(propertiesPath));
		prepareObjects(props);
		prepareAnnotaionObjects();
		injectDependency();
		System.out.println("어플리케이션 콘텍스트 끝\n");
	}
	
	Hashtable<String, Object> objTable = new Hashtable<String, Object>();
	//빈관리를 위해 contextloaderlistener에서 분리
	public Object getBean(String key) {
		System.out.println("어플리케이션콘텍스트 키: "+key);
		return objTable.get(key);
	}
	
	private void prepareAnnotaionObjects() throws Exception{
		Reflections reflector = new Reflections("");
		Set<Class<?>> list = reflector.getTypesAnnotatedWith(Component.class);
		String key = null;
		System.out.println("어플리케이션콘텍스트 prepareAnnotaionObject list: "+list);
		for(Class<?> clazz : list) {
			key = clazz.getAnnotation(Component.class).value();
			System.out.println("어플리케이션콘텍스트 prepareAnnotaionObject clazz: "+key);
			System.out.println("어플리케이션콘텍스트 prepareAnnotaionObject key: "+key+"\n");
			objTable.put(key, clazz.newInstance());
		}
		
		
	}
	private void prepareObjects(Properties props)throws Exception{
		Context ctx = new InitialContext();
		String key = null;
		String value = null;
		for(Object item : props.keySet()) {
			key = (String)item;
			value = props.getProperty(key);
			System.out.println("어플리케이션 콘텍스트 prepareObject 키: "+ key);
			System.out.println("어플리케이션 콘텍스트 prepareObject 밸류: "+ value+"\n");
			if(key.startsWith("jndi.")) {
				objTable.put(key, ctx.lookup(value));
			}else {
				objTable.put(key, Class.forName(value).newInstance());
			}
		}
	}
	
	private void callSetter(Object obj) throws Exception{
		Object dependency = null;
		for(Method m : obj.getClass().getMethods()) {
			if(m.getName().startsWith("set")) {
				dependency = findObjectByType(m.getParameterTypes()[0]);
				System.out.println("콜셋터 : "+m.getParameterTypes()[0]);
				if(dependency != null) {
					m.invoke(obj, dependency);
				}
			}
		}
	}
	private void injectDependency() throws Exception{
		System.out.println("의존성주입 keyset: "+objTable.keySet());
		for(String key : objTable.keySet()) {
			if(!key.startsWith("jndi.")) {
				System.out.println("의존성주입 키: "+key);
				callSetter(objTable.get(key));
			}
		}
	}
	private Object findObjectByType(Class<?> type) {
		int i= 0;
		for(Object obj : objTable.values()) {
			i++;
			System.out.println("오브젝트 타입찾기 method"+i);
			if(type.isInstance(obj)) {
				System.out.println("오브젝트 타입찾기 obj: "+obj);
				return obj;
			}
		}return null;
	}
}
