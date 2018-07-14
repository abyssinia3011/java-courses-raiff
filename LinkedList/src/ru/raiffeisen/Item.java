package ru.raiffeisen;

public class Item<ItemType> implements Comparable<Item> {
    private ItemType item;
    private Item<ItemType> next;



    public Item(ItemType item) {
        super();
        this.item = item;
        this.next = null;
    }

    public ItemType getItem() {
        return item;
    }

    public Item<ItemType> getNext() {
        return next;
    }

    public void setItem(ItemType item) {
        this.item = item;
    }

    public void setNext(Item<ItemType> next) {
        this.next = next;
    }

    @Override
    public int compareTo(Item obj) {
        if (this == obj)
            return 1;
        else
            return 0;
    }
}



