
package com.pichekiink.acmedistributors.forms;

import com.pichekiink.acmedistributors.responses.CannedResponses;

/**
 * The {@code ReplenishmentForm} class submits request for re-stocking inventory.
 */
public class ReplenishmentForm implements Form {
    
    /**
     * Instantiates a {@code ReplenishmentForm} object.
     */
    public ReplenishmentForm() {
        
    }
    
    @Override
    public ReplenishmentForm getInstance() {
        return new ReplenishmentForm();
    }
    
    @Override
    public String process(String data) {
        CannedResponses cannedResponses = new CannedResponses();
        return cannedResponses.getReplenishment();
    }
}
