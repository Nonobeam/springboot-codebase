package org.nonoproject.nonoproject.web.controller;

import org.nonoproject.nonoproject.utility.web.model.res.ApiResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class DummyController {

  @GetMapping
  public ResponseEntity<?> get() {
    return ResponseEntity.ok().body(ApiResp.builder().success(true).build());
  }
}
