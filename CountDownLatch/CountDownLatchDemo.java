package com.atguigu;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	public static void main(String[] args) throws Exception{
		CountDownLatch countDownLatch = new CountDownLatch(6);
		
		for(int i=1 ;i<= 6;i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"\t 国，被灭");
				countDownLatch.countDown();
			},CountryEnum.forEach_CountryEnum(i).getRetMessage()).start(); 
		}
		
		countDownLatch.await();
		System.out.println(Thread.currentThread().getName()+"\t ******秦帝国，一统华夏");
	}
	
	
	public static void closeDoor(String[] args) throws Exception{
		CountDownLatch countDownLatch = new CountDownLatch(6);
		
		for(int i=1 ;i<= 6;i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"\t上完自习，离开教室");
				countDownLatch.countDown();
			},String.valueOf(i)).start(); 
		}
		
		countDownLatch.await();
		System.out.println(Thread.currentThread().getName()+"\t ******88班长最后关门走人");
	}
}
