package privatekey.modules.administratie;

/**
 * 
 * @author Jeroen
 * @version v0.1
 */
public class Element {

	// -------------------------------- Instance Variables -------------------------------- //
	
		private String name;
		
		// -------------------------------- Constructors -------------------------------------- //
		
		/**
		 * Creates a new <code>Element</code> with the given name.
		 * @param name the name of this <code>Element</code>
		 */
		public Element(String name){
			this.name = name;
		}
		// -------------------------------- Commands ------------------------------------------ //
		
		// -------------------------------- Queries ------------------------------------------- //
		
		/**
		 * Returns the name of this <code>Element</code>.
		 * @return name of the <code>Element</code>
		 */
		public String getName(){
			return name;
		}
}
