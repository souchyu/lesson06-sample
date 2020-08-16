package com.java.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestCollections {

	public static void main(String[] args) {
		List<TestModel> testModels = new ArrayList<>();

		testModels.add(TestModel.builder().date(LocalDate.of(2020, 3, 25)).amount(new BigDecimal(4.0)).build());
		testModels.add(TestModel.builder().date(LocalDate.of(2020, 3, 25)).amount(new BigDecimal(5.0)).build());
		testModels.add(TestModel.builder().date(LocalDate.of(2020, 3, 1)).amount(new BigDecimal(1.0)).build());
		testModels.add(TestModel.builder().date(LocalDate.of(2020, 3, 1)).amount(new BigDecimal(2.0)).build());
		testModels.add(TestModel.builder().date(LocalDate.of(2020, 3, 19)).amount(new BigDecimal(3.0)).build());
		

		Map<LocalDate, List<TestModel>> testModelMaps = testModels.stream()
				.collect(Collectors.groupingBy(testModel -> testModel.getDate()));

		List<TestModelSummary> testModelSummaryList = new ArrayList<>();

		testModelMaps.keySet().stream().sorted((d1, d2) -> d1.compareTo(d2)).forEach(date -> {
			TestModelSummary testModelSummary = TestModelSummary.builder().date(date).amount(new BigDecimal(0)).build();
			testModelSummaryList.add(testModelSummary);

			testModelSummary.setCount(testModelMaps.get(date).size());
			testModelSummary.setAmount(testModelMaps.get(date).stream().map(l -> l.getAmount())
					.reduce(new BigDecimal(0), BigDecimal::add));
		});

		testModelSummaryList.forEach(l -> {
			log.debug("{}", l);
		});

	}
}

@Data
@SuperBuilder(toBuilder = true)
class TestModel {
	private LocalDate date;
	private BigDecimal amount;
}

@Data
@SuperBuilder(toBuilder = true)
class TestModelSummary {
	private LocalDate date;
	private BigDecimal amount;
	private int count;
}
