package fanxing;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import callBack.Boss;
import callBack.Li;

public class Test {
	public static void main(String[] args) {
		Box<String>name=new Box<String>("4522");
		FanXing<Boss>f=new FanXing<>();
		try {
			Boss boss=f.getInstance("callBack.Boss");
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


class Box<T> {

    private T data;

    public Box() {

    }

    public Box(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
    public <E> E user(E e){
    	return e;
    }
    <F extends T> void set(F f){
    	data=f;
    }

}
