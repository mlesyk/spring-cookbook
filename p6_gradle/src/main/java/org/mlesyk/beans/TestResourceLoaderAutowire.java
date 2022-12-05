package org.mlesyk.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class TestResourceLoaderAutowire {
    private ResourceLoader resourceLoader;

    @Autowired
    public TestResourceLoaderAutowire(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
