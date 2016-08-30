/**
 * 
 */
package com.mycompany.mockito.reference.documentation.tutorial;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnit44Runner;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.mockito.verification.VerificationMode;

import com.mycompany.mockito.reference.documentation.tutorial.bdd.Seller;
import com.mycompany.mockito.reference.documentation.tutorial.bdd.Shop;
import com.mycompany.mockito.reference.documentation.tutorial.model.*;
import com.mycompany.mockito.reference.documentation.tutorial.model.RemoteControl.SmartRemoteControl;

import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;
import static org.junit.Assert.*;


/**
 * Test Example class for the Mockito Documentation Reference
 * Trying out all the Mockito features as defined in the Documentation Reference
 * 
 * @author colin
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoDocumentationTest {

	private List<String> mockedList = null;
	
	/* Section 9 of Documentation Reference */
	@Mock
	private List<String> mockedList1;
	
	@Mock
	private List<String> mockedList2;
	
	@Mock
	private List<String> mockedList3;
	
	@Mock
	private Car carMock;
	
	@Mock
	private Flat flatMock;
	
	@Mock
	private RemoteControl remoteControlMock;
	/* Section 9 of Documentation Reference */
	
	
	@InjectMocks // will inject other mocks (defined above that this mock requires)
	private Television televisionMock;
	
	@Spy 
	private Person personMock;
	
	Scenario scenario = new Scenario();
	
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp(){
		
		// setup mock
		mockedList = mock(List.class);
		
		MockitoAnnotations.initMocks(this);
	}
	
	/**
	 * Mockito Documentation - Section 1
	 */
	@Test
	public void testVerifySomeBehaviour(){
		
		// using the mock
		mockedList.add("one");
		mockedList.add("two");
		mockedList.clear();
		
		//verification
		verify(mockedList).add("one");
		verify(mockedList).add("two");
		//verify(mockedList).add("three");// this should fail!
		verify(mockedList).clear();
		
	}
	
	/**
	 * Mockito Documentation - Section 2
	 */
	@Test(expected=RuntimeException.class)
	public void testStubbing(){
		
		@SuppressWarnings("unchecked")
		LinkedList<String> mockedLinkedList = mock(LinkedList.class);
		
		when(mockedLinkedList.get(0)).thenReturn("First");
		when(mockedLinkedList.get(1)).thenThrow(new RuntimeException("RuntimeException"));
		
		System.out.println(mockedLinkedList.get(0));
		System.out.println(mockedLinkedList.get(1));
		System.out.println(mockedLinkedList.get(999)); //get(999) not stubbed
		
	}
	
	/**
	 * Mockito Documentation - Section 3
	 */
	@Test
	public void testArgumentMatchers(){
		
		// stubbing using anyInt() matcher
		when(mockedList.get(anyInt())).thenReturn("Element");
		
		assertEquals("Element", mockedList.get(999));
		
		verify(mockedList).get(anyInt());
		
	}
	
	/**
	 * Mockito Documentation - Section 4
	 */
	@Test
	public void testVerifyingExactNumberOfInvocations(){
		
		mockedList.add("once");
		
		mockedList.add("twice");
		mockedList.add("twice");
		
		mockedList.add("three times");
		mockedList.add("three times");
		mockedList.add("three times");
		
		verify(mockedList).add("once");
		verify(mockedList, times(1)).add("once");
		
		verify(mockedList, times(2)).add("twice"); 			// invoked 2 times
		verify(mockedList, times(3)).add("three times"); 	// invoked 3 times
		
		verify(mockedList, never()).add("four times");
		verify(mockedList, times(0)).add("never happened");
		
		verify(mockedList, atLeastOnce()).add("three times");
		verify(mockedList, atLeast(3)).add("five times");
		verify(mockedList, atMost(5)).add("three times");
		
	}
	
	/**
	 * Mockito Documentation - Section 5
	 */
	@Test
	public void testStubbingVoidMethods(){
		
		doThrow(new RuntimeException("Throwing RuntimeException")).when(mockedList).clear();
		
		mockedList.clear(); // this will throw RuntimeException
		
	}
	
	/**
	 * Mockito Documentation - Section 6
	 */
	@Test
	public void testVerificationInOrder(){
		
		@SuppressWarnings("unchecked")
		List<Integer> singleMock = mock(List.class);
		
		singleMock.add(10);
		singleMock.add(20);
		
		// this creates an 'inOrder' verifier for the mock
		InOrder inOrder = inOrder(singleMock);
		
		// makes sure the add(10) was called first
		// then add(20) was then called
		// so will pass
		inOrder.verify(singleMock).add(10);
		inOrder.verify(singleMock).add(20);
		
		// multiple mocks that must be 'used' in a particular order
		@SuppressWarnings("unchecked")
		List<Double> firstMock = mock(List.class);
		@SuppressWarnings("unchecked")
		List<Double> secondMock = mock(List.class);
		
		// just using those mocks
		firstMock.add(2.3);
		secondMock.add(9.9);
		
		InOrder inOrderMocks = inOrder(firstMock, secondMock);
		
		// verifies that the first mock is used first
		inOrderMocks.verify(firstMock).add(2.3);
		inOrderMocks.verify(secondMock).add(9.9);
		
		
	}
	
	/**
	 * Mockito Documentation - Section 7
	 */
	@Test
	public void testVerifyInteractionsNeverHappened(){
		
		@SuppressWarnings("unchecked")
		List<String> mockOne = mock(List.class);
		@SuppressWarnings("unchecked")
		List<String> mockTwo = mock(List.class);
		@SuppressWarnings("unchecked")
		List<String> mockThree = mock(List.class);
		
		mockOne.add("one");
		
		verify(mockOne).add("one");
		
		verify(mockOne, never()).add("two"); // verifies that add("two") never got stubbed
		
		// verifies that the other 2 mocks were not interacted at all
		verifyZeroInteractions(mockTwo, mockThree);
		
	}
	
	/**
	 * Mockito Documentation - Section 8
	 */
	@Test
	public void testFindingRedundantInvocations(){
		
		mockedList.add("one");
		mockedList.add("two");
		
		verify(mockedList).add("one");
		
		// this will fail! - because of line 198 above
		verifyNoMoreInteractions(mockedList);
		
	}
	
	/**
	 * Mockito Documentation - Section 9
	 */
	@Test
	public void testShorthandForMocksCreation(){
		
		// see start of file
		//fail("nothing to implement - default will fail");
	}
	
	/**
	 * Mockito Documentation - Section 10
	 */
	@Test
	public void testStubbingConsecutiveCalls(){
		
		when(mockedList.get(0))
			.thenThrow(new RuntimeException()) // uncomment this for throwing RuntimeException
			.thenReturn("two");
		
		// this should throw RuntimeException
		mockedList.get(0);
		
		// this should return "two"
		mockedList.get(0);
		
		// still return "two"
		mockedList.get(0);
		
		when(carMock.getGears()).thenReturn(8);
		assertEquals(8, carMock.getGears());
		
		/*
		 * An alternative version of above
		 */
		
		when(mockedList.get(1))
			.thenReturn("one", "two", "three", "four", "five");
		
	}
	
	/**
	 * Mockito Documentation - Section 11
	 */
	@Test
	public void testStubbingWithCallbacks(){
		
		ClassToBeMocked mock = mock(ClassToBeMocked.class);
		
		when(mock.someMethod(anyString())).thenAnswer(new Answer<Object>() {

			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				Object[] args = invocation.getArguments();
				Object mock = invocation.getMock();
				return "called with arguments: " + args;
			}
		});
		
		System.out.println(mock.someMethod("Foo"));
		
	}
	
	/**
	 * Mockito Documentation - Section 12
	 */
	@Test
	public void testDoFamilyOfMethods(){
		
		
		/*
		 * doReturn()
		 * doThrow()
		 * doAnswer()
		 * doNothing()
		 * doCallRealMethod()
		 */
		
		doThrow(new RuntimeException()).when(mockedList).clear();
		
		doNothing().when(remoteControlMock).putToStandby();
		
		doCallRealMethod().when(remoteControlMock).switchOn();
		doCallRealMethod().when(remoteControlMock).switchOff();
		
		doReturn(0).when(remoteControlMock).mute();
		
		// will throw RuntimeException
		mockedList.clear();
		
	}
	
	/**
	 * Mockito Documentation - Section 13
	 */
	@Test
	public void testSpyingOnRealObjects(){
		
		List<String> list = new LinkedList<String>();
		List<String> spy = spy(list);
		
		// (optionally) can stub methods
		when(spy.size()).thenReturn(100);
		
		// these call *real* methods
		spy.add("one");
		spy.add("two");
		
		assertEquals("one", spy.get(0));
		
		assertEquals(100, spy.size());
		
		// (optionally) can verify too
		verify(spy).add("one");
		verify(spy).add("two");
		
		// this is impossible: because real method is called
		// so will throw indexoutofboundsexception
		when(spy.get(10)).thenReturn("ten");
		
		// this is possible : a replacement for above
		// stubbing
		doReturn("10").when(spy).get(10);
	}
	
	/**
	 * Mockito Documentation - Section 14
	 */
	@Test
	public void testChangingDefaultValuesOfUnstubbedInvocations(){
		
		// Creates a mock with a specified strategy for return values
		
		Foo mock = mock(Foo.class, Mockito.RETURNS_SMART_NULLS);
		Foo mockTwo = mock(Foo.class, new YourOwnAnswer());
		
		// this passes
		// method is unstubbed so will return default as specified by Answer
		assertEquals("ANSWER", mockTwo.getModifiedName("Bar"));
		
	}
	
	/**
	 * Mockito Documentation - Section 15
	 */
	@Test
	public void testCapturingArgumentsForFurtherAssertions(){
		
	}
	
	/**
	 * Mockito Documentation - Section 16
	 */
	@Test
	public void testReadPartialMocks(){
		
		/*
		 * Partial Mock == Spy
		 */
		
		// Partial mock
		List<String> list = spy(new LinkedList<String>());
		
		// Create the mock - just like a normal mock
		UserService userServiceMock = mock(UserServiceImpl.class);
		
		// this makes the mock act as 'Partial Mock' i.e. Spy
		// because it calls the *real* method
		when(userServiceMock.getUserNameByUserId(anyInt())).thenCallRealMethod();
		
		
	}
	
	/**
	 * Mockito Documentation - Section 17
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testResettingMocks(){
		
		List<Integer> mock = mock(List.class);
		
		when(mock.size()).thenReturn(10);
		mock.add(20);
		
		reset(mock);
		// at this point the mock forgot all previous interactions
		
		// this should fail!
		verify(mock).add(20);
	}
	
	/**
	 * Mockito Documentation - Section 18
	 */
	@Test
	public void testTroubleShootingAndValidatingFrameworkUsage(){
		
		//when(carMock.getGear()).thenReturn(3);
		//carMock.getGear();
		verify(carMock);//.getGear(); 				// missing method to verify
		verify(personMock.getName()); 	// should be verify(personMock).getName();
		when(flatMock.getAddress()); 	// missing return bit
		
		validateMockitoUsage(); // don't need as Mockito does it all the time
	}
	
	/**
	 * Mockito Documentation - Section 19
	 */
	@Test
	public void testAliasesForBDD(){
		
		Seller seller = mock(Seller.class);
		Shop shop = new Shop(seller);
		
	}
	
	/**
	 * Mockito Documentation - Section 20
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSerializableMocks(){
		
		List<String> serializableMock = mock(List.class, withSettings().serializable());
		
		// making a spy serializable
		
		List<Object> list = new ArrayList<Object>();
		List<Object> spy = mock(ArrayList.class, withSettings()
										.spiedInstance(list)
										.defaultAnswer(CALLS_REAL_METHODS)
										.serializable());
		
	}
	
	/**
	 * Mockito Documentation - Section 21
	 */
	@Test
	public void testNewAnnotationsCaptorSpyInjectMocks(){
		
		// see start of file
		
	}
	
	/**
	 * Mockito Documentation - Section 22
	 */
	@Test
	public void testVerificationWithTimeout(){
		
		ClassToBeMocked mock = mock(ClassToBeMocked.class);
		
		verify(mock, timeout(2000)).someMethod(anyString());
		
		verify(mock, timeout(2000).times(1)).someMethod(anyString());
		
		verify(mock, timeout(2000).times(2)).someMethod(anyString());
		
		verify(mock, timeout(2000).atLeast(2)).someMethod(anyString());
		
		
	}
	
	/**
	 * Mockito Documentation - Section 23
	 */
	@Test
	public void testAutomaticInstantiationOfSpiesInjectMocksAndConstrucorInjectionGoodness(){
		
		/*
		 * See start of code file
		 */
	}
	
	/**
	 * Mockito Documentation - Section 24
	 */
	@Test
	public void testOneLineStubs(){
		
		// creation of mock + stubbing in one line
		List<String> listMock = when(mock(List.class).size()).thenReturn(200).getMock();
		
		// verify above worked!
		verify(listMock).size();
		
	}
	
	/**
	 * Mockito Documentation - Section 25
	 */
	@Test
	public void testVerifyIgnoringStubs(){
		
		verify(mockedList1).add("one");
		verify(mockedList2).add("two");
		
		// ignores all stubbed methods
		verifyNoMoreInteractions(ignoreStubs(mockedList1, mockedList2));
		
		InOrder inOrder = inOrder(ignoreStubs(mockedList1, mockedList2));
		inOrder.verify(mockedList1).add("mockedList1 added one");
		inOrder.verify(mockedList1).add("mockedList2 added one");
		inOrder.verifyNoMoreInteractions();
	}
	
	/**
	 * Mockito Documentation - Section 26
	 */
	@Test
	public void testMockingDetails(){
		
		assertTrue(mockingDetails(mockedList).isMock());
		assertTrue(mockingDetails(mockedList).isSpy());
		
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> spyList = spy(list);
		
		assertTrue(mockingDetails(spyList).isSpy());
		
		
	}
	
	/**
	 * Mockito Documentation - Section 27
	 */
	@Test
	public void testDelegateCallsToRealInstance(){
		
	}
	
	/**
	 * Mockito Documentation - Section 28
	 */
	@Test
	public void testMockMakerAPI(){
		/*
		 * See MockMaker docs
		 */
	}
	
	/**
	 * Mockito Documentation - Section 29
	 */
	@Test
	public void testNewBDDStyleVerification(){
	
	}
	
	/**
	 * Mockito Documentation - Section 30
	 */
	@Test
	public void testNewSpyingOrMockingAbstractClass(){
		
		House spyHouse = spy(House.class);
		
		// robust API - via settings builder
		Individual spyIndividual = mock(Individual.class, withSettings()
				.useConstructor().defaultAnswer(CALLS_REAL_METHODS));
		
		SmartRemoteControl spySmartRemoteControl = mock(SmartRemoteControl.class, withSettings()
				.useConstructor().outerInstance(remoteControlMock).defaultAnswer(CALLS_REAL_METHODS));
		
	}
	
	
	
	
	
	
	
	
	
}
