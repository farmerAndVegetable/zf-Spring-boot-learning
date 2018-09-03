package org.zf.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ScheduleDelayTest2 {
	public static Timer timer=new Timer();
	public static int runCount=0;
	
	static public class MyTask1 extends TimerTask{

		@Override
		public void run() {
			
			try {
				System.out.println("1 begin 运行了！时间为："+new Date());
				Thread.sleep(5000);
				System.out.println("1 end 运行了！时间为："+new Date());
				runCount++;
				if(runCount==5){
					timer.cancel();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	public static void main(String[] args) {
		
		try {
			MyTask1 task1=new MyTask1();
			SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString1="2016-8-12 15:16:18";
			Date dateRef1=sdf1.parse(dateString1);
			System.out.println("字符串1时间 ："+new Date());
			timer.schedule(task1, dateRef1, 2000);
			System.out.println("");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
