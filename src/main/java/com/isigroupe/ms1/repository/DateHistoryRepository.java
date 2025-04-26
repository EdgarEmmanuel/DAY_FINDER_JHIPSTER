package com.isigroupe.ms1.repository;

import com.isigroupe.ms1.domain.DateHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateHistoryRepository extends JpaRepository<DateHistory, Long> {}
