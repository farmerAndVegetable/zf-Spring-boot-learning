package org.zf.bo.impl;

import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class Quartz {
	
	private static final int THREADNUM=3;
	private static final Executor exec=Executors.newFixedThreadPool(THREADNUM);
	int runNum=1;
	public static void main(String[] args) {
		Quartz q=new Quartz();
		q.quartzExcute();
	}
	
	
	public void quartzExcute(){
		System.out.println("任务调度执行时间:"+new Date());
		while(runNum<=3){
			Runnable runable=new Runnable() {
				
				@Override
				public void run() {
					if(runNum==1){
						System.out.println("t1=========");
					}
					if(runNum==2){
						System.out.println("t2=========");
					}
					if(runNum==3){
						System.out.println("t3=========");
					}
					
				}
				
			};
			runNum++;
			exec.execute(runable);
			
		}
		
		/*
		Thread t1 = new Thread(){
		    public void run(){
		    	try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	System.out.println("t1=========");
		    	
		    }
		};
		t1.start();
		
		Thread t2 = new Thread(){
		    public void run(){
		    	System.out.println("t2=========");
		    	
		    }
		};
		t2.start();
		
		
		Thread t3 = new Thread(){
		    public void run(){
		    	System.out.println("t3=========");
		    	
		    }
		};
		t3.start();*/
		
		
	}

}
