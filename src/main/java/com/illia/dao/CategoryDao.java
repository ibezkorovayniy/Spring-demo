package com.illia.dao;

import com.illia.model.Category;

import java.util.List;

public interface CategoryDao {


    public List<Category> findAll();
    Category findById(Long cId);
}
