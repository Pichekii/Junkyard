
package com.pichekiink.acmedistributors.forms;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code FormFactory} class creates an instance of the requested {@link Form} object.
 */
public class FormFactory {
    
    /**
     * @var AVAILABLE_FORMS A {@link Map} containing the available forms.
     */
    private static final Map<String, Form> AVAILABLE_FORMS = new HashMap<>();
    
    /**
     * Instantiates a {@code FormFactory} object.
     */
    public FormFactory() {
        
    }
    
    /**
     * Returns a {@link Form} object for the requested form type.
     * @param form TRhe type of form requested.
     * @return A {@link Form} object.
     */
    public final Form getInstance(String form) {
        return AVAILABLE_FORMS.get(form).getInstance();
    }
    
    /**
     * Registers a {@link Form} object with the factory.
     * @param key The name (i.e. key) for the form.
     * @param form The {@link Form} object (i.e. value).
     */
    public static final void registerForm(String key, Form form) {
        AVAILABLE_FORMS.put(key, form);
    }
}
