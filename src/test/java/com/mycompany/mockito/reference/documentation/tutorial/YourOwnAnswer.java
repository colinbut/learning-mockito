/**
 * 
 */
package com.mycompany.mockito.reference.documentation.tutorial;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 * @author colin
 *
 */
public class YourOwnAnswer implements Answer<Object>{

	/*
	 * (non-Javadoc)
	 * @see org.mockito.stubbing.Answer#answer(org.mockito.invocation.InvocationOnMock)
	 */
	@Override
	public String answer(InvocationOnMock invocation) throws Throwable {
		return "ANSWER";
	}

}
