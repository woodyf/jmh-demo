package com.cybersoft;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NaiveBenchmark {

	static List<String> m1(List<Integer> ids, Collection<Item> allItems) {
		List<String> result = new ArrayList<>(ids.size());
		for (Integer id : ids) {
			for (Item item : allItems) {
				if (item.getId() == id) {
					result.add(item.getValue());
					break;
				}
			}
		}
		return result;
	}

	static List<String> m2(List<Integer> ids, Collection<Item> allItems) {
		Map<Integer, String> lookUpMap = allItems.stream().collect(Collectors.toMap(Item::getId, Item::getValue));
		return ids.stream().map(lookUpMap::get).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		// prepare test data
		Collection<Item> allItems = prepareItems(5);
		System.out.println("allItems: " + allItems);
		List<Integer> ids = prepareIds(5, 3);
		System.out.println("ids: " + ids);

		// confirm behavior
		System.out.println("m1");
		System.out.println(m1(ids, allItems));
		System.out.println("m2");
		System.out.println(m2(ids, allItems));

		// benchmark
		long t0 = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			m1(ids, allItems);
		}
		long t1 = System.currentTimeMillis();
		System.out.println("m1 cost:" + (t1 - t0));

		t0 = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			m2(ids, allItems);
		}
		t1 = System.currentTimeMillis();
		System.out.println("m2 cost:" + (t1 - t0));
	}

	private static Random rnd = new Random();

	private static Collection<Item> prepareItems(int size) {
		return IntStream.range(0, size).mapToObj(i -> new Item(i, String.valueOf(rnd.nextDouble()).substring(0, 6)))
				.collect(Collectors.toSet());
	}

	private static List<Integer> prepareIds(int size, int upperBound) {
		List<Integer> ids = IntStream.generate(() -> rnd.nextInt(upperBound)).limit(size).boxed()
				.collect(Collectors.toCollection(ArrayList::new));
		Collections.shuffle(ids);
		return ids;
	}
}
