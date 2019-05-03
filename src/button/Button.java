package button;

/**
 * 需要一个 接口(或者一个带有回调方法的类)
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
