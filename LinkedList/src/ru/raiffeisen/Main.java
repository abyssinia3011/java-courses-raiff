package ru.raiffeisen;

public class Main {

    public static void main(String[] args) {
        System.out.println("working with list of Strings");
        LinkedList<String> listOfStrings = new LinkedList<>();

        // addLast
        listOfStrings.addLast(new Item<String>("February"));
        listOfStrings.addLast(new Item<String>("March"));
        listOfStrings.addLast(new Item<String>("April"));
        listOfStrings.addLast(new Item<String>("April"));
        listOfStrings.addLast(new Item<String>("May"));
        listOfStrings.addLast(new Item<String>("June"));
        listOfStrings.addLast(new Item<String>("July"));
        listOfStrings.addLast(new Item<String>("August"));
        System.out.print("initial list ==> ");
        listOfStrings.print();

        // addFirst
        System.out.print("first element added ==> ");
        listOfStrings.addFirst(new Item<String>("January"));
        listOfStrings.print();

        // add
        System.out.print("new element inserted ==> ");
        listOfStrings.add(3, new Item<String>("*just inserted*"));
        listOfStrings.print();

        // getFirst()
        System.out.print("first element ==> ");
        System.out.println(listOfStrings.getFirst().getItem());

        // getLast()
        System.out.print("last element ==> ");
        System.out.println(listOfStrings.getLast().getItem());

        // getAt
        System.out.print("found element by index ==> ");
        System.out.println(listOfStrings.getAt(6).getItem());

        // set
        String prevString = listOfStrings.set(7, "*just replaced*");
        listOfStrings.print();
        System.out.println("previous value = " + prevString);

        // removeFirst()
        System.out.print("first element removed ==> ");
        listOfStrings.removeFirst();
        listOfStrings.print();

        //removeFirstOccurence
        System.out.print("first occurence of \"April\" removed ==> ");
        System.out.println(listOfStrings.removeFirstOccurence("April"));
        System.out.print("list after removing ==> ");
        listOfStrings.print();

        System.out.println("===========================");
        System.out.println("working with list of Ints");

        LinkedList<Integer> listOfInts = new LinkedList<>();
        listOfInts.addLast(new Item<Integer>(10));
        listOfInts.print();
        listOfInts.addLast(new Item<Integer>(20));
        listOfInts.print();
        listOfInts.addLast(new Item<Integer>(30));
        listOfInts.print();
        listOfInts.addLast(new Item<Integer>(40));
        listOfInts.print();
        listOfInts.addLast(new Item<Integer>(50));
        listOfInts.print();
        listOfInts.addLast(new Item<Integer>(60));
        listOfInts.print();
        listOfInts.addLast(new Item<Integer>(70));
        listOfInts.print();


        System.out.print("first element ===> ");
        System.out.println(listOfInts.getFirst().getItem());

        System.out.print("last element ===> ");
        System.out.println(listOfInts.getLast().getItem());

        System.out.print("50 replaced with 55  ===> ");

        Integer prevInt = listOfInts.set(4, 55);
        listOfInts.print();

        System.out.println("first element added");
        listOfInts.addFirst(new Item<Integer>(5));
        listOfInts.print();

        System.out.println("new element 99 just inserted");
        listOfInts.add(6, new Item<Integer>(99));
        listOfInts.print();
    }
}
