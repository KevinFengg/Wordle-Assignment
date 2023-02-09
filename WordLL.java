
public class WordLL {
	
	private Word mysteryWord;
	private LinearNode<Word> history;
	
	public WordLL(Word mystery) {
		history = null;
		this.mysteryWord = mystery;
	}
	
	public boolean tryWord(Word guess) {
		boolean trueFalse;
		LinearNode aNode;
		
		//Used to store the true/false that is returned from labelWord method
		trueFalse = mysteryWord.labelWord(guess);
		
		//Creating a new node with the updated guess and adding it to history
		aNode = new LinearNode<Word>(guess);
		aNode.setNext(history);
		history = aNode;
		System.out.println(history.getElement());
		return trueFalse;
	}
	
	/*
	 * This method will return all guess attempts in history.
	 * Variable aString will hold that info.
	 */
	public String toString() {
		LinearNode<Word> current = history;
		String aString = "";
		
		while (current != null) {
			aString = current.getElement().toString() + "\n";
			current = current.getNext();
		}
		return aString;
	}
}
