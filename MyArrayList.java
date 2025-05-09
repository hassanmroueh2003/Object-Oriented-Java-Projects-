/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tester;

/** The MyArrayList creates an empty array of type Object and appends objects
 * of different classes to it .
 * It has various methods that edits elements in the list such as: 
 * add (adds an element to the list), clear (removes all the elements from the list),
 * remove(removes an element from the list).
 * Other methods to test and get information of the elements in the list
 * such as : contains (searches for a specific object ), 
 * get (returns the object of a specific index) , indexOf (gets index of an object) , 
 * isEmpty (tests if the list is empty) , lastIndexOf (returns the last index of an object),
 * size(returns the number of elements in the list).
 * @author Hassan Mroueh
 * Date: 4/20/2022
 */
public class MyArrayList {

    Object[] array;
    private int size = 0;

    /**
     * Constructs a new array empty list with capacity of 16 elements
     */
    
    public MyArrayList() {
        this.array = new Object[16];

    }

    /**
     * appends a new element o at the end of the list
     * @param o the object to add to the list
     */
    public void add(Object o) {
        this.size++;
        if (size < this.array.length) {
            this.array[size - 1] = o;
        } else {
            Object[] temp = new Object[size()];
            System.arraycopy(array, 0, temp, 0, array.length);
            temp[size() - 1] = o;
            this.array = temp;
        }
    }

    /**
     * Inserts  the specified object into this list at the specified
     * location. Shifts the element currently at that position (if any) and
     * any preceding elements to the right (adds one to their indices)
     * @param index the index at which to insert the object
     * @param o the object to add
     */

    public void add(int index, Object o) {
       
      int max = this.array.length;
      int min = size + 1;
      if (min > max)
        {
          Object [] temp = (Object[]) new Object[Math.max(max * 2, min)];
          System.arraycopy(this.array, 0, temp, 0, size);
         this.array = temp;
      }
    
	System.arraycopy(this.array, index, this.array, index + 1,
			 size - index);
	this.array[index] = o;
	size++;
    }
    
    /**
     * Removes all the elements from this list
     * The list will be empty after this method is called and size becomes 0
     */
    public void clear() {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                this.array = null;
            }
        }
        this.size = 0;
    }

    /**
     * Returns the number of elements in this list
     * @return 
     */
    public int size() {
        return this.size;
    }

    /**
     * Searches this MyArrayList for a specified object.
     * @param o the desired object to search for in the list
     * @return true if this list contains the element o
     *         false otherwise
     */
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(this.array[i])) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Returns the element from this list at a specified index
     * @param index of type int
     * @return the object at the specified index
     */
    
    public Object get(int index) {
        return this.array[index];
    }
    
    
    
    
    
    /**
     * Returns the index of the first matching element in the list
     * tests for the  equality using the equals method.
     * @param o an object
     * @return the index where the object was found
     */
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(this.array[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Tests whether this list has any elements.
     * @return true if this list contains no elements
     *         false if this list has any element
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the index of the last occurrence of the specified object in
     * this list.
     * @param o the wanted object 
     * @return the index of the last matching element in this list
     *         -1 if the object is not in this list
     */
    public int lastIndexOf(Object o) {

        for (int i = size - 1; i >= 0; i--) {
            if (o.equals(this.array[i])) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Removes the element o from the list
     * @param o the desired object that i want to remove
     * @return true if it was found and removed
     *         false if the object was not found in the list
     */
    public boolean remove(Object o) {

        for (int i = 0; i < size; i++) {
            if (o.equals(this.array[i])) {
                this.array[i] = null;
                size--;
                return true;
            }
        }

        return false;
    }
    /**
     * Removes the element o from the list at a specific index
     * @param index the index of the element that will be removed from the list
     * @return returns the list as an array of objects that has an element removed from it
     */
    public Object remove (int index ) {
        this.array[index] = null;
        size--;
        return this.array;
    }
    /**
     * Replaces the element at the specified location in this list
     * with the specified object.
     * @param index  the index at which the element is being set
     * @param o the object that will  be added
     */
    public void set(int index, Object o) {
        this.array[index] = o;
    }
}
