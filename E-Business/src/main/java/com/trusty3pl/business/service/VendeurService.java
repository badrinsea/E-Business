package com.trusty3pl.business.service;

import java.util.List;

import com.trusty3pl.business.model.Vendeur;


public interface VendeurService {
	Vendeur findById(String id);
	 boolean save(Vendeur c1);
	 boolean delete(String c1);
	 boolean update(Vendeur c1);
		List<Vendeur> findAllUsers();
}
