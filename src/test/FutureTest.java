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
		//4.����Task����
        Task task = new Task();
        //5.ʹ��submit()�����ύ�����ִ����
        System.out.println("Main Executing the Task\n");
        Future<String> result = executor.submit(task);
      //7.ʹ��ͨ��submit()�������ص�Future����result��cancel()������
        //ȡ�������ִ�С�����trueֵ��Ϊcancel�����Ĳ�����
        try {
        	System.out.println(new Date().getTime());
			String str=result.get(200, TimeUnit.MILLISECONDS);
			Thread.sleep(200);
			result.cancel(true);
			System.out.println(str);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			System.out.println(new Date().getTime());
			System.out.println("��ʱ");
			result.cancel(true);
			e.printStackTrace();
		}
        //8.��isCancelled()������isDone()�ĵ��ý��д�����̨����֤������ȡ���������
        System.out.printf("Main:Canceled:%s\n",result.isCancelled());
        System.out.printf("Main:Done:%s\n",result.isDone());
        //9.ʹ��shutdown()��������ִ���ߣ�д����Ϣ(������̨)�������������
        executor.shutdown();
        System.out.println("Main:The executor has finished");
	}
}

class Task implements Callable<String>{
	
    @Override
    public String call() throws Exception {
    	int i=0;
        while (true) {
            System.out.println("��ӡ...........");
            InputStream in = new FileInputStream("C:\\Users\\Administrator\\Desktop\\bms1.txt");
            byte[] bytes = new byte[2048];
            int n = -1;
            while ((n = in.read(bytes,0,bytes.length)) != -1) {
                //ת�����ַ���
                String str = new String(bytes,0,n,"GBK"); 
 //               System.out.println(str);
            }
            in.close();
//            Thread.sleep(500);
            i++;
        }
    }

}
