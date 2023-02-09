
public class Letter {

	private char letter;
	private int label;
	private final int UNSET = 0;
	private final int UNUSED = 1;
	private final int USED = 2;
	private final int CORRECT = 3;
	
	public Letter(char c) {
		this.label = UNSET;
		this.letter = c;
	}
	
	public char getLetter() {
		return letter;
	}
	
	public boolean equals(Object otherObject) {
		if (otherObject.getClass() == Letter.class) {
			
			//Casting otherObject into object type "Letter"
			Letter anObject = (Letter) otherObject;
			
			if (this.letter == anObject.letter) {		
				if (anObject.letter == this.letter) {
					return true;
				}
			}
			return false;
		}
		return false;
	}
	
	public String decorator() {
		if (this.label == USED) {
			return "+";
		}
		else if (this.label == UNUSED) {
			return "-";
		}
		else if (this.label == CORRECT) {
			return "!";
		}
		
		//Covers the UNSET condition as it is the only one remaining.
		else {
			return " ";
		}
	}
	
	@Override
	public String toString() {
		return decorator() + this.letter + decorator();
	}
	
	public void setUnused() {
		this.label = UNUSED;
	}
	
	public void setUsed() {
		this.label = USED;
	}
	
	public void setCorrect() {
		this.label = CORRECT;
	}
	
	public boolean isUnused() {
		if (this.label == UNUSED) {
			return true;
		}
		return false;
	}
	
	public static Letter[] fromString(String s) {
		Letter[] letterArray = new Letter[s.length()];
		for (int i = 0; i < s.length(); i ++) {
			
			//Using charAt() to determine the character at position i in the string s and using it to create a new Letter object in letterArray position i
			letterArray[i] = new Letter(s.charAt(i));
			//System.out.println(letterArray[i]);
		}
		return letterArray;
	}
}
