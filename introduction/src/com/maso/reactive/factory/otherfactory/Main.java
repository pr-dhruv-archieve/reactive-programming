package com.maso.reactive.factory.otherfactory;

import io.reactivex.Observable;

public class Main {
	public static void main(String[] args) {
		/*
		 * It doesn't emit anything. It is created because Observable factory method do
		 * not accept null objects, so you can't leave the interval() or fromIterable()
		 * or just() with empty or null Objects.
		 * 
		 * This thing is allowed in RxJava 1.0 but from 2.0 onward it is not allowed.
		 * 
		 * As an alternative they've chosen to work with a specific factory that emits
		 * nothing like the empty()
		 * 
		 * It will call onComplete() directly.
		 */
		Observable.empty();

		/**
		 * never() is not going to emit any values but also it will not call
		 * onComplete(), which means it will leave the observer wait forever.
		 */
		Observable.never();

		/**
		 * To make sure these factory functions are working we need to pause the main
		 * thread or make it sleep. for both the factory method empty() and never().
		 */
		
		
		
		
	}
}
