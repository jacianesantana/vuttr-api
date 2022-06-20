package vuttr.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vuttr.api.model.Tool;

public interface ToolRepository extends JpaRepository<Tool, Long> {
}
