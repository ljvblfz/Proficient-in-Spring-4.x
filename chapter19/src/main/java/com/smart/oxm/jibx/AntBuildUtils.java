package com.smart.oxm.jibx;

import java.io.File;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;

public class AntBuildUtils {
	public static void doBuild(String buildFilePath) {
		File buildFile = new File(buildFilePath);
		// 创建一个ANT项目
		Project p = new Project();
		try {
			p.fireBuildStarted();
			// 初始化该项目
			p.init();
			ProjectHelper helper = ProjectHelper.getProjectHelper();
			// 解析项目的构建文件
			helper.parse(p, buildFile);
			// 执行项目的某一个目标
			p.executeTarget(p.getDefaultTarget());
			p.fireBuildFinished(null);
		} catch (BuildException e) {
			e.printStackTrace();
		}
	}

}
