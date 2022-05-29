package cl.acabrera.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.acabrera.model.Books;
import cl.acabrera.service.BooksService;

@RestController
@RequestMapping("api/books/v1")
public class BooksController {
	
	@Autowired
	BooksService booksService;
	
	@GetMapping("/findAllByTitle/{title}")
	public ResponseEntity<List<Books>> findAllByTitle(@PathVariable String title){
		try {
			List<Books> listBooks=booksService.findAllByTitle(title);
			//consultamos valor obtenido
			if (!listBooks.isEmpty()) {
				//retornamos la lista y un estatus de ok.
				return new ResponseEntity<>(listBooks,HttpStatus.OK);
			}else {
				//retornamos un estatus de no encontrado
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// en este caso hubrá un error en el sevidor
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Books>> findAll(){
		try {
			List<Books> listBooks=booksService.findAll();
			//consultamos valor obtenido
			if (!listBooks.isEmpty()) {
				//retornamos la lista y un estatus de ok.
				return new ResponseEntity<>(listBooks,HttpStatus.OK);
			}else {
				//retornamos un estatus de no encontrado
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// en este caso hubrá un error en el sevidor
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Books book) {
		booksService.update(book);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void delete(@RequestBody Books book) {
		booksService.delete(book);
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	void save(@RequestBody Books book) {
		booksService.save(book);
	}

}
	
	
	
	
	