package fanxing;

public class FanXing<T> {
	
	public T getInstance(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Class<?> cls=Class.forName(className);
		T t=(T)cls.newInstance();
		return t;
	}

}
