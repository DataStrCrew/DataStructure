package com.datastrcrew.libraryapi.classes;
import java.util.Comparator;

/** Rotating Binary Search Tree */
public class RotatingBinarySearchTree<E extends Comparable<E>> extends BinarySearchTree<E>
{	
	/**
     * Constructor for RotatingBinarySearchTree.
     * @param comparator comparator object..
     */
	public RotatingBinarySearchTree(Comparator<E> comparator)
	{
		super(comparator);
	}
	/**
     * Constructor for RotatingBinarySearchTree.
     * @param comparator comparator object..
     * @param item item to add.
     */
	public RotatingBinarySearchTree(E item, Comparator<E> comparator)
	{
		super(comparator);
		add(item);
	}
	/**
     * Rotate left method.
     * @param node node to rotate .
     * @return rotated node.
     */
	protected Node<E> rotateLeft(Node<E> node)
	{
		Node<E> temp=node.right;
		node.right=temp.left;
		temp.left=node;
		return temp;
	}
	/**
     * Rotate right method.
     * @param node node to rotate.
     * @return rotated node.
     */
	protected Node<E> rotateRight(Node<E> node)
	{
		Node<E> temp=node.left;
		node.left=temp.right;
		temp.right=node;
		return temp;
	}
}
