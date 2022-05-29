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
	public List<Books> findAllByTitle(String titleTest) {
		return bookRespository.findAllByTitle(titleTest);
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
	
	
	

}
