package com.evan.tm.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.evan.tm.pojo.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer> {

}