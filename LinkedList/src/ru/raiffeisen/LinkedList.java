package ru.raiffeisen;

import java.util.NoSuchElementException;

public class LinkedList<ItemType> {
    private int size;
    private Item<ItemType> root;

    public LinkedList() {
        this.size = 0;
        this.root = null;
    }

    /**
     * It returns the number of elements in this list
     */
    public int getSize() {
        return size;
    }


    /**
     * It is used to print all the list elements
     */
    public void print() {
        Item<ItemType> pointer = root;
        System.out.print("[");
        while (pointer != null) {
            System.out.print(" " + pointer.getItem().toString());
            pointer = pointer.getNext();
        }
        System.out.println(" ]");
    }

    /**
     * It adds an element to the end of the list
     */
    public void addLast(Item<ItemType> newItem) {
        Item<ItemType> pointer = null;
        // list is empty
        if (root == null) {
            root = newItem;
        } else {  // one element on the list
            if (size == 1) {
                pointer = root;
                pointer.setNext(newItem);
            } else {
                pointer = root;
                for (int i = 1; i <= size - 1; i++) {
                    pointer = pointer.getNext();
                }
                newItem.setNext(pointer.getNext());
                pointer.setNext(newItem);
            }
        }
        size++;
    }

    /**
     * It inserts the element at the beginning of the list
     */
    public void addFirst(Item<ItemType> newItem) {
        Item<ItemType> pointer = null;
        // list is empty
        if (root == null) {
            root = newItem;
        } else {  // one or more element(s) on the list
            pointer = root;
            newItem.setNext(pointer);
            root = newItem;
        }
        size++;
    }

    /**
     * It is used to replace an existing element in the list with a new element
     * Throws IndexOutOfBoundsException if the index is out of range
     *
     * @param position
     * @param newItem
     */
    public void add(int position, Item newItem) throws IndexOutOfBoundsException {
        Item<ItemType> pointer = null;
        try {
            // no elements on the list
            if (root == null) {
                root = newItem;
            } else {
                if (position == 0) {
                    pointer = root;
                    newItem.setNext(pointer);
                    root = newItem;
                } else {
                    if ((position < 0) || (position >= size)) {
                        throw new IndexOutOfBoundsException("[add] Index is out of range!!!");
                    } else {
                        pointer = root;
                        for (int i = 0; i < position - 1; i++) {
                            pointer = pointer.getNext();
                        }
                        newItem.setNext(pointer.getNext());
                        pointer.setNext(newItem);
                    }
                }
                size++;
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }


    /**
     * It returns the first element on the list
     * Throws NoSuchElementException if this list is empty
     */
    public Item<ItemType> getFirst() {
        try {
            if (root == null) {
                throw new NoSuchElementException("[getFirst] List is empty!!!");
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return root;
    }

    /**
     * It returns the last element on the list
     * Throws NoSuchElementException if this list is empty
     */
    public Item<ItemType> getLast() {
        Item<ItemType> pointer = root;
        try {
            if (root == null) {
                throw new NoSuchElementException("[getLast] List is empty!!!");
            } else {
                for (int i = 1; i < size; i++) {
                    pointer = pointer.getNext();
                }
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return pointer;
    }

    /**
     * This method returns the element at the specified position in this list
     * Throws IndexOutOfBoundsException if the index is out of range
     */
    public Item<ItemType> getAt(int position) {
        Item<ItemType> pointer = root;
        try {
            if ((position < 0) || (position >= size)) {
                throw new IndexOutOfBoundsException("[getAt] Index is out of range!!!");
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        if (position == 0) {
            return root;
        } else {
            for (int i = 0; i < position; i++) {
                pointer = pointer.getNext();
            }
        }
        return pointer;
    }

    /**
     * This method removes and returns the first element from this list
     * Returns NoSuchElementException  if this list is empty
     */
    public Item<ItemType> removeFirst() {
        Item<ItemType> pointer = root;
        try {
            if (root == null)
                throw new NoSuchElementException("[removeFirst] No such element exception!!!");

        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        root = pointer.getNext();
        pointer.setNext(null);
        size--;
        return pointer;
    }

    /**
     * Method removes the first occurrence of the specified element in this list
     * Returns true if the list contained the specified element, otherwise false
     */
    public boolean removeFirstOccurence(ItemType item) {
        Item<ItemType> pointer = root;
        Item<ItemType> pointerPrev = root;
        while (pointer != null) {
            if (pointer.getItem().equals(item)) {
                // first element of the list matches the item
                if (pointer == root) {
                    pointer = pointer.getNext();
                    pointerPrev = pointer;
                    root = pointer;
                } else {
                    pointer = pointer.getNext();
                    pointerPrev.setNext(pointer);
                }
                size--;
                return true;
            }
            pointerPrev = pointer;
            pointer = pointer.getNext();
        }
        return false;
    }

    /**
     * Method replaces the element at the specified position in this list with the specified element
     * Returns the element previously at the specified position
     * Returns IndexOutOfBoundsException if the index is out of range
     */
    public ItemType set(int position, ItemType item) {
        Item<ItemType> pointer = root;
        ItemType prevValue = pointer.getItem();
        try {
            if ((position < 0) || (position >= size)) {
                throw new IndexOutOfBoundsException("[set] Index is out of range!!!");
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < position; i++) {
            pointer = pointer.getNext();
        }
        prevValue = pointer.getItem();
        pointer.setItem(item);
        return prevValue;
    }

}
