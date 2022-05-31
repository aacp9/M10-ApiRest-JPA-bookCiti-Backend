package cl.acabrera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.acabrera.model.Books;
import cl.acabrera.repository.BooksRepository;
@Service
public class BooksServiceImpl implements BooksService {

	@Autowired
	BooksRepository bookRespository;

	@Override
	public List<Books> findAllByTitleContainingIgnoreCase(String titleTest) {
		return bookRespository.findAllByTitleContainingIgnoreCase(titleTest);
	}

	@Override
	public List<Books> findAll() {
		return bookRespository.findAll();
	}

	@Override
	public void save(Books book) {
		bookRespository.save(book);
	}

	@Override
	public void delete(Books book) {
		bookRespository.delete(book);
	}

	@Override
	public void update(Books book) {
		bookRespository.save(book);
		
	}

	@Override
	public Books findByIdBook(int idBook) {
		return bookRespository.findByIdBook(idBook);
	}
	
	
	

}
