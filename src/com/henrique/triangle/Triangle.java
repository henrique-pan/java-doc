package com.henrique.triangle;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;


/**
 * Represents a triangle.
 * It offers method to create and manipulate triangles.
 *
 * @author  Henrique Nascimento
 * @version 1.0
 * @since   02-02-2018
 */
public class Triangle {

	private double coteAB;
	private double coteBC;
	private double coteCA;

	/**
	 * Initialize a triangle with "1" on each side.
	 */
	public Triangle() {
		setCotes(1.0, 1.0, 1.0);
	}

	/**
	 * Initialize a triangle with the values passed as parameters.
	 *
	 * If there is any problem with any parameters, it will
	 * create a Triangle default (with "1" on each side)
	 *
	 * @param coteAB Parameter to set the AB side
	 * @param coteBC Parameter to set the BC side
	 * @param coteCA Parameter to set the CA side
	 */
	public Triangle(double coteAB, double coteBC, double coteCA) {
		setCotes(coteAB, coteBC, coteCA);
	}

	/**
	 * Initialize a triangle with
	 * the values and rules passed as parameters.
	 *
	 * If there is any problem with any parameters, it will
	 * create a Triangle default (with "1" on each side)<br/>
	 *
	 * Exemple:<br/>
	 * 	Triangle(double coteAB, double coteBC, double angleB)<br/>
	 * 	Triangle(double coteAB, double coteCA, double angleB)<br/>
	 *  Triangle(double coteBC, double coteCA, double angleB)<br/>
	 *  Triangle(double coteAB, double angleB, double angleA)<br/>
	 *  Triangle(double coteCA, double angleB, double angleA)<br/>
	 *  Triangle(double coteBC, double angleB, double angleA)<br/>
	 *
	 * @param a Parameter to be used in the generic rule
	 * @param b Parameter to be used in the generic rule
	 * @param c Parameter to be used in the generic rule
	 * @param builder Generic rule of creation of the triangle
     * @see TriangleBuilder
	 */
	public Triangle(double a, double b, double c, TriangleBuilder builder) {
		Triangle t = builder.build(a, b, c);
		setCotes(t.coteAB, t.coteBC, t.coteCA);
	}

    /**
     * Set the sides
     *
     * If there is any problem with any parameters, it will
     * create a Triangle default (with "1" on each side)<br/>
     *
     * Exemple:<br/>
     * 	t.setCotes(7.5, 8.5, 9.5);<br/>
     *  t.setCotes(10, 10, 10);<br/>
     *  t.setCotes(0, 0, 0);<br/>
     *
     * @param coteAB Parameter to set the AB side
     * @param coteBC Parameter to set the BC side
     * @param coteCA Parameter to set the CA side
     */
	public void setCotes(double coteAB, double coteBC, double coteCA) {
		if (estValide(coteAB, coteBC, coteCA)) {
			this.coteAB = coteAB;
			this.coteBC = coteBC;
			this.coteCA = coteCA;
		} else {
			this.coteAB = 1.0;
			this.coteBC = 1.0;
			this.coteCA = 1.0;
		}
	}

    /**
     * Get the AB side
     *
     * @return double Side AB
     */
	public double getCoteAB() {
		return coteAB;
	}

    /**
     * Get the BC side
     *
     * @return double Side BC
     */
	public double getCoteBC() {
		return coteBC;
	}

    /**
     * Get the CA side
     *
     * @return double Side CA
     */
	public double getCoteCA() {
		return coteCA;
	}

    /**
     * Calculate the area of the triangle
     *
     * Returns with 4 decimals and Rounding HALF_UP
     *
     * @return double Area
     */
	public double getAire() {
		double d = (coteAB + coteBC + coteCA) / 2;
		double p = d * (d - coteAB) * (d - coteBC) * (d - coteCA);

		BigDecimal a = new BigDecimal(Math.sqrt(p)).setScale(4, RoundingMode.HALF_UP);

		return a.doubleValue();
	}

    /**
     * Calculate the perimeter of the triangle
     *
     * @return double Perimeter
     */
	public double getPerimetre() {
		return (coteAB + coteBC + coteCA);
	}

    /**
     * Calculate the angle A
     *
     * @return double Angle A
     */
	public double getAngleA() {
		return getAngle(coteCA, coteAB, coteBC);
	}

    /**
     * Calculate the angle B
     *
     * @return double Angle B
     */
	public double getAngleB() {
		return getAngle(coteAB, coteBC, coteCA);
	}

    /**
     * Calculate the angle C
     *
     * @return double Angle C
     */
	public double getAngleC() {
		return getAngle(coteBC, coteCA, coteAB);
	}

