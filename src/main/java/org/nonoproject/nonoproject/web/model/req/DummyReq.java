package org.nonoproject.nonoproject.web.model.req;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Getter
@ToString
@Builder
@Table(name = "dummy")
@Jacksonized
public class DummyReq {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NotNull(message = "dummy.id.not_null")
    private String id;

    @NotBlank(message = "dummy.name.not_blank")
    private String name;
}
