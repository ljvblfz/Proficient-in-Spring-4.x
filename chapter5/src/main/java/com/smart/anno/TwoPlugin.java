package com.smart.anno;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 2)
public class TwoPlugin implements Plugin{

}
