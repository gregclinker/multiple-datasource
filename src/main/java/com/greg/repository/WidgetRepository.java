package com.greg.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.greg.entity.Widget;

@Repository
public interface WidgetRepository extends CrudRepository<Widget, Long> {
}
