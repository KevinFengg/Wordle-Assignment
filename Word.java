
public class Word {
	
	private LinearNode<Letter> firstLetter;
	
	public Word(Letter[] letters) {
		LinearNode<Letter> prev = null;
		LinearNode<Letter> current = null;
		
		for (int i = 0; i < letters.length; i ++) {
			
			//Creating a new node at index i of letters and assigning it to current
			current = new LinearNode(letters[i]);
			
			//To make it so that firstLetter is only obtained at the front of the object
			if (i == 0) {
				this.firstLetter = current;
				prev = current;
			}
			else {
				prev.setNext(current);
				prev = current;
			}
		}
	}
	
	public String toString() {
		String returnString = "";
		
		//Creating a variable current to traverse through the contents of the linked list
		LinearNode<Letter> current = firstLetter;

		//Continue running as long as the end of the linked list has not been reached
		while (current != null) {
			returnString += current.getElement().toString() + " ";
			current = current.getNext();
		}
		return "Word: " + returnString;
	}
	
	//A helper method that will check if the letter guess exists in firstLetter
	public boolean doesItExist(LinearNode<Letter> guess) {
		LinearNode<Letter> aGuess = firstLetter;
		while (aGuess != null) {
			if (aGuess.getElement().getLetter() == guess.getElement().getLetter()) {
				System.out.println(aGuess.getElement());
				return true;
			}
			aGuess = aGuess.getNext();
		}
		return false;
	}
	
	/*This method traverses through each element in mystery linked list
	 *and uses the doesItExist() helper function to determine if the
	 *char at thisFirst exists in the mystery word and changes the labels
	 *accordingly.
	 */
	public boolean labelWord(Word mystery) {
		LinearNode<Letter> thisFirst = this.firstLetter;
		LinearNode<Letter> mysteryFirst = mystery.firstLetter;
		boolean exists = false;
		
		/*
		 * This is for the return statement at the end. Having a variable for
		 * the boolean makes it so that the return statement is only called at
		 * the very end regardless of whether or not a letter does
		 * not exist in mystery.
		 */
		boolean decision = true;
		
		/*
		 * Impractical while loop.
		 * Before checking any letters, it first checks if thisFirst or
		 * mysteryFirst is null so .getnext() is not called when it happens and
		 * an error occurs.
		 */
		while (decision == true || decision == false) {
			if (thisFirst == null || mysteryFirst == null) {
				if (thisFirst == null && mysteryFirst == null) {
					break;
				}
				decision = false;
				break;
				}
			
				/*
				 * Determining if each thisFirst letter exists in the mystery word
				 * and using setters to set their corresponding labels.
				 */
				if (thisFirst.getElement().getLetter() == mysteryFirst.getElement().getLetter()) {
					thisFirst.getElement().setCorrect();
				}
				else {
					if (mystery.doesItExist(thisFirst)) {
						thisFirst.getElement().setUsed();
					}
					else {
						thisFirst.getElement().setUnused();
						decision = false;
					}
				}
				thisFirst = thisFirst.getNext();
				mysteryFirst = mysteryFirst.getNext();
			}
		return decision;
	}
}
