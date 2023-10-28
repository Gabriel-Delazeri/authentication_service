package com.delazeri.link_bio_auth_service.infrastructure.controllers.advices.dtos;

import java.util.List;

public record ErrorResponse(List<String> errors) {
}
