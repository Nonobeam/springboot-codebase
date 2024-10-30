package org.nonoproject.nonoproject.web.repository;

import org.nonoproject.nonoproject.web.model.req.DummyReq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DummyRepository extends JpaRepository<DummyReq, String> {
}
