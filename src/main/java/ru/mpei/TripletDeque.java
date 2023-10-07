package ru.mpei;
import java.util.*;

public class TripletDeque<T> implements Deque<T> {
    private int maxSizeTripletDeque = 1000;
    private int sizeTripletDeque = 0;
    private MyLinkedDeque<T> firstTrip;
    private MyLinkedDeque<T> lastTrip;
    public TripletDeque() {
        MyLinkedDeque<T> myLinkedDeque = new MyLinkedDeque<>();
        firstTrip = myLinkedDeque;
        lastTrip = myLinkedDeque;
    }

    private void addTripletDequeFirst() {
        MyLinkedDeque<T> newMyLinkedDeque = new MyLinkedDeque<>();
        firstTrip.setNextLink(newMyLinkedDeque);
        newMyLinkedDeque.setLastLink(firstTrip);
        firstTrip = newMyLinkedDeque;
    }
    private void addTripletDequeLast() {
        MyLinkedDeque<T> newMyLinkedDeque = new MyLinkedDeque<>();
        lastTrip.setLastLink(newMyLinkedDeque);
        newMyLinkedDeque.setNextLink(lastTrip);
        lastTrip = newMyLinkedDeque;
    }

//    @Override
//    public String toString() {
//        return "TripletDeque{" +
//                "maxSizeTripletDeque=" + maxSizeTripletDeque +
//                ", sizeTripletDeque=" + sizeTripletDeque +
//                ", firstTrip=" + firstTrip +
//                ", lastTrip=" + lastTrip +
//                '}';
//    }
    /**
     * Метод toStringDeque выводит всю очередь*/
    public void toStringDeque() {
        MyLinkedDeque<T> link = firstTrip;
        while (link != null) {
            System.out.println(Arrays.toString(link.getTripletDeque()));
            link = link.getLastLink();
        }
    }

    @Override
    public void addFirst(T object) {
        if (object == null) {
            throw new NullPointerException("Нельзя добавить null");
        } else {
            if (sizeTripletDeque == maxSizeTripletDeque) {
                throw new IllegalArgumentException("Очередь переполнена");
            } else {
                if (firstTrip.checkFullMass() == true) {
                    addTripletDequeFirst();
                    this.firstTrip.addLast(object);
                    this.sizeTripletDeque++;
                } else {
                    this.firstTrip.addFirst(object);
                    this.sizeTripletDeque++;
                }
            }
        }
    }

    @Override
    public void addLast(T object) {
        if (object == null) {
            throw new NullPointerException("Нельзя добавить null");
        } else {
            if (sizeTripletDeque == maxSizeTripletDeque) {
                throw new IllegalArgumentException("Очередь переполнена");
            } else {
                if (lastTrip.checkFullMass() == true) {
                    addTripletDequeLast();
                    this.lastTrip.addFirst(object);
                    this.sizeTripletDeque++;
                } else {
                    this.lastTrip.addLast(object);
                    this.sizeTripletDeque++;
                }
            }
        }
    }

