package com.ruyn.baseproject.presenter.services;

/**
 * Copyright (C) 2019.
 * All rights reserved.
 *
 * @author ruyn.
 * @since Apr-27-2019
 */
public interface ApiResponseCallback {
    /**
     * Process Response
     * @param task ApiTask
     * @return True if Task is finished and do next task
     */
    boolean onResponse(ApiTask task);
}
