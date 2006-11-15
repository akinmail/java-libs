package org.openehr.am.openehrprofile.datatypes.text;

import java.util.*;

import org.openehr.rm.support.basic.Interval;
import org.openehr.rm.support.identification.TerminologyID;

import junit.framework.TestCase;

/**
 * Simple testcase for CDvCodedText
 * 
 * @author Rong.Chen
 */
public class CDvCodedTextTest extends TestCase {

	public void testCreateFullCDvCodedText() {
		String path = "/term_definitions[en]/items[at0001]/text/";
		Interval<Integer> occurrences = new Interval<Integer>(0, 1);
		String nodeId = "at0010";
		TerminologyID terminologyId = new TerminologyID("openehr");
		List<String> codeList = new ArrayList<String>();
		codeList.add("mean");
		codeList.add("total");
		String subset = "event math function";
		String query = null;
		
		CDvCodedText constraint = new CDvCodedText(path, occurrences, 
				nodeId, terminologyId, codeList, subset, query);
		
		assertNotNull(constraint);
		assertEquals(codeList, constraint.getCodeList());		
	}
	
	public void testCreateCDvCodedTextWithSingleCode() {
		String path = "/term_definitions[en]/items[at0001]/text/";
		String terminologyId = "local";
		String code = "at0001";
		
		CDvCodedText constraint = new CDvCodedText(path, terminologyId, code);
		
		assertNotNull(constraint);
		assertTrue(constraint.getCodeList().contains(code));		
	}
	
	public void testCreateCDvCodedTextWithCodeList() {
		String path = "/term_definitions[en]/items[at0001]/text/";
		String terminologyId = "openehr";
		List<String> codeList = new ArrayList<String>();
		codeList.add("mean");
		codeList.add("total");
		
		CDvCodedText constraint = new CDvCodedText(path, terminologyId, 
				codeList);
		
		assertNotNull(constraint);
		assertEquals(codeList, constraint.getCodeList());		
	}
}
