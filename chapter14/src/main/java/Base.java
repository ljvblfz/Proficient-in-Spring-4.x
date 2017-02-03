import java.util.List;


public class Base<T> {
   public <T> List<T> getEntity(Class<T> entity,int id){
	   return Mock.getList(entity);
   }
}
