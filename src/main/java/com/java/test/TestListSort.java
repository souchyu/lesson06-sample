package com.java.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestListSort {

    public static void main(String[] args) {
	log.info(TestListSort.sortList("bbbb,aaa4,aaa3,,,aaa1,aaa3,,,,", "\\,", ";\r\n"));
    }

    public static String sortList(String inputString, String srcDelimiter, String resultDelimiter) {

	// split to list
	List<String> list = Arrays.asList(inputString.split(srcDelimiter));

	List<String> resultList = new ArrayList<>(list.size());
	// sort
	list.sort((item1, item2) -> item1.compareTo(item2));
	list.stream().filter(l -> l.length() > 0).forEach(item -> {
	    // remove duplicate data
	    if (!resultList.contains(item)) {
		resultList.add(item);
	    }
	});
	resultList.add("");

	// change list to string
	return resultList.stream().collect(Collectors.joining(resultDelimiter));
    }
}
