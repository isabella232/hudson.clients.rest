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

package org.eclipse.hudson.rest.client.ext;

import org.cometd.client.BayeuxClient;
import org.eclipse.hudson.rest.client.HudsonClient;

/**
 * @author <a href="mailto:jason@planet57.com">Jason Dillon</a>
 * @since 2.1.0
 */
public interface NotificationClient
    extends HudsonClient.Extension
{
    // FIXME: Not really REST stuff
    BayeuxClient getBayeuxClient();
}
