
package com.pichekiink.trivia.patterns.factory;

import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * The {@code InspirationalFactoryTest} class tests the {@link InspirationFactory} enum,
 * and its ability to instantiate descendants of the {@link InspirationalQuotes} class.
 * 
 * @author Scott
 */
public class InspirationalFactoryTest {
    
    private final org.slf4j.Logger LOG = LoggerFactory.getLogger(this.getClass());
    
    /**
     * Sets up any resources before executing the tests.
     */
    @BeforeClass
    public void setUp() {
        this.LOG.info("Beginning tests in: {}", this.getClass());
    }
    
    /**
     * Clean up any resources used by the tests.
     */
    @AfterClass
    public void tearDown() {
        this.LOG.info("Finished all tests in: {}", this.getClass());
    }
    
    /**
     * Demonstrates that the factory instantiates the {@link AlexanderTheGreat} class.
     */
    @Test
    public void getAlexanderTheGreatQuote() {
        InspirationalQuotes inspiration = null;
        
        try {
            inspiration = InspirationFactory.ALEXANDER_THE_GREAT.instantiate();
        } catch (InstantiationException | IllegalAccessException ex) {
            this.LOG.error("An error occurred instantiating the class.", ex);
        }
        
        inspiration.getQuote();
        System.out.println();
    }
    
    /**
     * Demonstrates that the factory instantiates the {@link IsaacNewton} class.
     */
    @Test
    public void getIsaacNewtonQuote() {
        InspirationalQuotes inspiration = null;
        
        try {
            inspiration = InspirationFactory.ISAAC_NEWTON.instantiate();
        } catch (InstantiationException | IllegalAccessException ex) {
            this.LOG.error("An error occurred instantiating the class.", ex);
        }
        
        inspiration.getQuote();
        System.out.println();
    }
    
    /**
     * Demonstrates that the factory instantiates the {@link WilliamShakespeare} class.
     */
    @Test
    public void getWilliamShakespeareQuote() {
        InspirationalQuotes inspiration = null;
        
        try {
            inspiration = InspirationFactory.WILLIAM_SHAKESPEARE.instantiate();
        } catch (InstantiationException | IllegalAccessException ex) {
            this.LOG.error("An error occurred instantiating the class.", ex);
        }
        
        inspiration.getQuote();
        System.out.println();
    }
}
