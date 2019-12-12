package com.maso.reactive.factory.rangefactory;

import io.reactivex.Observable;

public class Main {
	public static void main(String[] args) {

		Observable.range(0, 20).subscribe(System.out::println);

	}
}