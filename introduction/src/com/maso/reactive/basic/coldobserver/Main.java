package com.maso.reactive.basic.coldobserver;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Main {
    public static void main(String[] args) {

        Observable<String> source = Observable.just("First", "Second", "Third");

        source.subscribe(e -> System.out.println("Oberserver 1 : " + e));
        source.subscribe(e -> System.out.println("Oberserver 2 : " + e));

    }
}