package test;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	int ii;
	long ll;
	double dd;
	Date date;
	Object oo=1;
	
	public static void main(String[] args) {
//		Object ss=1;
//		double ddd=2;
//		int iii=(int)ddd;
//		System.out.println(iii);
//		try {
//			Class cls=Class.forName("test.student");
//			Field field1=cls.getDeclaredField("score");
//			System.out.println(isNumberType(field1.getType()));
//			Field field2=cls.getDeclaredField("name");
//			System.out.println(isNumberType(field2.getType()));
//			System.out.println(isNumberType(ss.getClass()));
//			Object obj=cls.newInstance();
//			Object value1=3;
//			Object value2="小明";
//			field1.setAccessible(true);
//			field1.set(obj, value1);
//			field2.setAccessible(true);
//			field2.set(obj, value2);
//			System.out.println(obj.toString());
//			System.out.println(ss.getClass().getName());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		String finalDate="20170805";
		String rmk=finalDate.substring(6, 8);
		
		System.out.println(rmk);
		
		
//		String today="20170704";
//		int days=30;
//		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
//		try {
//			Date fdate=format.parse(finalDate);
//			Date tdate=format.parse(today);
//			long bd=(fdate.getTime()-tdate.getTime())/86400000;
//			System.out.println(bd);
//			
//			if((int)bd<0){
//				System.out.println("过期");
//			}else if(((int)bd-days<=1)){
//			    System.out.println("提醒");
////			}
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	
	}
	
	
	
	public static boolean isNumberType(Class<?> targetClazz) {
	    // 判断包装类
	    if (Number.class.isAssignableFrom(targetClazz)) {
	        return true;
	    }
	    // 判断原始类,过滤掉特殊的基本类型
	    if (targetClazz == boolean.class || targetClazz == char.class || targetClazz == void.class) {
	        return false;
	    }
	    return targetClazz.isPrimitive();
	}

}
