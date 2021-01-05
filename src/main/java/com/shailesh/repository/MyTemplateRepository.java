package com.shailesh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shailesh.domain.Template;


public interface MyTemplateRepository extends JpaRepository<Template, Long>  {

	@Query("select tm from Template tm where nettingTemplateId=:t and tm.creationDate < CURRENT_DATE")
	List<Template> findByNettingTemplateId(@Param("t") String templateName);// This is Working Fine
	
	List<Template> findByTemplateNameContains(String templateName);

	List<Template> findByTemplateNameContainsAndActiveFlag(String templateName, char activeFlag);// My POC

}
