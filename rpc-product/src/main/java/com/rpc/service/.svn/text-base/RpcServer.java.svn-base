package com.rpc.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.rpc.data.RequestData;

public class RpcServer {
	//zookeper
	private Map<String,Object> serviceMap=new ConcurrentHashMap<String, Object>(32);
	
	private ThreadPoolExecutor excExecutor=new ThreadPoolExecutor(8,20, 200,TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10));
	
	public void publishService(Class<?>interfaceClass,Object instance){
		this.serviceMap.put(interfaceClass.getName(), instance);
	}
	public void start(int port){
		try {
			ServerSocket serverSocket=new ServerSocket();
			serverSocket.bind(new InetSocketAddress(port));
			System.out.println("服务端已经启动.....");
			while(true){
				excExecutor.execute(new Tack(serverSocket.accept()));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private class Tack implements Runnable{
		private Socket client;
		public Tack(Socket socket){
			this.client=socket;
		}
		public void run() {
			try{
				ObjectOutputStream serializer=new ObjectOutputStream(client.getOutputStream());
				ObjectInputStream deserializer=new ObjectInputStream(client.getInputStream());	
				RequestData requestData=(RequestData) deserializer.readObject();
				Object instance=serviceMap.get(requestData.getInterfaceName());
				Method method= instance.getClass().getDeclaredMethod(requestData.getMethodName(),requestData.getParameterTypes());
				Object result=method.invoke(instance, requestData.getParameter());
				serializer.writeObject(result);
			}catch(Exception e){
				
			}
		
		}
		
	}
	
	
}
