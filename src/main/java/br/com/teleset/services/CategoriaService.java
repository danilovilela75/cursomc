package br.com.teleset.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.teleset.domain.Categoria;
import br.com.teleset.repositories.CategoriaRepository;
import br.com.teleset.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "
				+ id
				+ ", Tipo: "
				+ Categoria.class.getName()));
		
	}
	
	//inserir
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	//update
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	//delete
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluir uma categoria que possui produtos!");
		}
	}
	
	//listar tudo
	public List<Categoria> findAll() {
		return repo.findAll();
	}

}
