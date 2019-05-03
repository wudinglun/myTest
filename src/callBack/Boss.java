package callBack;
/**
 * 
 * 1.需要一个回调方法。2.需要li 3.需要 li 调用一个带有（boss类 或者回调接口的方法）
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
		System.out.println("老板让小李"+question);
		new Thread(){
			@Override
			public void run() {
				li.work(Boss.this, question);
			}
		}.start();
		System.out.println("老板交代完喝茶去了");
	}

	//得到回复 回调方法
	@Override
	public void getAnswer(String str) {
		System.out.println("老板得到员工的回复："+str);		
	}
}
