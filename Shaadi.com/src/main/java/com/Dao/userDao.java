package com.Dao;

import java.util.List;

import com.module.userDetails;

public interface userDao {
	int save(userDetails details);
	
  userDetails userFind(int id);

	
}
