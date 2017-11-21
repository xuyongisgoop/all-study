package com.xuyong.study.jexl;

import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;

public class JexlTest {
	public static void main(String[] args) {
		Ower ower = new Ower();
		ower.setName("jetty");
		ower.setAge(20);
		Cat cat = new Cat();
		cat.setName("tom");
		cat.setAge(1);
		Dog dog = new Dog();
		dog.setName("mydog");
		dog.setAge(9);
		
	    // Create or retrieve an engine
	    JexlEngine jexl = new JexlBuilder().create();
	    
	    // Create a context and add data
	    JexlContext jc = new MapContext();
	    jc.set("a", 1);
	    jc.set("b", 2);
	    jc.set("dog", dog);
	    
	    // Create an expression
	    String jexlExp = "dog.name == 'mydog'";
	    JexlExpression e = jexl.createExpression(jexlExp);
	    
	    // Now evaluate the expression, getting the result
	    Object o = e.evaluate(jc);
	    
	    System.out.println(o.getClass());
	    System.out.println(o);
	}
}




