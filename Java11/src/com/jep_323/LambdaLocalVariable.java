package com.jep_323;

import java.util.stream.Stream;

public class LambdaLocalVariable {

	public static void main(String[] args) {
		Stream<String> names = Stream.of("1","2","3");
		names.forEach((String name)->System.out.println(name));
		
		Stream<String> names2 = Stream.of("1","2","3");
		names2.forEach(s->System.out.println(s));
		
		Stream<String> names3 = Stream.of("1","2","3");
		names3.forEach((var name)->System.out.println(name));
	}
	
}
