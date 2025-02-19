package com.tickets_online.tickets.models;

import java.math.BigDecimal;

public record Product(int id, int eventId, String name, String description, BigDecimal price) {

}
