
package com.pichekiink.trivia.patterns.factory.authors;

import com.pichekiink.trivia.patterns.factory.InspirationalQuotes;

/**
 * The {@code WilliamShakespeare} class displays an inspirational quote from the author.
 * 
 * @author Scott Natelli
 */
public class WilliamShakespeare extends InspirationalQuotes {
    
    /**
     * @var author The name of the author of the quote.
     * @var quote The inspirational quote.
     */
    final String author = "  - William Shakespeare";
    final String quote = "We know not what we are, but know not what we may be.";
    
    /**
     * Instantiates a {@code WilliamShakespeare} object.
     */
    public WilliamShakespeare() {
        
    }
    
    @Override
    public void getQuote() {
        System.out.println(this.quote);
        System.out.println(this.author);
    }
}
