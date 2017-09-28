package Java_Enterprise.Collections;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

/**
 * Created by Vitaliy on 19.01.2017.
 */
public class CollectionsCompare {

    public static final ArrayList<Number> arrayList = new ArrayList<>();
    public static final LinkedList<Number> linkedList = new LinkedList<>();
    public static final HashMap<Number, Number> hashMap = new HashMap<>();
    public static final TreeMap<Number, Number> treeMap = new TreeMap<>();
    public static final Stack<Number> stack = new Stack<>();
    public static final Vector<Number> vector = new Vector<>();
    public static final ArrayDeque<Number> arrayDeque = new ArrayDeque<>();
    public static final PriorityQueue<Number> priorityQueue = new PriorityQueue<>();
    public static final LinkedHashMap<Number, Number> linkedHashMap = new LinkedHashMap<>();

    public static final HashSet<Number> hashSet = new HashSet<>();
    public static final TreeSet<Number> treeSet = new TreeSet<>();
    public static final LinkedHashSet<Number> linkedHashSet = new LinkedHashSet<>();


    public static void main(String[] args) throws FileNotFoundException {

        PrintStream out = new PrintStream(new FileOutputStream("CollectionsCompare_1000K.txt"));
        System.setOut(out);

        int n = 1000000;
        int startPosition = 0;
        int centerPosition = 500000;
        int endPosition = 999999;
        int modCenterPosition = n * 2;
        int modEndPosition = modCenterPosition + centerPosition;

        System.out.println("---------------------POPULATE---------------------");
        populate(n);
        System.out.println("--------------------------------------------------");
        System.out.println();

        System.out.println("------------------ADD FROM BEGIN------------------");
        addItems(n, startPosition);
        System.out.println("--------------------------------------------------");
        System.out.println();

        System.out.println("------------------ADD FROM CENTER-----------------");
        addItems(n, centerPosition);
        System.out.println("--------------------------------------------------");
        System.out.println();

        System.out.println("-------------------ADD FROM END-------------------");
        addItems(n, endPosition);
        System.out.println("--------------------------------------------------");
        System.out.println();

        System.out.println("------------------GET FROM BEGIN------------------");
        getItems(n, startPosition);
        System.out.println("--------------------------------------------------");
        System.out.println();

        System.out.println("-----------------GET FROM CENTER------------------");
        getItems(n, centerPosition);
        System.out.println("--------------------------------------------------");
        System.out.println();

        System.out.println("-------------------GET FROM END-------------------");
        getItems(n, endPosition);
        System.out.println("--------------------------------------------------");
        System.out.println();

        System.out.println("----------------CONTAIN FROM BEGIN----------------");
        containItems(n, startPosition);
        System.out.println("--------------------------------------------------");
        System.out.println();

        System.out.println("---------------CONTAIN FROM CENTER----------------");
        containItems(n, centerPosition);
        System.out.println("--------------------------------------------------");
        System.out.println();

        System.out.println("-----------------CONTAIN FROM END-----------------");
        containItems(n, endPosition);
        System.out.println("--------------------------------------------------");
        System.out.println();

        System.out.println("----------------REMOVE FROM BEGIN-----------------");
        removeItems(n, startPosition, 0);
        System.out.println("--------------------------------------------------");
        System.out.println();

        System.out.println("---------------REMOVE FROM CENTER-----------------");
        removeItems(n, centerPosition, modCenterPosition);
        System.out.println("--------------------------------------------------");
        System.out.println();

        System.out.println("-----------------REMOVE FROM END------------------");
        removeItems(n, endPosition, modEndPosition);
        System.out.println("--------------------------------------------------");
        System.out.println();

        System.out.println("------------------SET FROM BEGIN------------------");
        setItems(n, startPosition);
        System.out.println("--------------------------------------------------");
        System.out.println();

        System.out.println("-----------------SET FROM CENTER------------------");
        setItems(n, centerPosition);
        System.out.println("--------------------------------------------------");
        System.out.println();

        System.out.println("-------------------SET FROM END-------------------");
        setItems(n, endPosition);
        System.out.println("--------------------------------------------------");
        System.out.println();

        System.out.println("------------ADD BY ITERATOR FROM BEGIN------------");
        addIteratorItems(n, startPosition);
        System.out.println("--------------------------------------------------");
        System.out.println();

        System.out.println("-----------ADD BY ITERATOR FROM CENTER------------");
        addIteratorItems(n, centerPosition);
        System.out.println("--------------------------------------------------");
        System.out.println();

        System.out.println("-------------ADD BY ITERATOR FROM END-------------");
        addIteratorItems(n, endPosition);
        System.out.println("--------------------------------------------------");
        System.out.println();

        System.out.println("----------------REMOVE BY ITERATOR----------------");
        removeIteratorItems(n);
        System.out.println("--------------------------------------------------");
        System.out.println();
    }

