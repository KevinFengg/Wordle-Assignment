
public class ExtendedLetter extends Letter{
	
	private String content;
	private int family;
	private boolean related;
	private final int SINGLETON = -1;
	
	public ExtendedLetter(String s) {
		super('c');
		this.content = s;
		this.related = false;
		this.family = this.SINGLETON;
	}
	
	public ExtendedLetter(String s, int fam) {
		super('c');
		this.content = s;
		this.related = false;
		this.family = fam;
	}
	
	public boolean equals(Object other) {
		if (other instanceof ExtendedLetter) {
			
			//Casting other into an object of type ExtendedLetter
			if (((ExtendedLetter) other).family == this.family) {
				this.related = true;
			}
			if (((ExtendedLetter) other).content == this.content) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		if (this.isUnused() == true & this.related == true) {
			return "." + this.content + ".";
		}
		return decorator() + this.content + decorator();
	}
	
	public static Letter[] fromStrings(String[] content, int[] codes) {
		Letter[] letters = new Letter[content.length];
		if (codes == null) {
			for (int i = 0; i < letters.length; i ++) {
				letters[i] = new ExtendedLetter(content[i]);
			}
		}
		else {
			for (int i = 0; i < letters.length; i ++) {
				letters[i] = new ExtendedLetter(content[i], codes[i]);
			}
		}
		return letters;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
