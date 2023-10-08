package ru.mpei;
import java.util.*;

public class TripletDeque<T> implements Deque<T>, Containerable {
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
            throw new NullPointerException("Нельзя добавить null");
        } else {
            if (sizeTripletDeque == maxSizeTripletDeque) {
                throw new IllegalArgumentException("Очередь переполнена");
            } else {
                addFirst(object);
                return true;
            }
        }
    }

    @Override
    public boolean offerLast(T object) {
        if (object == null) {
            throw new NullPointerException("Нельзя добавить null");
        } else {
            if (sizeTripletDeque == maxSizeTripletDeque) {
                throw new IllegalArgumentException("Очередь переполнена");
            } else {
                addLast(object);
                return true;
            }
        }
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
                firstTrip.setNextLink(null);
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
                lastTrip.setLastLink(null);
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
            MyLinkedDeque<T> myLinkedDeque = firstTrip;
            boolean flag = false;
            while (myLinkedDeque != null) {
                if (myLinkedDeque.findIndexBool(object) == false) {
                    myLinkedDeque = myLinkedDeque.getLastLink();
                } else {
                    int removeIndex = myLinkedDeque.findIndexObject(object);
                    myLinkedDeque.getTripletDeque()[removeIndex] = null;
                    flag = true;
                    break;
                }
            }
            return flag;
        }
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
    public boolean addAll(Collection<? extends T> c) {
        for (T elementCollection : c) {
            offerLast(elementCollection);
        }
        return true;
    }

    @Override
    public void clear() {
        MyLinkedDeque<T> myLinkedDeque = new MyLinkedDeque<>();
        firstTrip = myLinkedDeque;
        lastTrip = myLinkedDeque;
        sizeTripletDeque = 0;
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
            boolean flag = false;
            Iterator<T> iterator = iterator();
            while (iterator.hasNext()) {
                if (iterator.next().equals(object)) {
                    flag = true;
                    break;
                }
            }
            return flag;
        }
    }

    @Override
    public int size() {
        return this.sizeTripletDeque;
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>(){
            private MyLinkedDeque<T> myLinkedDeque = firstTrip;
            private int resettableCounter = firstTrip.addFirstIndex();
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return (currentIndex < size());
            }

            @Override
            public T next() {
                int count;
                if (resettableCounter == myLinkedDeque.getSizeLinkDeque()) {
                    myLinkedDeque = myLinkedDeque.getLastLink();
                    resettableCounter = 0;
                }
                count = resettableCounter;
                resettableCounter++;
                currentIndex++;
                return (T) myLinkedDeque.getTripletDeque()[count++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return iterator;
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

    @Override
    public Object[] getContainerByIndex(int cIndex) {

        return new Object[0];
    }
}