    public static void populate(int n) {

        Date startTime = new Date();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        Date endTime = new Date();
        System.out.println("Time of adding " + n + " items in ArrayList are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = 0; i < n; i++) {
            linkedList.add(i);
        }
        endTime = new Date();
        System.out.println("Time of adding " + n + " items in LinkedList are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = 0; i < n; i++) {
            hashSet.add(i);
        }
        endTime = new Date();
        System.out.println("Time of adding " + n + " items in HashSet are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = 0; i < n; i++) {
            treeSet.add(i);
        }
        endTime = new Date();
        System.out.println("Time of adding " + n + " items in TreeSet are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = 0; i < n; i++) {
            stack.add(i);
        }
        endTime = new Date();
        System.out.println("Time of adding " + n + " items in Stack are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = 0; i < n; i++) {
            vector.add(i);
        }
        endTime = new Date();
        System.out.println("Time of adding " + n + " items in Vector are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = 0; i < n; i++) {
            arrayDeque.add(i);
        }
        endTime = new Date();
        System.out.println("Time of adding " + n + " items in ArrayDeque are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = 0; i < n; i++) {
            priorityQueue.add(i);
        }
        endTime = new Date();
        System.out.println("Time of adding " + n + " items in PriorityQueue are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = 0; i < n; i++) {
            linkedHashSet.add(i);
        }
        endTime = new Date();
        System.out.println("Time of adding " + n + " items in LinkedHashSet are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = 0; i < n; i++) {
            hashMap.put(i, i);
        }
        endTime = new Date();
        System.out.println("Time of \"putting\" " + n + " items in HashMap are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = 0; i < n; i++) {
            treeMap.put(i, i);
        }
        endTime = new Date();
        System.out.println("Time of \"putting\" " + n + " items in TreeMap are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = 0; i < n; i++) {
            linkedHashMap.put(i, i);
        }
        endTime = new Date();
        System.out.println("Time of \"putting\" " + n + " items in LinkedHashMap are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");
    }

