package store;

import java.lang.reflect.Method;
import java.sql.Date;
import java.util.Set;

import javax.servlet.ServletRequest;

public class ServletRequestDataBinder {

	public static Object bind(ServletRequest request, Class<?> dataType, String dataName) throws Exception {
		if (isWhatType(dataType) == 1) {
			return createValueObject(dataType, request.getParameter(dataName));
		} else if (isWhatType(dataType) == 2) {
			return createValueObject2(dataType, request.getParameterValues(dataName));
		} else {
			Set<String> paramNames = request.getParameterMap().keySet();
			Object dataObject = dataType.newInstance();
			Method m = null;
			for (String paramName : paramNames) {
				m = findSetter(dataType, paramName);
				System.out.println("서블릿리퀘스트데이터바인더 bind paramName, getparam, datatype: " + paramName + ", "
						+ request.getParameter(paramName) + ", " + dataType);
				if (m != null) {
					m.invoke(dataObject, createValueObject(m.getParameterTypes()[0], request.getParameter(paramName)));
				}
			}return dataObject;

		}
	}

	private static int isWhatType(Class<?> type) {
		if (type.getName().contentEquals("int") || type == Integer.class || type.getName().contentEquals("double")
				|| type == Double.class || type.getName().contentEquals("float") || type == Float.class
				|| type.getName().contentEquals("boolean") || type == Boolean.class
				|| type == String.class || type == Date.class) {
			return 1;
		} else if (type.getName().contentEquals("String[]") || type == String[].class) {
			return 2;
		} else {
			return 3;
		}
	}

	private static Object createValueObject(Class<?> type, String value) {
		if (type.getName().contentEquals("int") || type == Integer.class) {
			return new Integer(value);
		} else if (type.getName().equals("float") || type == Float.class) {
			return new Float(value);

		} else if (type.getName().equals("long") || type == Long.class) {
			return new Long(value);

		} else if (type.getName().equals("double") || type == Double.class) {
			return new Double(value);

		} else if (type.getName().equals("boolean") || type == Boolean.class) {
			return new Boolean(value);

		} else if (type == Date.class) {
			return java.sql.Date.valueOf(value);

		} else {
			return value;
		}
	}

	private static Object createValueObject2(Class<?> type, String[] value) {
		return value;
	}

	private static Method findSetter(Class<?> type, String name) {
		Method[] methods = type.getMethods();
		System.out.println("파인드 세터: "+type);
		String propName = null;
		for (Method m : methods) {
			if (!m.getName().startsWith("set"))
				continue;
			propName = m.getName().substring(3);
			if (propName.toLowerCase().contentEquals(name.toLowerCase())) {
				return m;
			}
		}
		return null;
	}
}
