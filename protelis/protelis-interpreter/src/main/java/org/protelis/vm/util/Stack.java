/*******************************************************************************
 * Copyright (C) 2014, 2015, Danilo Pianini and contributors
 * listed in the project's build.gradle or pom.xml file.
 *
 * This file is part of Protelis, and is distributed under the terms of
 * the GNU General Public License, with a linking exception, as described
 * in the file LICENSE.txt in this project's top directory.
 *******************************************************************************/
package org.protelis.vm.util;

import java.util.Map;

import org.protelis.lang.util.Reference;

/**
 * Stack implementation used by the Protelis VM for tracking local variable
 * values during execution.
 */
public interface Stack {

    /**
     * Enter a new nested lexical scope.
     */
    void push();

    /**
     * Exit the current most-nested lexical scope.
     */
    void pop();

    /**
     * Assign a value to a variable, either overwriting or shadowing prior
     * value.
     * 
     * @param var
     *            Name of the variable to be bound
     * @param val
     *            Value to be assigned
     * @param canShadow
     *            If true, then only values in the same lexical scope are
     *            overwritten; others are shadowed. If false, then prior value
     *            is always overwritten.
     * @return Value overwritten, or null if no value is overwritten
     */
    Object put(Reference var, Object val, boolean canShadow);

    /**
     * Bind a collection of variable/value pairs into the current lexical scope,
     * e.g., the arguments of a function.
     * 
     * @param map
     *            Collection of variable/value pairs to be bound
     */
    void putAll(Map<Reference, ? extends Object> map);

    /**
     * Look up a variable in the stack.
     * 
     * @param var
     *            The variable to be looked up
     * @return Value of the variable in the innermost lexical scope where it
     *         exists, if bound; otherwise null.
     */
    Object get(Reference var);

}
