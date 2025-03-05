package com.java.mack.sBig.app.repository;

import com.java.mack.sBig.app.model.entity.RecipeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RecipeDetailRepository extends JpaRepository<RecipeDetail, Long> {

}
