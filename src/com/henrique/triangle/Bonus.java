package com.henrique.triangle;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Bonus exercises for the POO classes
 *
 * @author  Henrique Nascimento
 * @version 1.0
 * @since   02-02-2018
 */
public class Bonus {

    /**
     * Bonus exercises for the POO classes
     *
     * Execution of the Bonus
     * @param args Unused
     */
	public static void main(String[] args) {
		TriangleBuilder builder = (a, b, c) -> {
			Triangle t = new Triangle(a, b, c);
			return t;
		};
		Triangle triangle = new Triangle(30, 40, 50, builder);
		System.out.println(triangle.getDescription());

		// Bonus 1
		// Triangle(double coteAB, double coteBC, double angleB)
		TriangleBuilder b1 = (coteAB, coteBC, angleB) -> {
			Triangle t = new Triangle();
			try {
				double cosB = Math.cos(angleB);
				double d = Math.pow(coteAB, 2) + Math.pow(coteBC, 2) - (2 * coteAB * coteBC * cosB);
				BigDecimal ac = new BigDecimal(Math.sqrt(d)).setScale(4, RoundingMode.HALF_UP);

				t.setCotes(coteAB, coteBC, ac.doubleValue());
			} catch (Exception e) {
				System.out.println("Les arguments sont invalides.");
				t.setCotes(1.0, 1.0, 1.0);
			}
			return t;
		};
		triangle = new Triangle(30, 40, 1.5708, b1);
		System.out.println(triangle.getDescription());

		// Bonus 2
		// Triangle(double coteAB, double coteCA, double angleB)
		triangle = new Triangle(30, 50, 1.5708, (coteAB, coteCA, angleB) -> {
			Triangle t = new Triangle();
			try {
				double cosB = Math.cos(angleB);
				double sinB = Math.sin(angleB);

				double d = Math.pow(coteCA, 2) - Math.pow(coteAB, 2) * Math.pow(sinB, 2);
				BigDecimal ac = new BigDecimal(Math.sqrt(d) + coteAB * cosB).setScale(4, RoundingMode.HALF_UP);
				t.setCotes(coteAB, ac.doubleValue(), coteCA);
			} catch (Exception e) {
				System.out.println("Les arguments sont invalides.");
				t.setCotes(1.0, 1.0, 1.0);
			}

			return t;
		});
		System.out.println(triangle.getDescription());

		// Bonus 3
		// Triangle(double coteBC, double coteCA, double angleB)
		triangle = new Triangle(40, 50, 1.5708, new TriangleBuilder() {

			@Override
			public Triangle build(double coteBC, double coteCA, double angleB) {
				Triangle t = new Triangle();
				try {
					double cosB = Math.cos(angleB);
					double sinB = Math.sin(angleB);

					double d = Math.pow(coteCA, 2) - Math.pow(coteBC, 2) * Math.pow(sinB, 2);
					BigDecimal ac = new BigDecimal(Math.sqrt(d) + coteBC * cosB).setScale(4, RoundingMode.HALF_UP);
					t.setCotes(ac.doubleValue(), coteBC, coteCA);
				} catch (Exception e) {
					System.out.println("Les arguments sont invalides.");
					t.setCotes(1.0, 1.0, 1.0);
				}

				return t;
			}
			
		});
		System.out.println(triangle.getDescription());

		// Bonus 4
		// Triangle(double coteAB, double angleB, double angleA)
		TriangleBuilder b4 = (coteAB, angleB, angleA) -> {
			Triangle t = new Triangle();
			try {
				double coteCA = new BigDecimal((coteAB * Math.sin(angleB))/ Math.sin(angleA + angleB)).setScale(4, RoundingMode.HALF_UP).doubleValue();
				double coteBC = new BigDecimal((coteAB * Math.sin(angleA))/ Math.sin(angleA + angleB)).setScale(4, RoundingMode.HALF_UP).doubleValue();
				t.setCotes(coteAB, coteBC, coteCA);
			} catch (Exception e) {
				System.out.println("Les arguments sont invalides.");
				t.setCotes(1.0, 1.0, 1.0);
			}
			return t;
		};
		triangle = new Triangle(30, 1.5708, 0.9273, b4);
		System.out.println(triangle.getDescription());

		// Bonus 5
		// Triangle(double coteCA, double angleB, double angleA)
		triangle = new Triangle(50, 1.5708, 0.9273, (coteCA, angleB, angleA) -> {
			Triangle t = new Triangle();
			try {
				double coteAB = new BigDecimal((coteCA * Math.sin(angleA + angleB))/ Math.sin(angleB)).setScale(4, RoundingMode.HALF_UP).doubleValue();
				double coteBC = new BigDecimal((coteCA * Math.sin(angleA))/ Math.sin(angleB)).setScale(4, RoundingMode.HALF_UP).doubleValue();
				t.setCotes(coteAB, coteBC, coteCA);
			} catch (Exception e) {
				System.out.println("Les arguments sont invalides.");
				t.setCotes(1.0, 1.0, 1.0);
			}
			return t;
		});
		System.out.println(triangle.getDescription());

		// Bonus 6
		// Triangle(double coteBC, double angleB, double angleA)
		triangle = new Triangle(40, 1.5708, 0.9273, new TriangleBuilder() {

			@Override
			public Triangle build(double coteBC, double angleB, double angleA) {
				Triangle t = new Triangle();
				try {
					double coteAB = new BigDecimal((coteBC * Math.sin(angleA + angleB))/ Math.sin(angleA)).setScale(4, RoundingMode.HALF_UP).doubleValue();
					double coteCA = new BigDecimal((coteBC * Math.sin(angleB))/ Math.sin(angleA)).setScale(4, RoundingMode.HALF_UP).doubleValue();
					t.setCotes(coteAB, coteBC, coteCA);
				} catch (Exception e) {
					System.out.println("Les arguments sont invalides.");
					t.setCotes(1.0, 1.0, 1.0);
				}
				return t;
			}
			
		});
		System.out.println(triangle.getDescription());
	}

}
