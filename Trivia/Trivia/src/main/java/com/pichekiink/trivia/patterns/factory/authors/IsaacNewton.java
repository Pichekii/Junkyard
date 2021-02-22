
package com.pichekiink.trivia.patterns.factory.authors;

import com.pichekiink.trivia.patterns.factory.InspirationalQuotes;

/**
 * The {@code IsaacNewton} class displays an inspirational quote from the author.
 * 
 * @author Scott Natelli
 */
public class IsaacNewton extends InspirationalQuotes {
    
    /**
     * @var author The name of the author of the quote.
     * @var quote The inspirational quote.
     */
    final String author = "  - Isaac Newton";
    final String quote = "If I have seen further than others, it is by standing upon the shoulders of giants.";
    
    /**
     * Instantiates a {@code IsaacNewton} object.
     */
    public IsaacNewton() {
        
    }
    
    @Override
    public void getQuote() {
        System.out.println(this.quote);
        System.out.println(this.author);
    }
}
