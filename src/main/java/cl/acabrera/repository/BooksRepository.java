package cl.acabrera.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.acabrera.model.Books;
@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {
	//save			//recibe objeto Books		   	//ocuparemos esté método 
	//update		//recibe objeto Books		   	//ocuparemos esté método 
	//findAll		//retorna una lista de Books   	//ocuparemos esté método	
	//findById		//retorna un objeto Books		
	//findAllById	//retorna una lista de books
	//delete		//recibe objeto Books			//ocuparemos esté método
	
	
	//creando un método custumizado
	
	//IMPORTANTE: el nombre del método después del By debe ser algún nombre del atributo del objeto, 
	//este nombre de iniciar con mayúscula ya que en los setter o getter se utilza esa nomenclatura
	//gracias a los componentes de jpa podemos utilizar Containg: es un like con %parametro%
	//tambien utilzar IgnoreCase para omitir comparaciones entre minúscualas  y mayúsculas
	//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
	List<Books> findAllByTitleContainingIgnoreCase(String title); 
	

	Books findByIdBook(int idBook);
	
	
} 
