package org.zf.bo.impl;

public class SynTest {
	private String name;
	private int age;
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public static void main(String[] args) {
		
		SynTest syntest=new SynTest();
		syntest.setName("zhangsan");
		syntest.setAge(18);

		Thread thread1=new Thread("synchronizedOne"){
			@Override
			public void run() {
				synchronized (syntest) {
					try {
						System.out.println("thread1睡之前=============================被锁住了");
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("thread1醒了：=============================被锁住了");
				}
				
			};
		};
		thread1.start();
		
		SynTest syntest1=new SynTest();
		syntest.setName("李四");
		syntest.setAge(18);
		synchronized (syntest1) {
		
			try {
				System.out.println(syntest.getName()+"============================进入main线程同步快");
				Thread.sleep(5000);
				System.out.println(syntest.getName()+"============================main线程同步快即将结束");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}

}
