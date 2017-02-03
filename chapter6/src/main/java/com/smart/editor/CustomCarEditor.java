package com.smart.editor;

import java.beans.PropertyEditorSupport;

public class CustomCarEditor extends PropertyEditorSupport {

	public void setAsText(String text){
		if(text == null || text.indexOf(",") == -1){
			throw new IllegalArgumentException("设置的字符串格式不正确");
		}
		String[] infos = text.split(",");
		Car car = new Car();
		car.setBrand(infos[0]);
		car.setMaxSpeed(Integer.parseInt(infos[1]));
		car.setPrice(Double.parseDouble(infos[2]));
		setValue(car);
	}

	public String getAsText() {
		Object value = getValue();
		if(value == null){
		   return "";
		}else{
		   Car car = (Car)value;
		   return car.getBrand()+","+car.getMaxSpeed()+","+car.getPrice();
		}
	}
}
