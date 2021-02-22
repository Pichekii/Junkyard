
package com.pichekiink.acmedistributors.forms;

import com.pichekiink.acmedistributors.responses.CannedResponses;

/**
 * The {@code PriceListForm} class provides pricing information for current product inventory.
 */
public class PriceListForm implements Form {
    
    /**
     * Instantiates a {@code PriceListForm} object.
     */
    public PriceListForm() {
        
    }
    
    @Override
    public PriceListForm getInstance() {
        return new PriceListForm();
    }
    
    @Override
    public String process(String data) {
        CannedResponses cannedResponses = new CannedResponses();
        return cannedResponses.getPriceList();
    }
}
