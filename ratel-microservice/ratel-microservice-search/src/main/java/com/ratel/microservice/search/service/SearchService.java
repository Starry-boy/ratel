package com.ratel.microservice.search.service;

import java.util.Map;

public interface SearchService {
    Map<String, String> get(Long id);
}
