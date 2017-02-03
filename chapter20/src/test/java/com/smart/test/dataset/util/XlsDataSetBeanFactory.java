package com.smart.test.dataset.util;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.converters.DateConverter;
import org.dbunit.dataset.Column;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.excel.XlsDataSet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 从EXCEL数据集文件创建Bean
 */
public class XlsDataSetBeanFactory {
	
	//从DbUnit的EXCEL数据集文件创建多个bean
	public static <T> List<T> createBeans(Class testClass,String file, String tableName,
			Class<T> clazz) throws Exception {
		BeanUtilsBean beanUtils = createBeanUtils();
		List<Map<String, Object>> propsList = createProps(testClass,file, tableName);
		List<T> beans = new ArrayList<T>();
		for (Map<String, Object> props : propsList) {
			T bean = clazz.newInstance();
			beanUtils.populate(bean, props);
			beans.add(bean);
		}
		return beans;
	}

	//从DbUnit的EXCEL数据集文件创建多个bean
	public static <T> T createBean(Class testClass,String file, String tableName, Class<T> clazz)
			throws Exception {
		BeanUtilsBean beanUtils = createBeanUtils();
		List<Map<String, Object>> propsList = createProps(testClass,file, tableName);
		T bean = clazz.newInstance();
		beanUtils.populate(bean, propsList.get(0));
		return bean;
	}
	
	private static List<Map<String, Object>> createProps(Class testClass,String file,
			String tableName) throws IOException, DataSetException {
		List<Map<String, Object>> propsList = new ArrayList<Map<String, Object>>();
		IDataSet expected = new XlsDataSet(testClass.getResourceAsStream(file));
		ITable table = expected.getTable(tableName);
		Column[] columns = table.getTableMetaData().getColumns();
		for (int i = 0; i < table.getRowCount(); i++) {
			Map<String, Object> props = new HashMap<String, Object>();
			for (Column c : columns) {
				Object value = table.getValue(i, c.getColumnName());
				String propName = underlineToCamel(c.getColumnName());
				props.put(propName, value);
			}
			propsList.add(props);
		}
		return propsList;
	}

	private static String underlineToCamel(String str) {
		String pattern[] = str.split("_");
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < pattern.length; i++) {
			if (i == 0) {
				builder.append(pattern[i]);
			} else {
				builder.append(pattern[i].substring(0, 1).toUpperCase());
				builder.append(pattern[i].substring(1));
			}
		}
		return builder.toString();
	}

	private static BeanUtilsBean createBeanUtils() {
		ConvertUtilsBean convertUtilsBean = createConverUtils();
		return new BeanUtilsBean(convertUtilsBean);
	}
	private static ConvertUtilsBean createConverUtils() {
		DateConverter dateConverter = new DateConverter();
		dateConverter.setPattern("yyyy-MM-dd");
		ConvertUtilsBean convertUtilsBean = new ConvertUtilsBean();
		convertUtilsBean.register(dateConverter, java.util.Date.class);
		convertUtilsBean.register(dateConverter, Timestamp.class);
		convertUtilsBean.register(dateConverter, java.sql.Date.class);
		return convertUtilsBean;
	}
}