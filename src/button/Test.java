package button;

public class Test {
	public static void main(String[] args) {
		Button b=new Button();
		Listener listener=new Listener() {
			
			@Override
			public void onClick(String str) {
				System.out.println(str+"�����һ��");
				
			}
		};
		b.setListener(listener);
		b.onClick("��");
	}
    

}


