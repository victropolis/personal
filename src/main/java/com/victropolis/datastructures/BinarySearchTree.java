package com.victropolis.datastructures;

import com.victropolis.util.ComparableUtils;
import com.victropolis.util.sorting.impl.QuickSort;

/**
 * Created by victropolis on 5/20/15.
 */
public class BinarySearchTree<T extends Comparable<T>>
{
    protected class Node<T>
    {
        Node<T> parent;
        Node<T> leftChild;
        Node<T> rightChild;

        T item;

        public Node(T item)
        {
            this.item = item;
        }

        public Node(Node<T> parent, T item)
        {
            this.parent = parent;
            this.item = item;
        }

        public boolean hasLeft()
        {
            return getLeftChild() != null;
        }

        public boolean hasRight()
        {
            return getRightChild() != null;
        }

        public Node<T> getParent()
        {
            return parent;
        }

        public void setParent(Node<T> parent)
        {
            this.parent = parent;
        }

        public Node<T> getLeftChild()
        {
            return leftChild;
        }

        public void setLeftChild(Node<T> leftChild)
        {
            this.leftChild = leftChild;
        }

        public Node<T> getRightChild()
        {
            return rightChild;
        }

        public void setRightChild(Node<T> rightChild)
        {
            this.rightChild = rightChild;
        }

        public T getItem()
        {
            return item;
        }

        public void setItem(T item)
        {
            this.item = item;
        }
    }

    private Node<T> rootNode;

    public BinarySearchTree(T[] items)
    {
        for (T item : items)
        {
            add(item);
        }
    }

    public BinarySearchTree()
    {
    }

    public T getMax()
    {
        if (this.rootNode == null)
        {
            return null;
        }

        Node<T> node = this.rootNode;

        while (node.hasRight())
        {
            node = node.getRightChild();
        }

        return node.getItem();
    }

    public T getMin()
    {
        if (this.rootNode == null)
        {
            return null;
        }

        Node<T> node = this.rootNode;

        while (node.hasLeft())
        {
            node = node.getLeftChild();
        }

        return node.getItem();
    }

    public T find(T soughtItem)
    {
        return find(soughtItem, rootNode);
    }

    public void add(T soughtItem)
    {
        if (soughtItem == null)
        {
            return;
        }

        if (rootNode == null)
        {
            rootNode = new Node<T>(null, soughtItem);
        }
        else
        {
            add(soughtItem, rootNode);
        }
    }

    private T find(T soughtItem, Node<T> node)
    {
        T nodeItem = node.getItem();

        if (ComparableUtils.lt(soughtItem, nodeItem))
        {
            return find(soughtItem, node.getLeftChild());
        }
        else if (ComparableUtils.gt(soughtItem, nodeItem))
        {
            return find(soughtItem, node.getRightChild());
        }
        else if (ComparableUtils.eq(soughtItem, nodeItem))
        {
            return nodeItem;
        }

        return null;
    }

    private void add(T item, Node<T> node)
    {
        T nodeItem = node.getItem();

        if (ComparableUtils.lt(item, nodeItem))
        {
            if (node.hasLeft())
            {
                add(item, node.getLeftChild());
            }
            else
            {
                node.setLeftChild(new Node<T>(node, item));
            }
        }
        else if (ComparableUtils.gt(item, nodeItem))
        {
            if (node.hasRight())
            {
                add(item, node.getRightChild());
            }
            else
            {
                node.setRightChild(new Node<T>(node, item));
            }
        }
        else if (ComparableUtils.eq(item, nodeItem))
        {
            node.setItem(item);
        }
    }

    public T remove(T soughtItem)
    {
        return find(soughtItem, rootNode);
    }
}