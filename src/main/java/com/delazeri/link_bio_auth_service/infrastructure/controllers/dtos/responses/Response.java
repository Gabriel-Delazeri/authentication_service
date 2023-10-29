package com.delazeri.link_bio_auth_service.infrastructure.controllers.dtos.responses;

import java.util.ArrayList;

public record Response<T>(T data, boolean success, ArrayList<String> errors) {
}
