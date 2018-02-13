package com.henrique.triangle;

/**
 * Allow the creation of an Triangle with any rule
 *
 * @author  Henrique Nascimento
 * @version 1.0
 * @since   02-02-2018
 */
@FunctionalInterface
public interface TriangleBuilder {

    /**
     * Build an triangle with any posible rule
     *
     *
     * @param a Parameter to set the AB side
     * @param b Parameter to set the BC side
     * @param c Parameter to set the CA side
     *
     * @return Triangle
     */
	Triangle build(double a, double b, double c);

}
