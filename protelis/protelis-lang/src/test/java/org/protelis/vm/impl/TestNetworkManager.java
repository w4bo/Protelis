/*******************************************************************************
 * Copyright (C) 2010, 2015, Danilo Pianini and contributors
 * listed in the project's build.gradle or pom.xml file.
 *
 * This file is part of Protelis, and is distributed under the terms of
 * the GNU General Public License, with a linking exception, as described
 * in the file LICENSE.txt in this project's top directory.
 *******************************************************************************/
/**
 * 
 */
package org.protelis.vm.impl;

import java.util.Map;
import java.util.Objects;

import org.protelis.lang.datatype.DeviceUID;
import org.protelis.vm.NetworkManager;
import org.protelis.vm.util.CodePath;

/**
 * A dummy network manager with test purpose.
 */
public class TestNetworkManager implements NetworkManager {
    private final TestEnvironment env;
    private final DeviceUID id;

    /**
     * @param id
     *            device id
     * @param env
     *            environment
     */
    public TestNetworkManager(final DeviceUID id, final TestEnvironment env) {
        this.id = id;
        this.env = env;
    }

    @Override
    public Map<DeviceUID, Map<CodePath, Object>> getNeighborState() {
        return env.getNeighborhood(id);
    }

    @Override
    public void shareState(final Map<CodePath, Object> toSend) {
        Objects.requireNonNull(toSend);
        if (!toSend.isEmpty()) {
            env.putContent(id, toSend);
        }
    }

}