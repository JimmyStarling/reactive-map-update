# Reactive Map Update
Update GoogleMap inside a Fragment Using ReactiveX Frameworks.

## Usage
Clone this repo, and place on your workspace and open in android studio [with kotlin plugin](https://plugins.jetbrains.com/plugin/6954-kotlin)


### How it work
Using the Reactive libraries, we can create a object who can
encapsule two functions ( One for publish events, and another one is for Listen them )
``` 
object ExBus {
	private value publisher who will receive the 
	PublishSubject who will **create<Any>()** (Simple yeah :+1:?)
	
	fun publish, have any typed value in their constructor called **event**
	who will be used inside to pass the publish param to 
	onNext of publiser val

	fun listen, have Class<T> typed value eventType returning 
	a generic observable<T> who will receive publisher.ofType(eventType)
}
``` 
Didn't understood? consult the author of this code: [Dai medium post](https://android.jlelse.eu/super-simple-event-bus-with-rxjava-and-kotlin-f1f969b21003)

## What would be great to implement
- [ ] Add more examples with RxBus.
- [ ] Perfomace Feedback
- [ ] Make a Cross-Plataform version

### Special Thanks
- Jimmy Starling ( Creator/Author of this repository :+1:) [Jimmy Site](https://jimmystarling.github.com/)
- Dai ( Senior Software Enginner at BBC who has created the simplest object used on this tutorial) Thanks man :+1: 
[His medium post](https://android.jlelse.eu/super-simple-event-bus-with-rxjava-and-kotlin-f1f969b21003)

