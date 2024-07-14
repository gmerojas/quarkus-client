package org.acme.contract.service;

import org.acme.response.HandlerResponse;

public interface IShowService {
    HandlerResponse getShowsById(Integer showId);
}
