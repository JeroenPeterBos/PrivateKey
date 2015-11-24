package privatekey.modules.administratie;

/**
 * 
 * @author Jeroen
 * @version v0.1
 */
public class Element {

	// -------------------------------- Instance Variables -------------------------------- //
	
		private String name;
		private int id;
		
		// -------------------------------- Constructors -------------------------------------- //
		
		/**
		 * Creates a new <code>Element</code> with the given name.
		 * @param name the name of this <code>Element</code>
		 */
		public Element(String name, int id){
			this.name = name;
			this.id = id;
		}
		// -------------------------------- Commands ------------------------------------------ //
		
		public void setId(int id){
			this.id = id;
		}
		
		// -------------------------------- Queries ------------------------------------------- //
		
		/**
		 * Returns the name of this <code>Element</code>.
		 * @return name of the <code>Element</code>
		 */
		public String getName(){
			return name;
		}
		
		public int getId(){
			return id;
		}
}
