/*
 * component:   "openEHR Reference Implementation"
 * description: "Class InstructionDetails"
 * keywords:    "composition"
 *
 * author:      "Yin Su Lim <y.lim@chime.ucl.ac.uk>"
 * support:     "CHIME, UCL"
 * copyright:   "Copyright (c) 2006 UCL, UK"
 * license:     "See notice at bottom of class"
 *
 * file:        "$URL: http://svn.openehr.org/ref_impl_java/TRUNK/libraries/src/java/org/openehr/rm/composition/content/entry/InstructionDetails.java $"
 * revision:    "$LastChangedRevision: 53 $"
 * last_change: "$LastChangedDate: 2006-08-11 13:20:08 +0100 (Fri, 11 Aug 2006) $"
 */
package org.openehr.rm.composition.content.entry;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.openehr.rm.Attribute;
import org.openehr.rm.RMObject;
import org.openehr.rm.common.archetyped.Archetyped;
import org.openehr.rm.common.archetyped.FeederAudit;
import org.openehr.rm.common.archetyped.Link;
import org.openehr.rm.common.archetyped.Locatable;
import org.openehr.rm.common.generic.Participation;
import org.openehr.rm.common.generic.PartyProxy;
import org.openehr.rm.datastructure.itemstructure.ItemStructure;
import org.openehr.rm.datatypes.quantity.datetime.DvDateTime;
import org.openehr.rm.datatypes.text.CodePhrase;
import org.openehr.rm.datatypes.text.DvText;
import org.openehr.rm.support.identification.LocatableRef;
import org.openehr.rm.support.identification.ObjectID;
import org.openehr.rm.support.identification.ObjectVersionID;
import org.openehr.rm.support.identification.ObjectRef;
import org.openehr.rm.support.terminology.TerminologyService;

/**
 * Used to record details of the Instruction causing an Action.
 *
 * @author Yin Su Lim
 * @version 1.0
 */
public class InstructionDetails extends RMObject {

	/**
	 * @param uid
	 * @param archetypeNodeId
	 * @param name
	 * @param archetypeDetails
	 * @param feederAudit
	 * @param links
	 * @param parent
	 */
	public InstructionDetails(
            @Attribute(name = "instructionID", required = true) LocatableRef instructionID,
            @Attribute(name = "activityID", required = true) String activityID,
            @Attribute(name = "wfDetails") ItemStructure wfDetails) {
		if (instructionID == null) {
			throw new IllegalArgumentException("null instructionID");
		}
		if (StringUtils.isEmpty(activityID)) {
			throw new IllegalArgumentException("null or empty activityID");
		}
		this.instructionID =instructionID;
		this.activityID = activityID;
		this.wfDetails = wfDetails;
	}

	/**
	 * Identifier of Activity within Instruction, in the form of its archetype 
	 * path.
	 * 
	 * @return activityID
	 */
	public String getActivityID() {
		return activityID;
	}

	/**
	 * Id of causing Instruction
	 * 
	 * @return instructionID
	 */
	public LocatableRef getInstructionID() {
		return instructionID;
	}

	/**
	 * Various workflow engine state details, potentially including such things as:
	 * -condition that fired to cause this Action to be done
	 * -list of notifications which actually occured
	 * -other workflow engine state
	 * 
	 * @return wfDetails
	 */
	public ItemStructure getWfDetails() {
		return wfDetails;
	}

	//POJO start
	InstructionDetails() {
	}

	void setActivityID(String activityID) {
		this.activityID = activityID;
	}

	void setInstructionID(LocatableRef instructionID) {
		this.instructionID = instructionID;
	}

	void setWfDetails(ItemStructure wfDetails) {
		this.wfDetails = wfDetails;
	}
	//POJO end
	
	/* fields */
	private LocatableRef instructionID;
	private String activityID;
	private ItemStructure wfDetails;

}

/*
 *  ***** BEGIN LICENSE BLOCK *****
 *  Version: MPL 1.1/GPL 2.0/LGPL 2.1
 *
 *  The contents of this file are subject to the Mozilla Public License Version
 *  1.1 (the 'License'); you may not use this file except in compliance with
 *  the License. You may obtain a copy of the License at
 *  http://www.mozilla.org/MPL/
 *
 *  Software distributed under the License is distributed on an 'AS IS' basis,
 *  WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 *  for the specific language governing rights and limitations under the
 *  License.
 *
 *  The Original Code is InstructionDetails.java
 *
 *  The Initial Developer of the Original Code is Yin Su Lim.
 *  Portions created by the Initial Developer are Copyright (C) 2003-2004
 *  the Initial Developer. All Rights Reserved.
 *
 *  Contributor(s):
 *
 * Software distributed under the License is distributed on an 'AS IS' basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 *  ***** END LICENSE BLOCK *****
 */