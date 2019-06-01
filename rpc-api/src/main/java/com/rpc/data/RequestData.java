package com.rpc.data;

import java.io.Serializable;

public class RequestData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String interfaceName;
	private String methodName;
	private Class<?>[]parameterTypes;
	private Object[] parameter;
	public String getInterfaceName() {
		return interfaceName;
	}
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public Class<?>[] getParameterTypes() {
		return parameterTypes;
	}
	public void setParameterTypes(Class<?>[] parameterTypes) {
		this.parameterTypes = parameterTypes;
	}
	public Object[] getParameter() {
		return parameter;
	}
	public void setParameter(Object[] parameter) {
		this.parameter = parameter;
	}
	
}
