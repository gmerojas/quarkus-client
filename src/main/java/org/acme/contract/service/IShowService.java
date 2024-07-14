package org.acme.contract.service;

import org.acme.response.HandlerResponse;

public interface IShowService {
    HandlerResponse getShowsById1(Integer showId);
    HandlerResponse getShows1();

    HandlerResponse getShowsById2(Integer showId);
    HandlerResponse getShows2();
}
