package com.coderscampus.arraylist;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	int size = 0;

	@Override
	public boolean add(T item) {
		if (item.equals(null)) {
			return false;
		} else {
			if (size == items.length) {
				Object[] expandedArray = new Object[items.length * 2];
				for (int i = 0; i < size; i++) {
					expandedArray[i] = items[i];
				}
				items = expandedArray;
			}
			items[size++] = item;
		}

		return true;
	}

	@Override
	public int getSize() {
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		return (T) items[index];
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {

		int itemsLength = size;

		if (item.equals(null)) {
			return false;
		} else if (index > items.length) {
			throw new IndexOutOfBoundsException();
		} else if (items[index].equals(null)) {
			items[index] = item;
			return true;
		} else {
			while (itemsLength >= index) {
				T temp = (T) items[itemsLength + 1];
				items[itemsLength + 1] = items[itemsLength];
				items[itemsLength] = temp;
				itemsLength--;
			}
			items[index] = item;
			size = size + 1;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		
		T item=null;
		
//		int itemsLength = size;

         if (index > items.length) {
			throw new IndexOutOfBoundsException();
		} 		else {
			while (index <= size) {
				item = (T) items[index];
				items[index] = items[index + 1 ];
				index++;
			}
    		 size = size - 1;
		}
		return item;
	}

}
