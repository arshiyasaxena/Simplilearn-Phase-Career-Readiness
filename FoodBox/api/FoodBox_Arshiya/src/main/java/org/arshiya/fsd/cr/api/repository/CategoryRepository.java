package org.arshiya.fsd.cr.api.repository;

import org.arshiya.fsd.cr.api.entity.Category;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Modifying
	@Query(value = "Update Category c set enabled=?2 where id=?1")
	void setEnabled(Long id, Boolean enabled);

	@EntityGraph(attributePaths = { "image" })
	Category findWithImageAttachedById(Long id);

}
