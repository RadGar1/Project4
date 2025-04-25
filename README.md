## Stateful unit testing using Jqwik actions: fixed-size circular queue

In this project, we'll implement and thoroughly test our own array-based data structure, a fixed-size circular queue!

## Objectives

An understanding of the following concepts and techniques:

- ADT implementation perspective
- queue ADT (see also [java.util.Queue](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Queue.html))
- implementing queue as a circular array
- queues with fixed versus growing capacity
- algorithms based on the queue's FIFO policy
- interface-based testing
- stateful property-based testing
- initial exposure to concurrency

## Instructions

In this project, you will have the opportunity to implement a generic queue as a circular array and use this implementation in the context of a typical queue-based application.

Specifically:

1. Complete the TODO items in the `FixedArrayQueue` implementation until the tests in `TestSimpleQueue` pass.
1. Complete the main class `SingleQueueService`, which reads successive input lines until EOF and
puts them on a queue that the background consumer activity processes.
1. When running the main class, note that the consumer is set to serve customers at a fixed rate.
By entering customers' names at different rates, try to create scenarios where customers arrive infrequently enough for the queue to remain empty, or in such quick succession that the queue becomes full (by pasting several of them at once).
1. Complete the TODO items in the `TestSimpleQueueJqwik` test suite until it reflects the stated pre- and postconditions of the `SimpleQueue` methods.
1. Answer the following questions in a separate file `Answers.md`:
   - Why does `FixedArrayQueue` require an explicit constructor?
   - What happens when you offer an item to a full `FixedArrayQueue`?
   - What happens when you poll an empty `FixedArrayQueue`?
   - What is the time and (extra) space complexity of each of the `FixedArrayQueue` methods?
   - How exhaustively does the `TestSimpleQueue` test suite test the implementation, both conceptually and in terms of actual coverage?
   - How exhaustively does the `TestSimpleQueueJqwik` test suite test the implementation, both conceptually and in terms of actual coverage?
   - What kind of test cases does the `simpleQueueActions` method generate?

## Running the code

To run the tests:

    mvn verify

To run the main program:

    mvn exec:java

## Grading (total 6 points)

- 2 completion of items marked TODO in `FixedArrayQueue` and existing JUnit tests passing
- 1 completion of `SingleQueueService` and correct behavior
- 2 completion of items marked TODO in `TestSimpleQueueJqwik` and working
- 1 written part
  - 0.8 responses to the questions above
  - 0.2 grammar, style, formatting

## Extra credit

Clearly indicate in your `Answers.md` file any extra credit attempted.

- 0.2 add a working CI status badge for your project
- 0.3 apply `checkSimpleQueue` property to different queue capacities
- 0.3 add observable data invariant(s) for 0 <= size <= capacity to the `checkSimpleQueue` property
- 0.5 add a `clear` method, which removes all elements in the queue, to interface, impmlementation, and tests

## References

- [java.util.Queue interface](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Queue.html)
- [Introduction and Array Implementation of Circular Queue](https://www.programiz.com/dsa/circular-queue)
- [Zombies testing](https://hackernoon.com/zombie-testing-one-behavior-at-a-time-9s2m3zjo)
- [Zombies testing with circular queue/buffer example](http://blog.wingman-sw.com/tdd-guided-by-zombies)
