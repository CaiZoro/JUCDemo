package com.atguigu;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author VULCAN
 *	1 CAS是什么？===>compareAnsSet
 *		比较并交换
 */
public class CASDemo {
	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger(5);
		
		System.out.println(atomicInteger.compareAndSet(5, 2019)+"\t current data:" + atomicInteger.get());
		System.out.println(atomicInteger.compareAndSet(5, 2014)+"\t current data:" + atomicInteger.get());
		atomicInteger.getAndIncrement();
	}
}
