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

        T value;

        Node(T value)
        {
            this.value = value;
        }

        Node(Node<T> parent, T value)
        {
            this.parent = parent;
            this.value = value;
        }

        boolean isRoot()
        {
            return parent == null;
        }
        
        boolean isLeftChild()
        {
            return !isRoot() && parent.hasLeftChild() && ComparableUtils.eq(value, parent.leftChild.value);
        }
        
        boolean isRightChild()
        {
            return !isRoot() && parent.hasRightChild() && ComparableUtils.eq(value, parent.rightChild.value);
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

        T getValue()
        {
            return value;
        }

        void setValue(T value)
        {
            this.value = value;
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
        if (rootNode == null)
        {
            return null;
        }

        return getMax(rootNode).getValue();
    }

    public T getMin()
    {
        if (rootNode == null)
        {
            return null;
        }

        return getMin(rootNode).getValue();
    }

    private Node<T> getMin(Node<T> startingFrom)
    {
        Node<T> node;

        for (node = startingFrom; node.hasLeftChild(); node = node.getLeftChild());

        return node;
    }

    private Node<T> getMax(Node<T> startingFrom)
    {
        Node<T> node;

        for (node = startingFrom; node.hasRightChild(); node = node.getRightChild());

        return node;
    }

    public T find(T soughtValue)
    {
        Node<T> node = find(soughtValue, rootNode);
        return node == null ? null : node.getValue();
    }

    public void add(T value)
    {
        if (value == null)
        {
            return;
        }

        if (rootNode == null)
        {
            rootNode = new Node<T>(null, value);
        }
        else
        {
            add(value, rootNode);
        }
    }

    private Node<T> find(T soughtValue, Node<T> currentNode)
    {
        if (currentNode == null)
        {
            return null;
        }

        T currentNodeValue;

        for (currentNodeValue = currentNode.getValue(); ((ComparableUtils.lt(soughtValue, currentNodeValue) && currentNode.hasLeftChild()) || (ComparableUtils.gt(soughtValue, currentNodeValue) && currentNode.hasRightChild())); currentNodeValue = currentNode.getValue())
        {
            if (ComparableUtils.lt(soughtValue, currentNodeValue) && currentNode.hasLeftChild())
            {
                currentNode = currentNode.getLeftChild();
            }
            else if (ComparableUtils.gt(soughtValue, currentNodeValue) && currentNode.hasRightChild())
            {
                currentNode = currentNode.getRightChild();
            }
        }

        if (ComparableUtils.eq(soughtValue, currentNode.getValue()))
        {
            return currentNode;
        }

        return null;
    }

    private void add(T value, Node<T> currentNode)
    {
        T currentNodeValue;

        for (currentNodeValue = currentNode.getValue(); (ComparableUtils.lt(value, currentNodeValue) && currentNode.hasLeftChild()) || (ComparableUtils.gt(value, currentNodeValue) && currentNode.hasRightChild()); currentNodeValue = currentNode.getValue())
        {
            if (ComparableUtils.lt(value, currentNodeValue) && currentNode.hasLeftChild())
            {
                currentNode = currentNode.getLeftChild();
            }
            else if (ComparableUtils.gt(value, currentNodeValue) && currentNode.hasRightChild())
            {
                currentNode = currentNode.getRightChild();
            }
        }

        if (ComparableUtils.lt(value, currentNodeValue))
        {
            assert !currentNode.hasLeftChild();

            currentNode.setLeftChild(new Node<T>(currentNode, value));
        }
        else if (ComparableUtils.gt(value, currentNodeValue))
        {
            assert !currentNode.hasRightChild();

            currentNode.setRightChild(new Node<T>(currentNode, value));
        }
        else if (ComparableUtils.eq(value, currentNodeValue))
        {
            currentNode.setValue(value);
        }
    }

    public T remove(T value)
    {
        Node<T> node = find(value, rootNode);

        if (node == null)
        {
            return null;
        }

        T result = node.getValue();

        remove(node);

        return result;
    }

    private void remove(Node<T> node)
    {
        if (node.hasLeftChild() || node.hasRightChild())
        {
            Node<T> valuePromotionCandidate = (node.hasRightChild() ? getMin(node.getRightChild()) : getMax(node.getLeftChild()));
            node.setValue(valuePromotionCandidate.getValue());
            remove(valuePromotionCandidate);
        }
        else
        {
            if (node.isRoot())
            {
                rootNode = null;
            }
            else
            {
                Node<T> parent = node.getParent();

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
        }
    }
}