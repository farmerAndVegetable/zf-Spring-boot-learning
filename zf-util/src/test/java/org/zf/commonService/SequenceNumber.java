package org.zf.commonService;

public class SequenceNumber {
	//①通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
		public Integer initialValue(){
			return 0;
		}
	};
	
	//②获取下一个序列值
	public int getNextNum(){
		seqNum.set(seqNum.get()+1);
		return seqNum.get();
	}
	
	public static void main(String[] args){
		SequenceNumber sn = new SequenceNumber();
		//③ 3个线程共享sn，各自产生序列号
		TestClient1 t1 = new TestClient1(sn);
		TestClient2 t2 = new TestClient2(sn);
		TestClient3 t3 = new TestClient3(sn);
		t1.start();
		t2.start();
		t3.start();
	}
	private static class TestClient1 extends Thread{
		private SequenceNumber sn;
		
		public TestClient1(SequenceNumber sn) {
			this.sn = sn;
		}
		public void run(){
			for (int i = 0; i < 10; i++) {//④每个线程打出3个序列值
				
				System.out.println("thread["+Thread.currentThread().getName()+
				"] t1sn["+sn.getNextNum()+"]");
				
			}
		}
	}
	
	
	private static class TestClient2 extends Thread{
		private SequenceNumber sn;
		
		public TestClient2(SequenceNumber sn) {
			this.sn = sn;
		}
		public void run(){
			for (int i = 0; i < 10; i=i+2) {//④每个线程打出3个序列值
				
				System.out.println("thread["+Thread.currentThread().getName()+
				"] t2sn["+sn.getNextNum()+"]");
				
			}
		}
	}
	
	private static class TestClient3 extends Thread{
		private SequenceNumber sn;
		
		public TestClient3(SequenceNumber sn) {
			this.sn = sn;
		}
		public void run(){
			for (int i = 0; i < 10; i=i+3) {//④每个线程打出3个序列值
				
				System.out.println("thread["+Thread.currentThread().getName()+
				"] t3sn["+sn.getNextNum()+"]");
				
			}
		}
	}
}
 