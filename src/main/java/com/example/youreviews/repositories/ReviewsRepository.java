package com.example.youreviews.repositories;

import com.example.youreviews.entities.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReviewsRepository extends JpaRepository<Reviews,Long> {
}
