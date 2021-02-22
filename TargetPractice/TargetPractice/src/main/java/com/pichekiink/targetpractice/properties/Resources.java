
package com.pichekiink.targetpractice.properties;

import com.pichekiink.targetpractice.points.PointCoordinate;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * The {@code Resources} enum retrieves the contents of the properties files
 * for the program.
 * <br />
 * This class is not used in the application after adding support for the CLI flags.
 */
public enum Resources {
    
    SHOTS_FIRED("shots-fired.txt"),
    TARGETS("targets.properties");
    
    private final String resource;
    
    /**
     * Instantiates a {code Resources} object provided the name of a resource file.
     * @param resource The name of the resource file.
     */
    private Resources(String resource) {
        this.resource = resource;
    }
    
    /**
     * Returns a {@code Properties} object containing the point coordinates for two targets.
     * @return The point coordinates for the two targets.
     * @throws IOException 
     */
    public Properties getTargets() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = this.getClass().getResourceAsStream(this.resource);
        properties.load(inputStream);
        
        return properties;
    }
    
    /**
     * Returns a {@code List} of {@code PointCoordinate} objects of the shots fired.
     * @return A {@code List} of {@code PointCoordinate} objects.
     * @throws URISyntaxException
     * @throws IOException 
     */
    public List<PointCoordinate> getShotsFired() throws URISyntaxException, IOException {
        List<PointCoordinate> shotsFired = new LinkedList<>();
        
        Path path = Paths.get(this.getClass().getResource(this.resource).toURI());
        BufferedReader reader = Files.newBufferedReader(path);
        String line = null;
        
        while((line = reader.readLine()) != null) {
            shotsFired.add(new PointCoordinate(line));
        }
        
        return shotsFired;
    }
}
