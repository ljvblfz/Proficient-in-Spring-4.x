package com.smart.anno;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {
    
	@Autowired(required=false)
	private List<Plugin> plugins;
	@Autowired
	private Map<String,Plugin> pluginMaps;

	public List<Plugin> getPlugins() {
		return plugins;
	}
}
