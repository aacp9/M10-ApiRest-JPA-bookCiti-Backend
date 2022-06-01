package cl.acabrera.controller;

import java.util.Objects;

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
import org.springframework.web.bind.annotation.RestController;

import cl.acabrera.VO.BooksVO;
import cl.acabrera.model.Books;
import cl.acabrera.service.BooksService;

@RestController
@RequestMapping("api/books/v1")
public class BooksController {
	
	@Autowired
	BooksService booksService;
	

	@GetMapping("/findAllByTitleContainingIgnoreCase/{title}")
	public ResponseEntity<BooksVO> findAllByTitleContainingIgnoreCase(@PathVariable String title){
		try {
			BooksVO booksVO=booksService.findAllByTitleContainingIgnoreCase(title);
			//consultamos valor obtenido
			if (!(Objects.isNull(booksVO))) {
				//retornamos la lista y un estatus de ok.
				return new ResponseEntity<>(booksVO,HttpStatus.OK);
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
	public ResponseEntity<BooksVO> findAll(){
		try {
			BooksVO booksVO=booksService.findAll();
//			System.out.println("---------Backend-----------");
//			System.out.println(booksService.findAll().toString());
//			System.out.println("---------fin-----------");

			//consultamos valor obtenido
			if (!(Objects.isNull(booksVO))) {
				//retornamos la lista y un estatus de ok.
				return new ResponseEntity<>(booksVO,HttpStatus.OK);
			}else {
				//retornamos un estatus de no encontrado
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// en este caso hubrá un error en el sevidor
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}

	@GetMapping("/findByIdBook/{idBook}")
	public ResponseEntity<BooksVO> findByIdBook(@PathVariable int idBook) {
		try {
			BooksVO booksVO=booksService.findByIdBook(idBook);
			//consultamos valor obtenido
			if (!Objects.isNull(booksVO)) {
				//retornamos la lista y un estatus de ok.
				return new ResponseEntity<>(booksVO,HttpStatus.OK);
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
	public ResponseEntity<BooksVO> update(@RequestBody Books book) {
		try {
			BooksVO booksVO=booksService.update(book);
			//consultamos valor obtenido
			if (!Objects.isNull(booksVO)) {
				//retornamos la lista y un estatus de ok.
				return new ResponseEntity<>(booksVO,HttpStatus.OK);
			}else {
				//retornamos un estatus de no encontrado
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// en este caso hubrá un error en el sevidor
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}

	@DeleteMapping
	public ResponseEntity<BooksVO> delete(@RequestBody Books book) {
		try {
			BooksVO booksVO=booksService.delete(book);
			//consultamos valor obtenido
			if (!Objects.isNull(booksVO)) {
				//retornamos la lista y un estatus de ok.
				return new ResponseEntity<>(booksVO,HttpStatus.OK);
			}else {
				//retornamos un estatus de no encontrado
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// en este caso hubrá un error en el sevidor
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@PostMapping
	public ResponseEntity<BooksVO> save(@RequestBody Books book) {
		try {
			BooksVO booksVO=booksService.save(book);
			//consultamos valor obtenido
			if (!Objects.isNull(booksVO)) {
				//retornamos la lista y un estatus de ok.
				return new ResponseEntity<>(booksVO,HttpStatus.CREATED);
			}else {
				//retornamos un estatus de no encontrado
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// en este caso hubrá un error en el sevidor
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}

}
	
	
	
	
	