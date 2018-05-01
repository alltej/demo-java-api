package com.alltej.apps.rbtreev2;

/**
 * @author Allan Tejano
 * 4/30/2018
 */
/* Class Node */
public class RedBlackNode
{
    RedBlackNode left, right;
    int element;
    int color;

    /* Constructor */
    public RedBlackNode(int theElement)
    {
        this( theElement, null, null );
    }
    /* Constructor */
    public RedBlackNode(int theElement, RedBlackNode lt, RedBlackNode rt)
    {
        left = lt;
        right = rt;
        element = theElement;
        color = 1;
    }
}
