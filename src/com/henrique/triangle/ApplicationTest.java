package com.henrique.triangle;

/**
 * Test of the Triangle class
 *
 * @author  Henrique Nascimento
 * @version 1.0
 * @since   02-02-2018
 */
public class ApplicationTest {

	/**
	 * main to the Triangle's test
	 *
	 * Execution of the Tests
	 * @param args Unused
	 */
	public static void main(String[] args) {
		// Testes des constructeurs
		test1();

		// Testes du méthode setter
		test2();

		// Testes d'aire et perimetre
		test3();

		// Testes des angles
		test4();

		// Testes des egal et semblable
		test5();
	}

	/**
	 * Testes des constructeurs + methodes getters
	 */
	public static void test1() {
		Triangle t1 = new Triangle();

		assert t1.getCoteAB() == 1.0;
		assert t1.getCoteBC() == 1.0;
		assert t1.getCoteCA() == 1.0;
		System.out.println(t1);

		Triangle t2 = new Triangle(5, 5, 5);

		assert t2.getCoteAB() == 5;
		assert t2.getCoteBC() == 5;
		assert t2.getCoteCA() == 5;
		System.out.println(t2);

		Triangle t3 = new Triangle(0, 0, 0);

		assert t3.getCoteAB() == 1;
		assert t3.getCoteBC() == 1;
		assert t3.getCoteCA() == 1;
		System.out.println(t3);
	}

	/**
	 * Testes du méthode setter
	 */
	public static void test2() {
		Triangle t1 = new Triangle();
		t1.setCotes(7, 8, 9);

		assert t1.getCoteAB() == 7.0;
		assert t1.getCoteBC() == 8.0;
		assert t1.getCoteCA() == 9.0;
		System.out.println(t1);

		Triangle t2 = new Triangle(5, 5, 5);
		t2.setCotes(10, 11, 12);

		assert t2.getCoteAB() == 10;
		assert t2.getCoteBC() == 11;
		assert t2.getCoteCA() == 12;
		System.out.println(t2);

		Triangle t3 = new Triangle();
		t3.setCotes(0, 8, 9);

		assert t3.getCoteAB() == 1;
		assert t3.getCoteBC() == 1;
		assert t3.getCoteCA() == 1;
		System.out.println(t3);
	}

	/**
	 * Testes d'aire et perimetre
	 */
	public static void test3() {
		Triangle t1 = new Triangle(10, 10, 10);

		double aire = t1.getAire();
		assert aire == 43.3013;
		System.out.println("Aire(10, 10, 10): " + aire);

		double perimetre = t1.getPerimetre();
		assert perimetre == 30;
		System.out.println("Perimetre(10, 10, 10): " + perimetre);

		t1.setCotes(7.5, 8.5, 9.5);
		aire = t1.getAire();
		assert aire == 30.4068;
		System.out.println("Aire(7.5, 8.5, 9.5): " + aire);

		perimetre = t1.getPerimetre();
		assert perimetre == 25.5;
		System.out.println("Perimetre(7.5, 8.5, 9.5): " + perimetre);

		System.out.println(t1);
	}

	/**
	 * Testes des angles
	 */
	public static void test4() {
		Triangle t1 = new Triangle(10, 10, 10);
		double angleAComp = t1.getAngleA();
		double angleBComp = t1.getAngleB();
		double angleCComp = t1.getAngleC();

		assert angleAComp == 1.0472;
		assert angleBComp == 1.0472;
		assert angleCComp == 1.0472;

		t1.setCotes(7.5, 8.5, 9.5);
		angleAComp = t1.getAngleA();
		angleBComp = t1.getAngleB();
		angleCComp = t1.getAngleC();

		assert angleAComp == 1.0227;
		assert angleBComp == 1.2661;
		assert angleCComp == 0.8528;

		System.out.println(t1);
	}

	/**
	 * Testes des egal et semblable
	 */
	public static void test5() {
		Triangle t1 = new Triangle(10, 10, 10);
		System.out.println(t1);
		
		Triangle t2 = new Triangle(10, 10, 10);
		System.out.println(t2);
		
		assert t1.estEgal(t2);
		assert t2.estEgal(t1);
		assert t1.estSemblable(t2);
		assert t2.estSemblable(t1);
		
		t1 = new Triangle(7, 8, 9);
		System.out.println(t1);
		
		assert !t1.estEgal(t2);
		assert !t2.estEgal(t1);
		assert !t1.estSemblable(t2);
		assert !t2.estSemblable(t1);
	}

}
