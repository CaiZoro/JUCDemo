/**
 * Synchronized和Lock的区别
 * 1、底层实现
 * 2、实现方式
 *    Synchronized不需要手动释放
 *    ReentrentLock需要在finally里释放
 * 3、是否可以中断
 * 4、加锁是否公平
 * 5、精准唤醒
 * 
 * 
 */

package com.leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareResource{
	private int number = 1;
	private Lock lock = new ReentrantLock();
	private Condition c1 =  lock.newCondition(); 
	private Condition c2 =  lock.newCondition(); 
	private Condition c3 =  lock.newCondition(); 
	
	public void print5() {
		lock.lock();
		try {
			while(number != 1) {
				c1.await();
			}
			
			for (int i = 1; i <= 5; i++) {
				System.out.println(Thread.currentThread().getName()+"\t"+i);
			}
			
			number = 2;
			c2.signal();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			// TODO: handle finally clause
			lock.unlock();
		}
		
	}
	
	public void print10() {
		lock.lock();
		try {
			while(number != 2) {
				c2.await();
			}
			
			for (int i = 1; i <= 10; i++) {
				System.out.println(Thread.currentThread().getName()+"\t"+i);
			}
			
			number = 3;
			c3.signal();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			// TODO: handle finally clause
			lock.unlock();
		}
		
	}
	
	public void print15() {
		lock.lock();
		try {
			while(number != 3) {
				c3.await();
			}
			
			for (int i = 1; i <= 15; i++) {
				System.out.println(Thread.currentThread().getName()+"\t"+i);
			}
			
			number = 1;
			c1.signal();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			// TODO: handle finally clause
			lock.unlock();
		}
		
	}
}


public class SyncAndReentrantLockDemo {
	public static void main(String[] args) {
		ShareResource shareResource = new ShareResource();
		new Thread(()-> {
			for (int i = 1; i <= 10; i++) {
				shareResource.print5();
			}
		},"A").start();
		
		new Thread(()-> {
			for (int i = 1; i <= 10; i++) {
				shareResource.print10();
			}
		},"B").start();
		
		new Thread(()-> {
			for (int i = 1; i <= 10; i++) {
				shareResource.print15();
			}
		},"C").start();
	}
}
