package button;

/**
 * ��Ҫһ�� �ӿ�(����һ�����лص���������)
 * @author adam
 *
 */
public class Button {
	
	private Listener listener;
	public void setListener(Listener listener) {
		this.listener = listener;
	}
	public void onClick(String str){
		listener.onClick(str);
	}

}
