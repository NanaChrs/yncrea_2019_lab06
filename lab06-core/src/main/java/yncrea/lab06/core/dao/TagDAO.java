package yncrea.lab06.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import yncrea.lab06.core.entity.Tag;

public interface TagDAO extends JpaRepository<Tag, Long> {
}
