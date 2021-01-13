package com.coderscampus.arraylist;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
    int size=0;
	@Override
	public boolean add(T item) {
		if (items.equals(null)){
			return false;
		}if (item.equals(null)) {
			return false;
		}else {
			   if (items.length!=size) {
				   items[size]=item;
				   size++;
				   return true;
			   }else if (size==items.length) {
					  Object[] temp = new Object[items.length];
					  int i=0;
					  for (Object obj: items) {
					       temp[i]= obj;
					       i++;
					  }
					  items= new Object[items.length *2];
					  int j=0;
					  for (Object obj: temp) {
					       items[j]= obj;
					       j++;
					       
					  }
					  items[size]=item;

					  }

		}
		 size++;
	     return true;
	}

	@Override
	public int getSize() {

		return size;
	}

	@Override
	public T get(int index) {
		return (T) items[index];
	}
	
}
