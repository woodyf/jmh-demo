package com.cybersoft;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExampleServiceImpl implements ExampleService {

	@Override
	public List<String> mapIdsToItems(List<Integer> ids, Collection<Item> allItems) {
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

}
