package ru.mpei;

import java.util.Arrays;

public class MyLinkedDeque<T> {
    private int sizeLinkDeque = 5;
    private int size;
//    private T[] tripletDeque = (T[]) new Object[sizeLinkDeque];
    private Object[] tripletDeque;
    private MyLinkedDeque<T> nextLink;
    private MyLinkedDeque<T> lastLink;

    /**
     * Добавление элемента в конец массива.
     * - - - Метод создан для тестирования массива, на этапе разработки.
     * */
    public void addMyLinkDeq(T elem) {
        for (int i = 0; i < this.sizeLinkDeque; i++) {
            if (this.tripletDeque[i] == null) {
                this.tripletDeque[i] = elem;
                break;
            }
        }
    }
    /**
     * Проверка массива из sizeLinkDeque элементов на пустоту.
     * - Если в массиве нет элемнтов, то возвращает true.
     * - Если в массиве есть хотя бы элемент, то возвращает false
     * */
    public boolean checkNull() {
        int count = 0;
        for (int i = 0; i < this.sizeLinkDeque; i++) {
            if (tripletDeque[i] != null) {
                count++;
            }
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Проверка массива из sizeLinkDeque элементов на наличие свободного места в масисве.
     * - Если массив содержи все 5 (sizeLinkDeque) элементов, то возвращает true.
     * - Если массив содержит меньше 5 (sizeLinkDeque) элементов, то возвращает false.
     * */
    public boolean checkFullMass() {
       int count = 0;
       for (int i = 0; i < this.sizeLinkDeque; i++) {
           if (tripletDeque[i] == null) {
               count++;
           }
       }
       if (count == 0) {
           return true;
       } else {
           return false;
       }
    }
    /**
     * Добавление элемента в массив спереди. Перед добавление происзводится проверка на заполненность массива (триплета)
     * Если массив не полон, то производится проверка на нулевой массив. После этого производится добавление элемента
     * с предварительным сдвигом всех элементов вправо, если первая позиция массива уже занята.
     * */
    public void addFirst(T element) {
        if (checkFullMass() == false) {
            if (checkNull() == true) {
                tripletDeque[0] = element;
            } else {
                if (addFirstIndex() == 0) {
                    /**
                     * Цикл по сдвигу массива вправо, для добавления элементов спереди.
                     * */
                    for (int i = this.sizeLinkDeque - 1; i >= 1; i--) {
                        tripletDeque[i] = tripletDeque[i - 1];
                    }
                    tripletDeque[addFirstIndex()] = element;
                    size++;
                } else {
                    tripletDeque[addFirstIndex() - 1] = element;
                    size++;
                }
            }
        } else {
            System.out.println("Массив полон");
        }
    }
    /**
     * Добавление элемента в массив сзади. Перед добавление происзводится проверка на заполненность массива (триплета)
     * Если массив не полон, то производится проверка на нулевой массив. После этого производится добавление элемента
     * с предварительным сдвигом всех элементов влево, если последняя позиция массива уже занята.
     * */
    public void addLast(T element) {
        if (checkFullMass() == false) {
            if (checkNull() == true) {
                tripletDeque[this.sizeLinkDeque - 1] = element;
            } else {
                if (addLastIndex() == this.sizeLinkDeque - 1) {
                    /**
                     * Цикл по сдвигу маасива влево, для добавления элементов сзади.
                     * */
                    for (int i = 0; i < this.sizeLinkDeque - 1; i++) {
                        tripletDeque[i] = tripletDeque[i + 1];
                    }
                    tripletDeque[addLastIndex()] = element;
                    size++;
                } else {
                    tripletDeque[addLastIndex() + 1] = element;
                    size++;
                }
            }
        } else {
            System.out.println("Массив полон");
        }
    }
    /**
     * Поиск индекса первого ненулевого элемента массива.
     * */
    public int addFirstIndex() {
        int index = 0;
        for (int i = 0; i < this.sizeLinkDeque; i++) {
            if (tripletDeque[i] != null) {
                index = i;
                break;
            }
        }
        return index;
    }
    /**
     * Поиск индекса последнего ненулевого элемента массива.
     * */
    public int addLastIndex() {
        int index = 0;
        for (int i = this.sizeLinkDeque - 1; i >= 0; i--) {
            if (tripletDeque[i] != null) {
                index = i;
                break;
            }
        }
        return index;
    }
    /**
     * Удаляет первый элемент массива.
     * */
    public T removeFirst() {
        if (checkNull() == false) {
            T firstElem;
            if (checkFullMass() == true) {
                firstElem = (T) tripletDeque[0];
                tripletDeque[0] = null;
                size--;
            } else {
                firstElem = (T) tripletDeque[addFirstIndex()];
                tripletDeque[addFirstIndex()] = null;
                size--;
            }
            return firstElem;
        } else {
            System.out.println("Массив пуст");
            return null;
        }
    }
    /**
     * Удаляет последний элемент массива.
     * */
    public T removeLast() {
        if (checkNull() == false) {
            T lastElem;
            if (checkFullMass() == true) {
                lastElem = (T) tripletDeque[this.sizeLinkDeque - 1];
                tripletDeque[this.sizeLinkDeque - 1] = null;
                size--;
            } else {
                lastElem = (T) tripletDeque[addLastIndex()];
                tripletDeque[addLastIndex()] = null;
                size--;
            }
            return lastElem;
        } else {
            System.out.println("Массив пуст");
            return null;
        }
    }
    /**
     * Проверяет, есть ли среди элементов данного массива искомый элемент.
     * - Если есть, то возвращает true.
     * - Если нету, то возвращает false.
     * */
    public boolean findIndexBoolFirst(Object object) {
        boolean flag = false;
        for (int i = 0; i < sizeLinkDeque; i++) {
            if (tripletDeque[i] != null) {
                if (tripletDeque[i].equals(object) == true) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
    /**
     * Ищет индекс первого искомого элемента в массиве. После нахождения искомого элемента, запоминает его индекс
     * и выходит из цикла. Возвращает индекс первого искомого элемента.
     * */
    public int findIndexObjectFirst(Object object) {
        int indexFind = 0;
        for (int i = 0; i < sizeLinkDeque; i++) {
            if (tripletDeque[i] != null) {
                if (tripletDeque[i].equals(object) == true) {
                    indexFind = i;
                    break;
                }
            }
        }
        return indexFind;
    }
    /**
     * Проверяет, есть ли среди элементов данного массива искомый элемент.
     * - Если есть, то возвращает true.
     * - Если нету, то возвращает false.
     * */
    public boolean findIndexBoolLast(Object object) {
        boolean flag = false;
        for (int i = 0; i < sizeLinkDeque; i++) {
            if (tripletDeque[i] != null) {
                if (tripletDeque[i].equals(object) == true) {
                    flag = true;
                }
            }
        }
        return flag;
    }
    /**
     * Ищет индекс последнего искомого элемента в массиве. После нахождения искомого элемента, запоминает его индекс
     * и выходит из цикла. Возвращает индекс последнего искомого элемента.
     * */
    public int findIndexObjectLast(Object object) {
        int indexFind = 0;
        for (int i = 0; i < sizeLinkDeque; i++) {
            if (tripletDeque[i] != null) {
                if (tripletDeque[i].equals(object) == true) {
                    indexFind = i;
                }
            }
        }
        return indexFind;
    }

    public MyLinkedDeque() {
        this.tripletDeque = new Object[this.sizeLinkDeque];
    }

    public MyLinkedDeque(T[] tripletDeque) {
        this.tripletDeque = tripletDeque;
    }

    public MyLinkedDeque(T[] tripletDeque, MyLinkedDeque<T> firstElement, MyLinkedDeque<T> lastElement) {
        this.tripletDeque = tripletDeque;
        this.nextLink = firstElement;
        this.lastLink = lastElement;
    }

    @Override
    public String toString() {
        return "MyLinkedDeque{" +
                "sizeTripletDeque=" + sizeLinkDeque +
                ", tripletDeque=" + Arrays.toString(tripletDeque) +
                ", firstElement=" + nextLink +
                ", lastElement=" + lastLink +
                '}';
    }

    public int getSizeLinkDeque() {
        return sizeLinkDeque;
    }

    public void setSizeLinkDeque(int sizeLinkDeque) {
        this.sizeLinkDeque = sizeLinkDeque;
    }

//    public T[] getTripletDeque() {
//        return tripletDeque;
//    }

//    public void setTripletDeque(T[] tripletDeque) {
//        this.tripletDeque = tripletDeque;
//    }

    public Object[] getTripletDeque() {
        return tripletDeque;
    }

    public void setTripletDeque(Object[] tripletDeque) {
        this.tripletDeque = tripletDeque;
    }

    public MyLinkedDeque<T> getNextLink() {
        return nextLink;
    }

    public void setNextLink(MyLinkedDeque<T> nextLink) {
        this.nextLink = nextLink;
    }

    public MyLinkedDeque<T> getLastLink() {
        return lastLink;
    }

    public void setLastLink(MyLinkedDeque<T> lastLink) {
        this.lastLink = lastLink;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
