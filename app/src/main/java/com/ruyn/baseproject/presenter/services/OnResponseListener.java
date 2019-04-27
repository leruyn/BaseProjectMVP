package com.ruyn.baseproject.presenter.services;

/**
 * Copyright (C) 2019.
 * All rights reserved.
 *
 * @author ruyn.
 * @since Apr-27-2019
 */
public interface OnResponseListener {
    /**
     * Receive Response
     * @param task ApiTask
     * @param status int
     * @param messageError
     * @return True if Task is Finished and Execute next Task
     */
    boolean onResponse(ApiTask task, int status, String messageError);

    /**
     * Will Process on Child Classes
     * @param task ApiTask
     * @param status int
     * @return True if Response is Process on Child Classes
     */
    boolean willProcess(ApiTask task, int status);
}