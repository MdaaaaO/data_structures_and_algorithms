/*---------------------------------------------------
 * Hochschule für Technik Stuttgart
 * Fachbereich Vermessung, Informatik und Mathematik
 * Schellingstr. 24
 * D-70174 Stuttgart
 *
 * Volker Coors, Markus Deininger
 * 17.10.2008
 *
 * Datenstrukturen und Algorithmen
 * SG Informatik und SG Informationslogistik
 *
 * Hausübung 3: ADT Stack
 * 
 * ------------------------------------------------*/

/*
 * Aufgabe 1.a - Stack Implementierung als Array mit Exception-Handling
 * 
 * Vervollständigen Sie zunächst die Klasse Stack. Diese Klasse repräsentiert
 * einen Stack der beliebige Objekte aufnimmt.
 * Ergänzen Sie den Stack um eine Fehlerbehandlung für leere und volle Stacks. 
 * Nutzen Sie dazu die beiden Fehlerklassen StackEmptyException und
 * StackFullException. Die Fehler sollen ausgelöst werden, wenn eine Operation
 * einen Stacküberlauf oder –unterlauf verursachen würde.
 * Hinweis: dazu müssen Sie die Signatur einiger Stack-Methoden anpassen.
 * 
 *  Aufgabe 1.b - Stack Implementierung als verkettete Liste mit Exception-Handling
 *  
 *  Bauen Sie die Klasse Stack wie in der Vorlesung dargestellt um, so dass die
 *  Datenhaltung statt in einem Array nun als verkettete Liste erfolgt.
 *  Nutzen Sie dazu die Klasse Link. Realisieren Sie die Methode toString so,
 *  dass der Stack beginnend mit dem untersten Element ausgegeben wird.
 *  Optimieren Sie den Stack so, dass alle Methoden (außer toString) nun die
 *  Komplexität O(1) besitzen. 
 *  Zusatzaufgabe: Wie könnten Sie die Methode toString ebenfalls mit O(1) realisieren? 
 */

/**
 * This is the representation of our stack for an exercise, the original 
 * interface was provided by 
 * 
 * @date 10/17/2008 
 * @author Volker Coors 
 * @author Markus Deininger
 * 
 * Exercise 1.a - Stack Implementation as an Array with Exception-Handling
 * Exercise 1.b - Stack Implementation as a linked List with Exception-Handling.
 * 
 * @date 10/21/2015
 * @author Georg Kasper 
 */
package stack;

public abstract class Stack {

	// Implementierung der Methoden hier ...
	/**
	 * Returns the Version
	 * 
	 * @return String
	 */
	public String version() {
		return "NULL";
	};

	/**
	 * Empties the stack
	 */
	public void empty() {

	};

	/**
	 * Pushes a new Object to the stack
	 * 
	 * @param element
	 */
	public void push(Object element) {
	}

	/**
	 * Returns the latest Object from the stack and removes it from the stack.
	 * 
	 * @return Object
	 */
	public Object pop() {
		return null;
	}

	/**
	 * Returns the size of the stack
	 * 
	 * @return
	 */
	public int size() {
		return 0; // Dummy-Wert
	}

	/**
	 * Returns True if the stack has no Objects stored
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		return true; // Dummy-Wert
	}

	/**
	 * Returns True if the stack is full
	 * 
	 * @return boolean
	 */
	public boolean isFull() {
		return true; // Dummy-Wert
	}

	/**
	 * Returns the top Object of the stack without removing it.
	 * 
	 * @return
	 */
	public Object peek() {
		return null; // Dummy-Wert
	}

	/**
	 * Prints the representation of the stack to the shell. 
	 * format: value1 value2 value3 [top_value] e.g.: 5 8 1 10 [9]
	 */
	public String toString() {
		return "[x]"; // Dummy-Wert
	}
}
