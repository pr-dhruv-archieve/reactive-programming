package com.maso.reactive.factory.intervalfactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class Main {
	public static void main(String[] args) {

		Observable.interval(200, TimeUnit.MILLISECONDS).subscribe(System.out::println);
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
