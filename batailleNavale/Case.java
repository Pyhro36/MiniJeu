package batailleNavale;

/**
 * @author PL
 * @version 1.0
 */

public class Case {
	
	protected char typeCase;
	
	/**
	 * 
	 */
	
	public Case() {
		
		this.typeCase = ' ';
	}
	
	public Case(char typeCase) {
		
		this.typeCase = typeCase;
	}
	
	public void touche(){
		
		this.typeCase = 'X';
    }
    
    public String toString() {
    	
    	return String.valueOf(typeCase);
    }
}
