package com.solvd.onlinestore.domain.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventHolder {

    private static final Map<EventType, List<IEvent>> HOLDER = new HashMap<>();

    public static void subscribe(EventType type, IEvent event) {
        HOLDER.computeIfAbsent(type, t -> new ArrayList<>());
        HOLDER.get(type).add(event);
    }

    public static void unsubscribe(EventType type, IEvent event) {
        List<IEvent> events = HOLDER.get(EventType.SUBSCRIPTION);
        IEvent object = events.get(events.indexOf(event));
        HOLDER.forEach((key, value) -> value.removeIf(n -> n.equals(event)));
        HOLDER.computeIfAbsent(type, t -> new ArrayList<>());
        HOLDER.get(type).add(object);
    }

    public static void notify(EventType type) {
        List<IEvent> events = HOLDER.get(type);
        if (events != null) {
            events.forEach(event -> event.onEvent(type));
        }
    }
}
