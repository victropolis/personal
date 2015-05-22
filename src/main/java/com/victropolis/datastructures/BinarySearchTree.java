package com.victropolis.datastructures;

import com.victropolis.util.ComparableUtils;

/**
 * Created by victropolis on 5/20/15.
 */
public class BinarySearchTree<T extends Comparable<T>>
{
    private class Node<T extends Comparable<T>>
    {
        Node<T> parent;
        Node<T> leftChild;
        Node<T> rightChild;

        T item;

        Node(T item)
        {
            this.item = item;
        }

        Node(Node<T> parent, T item)
        {
            this.parent = parent;
            this.item = item;
        }

        boolean isRoot()
        {
            return parent == null;
        }
        
        boolean isLeftChild()
        {
            return !isRoot() && parent.hasLeftChild() && ComparableUtils.eq(item, parent.leftChild.item);
        }
        
        boolean isRightChild()
        {
            return !isRoot() && parent.hasRightChild() && ComparableUtils.eq(item, parent.rightChild.item);
        }
        
        boolean hasLeftChild()
        {
            return leftChild != null;
        }

        boolean hasRightChild()
        {
            return rightChild != null;
        }

        Node<T> getParent()
        {
            return parent;
        }

        void setParent(Node<T> parent)
        {
            this.parent = parent;
        }

        Node<T> getLeftChild()
        {
            return leftChild;
        }

        void setLeftChild(Node<T> leftChild)
        {
            this.leftChild = leftChild;
        }

        Node<T> getRightChild()
        {
            return rightChild;
        }

        void setRightChild(Node<T> rightChild)
        {
            this.rightChild = rightChild;
        }

        T getItem()
        {
            return item;
        }

        void setItem(T item)
        {
            this.item = item;
        }
    }

    private Node<T> rootNode;
//    private T min;
//    private T max;

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

        while (node.hasLeftChild())
        {
            node = node.getLeftChild();
        }

        return node;
    }

    private Node<T> getMax(Node<T> fromNode)
    {
        Node<T> node = fromNode;

        while (node.hasRightChild())
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

    public void add(T item)
    {
        if (item == null)
        {
            return;
        }

        if (rootNode == null)
        {
            rootNode = new Node<T>(null, item);
        }
        else
        {
            add(item, rootNode);
        }

//        if (min == null && max == null)
//        {
//            min = max = item;
//        }
//        else if (ComparableUtils.lt(item, min))
//        {
//            min = item;
//        }
//        else if (ComparableUtils.gt(item, max))
//        {
//            max = item;
//        }
    }

    private Node<T> find(T item, Node<T> node)
    {
        if (node != null)
        {
            T nodeItem;

            for (nodeItem = node.getItem(); ((ComparableUtils.lt(item, nodeItem) && node.hasLeftChild()) || (ComparableUtils.gt(item, nodeItem) && node.hasRightChild())); nodeItem = node.getItem())
            {
                if (ComparableUtils.lt(item, nodeItem) && node.hasLeftChild())
                {
                    node = node.getLeftChild();
                }
                else if (ComparableUtils.gt(item, nodeItem) && node.hasRightChild())
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

        for (nodeItem = node.getItem(); (ComparableUtils.lt(item, nodeItem) && node.hasLeftChild()) || (ComparableUtils.gt(item, nodeItem) && node.hasRightChild()); nodeItem = node.getItem())
        {
            if (ComparableUtils.lt(item, nodeItem) && node.hasLeftChild())
            {
                node = node.getLeftChild();
            }
            else if (ComparableUtils.gt(item, nodeItem) && node.hasRightChild())
            {
                node = node.getRightChild();
            }
        }

        if (ComparableUtils.lt(item, nodeItem))
        {
            if (node.hasLeftChild())
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
            if (node.hasRightChild())
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
//            if (node.isRoot())
//            {
//                min = max = null;
//            }
//            else if (node.isLeftChild() && ComparableUtils.eq(node.getItem(), min))
//            {
//                min = node.getParent().getItem();
//            }
//            else if (node.isRightChild() && ComparableUtils.eq(node.getItem(), max))
//            {
//                max = node.getParent().getItem();
//            }

            T result = node.getItem();

            remove(node);

            return result;
        }
    }

    private void remove(Node<T> node)
    {
        if (node.hasLeftChild() || node.hasRightChild())
        {
            Node<T> candidate = (node.hasRightChild() ? getMin(node.getRightChild()) : getMax(node.getLeftChild()));
            node.setItem(candidate.getItem());
            remove(candidate);
        }
        else
        {
            Node<T> parent = node.getParent();

            if (parent != null)
            {
                if (node.isLeftChild())
                {
                    parent.setLeftChild(null);
                }
                else if (node.isRightChild())
                {
                    parent.setRightChild(null);
                }

                node.setParent(null);
            }
            else
            {
                rootNode = null;
            }
        }
    }
}