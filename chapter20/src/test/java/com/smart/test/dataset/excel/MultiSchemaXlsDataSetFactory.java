package com.smart.test.dataset.excel;

import org.unitils.core.UnitilsException;
import org.unitils.dbunit.datasetfactory.DataSetFactory;
import org.unitils.dbunit.util.MultiSchemaDataSet;

import java.io.File;
import java.util.Arrays;
import java.util.Properties;

public class MultiSchemaXlsDataSetFactory implements DataSetFactory {

	protected String defaultSchemaName;

	//初始化
	public void init(Properties configuration, String defaultSchemaName) {
		this.defaultSchemaName = defaultSchemaName;
	}

	//创建数据集
	public MultiSchemaDataSet createDataSet(File... dataSetFiles) {
		try {
			MultiSchemaXlsDataSetReader xlsDataSetReader = new MultiSchemaXlsDataSetReader(
					defaultSchemaName);
			return xlsDataSetReader.readDataSetXls(dataSetFiles);
		} catch (Exception e) {
			throw new UnitilsException("创建数据集失败: "
					+ Arrays.toString(dataSetFiles), e);
		}
	}

	// 获取数据集文件的扩展名
	public String getDataSetFileExtension() {
		return "xls";
	}

}
