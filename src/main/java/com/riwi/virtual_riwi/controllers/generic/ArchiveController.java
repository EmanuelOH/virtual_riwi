package com.riwi.virtual_riwi.controllers.generic;

import org.springframework.http.ResponseEntity;

public interface ArchiveController<ID> {
    public ResponseEntity<Void> archive(ID id);
}
