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

        return getMax(this.rootNode).getItem();
    }

    public T getMin()
    {
        if (this.rootNode == null)
        {
            return null;
        }

        return getMin(this.rootNode).getItem();
    }

    private Node<T> getMin(Node<T> fromNode)
    {
        Node<T> node = fromNode;

        while (node.hasLeft())
        {
            node = node.getLeftChild();
        }

        return node;
    }

    private Node<T> getMax(Node<T> fromNode)
    {
        Node<T> node = fromNode;

        while (node.hasRight())
        {
            node = node.getRightChild();
        }

        return node;
    }

    public T find(T soughtItem)
    {
        Node<T> node = find(soughtItem, rootNode);
        return node != null ? node.getItem() : null;
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

    private Node<T> find(T item, Node<T> node)
    {
        if (node != null)
        {
            T nodeItem;

            for (nodeItem = node.getItem(); ((ComparableUtils.lt(item, nodeItem) && node.hasLeft()) || (ComparableUtils.gt(item, nodeItem) && node.hasRight())); nodeItem = node.getItem())
            {
                if (ComparableUtils.lt(item, nodeItem) && node.hasLeft())
                {
                    node = node.getLeftChild();
                }
                else if (ComparableUtils.gt(item, nodeItem) && node.hasRight())
                {
                    node = node.getRightChild();
                }
            }

            if (ComparableUtils.eq(item, node.getItem()))
            {
                return node;
            }
        }

        return null;
    }

    private void add(T item, Node<T> node)
    {
        T nodeItem;

        for (nodeItem = node.getItem(); (ComparableUtils.lt(item, nodeItem) && node.hasLeft()) || (ComparableUtils.gt(item, nodeItem) && node.hasRight()); nodeItem = node.getItem())
        {
            if (ComparableUtils.lt(item, nodeItem) && node.hasLeft())
            {
                node = node.getLeftChild();
            }
            else if (ComparableUtils.gt(item, nodeItem) && node.hasRight())
            {
                node = node.getRightChild();
            }
        }

        if (ComparableUtils.lt(item, nodeItem))
        {
            if (node.hasLeft())
            {
                throw new IllegalStateException();
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
                throw new IllegalStateException();
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
        Node<T> node = find(soughtItem, rootNode);

        if (node == null)
        {
            return null;
        }
        else
        {
            T result = node.getItem();

            remove(node);

            return result;
        }
    }

    private void remove(Node<T> node)
    {
        if (node.hasLeft() || node.hasRight())
        {
            Node<T> candidate = (node.hasRight() ? getMin(node.getRightChild()) : getMax(node.getLeftChild()));
            node.setItem(candidate.getItem());
            remove(candidate);
        }
        else
        {
            Node<T> parent = node.getParent();

            if (parent != null)
            {
                if (parent.hasLeft() && ComparableUtils.eq(node.getItem(), parent.getLeftChild().getItem()))
                {
                    parent.setLeftChild(null);
                }
                else if (parent.hasRight() && ComparableUtils.eq(node.getItem(), parent.getRightChild().getItem()))
                {
                    parent.setRightChild(null);
                }

                node.setParent(null);
            }
            else
            {
                this.rootNode = null;
            }
        }
    }
}