    public static void addItems(int n, int startPosition) {

        Date startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            arrayList.add(i);
        }
        Date endTime = new Date();
        System.out.println("Time of adding " + n + " items from " + startPosition + " in ArrayList are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            linkedList.add(i);
        }
        endTime = new Date();
        System.out.println("Time of adding " + n + " items from " + startPosition + " in LinkedList are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            hashSet.add(i + hashSet.size());
        }
        endTime = new Date();
        System.out.println("Time of adding " + n + " items from " + startPosition + " in HashSet are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            treeSet.add(i + treeSet.size());
        }
        endTime = new Date();
        System.out.println("Time of adding " + n + " items from " + startPosition + " in TreeSet are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            stack.add(i);
        }
        endTime = new Date();
        System.out.println("Time of adding " + n + " items from " + startPosition + " in Stack are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            vector.add(i);
        }
        endTime = new Date();
        System.out.println("Time of adding " + n + " items from " + startPosition + " in Vector are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            arrayDeque.add(i);
        }
        endTime = new Date();
        System.out.println("Time of adding " + n + " items from " + startPosition + " in ArrayDeque are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            priorityQueue.add(i);
        }
        endTime = new Date();
        System.out.println("Time of adding " + n + " items from " + startPosition + " in PriorityQueue are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            linkedHashSet.add(i + linkedHashSet.size());
        }
        endTime = new Date();
        System.out.println("Time of adding " + n + " items from " + startPosition + " in LinkedHashSet are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            hashMap.put(i + hashMap.size(), i + hashMap.size());
        }
        endTime = new Date();
        System.out.println("Time of \"putting\" " + n + " items from " + startPosition + " in HashMap are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            treeMap.put(i + hashMap.size(), i + hashMap.size());
        }
        endTime = new Date();
        System.out.println("Time of \"putting\" " + n + " items from " + startPosition + " in TreeMap are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            linkedHashMap.put(i + linkedHashMap.size(), i + linkedHashMap.size());
        }
        endTime = new Date();
        System.out.println("Time of \"putting\" " + n + " items from " + startPosition + " in LinkedHashMap are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");
    }

    public static void getItems(int n, int startPosition) {

        Date startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            arrayList.get(i);
        }
        Date endTime = new Date();
        System.out.println("Time of getting " + n + " items from " + startPosition + " in ArrayList are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            linkedList.get(i);
        }
        endTime = new Date();
        System.out.println("Time of getting " + n + " items from " + startPosition + " in LinkedList are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            stack.get(i);
        }
        endTime = new Date();
        System.out.println("Time of getting " + n + " items from " + startPosition + " in Stack are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            vector.get(i);
        }
        endTime = new Date();
        System.out.println("Time of getting " + n + " items from " + startPosition + " in Vector are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            arrayDeque.getFirst();
        }
        int sum = n - startPosition;
        endTime = new Date();
        System.out.println("Time of getting " + sum + " first items in ArrayDeque are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            priorityQueue.peek();
        }
        sum = n - startPosition;
        endTime = new Date();
        System.out.println("Time of peeking " + sum + " items in PriorityQueue are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            hashMap.get(i);
        }
        endTime = new Date();
        System.out.println("Time of getting " + n + " items from " + startPosition + " in HashMap are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            treeMap.get(i);
        }
        endTime = new Date();
        System.out.println("Time of getting " + n + " items from " + startPosition + " in TreeMap are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            linkedHashMap.get(i);
        }
        endTime = new Date();
        System.out.println("Time of getting " + n + " items from " + startPosition + " in LinkedHashMap are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");
    }

    public static void removeItems(int n, int startPosition, int mod) {

        Date startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            arrayList.remove(i);
        }
        Date endTime = new Date();
        System.out.println("Time of removing " + n + " items from " + startPosition + " in ArrayList are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            linkedList.remove(i);
        }
        endTime = new Date();
        System.out.println("Time of removing " + n + " items from " + startPosition + " in LinkedList are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            stack.remove(i);
        }
        endTime = new Date();
        System.out.println("Time of removing " + n + " items from " + startPosition + " in Stack are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            vector.remove(i);
        }
        endTime = new Date();
        System.out.println("Time of removing " + n + " items from " + startPosition + " in Vector are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            arrayDeque.removeLast();
        }
        int sum = n - startPosition;
        endTime = new Date();
        System.out.println("Time of removing " + sum + " last items in ArrayDeque are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            priorityQueue.poll();
        }
        sum = n - startPosition;
        endTime = new Date();
        System.out.println("Time of polling " + sum + " items in PriorityQueue are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            hashMap.remove(i + mod);
        }
        endTime = new Date();
        System.out.println("Time of removing " + n + " items from " + startPosition + " in HashMap are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            treeMap.remove(i + mod);
        }
        endTime = new Date();
        System.out.println("Time of removing " + n + " items from " + startPosition + " in TreeMap are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            linkedHashMap.remove(i + mod);
        }
        endTime = new Date();
        System.out.println("Time of removing " + n + " items from " + startPosition + " in LinkedHashMap are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            hashSet.remove(i + mod);
        }
        endTime = new Date();
        System.out.println("Time of removing " + n + " items from " + startPosition + " in HashSet are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            treeSet.remove(i + mod);
        }
        endTime = new Date();
        System.out.println("Time of removing " + n + " items from " + startPosition + " in TreeSet are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            linkedHashSet.remove(i + mod);
        }
        endTime = new Date();
        System.out.println("Time of removing " + n + " items from " + startPosition + " in LinkedHashSet are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");
    }

    public static void containItems(int n, int searchItem) {

        Date startTime = new Date();
        for (int i = 0; i < n; i++) {
            arrayList.contains(searchItem);
        }
        Date endTime = new Date();
        System.out.println("Time of searching " + searchItem + " in ArrayList are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = 0; i < n; i++) {
            linkedList.contains(searchItem);
        }
        endTime = new Date();
        System.out.println("Time of searching " + searchItem + " in LinkedList are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = 0; i < n; i++) {
            stack.contains(searchItem);
        }
        endTime = new Date();
        System.out.println("Time of searching " + searchItem + " in Stack are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = 0; i < n; i++) {
            vector.contains(searchItem);
        }
        endTime = new Date();
        System.out.println("Time of searching " + searchItem + " in Vector are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = 0; i < n; i++) {
            arrayDeque.contains(searchItem);
        }
        endTime = new Date();
        System.out.println("Time of searching " + searchItem + " in ArrayDeque are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = 0; i < n; i++) {
            priorityQueue.contains(searchItem);
        }
        endTime = new Date();
        System.out.println("Time of searching " + searchItem + " in PriorityQueue are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = 0; i < n; i++) {
            hashMap.containsValue(searchItem);
        }
        endTime = new Date();
        System.out.println("Time of searching " + searchItem + " in HashMap are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = 0; i < n; i++) {
            treeMap.containsValue(searchItem);
        }
        endTime = new Date();
        System.out.println("Time of searching " + searchItem + " in TreeMap are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = 0; i < n; i++) {
            linkedHashMap.containsValue(searchItem);
        }
        endTime = new Date();
        System.out.println("Time of searching " + searchItem + " in LinkedHashMap are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = 0; i < n; i++) {
            hashSet.contains(searchItem);
        }
        endTime = new Date();
        System.out.println("Time of searching " + searchItem + " in HashSet are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = 0; i < n; i++) {
            treeSet.contains(searchItem);
        }
        endTime = new Date();
        System.out.println("Time of removing " + searchItem + " in TreeSet are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = 0; i < n; i++) {
            linkedHashSet.contains(searchItem);
        }
        endTime = new Date();
        System.out.println("Time of removing " + searchItem + " in LinkedHashSet are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");
    }

    public static void setItems(int n, int startPosition) {

        Date startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            arrayList.set(i, i);
        }
        Date endTime = new Date();
        System.out.println("Time of setting " + n + " items from " + startPosition + " in ArrayList are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            linkedList.set(i, i);
        }
        endTime = new Date();
        System.out.println("Time of setting " + n + " items from " + startPosition + " in LinkedList are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            stack.set(i, i);
        }
        endTime = new Date();
        System.out.println("Time of setting " + n + " items from " + startPosition + " in Stack are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            vector.set(i, i);
        }
        endTime = new Date();
        System.out.println("Time of setting " + n + " items from " + startPosition + " in Vector are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");
    }

    public static void addIteratorItems(int n, int startPosition) {

        ListIterator<Number> arrayListIterator = arrayList.listIterator();
        ListIterator<Number> linkedListIterator = linkedList.listIterator();
        ListIterator<Number> stackIterator = stack.listIterator();
        ListIterator<Number> vectorIterator = vector.listIterator();


        Date startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            arrayListIterator.add(i);
        }
        Date endTime = new Date();
        System.out.println("Time of iterator adding " + n + " items from " + startPosition + " in ArrayList are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            linkedListIterator.add(i);
        }
        endTime = new Date();
        System.out.println("Time of iterator adding " + n + " items from " + startPosition + " in LinkedList are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            stackIterator.add(i);
        }
        endTime = new Date();
        System.out.println("Time of iterator adding " + n + " items from " + startPosition + " in Stack are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = startPosition; i < n; i++) {
            vectorIterator.add(i);
        }
        endTime = new Date();
        System.out.println("Time of iterator adding " + n + " items from " + startPosition + " in Vector are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");
    }

    public static void removeIteratorItems(int n) {

        ListIterator<Number> arrayListIterator = arrayList.listIterator();
        ListIterator<Number> linkedListIterator = linkedList.listIterator();
        ListIterator<Number> stackIterator = stack.listIterator();
        ListIterator<Number> vectorIterator = vector.listIterator();

        Date startTime = new Date();
        for (int i = 0; i < n; i++) {
            while (arrayListIterator.hasNext()) {
                if (arrayListIterator.next().equals(i)) {
                    arrayListIterator.remove();
                }
            }
        }
        Date endTime = new Date();
        System.out.println("Time of iterator removing " + n + " items in ArrayList are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = 0; i < n; i++) {
            while (linkedListIterator.hasNext()) {
                if (linkedListIterator.next().equals(i)) {
                    linkedListIterator.remove();
                }
            }
        }
        endTime = new Date();
        System.out.println("Time of iterator removing " + n + " items in LinkedList are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = 0; i < n; i++) {
            while (stackIterator.hasNext()) {
                if (stackIterator.next().equals(i)) {
                    stackIterator.remove();
                }
            }
        }
        endTime = new Date();
        System.out.println("Time of iterator removing " + n + " items in Stack are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");

        startTime = new Date();
        for (int i = 0; i < n; i++) {
            while (vectorIterator.hasNext()) {
                if (vectorIterator.next().equals(i)) {
                    vectorIterator.remove();
                }
            }
        }
        endTime = new Date();
        System.out.println("Time of iterator removing " + n + " items in Vector are: " + String.valueOf(endTime.getTime() - startTime.getTime()) + " ms.");
    }

}