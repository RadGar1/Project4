package edu.luc.cs335.arrayqueue;

import java.util.ArrayList;
import java.util.List;

public class FixedArrayQueue<E> implements SimpleQueue<E> {

  private final int capacity;

  private int size;

  private int front;

  private int rear;

  private final E[] data;

  // We need an explicit constructor to initialize the queue with a specific capacity
  // and to set up the initial state of the queue (size, front, rear, and data array)

  @SuppressWarnings("unchecked")
  public FixedArrayQueue(final int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException("Capacity must be positive");
    }

    this.capacity = capacity;
    this.data = (E[]) new Object[capacity];
    this.size = 0;
    this.front = 0;
    this.rear = capacity - 1;
  }

  @Override
  public boolean offer(final E obj) {
    if (isFull()) {
      return false;
    }
    rear = (rear + 1) % capacity;
    data[rear] = obj;
    size++;
    return true;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      return null;
    }
    return data[front];
  }

  @Override
  public E poll() {
    if (isEmpty()) {
      return null;
    }
    E item = data[front];
    data[front] = null; // clear the reference
    front = (front + 1) % capacity;
    size--;
    return item;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean isFull() {
    return size == capacity;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public int capacity() {
    return capacity;
  }

  @Override
  public List<E> asList() {
    final ArrayList<E> result = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      result.add(data[(front + i) % capacity]);
    }
    return result;
  }
}
