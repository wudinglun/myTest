package test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTest {
	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		//4.创建Task对象
        Task task = new Task();
        //5.使用submit()方法提交任务给执行者
        System.out.println("Main Executing the Task\n");
        Future<String> result = executor.submit(task);
      //7.使用通过submit()方法返回的Future对象result的cancel()方法，
        //取消任务的执行。传入true值作为cancel方法的参数。
        try {
        	System.out.println(new Date().getTime());
			String str=result.get(200, TimeUnit.MILLISECONDS);
			Thread.sleep(200);
			result.cancel(true);
			System.out.println(str);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.out.println(new Date().getTime());
			System.out.println("超时");
			result.cancel(true);
			e.printStackTrace();
		}
        //8.将isCancelled()方法和isDone()的调用结果写入控制台，验证任务已取消，已完成
        System.out.printf("Main:Canceled:%s\n",result.isCancelled());
        System.out.printf("Main:Done:%s\n",result.isDone());
        //9.使用shutdown()方法结束执行者，写入信息(到控制台)，表明程序结束
        executor.shutdown();
        System.out.println("Main:The executor has finished");
	}
}

class Task implements Callable<String>{
	
    @Override
    public String call() throws Exception {
    	int i=0;
        while (true) {
            System.out.println("打印...........");
            InputStream in = new FileInputStream("C:\\Users\\Administrator\\Desktop\\bms1.txt");
            byte[] bytes = new byte[2048];
            int n = -1;
            while ((n = in.read(bytes,0,bytes.length)) != -1) {
                //转换成字符串
                String str = new String(bytes,0,n,"GBK"); 
 //               System.out.println(str);
            }
            in.close();
//            Thread.sleep(500);
            i++;
        }
    }

}
