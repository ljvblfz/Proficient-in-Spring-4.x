package com.smart.anno;

import org.springframework.core.annotation.Order;
        import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class OnePlugin implements Plugin{

}
