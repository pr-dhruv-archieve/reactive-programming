package com.maso.reactive.basic.observable;

import io.reactivex.Observable;

public class Main {

    public static void main(String[] args) {
        // Using 'create' factory
	    Observable<String> source =  Observable.create(emitter->{
	        try {
                emitter.onNext("First");
                emitter.onNext("Second");
                emitter.onNext("Third");
                emitter.onComplete();
            } catch(Exception e) {
	            emitter.onError(e);
            }
        });

	    // Using 'just-factrory'
        // Limited to 10 parameter only
        Observable<String> source2 = Observable.just("First", "Second", "Third");
    }
}