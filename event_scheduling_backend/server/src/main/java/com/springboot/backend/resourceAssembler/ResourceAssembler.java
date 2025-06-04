package com.springboot.backend.resourceAssembler;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.springboot.backend.entities.MainEntity;
import com.springboot.backend.resources.MainResource;

@Component
public class ResourceAssembler {
    
    private static ApplicationContext context;

    @Autowired
    void setContext(ApplicationContext context) { ResourceAssembler.context = context; }

    public static <A extends MainEntity, T extends MainResource<A>> T toResource(A entity, Class<T> resourceType, Object... args) {
        if (entity == null) return null;
        Collection<T> beans = context.getBeansOfType(resourceType).values();

        T resource = null;
        if (beans.size() == 1) {
            resource = beans.iterator().next();
        } else {
            resource = beans.stream().filter(t -> t.getClass().equals(resourceType)).findFirst().orElse(null);
        }

        resource.setArgs(args);
        resource.setEntity(entity);
        resource.initAttributes();

        return resource;
    }
}