    /**
     * Compare if 2 triangles
     * are equal.
     *
     * Offers a precision of +-0,0001
     *
     * @param triangle The other triangle
     * @return boolean If it is equal
     */
	public boolean estEgal(Triangle triangle) {
		if (this == triangle)
			return true;
		if (triangle == null)
			return false;
		if (getClass() != triangle.getClass())
			return false;

		double erreurPrecision = 0.0001;

		Set<Double> cotes = new HashSet<Double>();
		cotes.add(this.getCoteAB());
		cotes.add(this.getCoteAB() + erreurPrecision);
		cotes.add(this.getCoteAB() - erreurPrecision);
		cotes.add(this.getCoteBC());
		cotes.add(this.getCoteBC() + erreurPrecision);
		cotes.add(this.getCoteBC() - erreurPrecision);
		cotes.add(this.getCoteCA());
		cotes.add(this.getCoteCA() + erreurPrecision);
		cotes.add(this.getCoteCA() - erreurPrecision);

		double coteABComp = triangle.getCoteAB();
		double coteBCComp = triangle.getCoteBC();
		double coteCAComp = triangle.getCoteCA();

		if (cotes.contains(coteABComp) && cotes.contains(coteBCComp) && cotes.contains(coteCAComp)) {
			return true;
		}
		return false;
	}

    /**
     * Compare if 2 triangles are similar.
     *
     * Offers a precision of +-0,0001
     *
     * @param triangle The other triangle
     * @return boolean If it is similar
     */
	public boolean estSemblable(Triangle triangle) {
		if (this == triangle)
			return true;
		if (triangle == null)
			return false;
		if (getClass() != triangle.getClass())
			return false;

		double erreurPrecision = 0.0001;

		Set<Double> angles = new HashSet<Double>();
		angles.add(this.getAngleA());
		angles.add(this.getAngleA() + erreurPrecision);
		angles.add(this.getAngleA() - erreurPrecision);
		angles.add(this.getAngleB());
		angles.add(this.getAngleB() + erreurPrecision);
		angles.add(this.getAngleB() - erreurPrecision);
		angles.add(this.getAngleC());
		angles.add(this.getAngleC() + erreurPrecision);
		angles.add(this.getAngleC() - erreurPrecision);

		double angleAComp = triangle.getAngleA();
		double angleBComp = triangle.getAngleB();
		double angleCComp = triangle.getAngleC();

		if (angles.contains(angleAComp) && angles.contains(angleBComp) && angles.contains(angleCComp)) {
			return true;
		}
		return false;
	}

    /**
     * Return a description of the triangle
     *
     * @return String The description
     */
	public String getDescription() {
		StringBuilder sb = new StringBuilder("----- Triangle -----\n");
		sb.append("   coteAB: ").append(coteAB).append("\n");
		sb.append("   coteBC: ").append(coteBC).append("\n");
		sb.append("   coteCA: ").append(coteCA).append("\n");
		sb.append("     Aire: ").append(getAire()).append("\n");
		sb.append("Perimetre: ").append(getPerimetre()).append("\n");
		sb.append("   AngleA: ").append(getAngleA()).append("\n");
		sb.append("   AngleB: ").append(getAngleB()).append("\n");
		sb.append("   AngleC: ").append(getAngleC()).append("\n");
		sb.append("--------------------");
		
		return sb.toString();
	}	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Triangle [");
		sb.append("coteAB: ").append(coteAB).append(", ");
		sb.append("coteBC: ").append(coteBC).append(", ");
		sb.append("coteCA: ").append(coteCA).append(", ");
		sb.append("Aire: ").append(getAire()).append(", ");
		sb.append("Perimetre: ").append(getPerimetre()).append(", ");
		sb.append("AngleA: ").append(getAngleA()).append(", ");
		sb.append("AngleB: ").append(getAngleB()).append(", ");
		sb.append("AngleC: ").append(getAngleC()).append("]");

		return sb.toString();
	}

    /**
     * Calculate the angle of any triangle
     *
     * It offers 4 decimals of precision and
     * Rounding HALF_UP
     *
     * @param a Side A
     * @param b Side B
     * @param c Side C
     * @return double The angle of 3 sides
     */
	private double getAngle(double a, double b, double c) {
		double p = (Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b);
		BigDecimal acos = new BigDecimal(Math.acos(p)).setScale(4, RoundingMode.HALF_UP);
		return acos.doubleValue();
	}

    /**
     * Verify if an triangle is valid
     *
     * @param coteAB AB side
     * @param coteBC BC side
     * @param coteCA CA side
     * @return boolean If the triangle is valid
     */
	private boolean estValide(double coteAB, double coteBC, double coteCA) {
		// |AB| < |BC| + |CA| && |BC| < |CA| + |AB| && |CA| < |AB| + |BC|
		if (coteAB <= 0 || coteBC <= 0 || coteCA <= 0)
			return false;

		if (coteAB < (coteBC + coteCA) && coteBC < (coteCA + coteAB) && coteCA < (coteAB + coteBC)) {
			return true;
		}

		return false;
	}

}
