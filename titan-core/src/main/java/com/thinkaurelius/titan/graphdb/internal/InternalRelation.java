package com.thinkaurelius.titan.graphdb.internal;

import com.thinkaurelius.titan.core.RelationType;
import com.thinkaurelius.titan.core.TitanRelation;

/**
 * Internal Relation interface adding methods that should only be used by Titan.
 *
 * The "direct" qualifier in the method names indicates that the corresponding action is executed on this relation
 * object and not migrated to a different transactional context. It also means that access returns the "raw" value of
 * what is stored on this relation
 *
 * @author Matthias Broecheler (me@matthiasb.com)
 */
public interface InternalRelation extends TitanRelation, InternalElement {

    /**
     * Returns this relation in the current transactional context
     *
     * @return
     */
    public InternalRelation it();

    /**
     * Returns the vertex at the given position (0=OUT, 1=IN) of this relation
     * @param pos
     * @return
     */
    public InternalVertex getVertex(int pos);

    /**
     * Number of vertices on this relation.
     *
     * @return
     */
    public int getArity();

    /**
     * Number of vertices on this relation that are aware of its existence. This number will
     * differ from {@link #getArity()}
     *
     */
    public int getLen();



    public <O> O getValueDirect(RelationType type);

    public void setPropertyDirect(RelationType type, Object value);

    public Iterable<RelationType> getPropertyKeysDirect();

    public <O> O removePropertyDirect(RelationType type);

}