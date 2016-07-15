package com.phoenixnap.oss.ramlapisync.raml.jrp.raml08v1;

import com.phoenixnap.oss.ramlapisync.raml.RamlAction;
import com.phoenixnap.oss.ramlapisync.raml.RamlModelEmitter;
import com.phoenixnap.oss.ramlapisync.raml.RamlModelFactory;
import com.phoenixnap.oss.ramlapisync.raml.RamlResource;
import com.phoenixnap.oss.ramlapisync.raml.RamlRoot;
import org.raml.model.Action;
import org.raml.model.Raml;
import org.raml.model.Resource;
import org.raml.parser.visitor.RamlDocumentBuilder;

/**
 * @author armin.weisser
 */
public class Jrp08V1RamlModelFactory implements RamlModelFactory {

    @Override
    public RamlModelEmitter createRamlModelEmitter() {
        return new Jrp08V1RamlModelEmitter();
    }

    @Override
    public RamlRoot buildRamlRoot(String ramlFileUrl) {
        return createRamlRoot(new RamlDocumentBuilder().build(ramlFileUrl));
    }

    @Override
    public RamlRoot createRamlRoot() {
        return createRamlRoot(new Raml());
    }

    @Override
    public RamlRoot createRamlRoot(String ramlFileUrl) {
        Raml raml = new RamlDocumentBuilder().build(ramlFileUrl);
        return createRamlRoot(raml);
    }

    RamlRoot createRamlRoot(Raml raml) {
        if(raml == null) {
            return null;
        }
        return new Jrp08V1RamlRoot(raml);
    }

    @Override
    public RamlResource createRamlResource() {
        return createRamlResource(new Resource());
    }

    @Override
    public RamlResource createRamlResource(Object resource) {
        if(resource == null) {
            return null;
        }
        return new Jrp08V1RamlResource((Resource)resource);
    }

    Resource extractResource(RamlResource ramlResource) {
        if(ramlResource == null) return null;
        return ((Jrp08V1RamlResource)ramlResource).getResource();
    }

    @Override
    public RamlAction createRamlAction(Object action) {
        if(action == null) {
            return null;
        }
        return new Jrp08V1RamlAction((Action)action);
    }

    @Override
    public RamlAction createRamlAction() {
        return createRamlAction(new Action());
    }

    static Action extractAction(RamlAction ramlAction) {
        return ((Jrp08V1RamlAction)ramlAction).getAction();
    }
}
