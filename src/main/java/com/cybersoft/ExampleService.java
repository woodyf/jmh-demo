package com.cybersoft;

import java.util.Collection;
import java.util.List;

public interface ExampleService {
	List<String> mapIdsToItems(List<Integer> ids, Collection<Item> allItems);
}