    @Override
    public boolean offerFirst(T object) {
        if (object == null) {
            System.out.println("Нельзя добавить null");
        } else {
            if (sizeTripletDeque == maxSizeTripletDeque) {
                System.out.println("Очередь переполнена");
            } else {
                addFirst(object);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean offerLast(T object) {
        if (object == null) {
            System.out.println("Нельзя добавить null");
        } else {
            if (sizeTripletDeque == maxSizeTripletDeque) {
                System.out.println("Очередь переполнена");
            } else {
                addLast(object);
                return true;
            }
        }
        return false;
    }

    @Override
    public T removeFirst() {
        if (sizeTripletDeque == 0) {
            throw new NoSuchElementException("Очередь пуста");
        } else {
            T firstElem = firstTrip.removeFirst();
            sizeTripletDeque--;
            if (firstTrip.checkNull() == true) {
                firstTrip = firstTrip.getLastLink();
            }
            return firstElem;
        }
    }

    @Override
    public T removeLast() {
        if (sizeTripletDeque == 0) {
            throw new NoSuchElementException("Очередь пуста");
        } else {
            T lastElem = lastTrip.removeLast();
            sizeTripletDeque--;
            if (lastTrip.checkNull() == true) {
                lastTrip = lastTrip.getNextLink();
            }
            return lastElem;
        }
    }

    @Override
    public T pollFirst() {
        if (sizeTripletDeque == 0) {
            return null;
        } else {
            return removeFirst();
        }
    }

    @Override
    public T pollLast() {
        if (sizeTripletDeque == 0) {
            return null;
        } else {
            return removeLast();
        }
    }

    @Override
    public T getFirst() {
        if (sizeTripletDeque == 0) {
            throw new NoSuchElementException("Очередь пуста");
        } else {
            T firstElem = (T) firstTrip.getTripletDeque()[firstTrip.addFirstIndex()];
            return firstElem;
        }
    }

    @Override
    public T getLast() {
        if (sizeTripletDeque == 0) {
            throw new NoSuchElementException("Очередь пуста");
        } else {
            T lastElem = (T) lastTrip.getTripletDeque()[lastTrip.addLastIndex()];
            return lastElem;
        }
    }

    @Override
    public T peekFirst() {
        if (sizeTripletDeque == 0) {
            return null;
        } else {
            T firstElem = (T) firstTrip.getTripletDeque()[firstTrip.addFirstIndex()];
            return firstElem;
        }
    }

    @Override
    public T peekLast() {
        if (sizeTripletDeque == 0) {
            return null;
        } else {
            T lastElem = (T) lastTrip.getTripletDeque()[lastTrip.addLastIndex()];
            return lastElem;
        }
    }

    @Override
    public boolean removeFirstOccurrence(Object object) {
        if (object == null) {
            throw new NullPointerException("Нельзя удалить null");
        } else {

        }
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object object) {
        if (object == null) {
            throw new NullPointerException("Нельзя удалить null");
        } else {

        }
        return false;
    }

    @Override
    public boolean add(T object) {
        if (object == null) {
            throw new NullPointerException("Нельзя добавить null");
        } else {
            if (sizeTripletDeque == maxSizeTripletDeque) {
                throw new IllegalStateException("Очередь переполнена");
            } else {
                addLast(object);
                return true;
            }
        }
    }

    @Override
    public boolean offer(T object) {
        if (object == null) {
            throw new NullPointerException("Нельзя добавить null");
        } else {
            if (sizeTripletDeque == maxSizeTripletDeque) {
                return false;
            } else {
                offerLast(object);
                return true;
            }
        }
    }

    @Override
    public T remove() {
        if (sizeTripletDeque == 0) {
            throw new NoSuchElementException("Очередь пуста");
        } else {
            return removeFirst();
        }
    }

    @Override
    public T poll() {
        if (sizeTripletDeque == 0) {
            return null;
        } else {
            return removeFirst();
        }
    }

    @Override
    public T element() {
        if (sizeTripletDeque == 0) {
            throw new NoSuchElementException("Очередь пуста");
        } else {
            return getFirst();
        }
    }

    @Override
    public T peek() {
        if (sizeTripletDeque == 0) {
            return null;
        } else {
            return peekFirst();
        }
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public void push(T object) {
        if (object == null) {
            throw new NullPointerException("Нельзя добавить null");
        } else {
            if (sizeTripletDeque == maxSizeTripletDeque) {
                throw new IllegalStateException("Очередь переполнена");
            } else {
                addFirst(object);
            }
        }
    }

    @Override
    public T pop() {
        if (sizeTripletDeque == 0) {
            throw new NoSuchElementException("Очередь пуста");
        } else {
            return removeFirst();
        }
    }

    @Override
    public boolean remove(Object object) {
        if (object == null) {
            throw new NullPointerException("Нельзя удалить null");
        } else {
            return removeFirstOccurrence(object);
        }
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean contains(Object object) {
        if (object == null) {
            throw new NullPointerException("Нельзя удалить null");
        } else {

        }
        return false;
    }

    @Override
    public int size() {
        return this.sizeTripletDeque;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        MyLinkedDeque<T> tripletDeque = firstTrip;
        while (tripletDeque.checkNull() == false) {
            for (int i = 0; i < tripletDeque.getSizeLinkDeque(); i++) {
                if (tripletDeque.getTripletDeque()[i] != null) {
//                    return tripletDeque.getTripletDeque()[i];
                }
            }
            tripletDeque = tripletDeque.getLastLink();
        }
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public Iterator<T> descendingIterator() {
        throw new UnsupportedOperationException("Реализация не поддерживается");
    }

}
