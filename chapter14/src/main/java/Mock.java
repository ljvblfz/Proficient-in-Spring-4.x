import java.util.ArrayList;
import java.util.List;


public class Mock {
    public static List getList(Class entity)
    {
    	List list = new ArrayList();
		try {
			list.add(entity.newInstance());
			list.add(entity.newInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}    

		
		return list;
    }
    
    public static void main(String[] args) {
		List<String> ls = new ArrayList();
		ls.add("str1");
		ls.add("str2");
		ls.add("str3");
		for (String string : ls) {
			System.out.println(string);
		}
	}
}
