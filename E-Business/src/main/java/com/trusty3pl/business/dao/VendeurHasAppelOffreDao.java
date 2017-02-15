package com.trusty3pl.business.dao;

import java.util.List;

import com.trusty3pl.business.model.VendeurHasAppelOffre;

public interface VendeurHasAppelOffreDao {
	VendeurHasAppelOffre findById(String id);
	 boolean save(VendeurHasAppelOffre c1);
	 boolean delete(String c1);
	 boolean update(VendeurHasAppelOffre c1);
		List<VendeurHasAppelOffre> findAllUsers();
}
