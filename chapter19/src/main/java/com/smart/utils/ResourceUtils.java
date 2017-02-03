package com.smart.utils;
public class ResourceUtils {
	/**
	 * 获取当前类所在的物理路径
	 * @param cls   类
	 * @param name  文件名
	 * @return
	 */
	public static String getResourceFullPath(Class cls,String name){
		String path= cls.getResource("").getPath();
		path = path.substring(1);
		StringBuffer fileName = new StringBuffer(path);
		fileName.append(name);
		return fileName.toString().replace("test-classes","classes");
	}

}
