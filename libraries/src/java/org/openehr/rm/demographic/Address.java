/*
 * component:   "openEHR Reference Implementation"
 * description: "Class Attestation"
 * keywords:    "demographic"
 *
 * author:      "Goran Pestana <goran@acode.se>"
 * support:     "Acode HB <support@acode.se>"
 * copyright:   "Copyright (c) 2005 Acode HB, Sweden"
 * license:     "See notice at bottom of class"
 *
 * file:        "$URL$"
 * revision:    "$LastChangedRevision$"
 * last_change: "$LastChangedDate$"
 */
package org.openehr.rm.demographic;

import org.openehr.rm.common.archetyped.Locatable;
import org.openehr.rm.common.archetyped.Archetyped;
import org.openehr.rm.common.archetyped.FeederAudit;
import org.openehr.rm.common.archetyped.Link;
import org.openehr.rm.support.identification.ObjectID;
import org.openehr.rm.datastructure.itemstructure.ItemStructure;
import org.openehr.rm.datatypes.text.DvText;
import org.openehr.rm.FullConstructor;
import org.openehr.rm.Attribute;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

import java.util.Set;

/**
 * Address of contact, which may be electronic or geographic.
 *
 * @author Goran Pestana
 * @version 1.0
 */

public class Address extends Locatable {

    protected Address() {
    }

    /**
     * Constructs a Address
     *
     * @param uid              null if not specified
     * @param archetypeNodeId
     * @param name
     * @param archetypeDetails null if not specified
     * @param feederAudit      null if not specified
     * @param links            null if not specified
     * @throws IllegalArgumentException if name null, or archetypeNodeId null,
     *                                  or links not null and empty,
     *                                  or details null
     */
    @FullConstructor
            public Address(@Attribute(name = "uid") ObjectID uid,
                           @Attribute(name = "archetypeNodeId", required = true) String archetypeNodeId,
                           @Attribute(name = "name", required = true) DvText name,
                           @Attribute(name = "archetypeDetails") Archetyped archetypeDetails,
                           @Attribute(name = "feederAudit") FeederAudit feederAudit,
                           @Attribute(name = "links") Set<Link> links,
                           @Attribute(name = "details", required = true) ItemStructure details) {
        super(uid, archetypeNodeId, name, archetypeDetails, feederAudit, links);
        if (details == null) {
            throw new IllegalArgumentException("null details");
        }
        this.details = details;
    }

    /**
     * Return true if the path is valid with respect to the current
     * item.
     *
     * @param path
     * @return true if valid
     */
    public boolean validPath(String path) {
        try {
            itemAtPath(path);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * The item at a path that is relative to this item.
     *
     * @param path
     * @return relative path
     * @throws IllegalArgumentException if path invalid
     */
    public Locatable itemAtPath(String path) {
        Locatable ret = super.itemAtPath(path);
        if (ret != null) {
            return ret;
        }
        String whole = whole();
        String tmp = path;
        if (tmp.startsWith(whole)) {
            tmp = tmp.substring(whole.length());
        }
        ret = checkAttribute(tmp, "details", details);
        if (ret == null) {
            throw new IllegalArgumentException("invalid path: " + path);
        }
        return ret;
    }

    public String pathOfItem(Locatable item) {
        //todo: to be implemented
        return null;
    }

    /**
     * Type of address, eg electronic, locality.
     * Taken from value of inherited name attribute.
     *
     * @return type of relationship
     */
    public DvText type() {
        return this.getName();
    }

    /**
     * Return the type of the relationship as string
     *
     * @return type of relationship
     */
    public String toString() {
        // todo: fix it
        return "";
    }

    /**
     * The details of the address, in the form of a STRUCTURE. This may take
     * the form of a SINGLE_S, whose data item is a parsable string or a list
     * or tree of many parts.
     *
     * @return details
     */
    public ItemStructure getDetails() {
        return details;
    }

    protected void setDetails(ItemStructure details) {
        this.details = details;
    }

    /**
     * Equals if two address has same values
     *
     * @param o
     * @return equals if true
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!( o instanceof Address )) return false;
        if (!super.equals(o)) return false;

        final Address address = (Address) o;
        return new EqualsBuilder()
            .appendSuper(super.equals(o))
            .append(details, address.details)
            .isEquals();
    }

    /**
     * Return a hash code of this object
     *
     * @return hash code
     */
    public int hashCode() {
        return new HashCodeBuilder(13, 29)
            .appendSuper(super.hashCode())
            .append(details)
            .toHashCode();
    }

    /* fields */
    private ItemStructure details;
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
 *  The Original Code is Address.java
 *
 *  The Initial Developer of the Original Code is Goran Pestana.
 *  Portions created by the Initial Developer are Copyright (C) 2003-2005
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