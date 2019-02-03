package project1;

/*
 * Written by - Ritesh Thapa
 * Prof. Tim Gegg-Harrison
 * Project 01
 * 
 * 1/25/2018
 * 
 */
public class Deck<AnyType> extends Pile<AnyType> {
	private int minRandomIndex;
	private int maxRandomIndex;
	
	/*
	 * this method mix up elements of the pile by swapping a random element
	 * with a random group of 2 consecutive elements
	 */
	public void shuffle() {
		minRandomIndex = 0;
		maxRandomIndex = size() - 1;
		for(int i=0; i < 10; ++i) { 	// repeats mixing for 1000 times

			//gets two random index to swap to
			int index1 = getRandomIndex();
			int index2 = getRandomIndex();
			
			//gets start and end index of the group of two consecutive elements
			int groupStart = index2;
			int groupEnd = index2 + 1;	//reason: group of two consecutive elements
			
			if(groupEnd > maxRandomIndex) {
				groupEnd = groupStart;
				groupStart--;
			}
			
			//makes sure that group do not overlap
			if(index1 < groupStart || index1 > groupEnd) {
				swapElement(index1, groupStart);
			}
			
		}
	}
	
	private void swapElement(int index, int groupStart) {
		AnyType element = removeIndexVal(index);	//removes element from list at 'index'
		
		if(index < groupStart) {
			groupStart--;	//because one element before 'groupStart', has been removed, refreshing the position
		}
		
		AnyType  groupStartElement = removeIndexVal(groupStart);	//removes 'groupStart' element
		AnyType  groupEndElement = removeIndexVal(groupStart);		//because 'groupStart' element has been removed, gruopEnd index = groupStart index
		
		if((groupStart+1) < index) {
			index--;	//because two elements (groupStart and groupEnd) has been removed in replacement for one 'index' element, refreshing the position
		}
		
		addIndexVal(groupStart, element);			//puts previously removed 'index' element to groupStart position
		addIndexVal(index, groupEndElement);		
		addIndexVal(index, groupStartElement);		//puts previously removed 'groupStart' element to index position and corrects the position of 'groupEnd' element
		
	}

	private int getRandomIndex() {
		return (int) (Math.random() * (maxRandomIndex - minRandomIndex) + minRandomIndex);	//gets random index between min and max
	}
	
}

	
	
	
	
	
	
	
	
	
	
	
