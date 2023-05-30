package com.company.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.company.utils.ConversibleContract;

import jakarta.transaction.Transactional;

@Service
@Transactional
public interface GenericService<E extends ConversibleContract<DTO>, ID, DTO extends ConversibleContract<E>> {

	JpaRepository<E, ID> repository();

	default public DTO insert(DTO dto) {
		return repository().save(dto.fromConvert()).fromConvert();
	}

	default public DTO findById(ID id) {
		return repository().findById(id).orElseThrow(() -> new ResourceNotFoundException()).fromConvert();
	}

	default public List<DTO> getAll() {
		return repository().findAll().stream().map(x -> x.fromConvert()).toList();
	}

	default public void delete(ID id) {
		repository().deleteById(id);
	}
}
