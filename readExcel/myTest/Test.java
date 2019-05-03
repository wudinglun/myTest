package myTest;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		Readxls readxls=new Readxls();
		try {
			List<List<String>>lists= readxls.readXls("D:\\a.xlsx");
			if(lists!=null&&lists.size()>0){
				List<String>list=lists.get(0);
				for(int i=0;i<list.size();i++){
					System.out.println(list.get(i)+"    ");					
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("½áÊø");
	}

}
