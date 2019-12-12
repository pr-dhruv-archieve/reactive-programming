package com.maso.reactive.factorymethods.hot;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class MyConnectableObservable {
	public static void main(String[] args) {
		/**
		 * Creation of the cold Observable using fromIterable() factory method of
		 * Observable Interface
		 */

		List<String> emissions = Arrays.asList("First", "Second", "Third", "Fourth");
		Observable<String> source = Observable.fromIterable(emissions);
		ConnectableObservable<String> hot = source.publish();

		hot.subscribe(e -> System.out.println("Observer 1 : " + e));
		hot.subscribe(e -> System.out.println("Observer 2 : " + e));
		hot.subscribe(e -> System.out.println("Observer 3 : " + e));
		hot.connect();
	}
}
