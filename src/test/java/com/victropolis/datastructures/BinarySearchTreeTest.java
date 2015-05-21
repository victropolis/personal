package com.victropolis.datastructures;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;
import java.util.Random;

/** 
* BinarySearchTree Tester. 
* 
* @author <Authors name> 
* @since <pre>May 20, 2015</pre> 
* @version 1.0 
*/ 
public class BinarySearchTreeTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getMax() 
* 
*/ 
@Test
public void testGetMax() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getMin() 
* 
*/ 
@Test
public void testGetMin() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: find(T soughtItem) 
* 
*/ 
@Test
public void testFind() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: add(T soughtItem) 
* 
*/ 
@Test
public void testAdd() throws Exception {
   Random random = new Random();

   ArrayList<Integer> integers = new ArrayList<Integer>();

   for (int x = 0; x < 1000000; x++)
   {
      integers.add(Float.valueOf(random.nextFloat() * Integer.MAX_VALUE).intValue());
   }

   BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();

   for (Integer integer : integers)
   {
      binarySearchTree.add(integer);
   }

   for (Integer integer : integers)
   {
      Assert.assertNotNull(binarySearchTree.find(integer));
   }
}

/** 
* 
* Method: remove(T soughtItem) 
* 
*/ 
@Test
public void testRemove() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: hasLeft() 
* 
*/ 
@Test
public void testHasLeft() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: hasRight() 
* 
*/ 
@Test
public void testHasRight() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getParent() 
* 
*/ 
@Test
public void testGetParent() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setParent(Node<T> parent) 
* 
*/ 
@Test
public void testSetParent() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getLeftChild() 
* 
*/ 
@Test
public void testGetLeftChild() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setLeftChild(Node<T> leftChild) 
* 
*/ 
@Test
public void testSetLeftChild() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getRightChild() 
* 
*/ 
@Test
public void testGetRightChild() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setRightChild(Node<T> rightChild) 
* 
*/ 
@Test
public void testSetRightChild() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getItem() 
* 
*/ 
@Test
public void testGetItem() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setItem(T item) 
* 
*/ 
@Test
public void testSetItem() throws Exception { 
//TODO: Test goes here... 
} 





} 
