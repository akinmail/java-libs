/*
 * component:   "openEHR Reference Implementation"
 * description: "Class VersionedEHRStatus"
 * keywords:    "ehr"
 *
 * author:      "Yin Su Lim <y.lim@chime.ucl.ac.uk>"
 * support:     "CHIME, UCL"
 * copyright:   "Copyright (c) 2006 UCL, UK"
 * license:     "See notice at bottom of class"
 *
 * file:        "$URL: http://svn.openehr.org/ref_impl_java/TRUNK/libraries/src/java/org/openehr/rm/ehr/VersionedEHRStatus.java $"
 * revision:    "$LastChangedRevision: 53 $"
 * last_change: "$LastChangedDate: 2006-08-11 13:20:08 +0100 (Fri, 11 Aug 2006) $"
 */
package org.openehr.rm.ehr;

import java.util.List;
import java.util.Set;

import org.openehr.rm.Attribute;
import org.openehr.rm.FullConstructor;
import org.openehr.rm.common.archetyped.Archetyped;
import org.openehr.rm.common.archetyped.FeederAudit;
import org.openehr.rm.common.archetyped.Link;
import org.openehr.rm.common.archetyped.Locatable;
import org.openehr.rm.common.changecontrol.OriginalVersion;
import org.openehr.rm.common.changecontrol.Version;
import org.openehr.rm.common.changecontrol.VersionedObject;
import org.openehr.rm.common.directory.Folder;
import org.openehr.rm.common.generic.AuditDetails;
import org.openehr.rm.common.generic.PartySelf;
import org.openehr.rm.composition.Composition;
import org.openehr.rm.datastructure.itemstructure.ItemStructure;
import org.openehr.rm.datatypes.basic.DvState;
import org.openehr.rm.datatypes.quantity.datetime.DvDateTime;
import org.openehr.rm.datatypes.text.DvCodedText;
import org.openehr.rm.datatypes.text.DvText;
import org.openehr.rm.support.identification.HierarchicalObjectID;
import org.openehr.rm.support.identification.ObjectID;
import org.openehr.rm.support.identification.ObjectRef;
import org.openehr.rm.support.identification.ObjectVersionID;
import org.openehr.rm.support.terminology.TerminologyService;

/**
 * Versioning container for EHRStatus instance
 *
 * @author Yin Su Lim
 * @version 1.0
 */
public class VersionedEHRStatus extends VersionedObject<EHRStatus> {
	
	/**
	 * Constructs a VersionEHRStatus with first EHRStatus created locally
	 */
	public VersionedEHRStatus(HierarchicalObjectID uid, ObjectRef ownerID, 
			DvDateTime timeCreated, ObjectVersionID versionID, EHRStatus ehrStatus, 
			DvCodedText lifecycleState, AuditDetails commitAudit, 
                        ObjectRef contribution, String signature,
                        TerminologyService terminologyService) {
		
        super(uid, ownerID, timeCreated, versionID, ehrStatus, lifecycleState, commitAudit, 
        	 contribution, signature, terminologyService);
	}
	
	/**
	 * Constructs a VersionEHRStatus with first imported EHRStatus
	 */
	public VersionedEHRStatus(HierarchicalObjectID uid, ObjectRef ownerID, 
			DvDateTime timeCreated, OriginalVersion<EHRStatus> item,
                        AuditDetails commitAudit, ObjectRef contribution, 
                        String signature) {
        super(uid, ownerID, timeCreated, item, commitAudit, contribution, signature);
        
	}

	/**
	 * Constructs a VersionEHRStatus with first merged EHRStatus
	 */
	public VersionedEHRStatus(HierarchicalObjectID uid, ObjectRef ownerID, 
			DvDateTime timeCreated, ObjectVersionID versionID,   
			ObjectVersionID precedingVersionID, EHRStatus ehrStatus, DvCodedText lifecycleState, 
                        AuditDetails commitAudit, ObjectRef contribution,   			  
			Set<ObjectVersionID> otherInputVersionUids, String signature,
                        TerminologyService terminologyService) {
		
		super(uid, ownerID, timeCreated, versionID, precedingVersionID, ehrStatus, lifecycleState, 
                        commitAudit, contribution, otherInputVersionUids, signature, terminologyService);
	}
    
	//POJO start
	VersionedEHRStatus() {
	}
	
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
 *  The Original Code is VersionedEHRStatus.java
 *
 *  The Initial Developer of the Original Code is Rong Chen.
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
