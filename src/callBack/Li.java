package callBack;

public class Li {
	//Ա���ɻ��Ҫһ������question �� �ظ��Ķ���
	public void work(final Boss boss, String question) {
		
		// ģ��С����Լ���������Ҫ�ܳ�ʱ��
		System.out.println("**Ա����ʼ�ɻ�**");
		new Thread(){
			public void run() {
				try {
					System.out.println("�ɻ���...");
					sleep(5000);
					System.out.println("**Ա���������**");
					boss.getAnswer("�ϰ��Ҹ�����");//����ظ��Ķ������ϰ�
					System.out.println("**Ա���ش����°���**");
				} catch (Exception e) {
					// TODO: handle exception
				}
			};
		}.start();
		
	}

}
