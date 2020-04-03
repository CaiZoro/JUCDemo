package com.leetcode;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


class MyThread implements Callable<Integer>
{

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("********come in Callable");
		return 1024;
	}
}

public class CallableDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
		
		Thread t1 = new Thread(futureTask,"AA");
		t1.start();
		System.out.println("*******result:"+futureTask.get());
	}
}
