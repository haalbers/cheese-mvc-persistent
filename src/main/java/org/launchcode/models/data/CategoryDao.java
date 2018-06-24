package org.launchcode.models.data;

import org.launchcode.models.Category;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CategoryDao extends org.springframework.data.repository.CrudRepository<Category, Integer> {
}
