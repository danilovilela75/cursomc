package br.com.teleset.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.teleset.domain.Cliente;
import br.com.teleset.dto.ClienteDTO;
import br.com.teleset.repositories.ClienteRepository;
import br.com.teleset.services.exceptions.DataIntegrityException;
import br.com.teleset.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		
		Optional<Cliente> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "
				+ id
				+ ", Tipo: "
				+ Cliente.class.getName()));
		
	}

	//inserir cliente
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	//atualizar cliente
	public Cliente update(Cliente obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	//delete cliente
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Proibido excluir com pedidos ativos!");
		}
	}
	
	//listar todos os clientes
	public List<Cliente> findAll() {
		return repo.findAll();
	}
	
	//paginar clientes
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	//fromDTO
	public Cliente fromDTO(ClienteDTO objDTO) {
		return new Cliente(objDTO.getId(), objDTO.getNome(), objDTO.getEmail(), null, null);
	}

}
