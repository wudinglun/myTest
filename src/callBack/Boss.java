package callBack;
/**
 * 
 * 1.��Ҫһ���ص�������2.��Ҫli 3.��Ҫ li ����һ�����У�boss�� ���߻ص��ӿڵķ�����
 * 
 * @author adam
 *
 */
public class Boss implements CallBack{
	private Li li;
	
	public Boss(Li li) {
		this.li=li;
	}
	
	public void ask(final String question){
		System.out.println("�ϰ���С��"+question);
		new Thread(){
			@Override
			public void run() {
				li.work(Boss.this, question);
			}
		}.start();
		System.out.println("�ϰ彻����Ȳ�ȥ��");
	}

	//�õ��ظ� �ص�����
	@Override
	public void getAnswer(String str) {
		System.out.println("�ϰ�õ�Ա���Ļظ���"+str);		
	}
}
