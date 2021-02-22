
package com.pichekiink.acmedistributors.registration;

import com.pichekiink.acmedistributors.forms.Form;
import com.pichekiink.acmedistributors.forms.FormFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The {@code FormRegistration} class registers the available forms in the
 * {@link FormFactory} class.
 */
public class FormRegistration {
    
    /**
     * @var resource Resource file containing the forms to register.
     */
    private final String resource = "form-registration.properties";
    
    /**
     * Instantiates a {@code FormRegistration} object.
     */
    public FormRegistration() {
        
    }
    
    /**
     * Registers all available forms in the {@link FormFactory} class.
     * @return Status indicating if the forms were successfully registered.
     */
    public final boolean process() {
        boolean success = true;
        Properties properties = this.loadFileContents(this.resource);
        
        if(properties.isEmpty()) {
            success = false;
        } else {
            final Set<Object> keys = properties.keySet();
            Form form = null;
            
            for(Object key : keys) {
                try {
                    form = (Form) Class.forName(properties.getProperty((String) key)).newInstance();
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                    Logger.getLogger(FormRegistration.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                FormFactory.registerForm((String) key, form);
            }
        }
        
        return success;
    }
    
    /**
     * Returns a {@link Properties} object containing the contents of the resource file.
     * @param file The resource file to load.
     * @return A {@link Properties} object containing the contents of the resource file.
     */
    private Properties loadFileContents(String file) {
        Properties properties = new Properties();
        Path path = null;
        
        try {
            path = Paths.get(this.getClass().getResource(file).toURI());
            BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            properties.load(reader);
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(FormRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return properties;
    }
}
