package com.tickets_online.events;

import java.math.BigDecimal;

public record Product(int id, int eventId, String name, String description, BigDecimal price) {

}
