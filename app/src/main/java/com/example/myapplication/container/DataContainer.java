package com.example.myapplication.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DataContainer<T> {

    private final List<T> items;

    public DataContainer() {
        this.items = new ArrayList<>();
    }

    public void addData(T item) {
        Objects.requireNonNull(item, "Item cannot be null");
        this.items.add(item);
    }

    public void addAllData(List<T> itemsToAdd) {
        Objects.requireNonNull(itemsToAdd, "List of items to add cannot be null");
        this.items.addAll(itemsToAdd);
    }

    public List<T> getAllItems() {
        return Collections.unmodifiableList(this.items);
    }

    public DataContainer<T> filter(Predicate<T> predicate) {
        Objects.requireNonNull(predicate, "Predicate cannot be null");
        DataContainer<T> filteredContainer = new DataContainer<>();
        List<T> filteredItems = this.items.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        filteredContainer.addAllData(filteredItems);
        return filteredContainer;
    }

    public InventoryIterator getCustomIterator() {
        return new InventoryIterator(new ArrayList<>(this.items));
    }

    public void clear() {
        this.items.clear();
    }
    public int size() {
        return this.items.size();
    }

    public class InventoryIterator implements Iterator<T> {
        private final List<T> iteratedList;
        private int currentIndex = 0;

        private InventoryIterator(List<T> listSnapshot) {
            this.iteratedList = listSnapshot;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < iteratedList.size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in iteration");
            }
            return iteratedList.get(currentIndex++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove operation is not supported by InventoryIterator.");
        }
    }
}