package com.tickets_online.tickets.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Registration(
        Integer id,
        @NotNull(message = "Product id is required") Integer productId,
        String ticketCode,
        @NotBlank(message = "Atteedee name is required") String attendeeName) {
}
