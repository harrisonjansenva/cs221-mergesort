import java.util.Comparator;
import java.util.ListIterator;

/**
 * Class for sorting lists that implement the IndexedUnsortedList interface,
 * using ordering defined by class of objects in list or a Comparator.
 * As written uses Mergesort algorithm.
 *
 * @author CS221
 */
public class Sort
{	
	/**
	 * Returns a new list that implements the IndexedUnsortedList interface. 
	 * As configured, uses WrappedDLL. Must be changed if using 
	 * your own IUDoubleLinkedList class. 
	 * 
	 * @return a new list that implements the IndexedUnsortedList interface
	 */
	private static <T> IndexedUnsortedList<T> newList() 
	{
		return new WrappedDLL<T>(); //TODO: replace with your IUDoubleLinkedList for extra-credit
	}
	
	/**
	 * Sorts a list that implements the IndexedUnsortedList interface 
	 * using compareTo() method defined by class of objects in list.
	 * DO NOT MODIFY THIS METHOD
	 * 
	 * @param <T>
	 *            The class of elements in the list, must extend Comparable
	 * @param list
	 *            The list to be sorted, implements IndexedUnsortedList interface 
	 * @see IndexedUnsortedList 
	 */
	public static <T extends Comparable<T>> void sort(IndexedUnsortedList<T> list) 
	{
		mergesort(list);
	}

	/**
	 * Sorts a list that implements the IndexedUnsortedList interface 
	 * using given Comparator.
	 * DO NOT MODIFY THIS METHOD
	 * 
	 * @param <T>
	 *            The class of elements in the list
	 * @param list
	 *            The list to be sorted, implements IndexedUnsortedList interface 
	 * @param c
	 *            The Comparator used
	 * @see IndexedUnsortedList 
	 */
	public static <T> void sort(IndexedUnsortedList <T> list, Comparator<T> c) 
	{
		mergesort(list, c);
	}
	
	/**
	 * Mergesort algorithm to sort objects in a list 
	 * that implements the IndexedUnsortedList interface, 
	 * using compareTo() method defined by class of objects in list.
	 * DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The class of elements in the list, must extend Comparable
	 * @param list
	 *            The list to be sorted, implements IndexedUnsortedList interface 
	 */
	private static <T extends Comparable<T>> void mergesort(IndexedUnsortedList<T> list)
	{
		IndexedUnsortedList<T> list2 = newList();
		if (list.size() < 2) {
			return;
		}
		ListIterator<T> it = list.listIterator();
		IndexedUnsortedList<T> leftList = newList();
		IndexedUnsortedList<T> rightList = newList();

		for (int i = 0; i < list.size() / 2; i++) {
			leftList.add(it.next());

		}
		for (int i = list.size() / 2; i < list.size(); i++) {
			rightList.add(it.next());
		}
		mergesort(leftList);
		mergesort(rightList);
		while (!leftList.isEmpty() && !rightList.isEmpty()) {
			if (leftList.first().compareTo(rightList.first()) < 0) {
				list2.add(leftList.removeFirst());
			} else {
				list2.add(rightList.removeFirst());
			}
		}
			while (!leftList.isEmpty()) {
				list2.addToRear(leftList.removeFirst());
			}
			while (!rightList.isEmpty()) {
				list2.addToRear(rightList.removeFirst());
			}
			ListIterator<T> it1 = list.listIterator();
			ListIterator<T> it2 = list2.listIterator();
			while (it1.hasNext()) {
				it1.next();
				it1.set(it2.next());
			}





	}
		
	/**
	 * Mergesort algorithm to sort objects in a list 
	 * that implements the IndexedUnsortedList interface,
	 * using the given Comparator.
	 * DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The class of elements in the list
	 * @param list
	 *            The list to be sorted, implements IndexedUnsortedList interface 
	 * @param c
	 *            The Comparator used
	 */
	private static <T> void mergesort(IndexedUnsortedList<T> list, Comparator<T> c)
	{
		// TODO: Implement recursive mergesort algorithm using Comparator
		IndexedUnsortedList<T> list2 = newList();
		if (list.size() < 2) {
			return;
		}
		ListIterator<T> it = list.listIterator();
		IndexedUnsortedList<T> leftList = newList();
		IndexedUnsortedList<T> rightList = newList();

		for (int i = 0; i < list.size() / 2; i++) {
			leftList.add(it.next());

		}
		for (int i = list.size() / 2; i < list.size(); i++) {
			rightList.add(it.next());
		}
		mergesort(leftList, c);
		mergesort(rightList, c);
		while (!leftList.isEmpty() && !rightList.isEmpty()) {
			if (c.compare(leftList.first(), rightList.first()) < 0) {
				list2.add(leftList.removeFirst());
			}
			else {
				list2.add(rightList.removeFirst());
			}
		}
		while (!leftList.isEmpty()) {
			list2.addToRear(leftList.removeFirst());
		}
		while (!rightList.isEmpty()) {
			list2.addToRear(rightList.removeFirst());
		}
		ListIterator<T> it1 = list.listIterator();
		ListIterator<T> it2 = list2.listIterator();
		while (it1.hasNext()) {
			it1.next();
			it1.set(it2.next());
		}


	}

}
