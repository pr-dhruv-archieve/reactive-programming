package com.maso.reactive.factorymethods.cold;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

public class FromIteratorFactory {

	public static void main(String[] args) {

		/**
		 * Creation of the cold Observable using fromIterable() factory method of
		 * Observable Interface
		 */

		List<String> emissions = Arrays.asList("First", "Second", "Third", "Fourth");
		Observable<String> source = Observable.fromIterable(emissions);

		source.subscribe(e -> System.out.println("Observer 1 : " + e));
		source.subscribe(e -> System.out.println("Observer 2 : " + e));

	}

}
