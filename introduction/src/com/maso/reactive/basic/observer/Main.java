package com.maso.reactive.basic.observer;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Main {
	public static void main(String[] args) {

		Observable<String> source = Observable.just("First", "Second", "Third");

		Observer<String> observer = new Observer<String>() {
			@Override
			public void onSubscribe(Disposable disposable) {

			}

			@Override
			public void onNext(String s) {
				System.out.println(s);
			}

			@Override
			public void onError(Throwable throwable) {
				throwable.printStackTrace();
			}

			@Override
			public void onComplete() {
				System.out.println("Printing operation is complete");
			}
		};

		source.subscribe(observer);

	}
}