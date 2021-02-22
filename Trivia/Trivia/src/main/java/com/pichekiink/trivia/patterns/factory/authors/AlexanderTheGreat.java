
package com.pichekiink.trivia.patterns.factory.authors;

import com.pichekiink.trivia.patterns.factory.InspirationalQuotes;

/**
 * The {@code AlexanderTheGreat} class displays an inspirational quote from the author.
 * 
 * @author Scott Natelli
 */
public class AlexanderTheGreat extends InspirationalQuotes {
    
    /**
     * @var author The name of the author of the quote.
     * @var quote The inspirational quote.
     */
    final String author = "  - Alexander The Great";
    final String quote = "There is nothing impossible to him who will try.";
    
    /**
     * Instantiates a {@code AlexanderTheGreat} object.
     */
    public AlexanderTheGreat() {
        
    }
    
    @Override
    public void getQuote() {
        System.out.println(this.quote);
        System.out.println(this.author);
    }
}
