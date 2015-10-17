package reflection.classes;


/**
 * Klasa A - test klasa namenjena testiranju refleksije u javi.
 * @author Zoran Luledzija
 */
public class A {
	
	/**
	 * Atribut field1
	 */
	private String field1;
	/**
	 * Atribut field2
	 */
	private int field2;
	/**
	 * Atribut field3
	 */
	private boolean field3;
	
	/**
	 * Default-ni (prazni) konstruktor
	 */
	public A(){	
		this.field1 = "";
		this.field2 = 0;
		this.field3 = false;
	}
	
	/**
	 * Konstruktor sa parametrima. Setovanje inicijalnih vrednosti atributa klase A
	 * @param field1
	 * @param field2
	 * @param field3
	 */
	public A(String field1, int field2, boolean field3){
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	
	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public int getField2() {
		return field2;
	}

	public void setField2(int field2) {
		this.field2 = field2;
	}

	public boolean isField3() {
		return field3;
	}

	public void setField3(boolean field3) {
		this.field3 = field3;
	}
	
	public String toString(){
		String result = new String("");
		result += "Field1: " + field1 + "\n";
		result += "Field2: " + field2 + "\n";
		result += "Field3: " + field3 + "\n";
		
		return result;
	}
	
}
