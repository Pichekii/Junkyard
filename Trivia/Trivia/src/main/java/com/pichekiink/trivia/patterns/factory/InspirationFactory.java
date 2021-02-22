
package com.pichekiink.trivia.patterns.factory;

import com.pichekiink.trivia.patterns.factory.authors.IsaacNewton;
import com.pichekiink.trivia.patterns.factory.authors.AlexanderTheGreat;
import com.pichekiink.trivia.patterns.factory.authors.WilliamShakespeare;

/**
 * The {@code InspirationFactory} instantiates a descendant of the {@link InspirationalQuotes} class.
 * 
 * @author Scott Natelli
 */
public enum InspirationFactory {
    
    ALEXANDER_THE_GREAT(AlexanderTheGreat.class),
    ISAAC_NEWTON(IsaacNewton.class),
    WILLIAM_SHAKESPEARE(WilliamShakespeare.class);
    
    /**
     * @var inspiration A descendant of the {@code InspirationalQuotes} class.
     */
    private final Class<? extends InspirationalQuotes> inspiration;
    
    /**
     * Instantiates an {@code InspirationFactory} object provided a {@code InspirationalQuotes} object.
     * @param inspiration 
     */
    private InspirationFactory(Class<? extends InspirationalQuotes> inspiration) {
        this.inspiration = inspiration;
    }
    
    /**
     * Returns an instance of the {@code InspirationalQuotes} class.
     * @return An instance of the {@code InspirationalQuotes} class.
     * @throws InstantiationException
     * @throws IllegalAccessException 
     */
    public InspirationalQuotes instantiate() throws InstantiationException, IllegalAccessException {
        return this.inspiration.newInstance();
    }
}
