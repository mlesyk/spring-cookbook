package org.mlesyk.service;

import org.mlesyk.model.Reservation;

import java.util.List;

public interface ReservationService {

    List<Reservation> query(String courtName);

}
