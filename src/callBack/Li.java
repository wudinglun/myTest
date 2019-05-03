package callBack;

public class Li {
	//员工干活，需要一个条件question 和 回复的对象
	public void work(final Boss boss, String question) {
		
		// 模拟小李办自己的事情需要很长时间
		System.out.println("**员工开始干活**");
		new Thread(){
			public void run() {
				try {
					System.out.println("干活中...");
					sleep(5000);
					System.out.println("**员工活干完了**");
					boss.getAnswer("老板我干完了");//这里回复的对象是老板
					System.out.println("**员工回答完下班了**");
				} catch (Exception e) {
					// TODO: handle exception
				}
			};
		}.start();
		
	}

}
