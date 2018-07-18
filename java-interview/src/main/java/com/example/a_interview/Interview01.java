package com.example.a_interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Interview01 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 8, 5, 4, 2);
		int number = 3;
//		1
//		filter(list, number);
//		System.out.println(list);
//		System.out.println(number);
		
//		2
//		List<Integer> filtered = list.stream().filter((Integer x) -> x > 3).collect(Collectors.toList());
//		System.out.println(filtered);
	}

	public static void filter(List<Integer> list, int number) {
		number = 7;
		List<Integer> filtered = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Integer el = list.get(i);
			if (el >= number) {
				filtered.add(el);
			}
		}

		list.clear();
		list = filtered;
	}

}
