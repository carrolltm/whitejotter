package com.evan.tm.service;


import com.evan.tm.dao.CategoryDAO;
import com.evan.tm.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryDAO categoryDAO;

    public List<Category> list() {
        // sort不能在实例化了，现在改成私有了

//        Sort sort = new Sort(Sort.Direction.DESC, "id");
//        return categoryDAO.findAll(sort);
        return categoryDAO.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Category get(int id) {
        Category c= categoryDAO.findById(id).orElse(null);
        return c;
    }
}