package ru.arhiser.linkedlist;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        SingleLinkList<shop> shopList = new SingleLinkList<>();

        shopList.addToEnd(new shop(1, "Помидор", "500"));
        shopList.addToEnd(new shop(2, "Огурец", "450"));
        shopList.addToEnd(new shop(3, "Редис", "200"));
        

        for(shop shop: shopList) {
            System.out.println(shop);
        }

        shopList.reverse();

        for(shop shop: shopList) {
            System.out.println(shop);
        }
    }

    static class shop {
        int id;
        String name;
        String Price;

        public shop(int id, String name, String Price) {
            this.id = id;
            this.name = name;
            this.Price = Price;
        }

        @Override
        public String toString() {
            return "shop{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", Price='" + Price + '\'' +
                    '}';
        }
    }

    public static class SingleLinkList<T> implements Iterable<T> {

        ListItem<T> head;
        ListItem<T> tail;

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                ListItem<T> current = head;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public T next() {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
            };
        }

        private static class ListItem<T> {
            T data;
            ListItem<T> next;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public void addToEnd(T item) {
            ListItem<T> newItem = new ListItem<>();
            newItem.data = item;
            if (isEmpty()) {
                head = newItem;
                tail = newItem;
            } else {
                tail.next = newItem;
                tail = newItem;
            }
        }

        public void reverse() {
            if (!isEmpty() && head.next != null) {
                tail = head;
                ListItem<T> current = head.next;
                head.next = null;
                while (current != null) {
                    ListItem<T> next = current.next;
                    current.next = head;
                    head = current;
                    current = next;
                }
            }
        }
    }
}
