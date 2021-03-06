/*******************************************************************************
 *
 * Copyright (c) 2010-2011 Sonatype, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: 
 *
 *   
 *     
 *
 *******************************************************************************/ 

package org.eclipse.hudson.rest.client.internal.ext;

import org.eclipse.hudson.rest.client.ext.StatusClient;
import org.eclipse.hudson.rest.client.internal.HudsonClientExtensionSupport;
import org.eclipse.hudson.rest.model.StatusDTO;
import com.sun.jersey.api.client.ClientResponse;

import javax.ws.rs.core.UriBuilder;


import static javax.ws.rs.core.Response.Status.*;

/**
 * {@link StatusClient} implementation.
 *
 * @author <a href="mailto:jason@planet57.com">Jason Dillon</a>
 * @since 2.1.0
 */
public class StatusClientImpl
    extends HudsonClientExtensionSupport
    implements StatusClient
{
    protected UriBuilder uri() {
        return getClient().uri().path("status");
    }
    
    public StatusDTO status() {
        ClientResponse resp = resource(uri()).get(ClientResponse.class);
        try {
            ensureStatus(resp, OK);
            return resp.getEntity(StatusDTO.class);
        }
        finally {
            close(resp);
        }
    }
}
