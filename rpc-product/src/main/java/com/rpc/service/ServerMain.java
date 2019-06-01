package com.rpc.service;

import com.rpc.api.Api;

public class ServerMain {

	public static void main(String[] args) {
		RpcServer rpcServer=new RpcServer();
		rpcServer.publishService(Api.class, new ApiImp());
		rpcServer.start(12345);
		
		
		
	}

}
